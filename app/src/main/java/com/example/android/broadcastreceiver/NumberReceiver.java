package com.example.android.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

/**
 * Created by Android on 7/27/2017.
 */

public class NumberReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            DbHelper dbHelper = new DbHelper(context);
            dbHelper.saveValue(number);
            dbHelper.close();
        }

    }
}
