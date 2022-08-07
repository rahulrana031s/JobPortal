package com.example.jobportal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobportal.databinding.ActivityHomeBinding
import com.example.jobportal.ui.adapters.NewJobAdapter
import com.example.jobportal.ui.adapters.UpComingSessionAdapter
import com.example.jobportal.ui.utils.NetworkResult
import com.example.jobportal.ui.viewModal.PortalViewModal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var _binding : ActivityHomeBinding
    private lateinit var viewModel: PortalViewModal
    private var upComingSessionAdapter: UpComingSessionAdapter? = null
    private var newJobAdapter: NewJobAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        setVieModal()
        observeViewModal()
        setLayoutManager()


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
                upComingSessionAdapter = UpComingSessionAdapter(this,it)
                _binding.rlvSession.adapter = upComingSessionAdapter

            }

            it.job_postings.let {
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