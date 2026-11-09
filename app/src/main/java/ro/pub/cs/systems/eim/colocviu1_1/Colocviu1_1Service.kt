package ro.pub.cs.systems.eim.colocviu1_1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.Date
import kotlin.time.Clock

class Colocviu1_1Service : Service() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private var dirs: String = ""

    inner class ProcessingThread : Thread() {
        override fun run() {
            sleep(2000)
            var intent = Intent()
            intent.action = "ro.pub.cs.systems.eim.colocviu1_1.act"
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            intent.putExtra("msg", currentDate + " " + dirs)
            sendBroadcast(intent)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        dirs = intent!!.extras!!.getString("dirs")!!
        val processingThread = ProcessingThread()
        processingThread.start()
        return START_REDELIVER_INTENT
    }
}