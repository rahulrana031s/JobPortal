package com.example.jobportal.ui.models

data class UserData(
    val dashboard_stats: DashboardStats,
    val full_name: String,
    val job_postings: List<JobPosting>,
    val upcoming_sessions: List<UpcomingSession>
)