package com.c2m.storyviewer.app

import android.app.Application

import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import io.requery.android.sqlite.DatabaseProvider

class StoryApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val leastRecentlyUsedCacheEvictor = LeastRecentlyUsedCacheEvictor(90 * 1024 * 1024)


        if (simpleCache == null) {
            simpleCache = SimpleCache(cacheDir, leastRecentlyUsedCacheEvictor)
        }
    }

    companion object {
        var simpleCache: SimpleCache? = null
    }
}