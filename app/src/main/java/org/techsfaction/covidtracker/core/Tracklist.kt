/*
 * Tracklist.kt
 * Implements the Tracklist data class
 * A Tracklist stores a list of Tracks
 *
 * This file is part of
 * covidtracker - Movement Recorder for Android
 *
 * Copyright (c) 2016-20 - Y20K.org
 * Licensed under the MIT-License
 * http://opensource.org/licenses/MIT
 *
 * covidtracker uses osmdroid - OpenStreetMap-Tools for Android
 * https://github.com/osmdroid/osmdroid
 */


package org.techsfaction.covidtracker.core

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import org.techsfaction.covidtracker.Keys
import org.techsfaction.covidtracker.helpers.TrackHelper
import java.util.*


/*
 * Tracklist data class
 */
@Keep
@Parcelize
data class Tracklist (@Expose val tracklistFormatVersion: Int = Keys.CURRENT_TRACKLIST_FORMAT_VERSION,
                      @Expose val tracklistElements: MutableList<TracklistElement> = mutableListOf<TracklistElement>(),
                      @Expose var modificationDate: Date = Date()): Parcelable {

    /* Return trackelement for given track id */
    fun getTrackElement(trackId: Long): TracklistElement? {
        tracklistElements.forEach { tracklistElement ->
            if (TrackHelper.getTrackId(tracklistElement) == trackId) {
                return tracklistElement
            }
        }
        return null
    }

    /* Create a deep copy */
    fun deepCopy(): Tracklist {
        return Tracklist(tracklistFormatVersion, mutableListOf<TracklistElement>().apply { addAll(tracklistElements) }, modificationDate)
    }

}