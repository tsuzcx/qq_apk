package com.tencent.service.update;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import btmsdkobf.ai;
import btmsdkobf.aj;
import btmsdkobf.z;
import com.qq.taf.jce.JceStruct;
import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.service.a;
import com.tencent.service.a.a;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.upload.i;
import com.tencent.token.utils.j;
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
import tmsdk.QQPIM.ConnectType;

public class f
{
  private static f a = null;
  private boolean b;
  private boolean c;
  private b d = new b("com.tencent.token");
  private boolean e = false;
  private byte[] f = new byte[0];
  private Activity g;
  private e h = e.a();
  private BroadcastReceiver i = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) && (NetworkUtil.getNetworkType().value() == 2)) {
        f.this.j();
      }
    }
  };
  
  public static f a()
  {
    try
    {
      if (a == null) {
        a = new f();
      }
      f localf = a;
      return localf;
    }
    finally {}
  }
  
  private void a(SoftUpdateInfo paramSoftUpdateInfo, long paramLong, int paramInt, String paramString)
  {
    this.h.a(paramSoftUpdateInfo, paramLong, paramInt, paramString);
  }
  
  private void a(SoftUpdateInfo paramSoftUpdateInfo, Bundle paramBundle)
  {
    int j = paramBundle.getInt("ask_type");
    Log.e("UpdateManager", "askType:" + j);
    a(paramBundle.getLong("taskId"), paramBundle.getLong("task_seqno"), paramBundle.getInt("cmd_id"), paramBundle.getInt("conch_seqno"));
    a(paramSoftUpdateInfo, 1000L * paramBundle.getLong("valid_End_Time"), paramBundle.getInt("message_type"), paramBundle.getString("message_title"));
    if (!g()) {}
    do
    {
      return;
      a(1, 1);
    } while ((this.b) || (e(true)));
    n();
  }
  
  private int b(int paramInt)
  {
    Object localObject1 = this.h.w();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("UpdateManager", "APK静默下载配置参数为空");
      return -1;
    }
    Log.e("UpdateManager", "APK静默下载配置参数=" + (String)localObject1);
    localObject1 = ((String)localObject1).split(";");
    if ((localObject1 == null) || (localObject1.length <= 1)) {
      return -1;
    }
    int j = 1;
    while (j < localObject1.length)
    {
      Object localObject2 = localObject1[j];
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return -1;
      }
      localObject2 = ((String)localObject2).split(",");
      if ((localObject2 == null) || (localObject2.length != 3)) {
        return -1;
      }
      int k = Integer.valueOf(localObject2[0]).intValue();
      int m = Integer.valueOf(localObject2[1]).intValue();
      int n = Integer.valueOf(localObject2[2]).intValue();
      if ((k < 0) || (k > 23)) {
        return -1;
      }
      if ((m < 1) || (m > 24)) {
        return -1;
      }
      if (m <= k) {
        return -1;
      }
      if ((n < 0) || (n > 100)) {
        return -1;
      }
      if ((paramInt >= k) && (paramInt < m)) {
        return n;
      }
      j += 1;
    }
    return 0;
  }
  
  private boolean e(boolean paramBoolean)
  {
    Log.i("UpdateManager", "canUpdateSilently");
    if (!q())
    {
      Log.i("UpdateManager", "canUpdateSilently canDownloadAPK is false");
      return false;
    }
    if (this.e)
    {
      Log.i("UpdateManager", "canUpdateSilently mIsUpdateUIShowing");
      return false;
    }
    if (this.b)
    {
      Log.i("UpdateManager", "canUpdateSilently mManualUpdateFlag");
      return false;
    }
    if (s())
    {
      Log.i("UpdateManager", "canUpdateSilently isDownloadTaskRunning");
      h();
      return false;
    }
    if (!i())
    {
      Log.i("UpdateManager", "canUpdateSilently !isSilentUpdate()");
      return false;
    }
    ConnectType localConnectType = NetworkUtil.getNetworkType();
    if (paramBoolean)
    {
      if (localConnectType != ConnectType.CT_WIFI) {
        break label154;
      }
      Log.i("UpdateManager", "canUpdateSilently onReceiveUpdateCloud wifi");
    }
    while ((this.h.m()) && (localConnectType == ConnectType.CT_WIFI) && (u()))
    {
      Log.i("UpdateManager", "canUpdateSilently true");
      return true;
      label154:
      Log.i("UpdateManager", "canUpdateSilently onReceiveUpdateCloud no wifi");
    }
    Log.i("UpdateManager", "canUpdateSilently false");
    a(false);
    return false;
  }
  
  private void o() {}
  
  private void p()
  {
    this.h.l();
  }
  
  private boolean q()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    int m = localCalendar.get(11);
    Log.d("UpdateManager", "现在时间的小时数是：" + m);
    try
    {
      j = b(m);
      k = j;
      if (j == -1)
      {
        if ((m >= 19) && (m < 23)) {
          k = 100;
        }
      }
      else
      {
        if (k != 0) {
          break label129;
        }
        Log.d("UpdateManager", "配置文件中已设置为不过滤，本次可以下载APK");
        return true;
      }
    }
    catch (Exception localException)
    {
      int k;
      for (;;)
      {
        localException.printStackTrace();
        Log.e("UpdateManager", "APK静默下载配置文件解析异常，将使用本地默认控制");
        int j = -1;
        continue;
        k = 0;
      }
      label129:
      if (k == 100)
      {
        Log.d("UpdateManager", "配置文件中已设置为全部过滤，本次不可以下载任何APK");
        return false;
      }
      double d1 = k / 100.0D;
      double d2 = Math.random();
      Log.d("UpdateManager", "配置文件中设置的过滤比例=" + d1 + ",生成的随机数=" + d2);
      if (d2 < d1)
      {
        Log.d("UpdateManager", "随机数小于过滤比例，本次不能下载APK");
        return false;
      }
      Log.d("UpdateManager", "随机数大于等于过滤比例，本次可以下载APK");
    }
    return true;
  }
  
  private boolean r()
  {
    return e(false);
  }
  
  private boolean s()
  {
    synchronized (this.f)
    {
      if ((this.d != null) && (this.d.c != null) && ((this.d.c.f == DownloaderTaskStatus.STARTED) || (this.d.c.f == DownloaderTaskStatus.DOWNLOADING)))
      {
        Log.i("UpdateManager", "isDownloadTaskRunning true");
        return true;
      }
      Log.i("UpdateManager", "isDownloadTaskRunning false");
      return false;
    }
  }
  
  private boolean t()
  {
    Log.i("UpdateManager", "isSilentDownloadTaskRunning false");
    return false;
  }
  
  private boolean u()
  {
    PhoneInfoFetcher.SizeInfo localSizeInfo = new PhoneInfoFetcher.SizeInfo();
    PhoneInfoFetcher.getStorageCardSize(localSizeInfo);
    Log.i("UpdateManager", "hasEnoughStorage info.availdSize :" + localSizeInfo.availdSize + " info.percent:" + localSizeInfo.percent());
    if ((localSizeInfo.availdSize >= 524288000L) || (localSizeInfo.percent() < 90L))
    {
      Log.i("UpdateManager", "hasEnoughStorage true");
      return true;
    }
    Log.i("UpdateManager", "hasEnoughStorage false");
    return false;
  }
  
  private boolean v()
  {
    boolean bool = this.h.s();
    long l = this.h.v();
    if ((!bool) || (System.currentTimeMillis() < l)) {}
    while ((!g()) || (!i.a())) {
      return false;
    }
    a().a(new d()
    {
      public void a()
      {
        f.this.d(false);
      }
      
      public void b()
      {
        f.a().d();
      }
      
      public void c() {}
    });
    return true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ConchServiceProxy.getInstance();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    this.h.a(paramLong1, paramLong2, paramInt1, paramInt2);
  }
  
  public void a(Activity paramActivity)
  {
    this.g = paramActivity;
  }
  
  public void a(Bundle paramBundle)
  {
    Log.i("UpdateManager", "handleSoftUpdate");
    SoftUpdateInfo localSoftUpdateInfo = (SoftUpdateInfo)paramBundle.getSerializable("update_info");
    if (localSoftUpdateInfo == null) {
      Log.i("UpdateManager", "handleSoftUpdate null");
    }
    do
    {
      return;
      if (paramBundle.getLong("taskId") > this.h.k()) {
        d();
      }
      if (!g()) {
        break;
      }
      Log.i("UpdateManager", "handleSoftUpdate hasUpdateInfo return");
    } while (!this.b);
    o();
    return;
    a(localSoftUpdateInfo, paramBundle);
  }
  
  public void a(final d paramd)
  {
    CSDCheckData localCSDCheckData = new CSDCheckData();
    localCSDCheckData.taskNo = this.h.k();
    Log.i("UpdateManager", "DoubleCheck TaskNo : " + this.h.k());
    if (this.h.k() == 0L)
    {
      paramd.b();
      return;
    }
    TMSDKContext.sendShark(3150, localCSDCheckData, new SCDCheckRes(), new ISharkCallBackOut()
    {
      public void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        if (paramAnonymousInt3 == 0)
        {
          Log.i("UpdateManager", "DoubleCheck : " + paramAnonymousInt1 + "|" + paramAnonymousInt2 + "|" + paramAnonymousInt3 + "|" + paramAnonymousInt4);
          if (paramAnonymousInt2 == 13150)
          {
            try
            {
              paramAnonymousJceStruct = (SCDCheckRes)paramAnonymousJceStruct;
              Log.i("UpdateManager", "DoubleCheck : " + paramAnonymousJceStruct.retCode + "|" + paramAnonymousJceStruct.res);
              if (paramAnonymousJceStruct.retCode == 0)
              {
                if (paramAnonymousJceStruct.res == 0)
                {
                  paramd.b();
                  return;
                }
                if (paramAnonymousJceStruct.res != 1) {
                  return;
                }
                paramd.a();
                return;
              }
            }
            catch (Exception paramAnonymousJceStruct)
            {
              paramd.c();
              paramAnonymousJceStruct.printStackTrace();
              return;
            }
            paramd.c();
          }
          else
          {
            paramd.c();
          }
        }
        else
        {
          paramd.c();
        }
      }
    });
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.c) {}
    while ((this.h.s()) || (this.h.t()) || (((!paramBoolean) || (!i())) && (paramBoolean))) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    RqdApplication.l().registerReceiver(this.i, localIntentFilter);
    this.c = true;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      Log.i("UpdateManager", "hasUpdateInfo buildNumber <= 0");
    }
    for (;;)
    {
      return false;
      Log.i("UpdateManager", "isBuildVesionNew");
      int j = j.a;
      try
      {
        if (Integer.valueOf(String.valueOf(j)).intValue() < paramInt)
        {
          Log.i("UpdateManager", "isBuildVesionNew curBuild < buildNumber");
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }
  
  public a.a b(boolean paramBoolean)
  {
    Object localObject2 = null;
    String str = this.h.d() + "." + this.h.e() + "." + this.h.f();
    int j = -this.h.g();
    Object localObject1;
    if (paramBoolean) {
      localObject1 = this.h.r();
    }
    for (;;)
    {
      if (localObject1 == null) {
        localObject1 = localObject2;
      }
      do
      {
        return localObject1;
        if (!f()) {
          break label175;
        }
        localObject1 = this.h.j();
        break;
        localObject2 = "com.tencent.token_" + j + "_" + str;
        localObject2 = this.d.a((String)localObject1, (String)localObject2);
        localObject1 = localObject2;
      } while (!a.a().a((a.a)localObject2));
      ((a.a)localObject2).f = DownloaderTaskStatus.COMPLETE;
      return localObject2;
      label175:
      localObject1 = null;
    }
  }
  
  public void b()
  {
    Log.i("UpdateManager", "registerConch");
    final ConchServiceProxy localConchServiceProxy = ConchServiceProxy.getInstance();
    localConchServiceProxy.registerConchPush(200, new ConchService.IConchPushListener()
    {
      public void onRecvPush(ConchService.ConchPushInfo paramAnonymousConchPushInfo)
      {
        Log.i("UpdateManager", "onRecvPush");
        if ((paramAnonymousConchPushInfo == null) || (paramAnonymousConchPushInfo.mConch == null))
        {
          Log.i("UpdateManager", "onRecvPush (conchPushInfo == null) || (conchPushInfo.mConch == null)");
          new Bundle().putInt("soft_update_ret", this.mErrorCode);
          return;
        }
        Log.i("UpdateManager", "onRecvPush info : " + paramAnonymousConchPushInfo.mTaskId + "|" + paramAnonymousConchPushInfo.mTaskSeqno + "|" + paramAnonymousConchPushInfo.mConch.cmdId + "|" + ConchPushInfoUtil.getConchSeqno(paramAnonymousConchPushInfo.mConch));
        switch (paramAnonymousConchPushInfo.mConch.cmdId)
        {
        default: 
          return;
        }
        Log.i("UpdateManager", "onRecvPush softUpdate");
        TMSDKContext.saveActionData(1150105);
        if (this.mErrorCode == 0)
        {
          SoftUpdateInfo localSoftUpdateInfo = (SoftUpdateInfo)JceStructUtil.getJceStruct(ConchPushInfoUtil.getConchParams(paramAnonymousConchPushInfo.mConch), new SoftUpdateInfo(), false);
          if (localSoftUpdateInfo != null) {
            localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 10, 1);
          }
          for (;;)
          {
            Bundle localBundle = new Bundle();
            localBundle.putLong("valid_End_Time", ConchPushInfoUtil.getConchTime(paramAnonymousConchPushInfo.mConch).validEndTime);
            localBundle.putInt("ask_type", ConchPushInfoUtil.getConchTips(paramAnonymousConchPushInfo.mConch).bq);
            localBundle.putSerializable("update_info", localSoftUpdateInfo);
            localBundle.putInt("message_type", ConchPushInfoUtil.getConchTips(paramAnonymousConchPushInfo.mConch).type);
            localBundle.putString("message_title", ConchPushInfoUtil.getConchTips(paramAnonymousConchPushInfo.mConch).title);
            localBundle.putLong("taskId", paramAnonymousConchPushInfo.mTaskId);
            localBundle.putLong("task_seqno", paramAnonymousConchPushInfo.mTaskSeqno);
            localBundle.putInt("cmd_id", paramAnonymousConchPushInfo.mConch.cmdId);
            localBundle.putInt("conch_seqno", ConchPushInfoUtil.getConchSeqno(paramAnonymousConchPushInfo.mConch));
            f.a().a(localBundle);
            return;
            localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 10, 2);
          }
        }
        if (this.mErrorCode == -2)
        {
          paramAnonymousConchPushInfo = new Bundle();
          paramAnonymousConchPushInfo.putInt("soft_update_ret", 0);
          f.a().b(paramAnonymousConchPushInfo);
          return;
        }
        paramAnonymousConchPushInfo = new Bundle();
        paramAnonymousConchPushInfo.putInt("soft_update_ret", this.mErrorCode);
        f.a().b(paramAnonymousConchPushInfo);
      }
    });
    localConchServiceProxy.pullConch(200);
  }
  
  public void b(Bundle paramBundle) {}
  
  public void c()
  {
    ConchServiceProxy.getInstance().unRegisterConchPush(200);
  }
  
  public void c(boolean paramBoolean)
  {
    Log.i("UpdateManager", "showUpdateDialog");
    final a.a locala = a().m();
    if (locala == null) {}
    while (this.g == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        new UpdateDownloadDialog(f.a(f.this), 2131362182, locala).show();
        f.this.a(4, 1);
        f.b(f.this).e(System.currentTimeMillis() + f.b(f.this).u());
        TMSDKContext.saveActionData(1150106);
      }
    });
  }
  
  public void d()
  {
    synchronized (this.f)
    {
      Log.i("UpdateManager", "resetUpdate");
      e();
      p();
      this.h.k(0);
      this.h.a(false);
      this.h.c(false);
      this.h.d(false);
      this.h.e(false);
      if (this.d != null)
      {
        this.d.a(this.d.a());
        this.d.b();
      }
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    final a.a locala = a().m();
    if (locala == null) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        if (f.a(f.this) != null)
        {
          new UpdateDownloadDialog(f.a(f.this), 2131362182, locala).show();
          f.this.a(4, 1);
          f.b(f.this).e(System.currentTimeMillis() + f.b(f.this).u());
        }
      }
    });
  }
  
  public void e()
  {
    long l = this.h.k();
    if (l > 0L) {
      this.h.c(l);
    }
    this.h.a(0L, 0L, 0, 0);
  }
  
  public boolean f()
  {
    if (this.h.c() != 0) {
      return false;
    }
    return g();
  }
  
  public boolean g()
  {
    Log.i("UpdateManager", "hasUpdateInfo");
    long l = this.h.b();
    if (l < System.currentTimeMillis())
    {
      Log.i("UpdateManager", "hasUpdateInfo endTimeMillis < now");
      if (l > 0L) {
        d();
      }
    }
    do
    {
      return false;
      if (a(this.h.g())) {
        break;
      }
      Log.i("UpdateManager", "hasUpdateInfo build < now");
    } while (this.h.g() <= 0);
    d();
    return false;
    return true;
  }
  
  public void h()
  {
    if (this.c)
    {
      RqdApplication.l().unregisterReceiver(this.i);
      this.c = false;
    }
  }
  
  public boolean i()
  {
    Log.i("UpdateManager", "isSilentUpdate");
    if ((this.h.n()) && (this.h.q()) && (g()))
    {
      Log.i("UpdateManager", "isSilentUpdate true");
      return true;
    }
    return false;
  }
  
  public void j()
  {
    Log.i("UpdateManager", "change to wifi!");
    if (t()) {}
    while (!r()) {
      return;
    }
    l();
  }
  
  public boolean k()
  {
    a.a locala = m();
    if ((locala == null) || (locala.f != DownloaderTaskStatus.COMPLETE))
    {
      this.h.c(false);
      this.h.d(false);
    }
    if (v()) {
      return true;
    }
    if (g())
    {
      if (i.a())
      {
        long l = this.h.v();
        if (System.currentTimeMillis() < l) {
          return false;
        }
        if (locala != null)
        {
          if (locala.f == DownloaderTaskStatus.COMPLETE)
          {
            a().a(new d()
            {
              public void a()
              {
                f.this.d(true);
              }
              
              public void b()
              {
                f.a().d();
              }
              
              public void c() {}
            });
            return true;
          }
          n();
          return true;
        }
        n();
        return true;
      }
      return false;
    }
    return false;
  }
  
  public void l() {}
  
  public a.a m()
  {
    a.a locala = null;
    synchronized (this.f)
    {
      if (this.d != null) {
        locala = this.d.a();
      }
      return locala;
    }
  }
  
  public void n()
  {
    Log.i("UpdateManager", "notifyUpdate");
    a(new d()
    {
      public void a()
      {
        switch (f.b(f.this).o())
        {
        default: 
          return;
        }
        f.this.c(false);
      }
      
      public void b()
      {
        f.this.d();
      }
      
      public void c() {}
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.update.f
 * JD-Core Version:    0.7.0.1
 */