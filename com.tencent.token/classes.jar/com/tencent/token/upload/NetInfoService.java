package com.tencent.token.upload;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import com.tencent.token.global.h;
import com.tencent.token.utils.x;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class NetInfoService
  extends Service
{
  private ConnectivityManager a;
  private NetworkInfo b;
  private NetInfoService.NetState c;
  private NetInfoService.NetState d = NetInfoService.NetState.NET_NO;
  private Handler e = new j(this);
  private BroadcastReceiver f = new l(this);
  
  private NetInfoService.NetState a(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {
      return NetInfoService.NetState.NET_NO;
    }
    switch (paramNetworkInfo.getType())
    {
    default: 
      return NetInfoService.NetState.NET_UNKNOWN;
    case 1: 
      return NetInfoService.NetState.NET_WIFI;
    }
    switch (paramNetworkInfo.getSubtype())
    {
    default: 
      return NetInfoService.NetState.NET_UNKNOWN;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return NetInfoService.NetState.NET_2G;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return NetInfoService.NetState.NET_3G;
    }
    return NetInfoService.NetState.NET_4G;
  }
  
  private boolean a()
  {
    long l1 = x.d() * 1000L;
    long l2 = System.currentTimeMillis();
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localDate.setTime(l1);
    localCalendar.setTime(localDate);
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int i = localCalendar.get(1);
    int j = localCalendar.get(6);
    localDate.setTime(l2);
    localCalendar.setTime(localDate);
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    int k = localCalendar.get(1);
    int m = localCalendar.get(6);
    if ((k > i) || ((k == i) && (m >= j + 1)))
    {
      h.a("report dns info need, time=" + l1 + ", current=" + l2);
      return true;
    }
    h.a("report dns info needn't, time=" + l1 + ", current=" + l2);
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    try
    {
      super.onCreate();
      Object localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      registerReceiver(this.f, (IntentFilter)localObject);
      localObject = ((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null)
      {
        this.d = NetInfoService.NetState.NET_NO;
        return;
      }
      this.d = a((NetworkInfo)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.f);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.NetInfoService
 * JD-Core Version:    0.7.0.1
 */