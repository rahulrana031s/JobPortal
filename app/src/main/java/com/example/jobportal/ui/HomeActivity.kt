package com.example.jobportal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.calc.BlinkEffect
import com.example.jobportal.databinding.ActivityHomeBinding
import com.example.jobportal.ui.adapters.NewJobAdapter
import com.example.jobportal.ui.adapters.UpComingSessionAdapter
import com.example.jobportal.ui.models.JobPosting
import com.example.jobportal.ui.models.UpcomingSession
import com.example.jobportal.ui.utils.NetworkResult
import com.example.jobportal.ui.utils.TokenManager
import com.example.jobportal.ui.viewModal.PortalViewModal
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var _binding : ActivityHomeBinding
    private lateinit var viewModel: PortalViewModal
    private var upComingSessionAdapter: UpComingSessionAdapter? = null
    private var newJobAdapter: NewJobAdapter? = null
    private var upcoming = listOf<UpcomingSession>()
    private var newJob = listOf<JobPosting>()

    @Inject
    lateinit var tokenManager: TokenManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)
//        setVieModal()
//        observeViewModal()
        BlinkEffect.blink(_binding.ivHome)

        setLayoutManager()
        setListners()
        setImage()


    }

    private fun setImage() {
//        if(tokenManager.getProfile()!=""){
//            Glide.with(this).load(tokenManager.getProfile()).into(_binding.ivProfile);
//        }

    }

    private fun setListners() {
        _binding.suffle.setOnClickListener {
            Collections.reverse(upcoming)
            val shuffAlp = newJob.shuffled()

            upComingSessionAdapter = UpComingSessionAdapter(this,upcoming)
            _binding.rlvSession.adapter = upComingSessionAdapter

            newJobAdapter = NewJobAdapter(this,shuffAlp)
            _binding.rlvJobs.adapter = newJobAdapter
        }


        _binding.homes.setOnClickListener {
            observeViewModal()
        }
        _binding.ivProfile.setOnClickListener {
            observeViewModal()
        }
    }

    private fun setLayoutManager() {
        _binding.rlvSession.layoutManager = LinearLayoutManager(this)
        _binding.rlvJobs.layoutManager = LinearLayoutManager(this)
    }

    private fun observeViewModal() {
        viewModel.userResponseLiveData.observe(this, Observer {

            _binding.tvJobsApplied.text = it.dashboard_stats.jobs_applied.toString()
            _binding.tvMentorshipSessions.text = it.dashboard_stats.mentorship_sessions.toString()
            _binding.tvProfileViews.text = it.dashboard_stats.profile_views.toString()
            _binding.tvSkillsVerified.text = it.dashboard_stats.skills_verified.toString()


            it.upcoming_sessions.let {
                upcoming = it
                upComingSessionAdapter = UpComingSessionAdapter(this,it)
                _binding.rlvSession.adapter = upComingSessionAdapter

            }

            it.job_postings.let {
                newJob = it
                newJobAdapter = NewJobAdapter(this,it)
                _binding.rlvJobs.adapter = newJobAdapter
            }


        })
    }

    private fun setVieModal() {
        viewModel = ViewModelProvider(this).get(PortalViewModal::class.java)
        viewModel.getUserInfo()

    }


}