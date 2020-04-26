package org.techsfaction.covidtracker

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.Long

class TracklistFragmentDirections private constructor() {
  private data class ActionTracksFragmentToFragmentTrack(
    val deleteTrackId: Long = -1L
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_tracks_fragment_to_fragment_track

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putLong("delete_track_id", this.deleteTrackId)
      return result
    }
  }

  companion object {
    fun actionTracksFragmentToFragmentTrack(deleteTrackId: Long = -1L): NavDirections =
        ActionTracksFragmentToFragmentTrack(deleteTrackId)
  }
}
