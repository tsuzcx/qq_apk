package com.tencent.map.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private WifiManager jdField_a_of_type_AndroidNetWifiWifiManager = null;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private a jdField_a_of_type_ComTencentMapLocationG$a = null;
  private b jdField_a_of_type_ComTencentMapLocationG$b = null;
  private c jdField_a_of_type_ComTencentMapLocationG$c = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = new Runnable()
  {
    public final void run()
    {
      g.a(g.this);
    }
  };
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  public final void a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMapLocationG$a == null)) {
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentMapLocationG$a);
      label50:
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      break label50;
    }
  }
  
  public final void a(long paramLong)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final boolean a(Context paramContext, c paramc, int paramInt)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      if ((paramContext == null) || (paramc == null)) {
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_ComTencentMapLocationG$c = paramc;
      this.jdField_a_of_type_Int = 1;
      try
      {
        this.jdField_a_of_type_AndroidNetWifiWifiManager = ((WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi"));
        paramContext = new IntentFilter();
        this.jdField_a_of_type_ComTencentMapLocationG$a = new a();
        if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
        {
          paramc = this.jdField_a_of_type_ComTencentMapLocationG$a;
          if (paramc != null) {}
        }
        else
        {
          return false;
        }
        paramContext.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        paramContext.addAction("android.net.wifi.SCAN_RESULTS");
        paramContext.setPriority(2147483647);
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentMapLocationG$a, paramContext);
        a(0L);
        this.jdField_a_of_type_Boolean = true;
        return this.jdField_a_of_type_Boolean;
      }
      catch (Exception paramContext)
      {
        return false;
      }
    }
  }
  
  public final boolean b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidNetWifiWifiManager == null)) {
      return false;
    }
    return this.jdField_a_of_type_AndroidNetWifiWifiManager.isWifiEnabled();
  }
  
  public final class a
    extends BroadcastReceiver
  {
    private int jdField_a_of_type_Int = 4;
    private List<ScanResult> jdField_a_of_type_JavaUtilList = null;
    private boolean jdField_a_of_type_Boolean = false;
    
    public a() {}
    
    private void a(List<ScanResult> paramList)
    {
      if (paramList == null) {
        return;
      }
      label47:
      ScanResult localScanResult;
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        int j = this.jdField_a_of_type_JavaUtilList.size();
        paramList = paramList.iterator();
        int i;
        if (paramList.hasNext())
        {
          localScanResult = (ScanResult)paramList.next();
          i = 0;
        }
        for (;;)
        {
          if (i < j)
          {
            if (((ScanResult)this.jdField_a_of_type_JavaUtilList.get(i)).BSSID.equals(localScanResult.BSSID)) {
              this.jdField_a_of_type_JavaUtilList.remove(i);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilList.add(localScanResult);
            break label47;
            break;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      for (;;)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localScanResult = (ScanResult)paramList.next();
          this.jdField_a_of_type_JavaUtilList.add(localScanResult);
        }
        break;
        this.jdField_a_of_type_JavaUtilList.clear();
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED"))
      {
        this.jdField_a_of_type_Int = paramIntent.getIntExtra("wifi_state", 4);
        if (g.a(g.this) != null) {
          g.a(g.this).b(this.jdField_a_of_type_Int);
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS")) || (paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")))
      {
        paramContext = null;
        if (g.a(g.this) != null) {
          paramContext = g.a(g.this).getScanResults();
        }
        if ((!paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) || ((paramContext != null) && ((paramContext == null) || (paramContext.size() != 0)))) {}
      }
      else
      {
        return;
      }
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 4) && (paramContext != null) && (paramContext.size() <= 2))
      {
        a(paramContext);
        this.jdField_a_of_type_Boolean = true;
        g.this.a(0L);
        return;
      }
      a(paramContext);
      this.jdField_a_of_type_Boolean = false;
      g.a(g.this, new g.b(g.this, this.jdField_a_of_type_JavaUtilList, System.currentTimeMillis(), this.jdField_a_of_type_Int));
      if (g.a(g.this) != null) {
        g.a(g.this).a(g.a(g.this));
      }
      g.this.a(g.a(g.this) * 20000L);
    }
  }
  
  public final class b
    implements Cloneable
  {
    private List<ScanResult> a = null;
    
    public b(long paramLong, int paramInt)
    {
      if (paramLong != null)
      {
        this.a = new ArrayList();
        this$1 = paramLong.iterator();
        while (this$1.hasNext())
        {
          paramLong = (ScanResult)this$1.next();
          this.a.add(paramLong);
        }
      }
    }
    
    public final List<ScanResult> a()
    {
      return this.a;
    }
    
    public final Object clone()
    {
      try
      {
        b localb = (b)super.clone();
        if (this.a != null)
        {
          localb.a = new ArrayList();
          localb.a.addAll(this.a);
        }
        return localb;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(g.b paramb);
    
    public abstract void b(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.map.location.g
 * JD-Core Version:    0.7.0.1
 */