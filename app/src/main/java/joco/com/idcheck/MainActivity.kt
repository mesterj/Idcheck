package joco.com.idcheck

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val telephonyManager: TelephonyManager? = getSystemService(TELEPHONY_SERVICE) as? TelephonyManager
        var myID = ""
        var myversion = 0;
        myversion = Integer.valueOf(android.os.Build.VERSION.SDK)
        //if (myversion < 23) {
            myID = telephonyManager!!.getDeviceId()
            Log.i("MYID","My phone id: "+myID)
       // } else {
            myID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID)
            Log.i("MYID","My SECURE ID:"+myID)
       // }
    }
}
