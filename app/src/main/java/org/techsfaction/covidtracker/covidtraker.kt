package org.techsfaction.covidtracker

import android.app.Application
import org.techsfaction.covidtracker.helpers.AppThemeHelper
import org.techsfaction.covidtracker.helpers.LogHelper
import org.techsfaction.covidtracker.helpers.PreferencesHelper


/*
 * covidtracker.class
 */
class covidtraker: Application() {


    /* Define log tag */
    private val TAG: String = LogHelper.makeLogTag(covidtraker::class.java)


    /* Implements onCreate */
    override fun onCreate() {
        super.onCreate()
        LogHelper.v(TAG, "Covidtraker application started.")
        // set Dark / Light theme state
        AppThemeHelper.setTheme(PreferencesHelper.loadThemeSelection(this))
    }


    /* Implements onTerminate */
    override fun onTerminate() {
        super.onTerminate()
        LogHelper.v(TAG, "Covidtraker application terminated.")
    }

}