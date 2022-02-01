package com.tencent.mobileqq.contactsync.syncadapter;

import aewf;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import mqq.app.MobileQQ;

public class SyncService
  extends Service
{
  private static aewf a;
  private static final Object dv = new Object();
  
  public static void A(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
    paramContext.putBoolean("IS_USER_EXIT_RECEIVING_MSG", paramBoolean);
    paramContext.commit();
  }
  
  public static void B(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
    paramContext.putBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean j(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("IS_USER_EXIT_RECEIVING_MSG", paramBoolean);
  }
  
  public static boolean k(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", paramBoolean);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return a.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    ??? = MobileQQ.sMobileQQ;
    if ((j(this, false)) && (k(this, false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("k_start_mode", 1);
      ((MobileQQ)???).onActivityCreate(this, localIntent);
    }
    synchronized (dv)
    {
      if (a == null) {
        a = new aewf(getApplicationContext(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.syncadapter.SyncService
 * JD-Core Version:    0.7.0.1
 */