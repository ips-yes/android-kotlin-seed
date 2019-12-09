package com.products.intelligent.androidkotlinseed.utils

import android.util.Log

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        //ignore the verbose and debug logs for a release build
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }
        //log to a file, server, Crashlytics.  Wherever you need to
        //TODO this should probably report to some server and not just log to the file system
        val logFile = File("sdcard/log.file")
        if (!logFile.exists()) {
            try {
                logFile.createNewFile()
            } catch (e: IOException) {
                e.printStackTrace() //we shouldn't try and log this failure to this class resulting in endless loop
            }

        }
        try {
            val buf = BufferedWriter(FileWriter(logFile, true))
            buf.append(priority.toString() + tag + message)
            buf.newLine()
            buf.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}
