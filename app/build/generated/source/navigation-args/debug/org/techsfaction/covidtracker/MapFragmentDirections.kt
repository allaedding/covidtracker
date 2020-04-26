package org.techsfaction.covidtracker

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.Long

class MapFragmentDirections private constructor() {
  private data class ActionMapFragmentToFragmentTrack(
    val deleteTrackId: Long = -1L
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_map_fragment_to_fragment_track

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putLong("delete_track_id", this.deleteTrackId)
      return result
    }
  }

  companion object {
    fun actionMapFragmentToSettingsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_map_fragment_to_settings_fragment)

    fun actionMapFragmentToTracksFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_map_fragment_to_tracks_fragment)

    fun actionMapFragmentToFragmentTrack(deleteTrackId: Long = -1L): NavDirections =
        ActionMapFragmentToFragmentTrack(deleteTrackId)
  }
}
