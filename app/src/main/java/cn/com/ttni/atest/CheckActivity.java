package cn.com.ttni.atest;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.lang.reflect.Method;

import static java.security.AccessController.getContext;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
//        Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID)

    }
    @Override
    protected void onResume() {
        try {

            String str=getSerialNumber();
            Log.v("mrds",str);
        } catch (Exception e) {
            // Just in case
        }
        super.onResume();

    }
    private String getSerialNumber(){

        String serial = null;

        try {

            Class<?> c =Class.forName("android.os.SystemProperties");

            Method get =c.getMethod("get", String.class);

            serial = (String)get.invoke(c, "ro.serialno");

        } catch (Exception e) {

            e.printStackTrace();

        }

        return serial;

    }
}
