package org.techsfaction.covidtracker

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Long
import kotlin.jvm.JvmStatic

data class TrackFragmentArgs(
  val deleteTrackId: Long = -1L
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("delete_track_id", this.deleteTrackId)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): TrackFragmentArgs {
      bundle.setClassLoader(TrackFragmentArgs::class.java.classLoader)
      val __deleteTrackId : Long
      if (bundle.containsKey("delete_track_id")) {
        __deleteTrackId = bundle.getLong("delete_track_id")
      } else {
        __deleteTrackId = -1L
      }
      return TrackFragmentArgs(__deleteTrackId)
    }
  }
}
