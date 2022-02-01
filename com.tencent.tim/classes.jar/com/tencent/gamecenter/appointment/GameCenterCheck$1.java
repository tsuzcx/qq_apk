package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import asbt;
import org.json.JSONArray;
import org.json.JSONException;
import tax;
import tbb;

final class GameCenterCheck$1
  implements Runnable
{
  public void run()
  {
    String str3 = tbb.gQ("APPOINTMENT_LIST");
    String str4 = tbb.gQ("DELAY_LIST");
    String str5 = tbb.gQ("APPOINTMENT_UPDATE_LIST");
    String str2 = tbb.gQ("APPOINTMENT_TGPA_LIST");
    String str1 = tbb.gQ("UNPACK_APK_LIST");
    if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str5)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str1)))
    {
      asbt.i("GameCenterCheck", "checkGameCenter no task, unRegisterReceiver");
      tax.unRegisterReceiver();
    }
    for (;;)
    {
      return;
      asbt.i("GameCenterCheck", "checkGameCenter begin");
      tbb.bCr();
      if ((!TextUtils.isEmpty(str4)) && (tbb.aOx)) {
        GameCenterCheck.z(str4.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str3)) && (tbb.aOy)) {
        GameCenterCheck.A(str3.split("\\|"));
      }
      if ((!TextUtils.isEmpty(str5)) && (tbb.aOz)) {}
      try
      {
        GameCenterCheck.k(new JSONArray(str5));
        if (TextUtils.isEmpty(str2)) {}
      }
      catch (JSONException localJSONException3)
      {
        try
        {
          GameCenterCheck.l(new JSONArray(str2));
          if ((TextUtils.isEmpty(str1)) || (!tbb.aOA)) {
            continue;
          }
          try
          {
            GameCenterCheck.m(new JSONArray(str1));
            return;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            return;
          }
          localJSONException3 = localJSONException3;
          localJSONException3.printStackTrace();
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            localJSONException2.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterCheck.1
 * JD-Core Version:    0.7.0.1
 */