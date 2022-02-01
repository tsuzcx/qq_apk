package com.tencent.token;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import btmsdkobf.ai;
import btmsdkobf.aj;
import btmsdkobf.z;
import com.qq.taf.jce.JceStruct;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.service.update.CSDCheckData;
import com.tencent.service.update.ProductVersion;
import com.tencent.service.update.SCDCheckRes;
import com.tencent.service.update.SilentDownloadInfo;
import com.tencent.service.update.SoftUpdateInfo;
import com.tencent.service.update.UpdateDownloadDialog;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.ConchPushInfoUtil;
import com.tmsdk.JceStructUtil;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.base.utils.NetworkUtil;
import com.tmsdk.base.utils.PhoneInfoFetcher;
import com.tmsdk.base.utils.PhoneInfoFetcher.SizeInfo;
import java.util.Calendar;

public final class sk
{
  private static sk d;
  boolean a;
  public Activity b;
  public sj c = sj.a();
  private boolean e;
  private sg f = new sg("com.tencent.token");
  private boolean g = false;
  private byte[] h = new byte[0];
  private BroadcastReceiver i = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousIntent.getAction())) && (NetworkUtil.getNetworkType().a == 2)) {
        sk.this.a(false);
      }
    }
  };
  
  public static sk a()
  {
    try
    {
      if (d == null) {
        d = new sk();
      }
      sk localsk = d;
      return localsk;
    }
    finally {}
  }
  
  private static boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    int j = aaw.a;
    try
    {
      j = Integer.valueOf(String.valueOf(j)).intValue();
      if (j < paramInt) {
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static void b()
  {
    ConchServiceProxy.getInstance().unRegisterConchPush(200);
  }
  
  public static void d()
  {
    ConchServiceProxy.getInstance();
  }
  
  private boolean i()
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(System.currentTimeMillis());
    int m = ((Calendar)localObject1).get(11);
    for (;;)
    {
      try
      {
        localObject1 = this.c.a.a("silent_download_time_control", "0;19,23,100");
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          j = -1;
        }
        else
        {
          localObject1 = ((String)localObject1).split(";");
          if (localObject1 != null)
          {
            if (localObject1.length > 1) {
              break label413;
            }
            continue;
            if (j < localObject1.length)
            {
              Object localObject2 = localObject1[j];
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                j = -1;
                break label301;
              }
              localObject2 = ((String)localObject2).split(",");
              if ((localObject2 != null) && (localObject2.length == 3))
              {
                int n = Integer.valueOf(localObject2[0]).intValue();
                int i1 = Integer.valueOf(localObject2[1]).intValue();
                k = Integer.valueOf(localObject2[2]).intValue();
                if ((n >= 0) && (n <= 23))
                {
                  if ((i1 > 0) && (i1 <= 24))
                  {
                    if (i1 <= n)
                    {
                      j = -1;
                      break label301;
                    }
                    if ((k >= 0) && (k <= 100))
                    {
                      if ((m >= n) && (m < i1))
                      {
                        j = k;
                        break label301;
                      }
                      j += 1;
                      continue;
                    }
                    j = -1;
                    break label301;
                  }
                  j = -1;
                  break label301;
                }
                j = -1;
                break label301;
              }
              j = -1;
              break label301;
            }
            j = 0;
            break label301;
          }
          j = -1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        j = -1;
      }
      label301:
      int k = j;
      if (j == -1) {
        if ((m >= 19) && (m < 23)) {
          k = 100;
        } else {
          k = 0;
        }
      }
      if (k == 0) {
        return true;
      }
      if (k == 100) {
        return false;
      }
      double d1 = k;
      Double.isNaN(d1);
      d1 /= 100.0D;
      double d2 = Math.random();
      StringBuilder localStringBuilder = new StringBuilder("配置文件中设置的过滤比例=");
      localStringBuilder.append(d1);
      localStringBuilder.append(",生成的随机数=");
      localStringBuilder.append(d2);
      return d2 >= d1;
      label413:
      int j = 1;
    }
  }
  
  private boolean j()
  {
    synchronized (this.h)
    {
      return (this.f != null) && (this.f.c != null) && ((this.f.c.f == DownloaderTaskStatus.STARTED) || (this.f.c.f == DownloaderTaskStatus.DOWNLOADING));
    }
  }
  
  public final void a(final si paramsi)
  {
    CSDCheckData localCSDCheckData = new CSDCheckData();
    localCSDCheckData.taskNo = this.c.i();
    new StringBuilder("DoubleCheck TaskNo : ").append(this.c.i());
    if (localCSDCheckData.taskNo == 0L)
    {
      paramsi.b();
      return;
    }
    TMSDKContext.sendShark(3150, localCSDCheckData, new SCDCheckRes(), new ISharkCallBackOut()
    {
      public final void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        if (paramAnonymousInt3 == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder("DoubleCheck : ");
          localStringBuilder.append(paramAnonymousInt1);
          localStringBuilder.append("|");
          localStringBuilder.append(paramAnonymousInt2);
          localStringBuilder.append("|");
          localStringBuilder.append(paramAnonymousInt3);
          localStringBuilder.append("|");
          localStringBuilder.append(paramAnonymousInt4);
          if (paramAnonymousInt2 == 13150) {
            try
            {
              paramAnonymousJceStruct = (SCDCheckRes)paramAnonymousJceStruct;
              localStringBuilder = new StringBuilder("DoubleCheck : ");
              localStringBuilder.append(paramAnonymousJceStruct.retCode);
              localStringBuilder.append("|");
              localStringBuilder.append(paramAnonymousJceStruct.res);
              if (paramAnonymousJceStruct.retCode == 0)
              {
                if (paramAnonymousJceStruct.res == 0)
                {
                  paramsi.b();
                  return;
                }
                if (paramAnonymousJceStruct.res == 1) {
                  paramsi.a();
                }
              }
              return;
            }
            catch (Exception paramAnonymousJceStruct)
            {
              paramAnonymousJceStruct.printStackTrace();
            }
          }
        }
      }
    });
  }
  
  final boolean a(boolean paramBoolean)
  {
    if (!i()) {
      return false;
    }
    if (this.g) {
      return false;
    }
    if (this.a) {
      return false;
    }
    if (j())
    {
      if (this.e)
      {
        RqdApplication.n().unregisterReceiver(this.i);
        this.e = false;
      }
      return false;
    }
    int j;
    if ((this.c.a.a("meri_silent_update_switch_cloud", true)) && (this.c.a.a("meri_silent_update", false)) && (e())) {
      j = 1;
    } else {
      j = 0;
    }
    if (j == 0) {
      return false;
    }
    Object localObject1 = NetworkUtil.getNetworkType();
    Object localObject2;
    if (paramBoolean) {
      localObject2 = arm.d;
    }
    if ((this.c.a.a("meri_silent_update_switch_user", true)) && (localObject1 == arm.d))
    {
      localObject1 = new PhoneInfoFetcher.SizeInfo();
      PhoneInfoFetcher.getStorageCardSize((PhoneInfoFetcher.SizeInfo)localObject1);
      localObject2 = new StringBuilder("hasEnoughStorage info.availdSize :");
      ((StringBuilder)localObject2).append(((PhoneInfoFetcher.SizeInfo)localObject1).availdSize);
      ((StringBuilder)localObject2).append(" info.percent:");
      ((StringBuilder)localObject2).append(((PhoneInfoFetcher.SizeInfo)localObject1).percent());
      if ((((PhoneInfoFetcher.SizeInfo)localObject1).availdSize < 524288000L) && (((PhoneInfoFetcher.SizeInfo)localObject1).percent() >= 90L)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j != 0) {
        return true;
      }
    }
    if ((!this.e) && (!this.c.l()))
    {
      if (this.c.a.a("meri_silent_update_show_insatll_notice", false)) {
        return false;
      }
      localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ((IntentFilter)localObject1).addAction("android.net.wifi.WIFI_STATE_CHANGED");
      ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
      RqdApplication.n().registerReceiver(this.i, (IntentFilter)localObject1);
      this.e = true;
    }
    return false;
  }
  
  public final void c()
  {
    synchronized (this.h)
    {
      long l = this.c.i();
      if (l > 0L) {
        this.c.a.b("conch_update_cloud_task_for_active", l);
      }
      this.c.a(0L, 0L, 0, 0);
      sj localsj = this.c;
      localsj.a.a();
      localsj.h(0);
      localsj.d("");
      localsj.a.b("meri_update_start_time", 0L);
      localsj.a(0L);
      localsj.b(0);
      localsj.c(0);
      localsj.d(0);
      localsj.e(0);
      localsj.f(0);
      localsj.b("");
      localsj.c("");
      localsj.a(0);
      localsj.a("");
      localsj.a.b("meri_patch_url", "");
      localsj.g(0);
      localsj.b(0L);
      localsj.c(0L);
      localsj.a.b("meri_update_show_dialog_count", 0);
      localsj.b(false);
      localsj.e("");
      localsj.f("");
      localsj.g("");
      localsj.i(0);
      localsj.j(0);
      localsj.a.b("has_click_update_tip_in_main_page", false);
      localsj.a.b();
      this.c.k(0);
      this.c.a.b("meri_need_show_update_dialog", false);
      this.c.k();
      this.c.m();
      this.c.c(false);
      if (this.f != null)
      {
        this.f.a();
        this.f.c = null;
      }
      return;
    }
  }
  
  public final boolean e()
  {
    long l = this.c.c();
    if (l < System.currentTimeMillis())
    {
      if (l > 0L) {
        c();
      }
      return false;
    }
    if (!a(this.c.g()))
    {
      if (this.c.g() > 0) {
        c();
      }
      return false;
    }
    return true;
  }
  
  public final void f()
  {
    final rw.a locala = a().g();
    if (locala == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        if (sk.a(sk.this) != null)
        {
          new UpdateDownloadDialog(sk.a(sk.this), locala).show();
          sk.d();
          sk.b(sk.this).c(System.currentTimeMillis() + sk.b(sk.this).n());
        }
      }
    });
  }
  
  public final rw.a g()
  {
    for (;;)
    {
      synchronized (this.h)
      {
        if (this.f != null)
        {
          rw.a locala = this.f.a();
          return locala;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public final void h()
  {
    a(new si()
    {
      public final void a()
      {
        int i = sk.b(sk.this).a.a("meri_update_msg_type");
        if ((i != 0) && (i != 6)) {
          return;
        }
        sk localsk = sk.this;
        rw.a locala = sk.a().g();
        if ((locala != null) && (localsk.b != null)) {
          new Handler(Looper.getMainLooper()).post(new sk.3(localsk, locala));
        }
      }
      
      public final void b()
      {
        sk.this.c();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.sk
 * JD-Core Version:    0.7.0.1
 */