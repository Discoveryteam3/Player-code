package com.example.sampleplayerapplication

import android.content.Context
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.HttpDataSource
import org.junit.Assert.*


import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import kotlin.properties.Delegates

@RunWith(JUnit4::class)
class MainActivityTest {

    private var isShowingTrackSelectionDialog by Delegates.notNull<Boolean>()
    private lateinit var videoURL : String
    private var trackSelector: DefaultTrackSelector? = null
    @Mock
    private lateinit var context: Context
    @Mock
    private lateinit var httpDataSourceFactory: HttpDataSource.Factory
    @Mock
    private lateinit var cacheDataSourceFactory: DataSource.Factory
    @Mock
    private var mPlayer: SimpleExoPlayer? = null
    @Mock
    private var trackSelectorDialog: TrackSelectionDialog? = null

    @Before
    fun setUp() {
        videoURL = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
        context = Mockito.mock(Context::class.java)
        trackSelector = Mockito.mock(DefaultTrackSelector:: class.java)
        httpDataSourceFactory = Mockito.mock(HttpDataSource.Factory:: class.java)
        cacheDataSourceFactory = Mockito.mock(DataSource.Factory:: class.java)
        mPlayer = Mockito.mock(SimpleExoPlayer::class.java)
        trackSelectorDialog = TrackSelectionDialog()
        isShowingTrackSelectionDialog = true
    }

    @Test
    fun initPlayerTest() {
        assertNotNull(httpDataSourceFactory)
        assertNotNull(trackSelector)
        assertNotNull(cacheDataSourceFactory)
        assertNotNull(mPlayer)
    }

    @Test
    fun openTrackSelectorDialogTest() {
        assertNotNull(trackSelectorDialog)
        assertTrue(isShowingTrackSelectionDialog)
    }

    @Test
    fun buildMediaSourceTest() {
        assertNotNull(videoURL)
    }
}