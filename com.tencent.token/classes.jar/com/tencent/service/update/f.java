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
import java.io.Serializable;
import java.util.Calendar;
import tmsdk.QQPIM.ConnectType;

public class f
{
  private static f a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("askType:");
    localStringBuilder.append(j);
    Log.e("UpdateManager", localStringBuilder.toString());
    a(paramBundle.getLong("taskId"), paramBundle.getLong("task_seqno"), paramBundle.getInt("cmd_id"), paramBundle.getInt("conch_seqno"));
    a(paramSoftUpdateInfo, paramBundle.getLong("valid_End_Time") * 1000L, paramBundle.getInt("message_type"), paramBundle.getString("message_title"));
    if (!g()) {
      return;
    }
    a(1, 1);
    if (this.b) {
      return;
    }
    if (e(true)) {
      return;
    }
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("APK静默下载配置参数=");
    ((StringBuilder)localObject2).append((String)localObject1);
    Log.e("UpdateManager", ((StringBuilder)localObject2).toString());
    localObject1 = ((String)localObject1).split(";");
    if (localObject1 != null)
    {
      if (localObject1.length <= 1) {
        return -1;
      }
      int j = 1;
      while (j < localObject1.length)
      {
        localObject2 = localObject1[j];
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return -1;
        }
        localObject2 = ((String)localObject2).split(",");
        if (localObject2 != null)
        {
          if (localObject2.length != 3) {
            return -1;
          }
          int k = Integer.valueOf(localObject2[0]).intValue();
          int m = Integer.valueOf(localObject2[1]).intValue();
          int n = Integer.valueOf(localObject2[2]).intValue();
          if (k >= 0)
          {
            if (k > 23) {
              return -1;
            }
            if (m >= 1)
            {
              if (m > 24) {
                return -1;
              }
              if (m <= k) {
                return -1;
              }
              if (n >= 0)
              {
                if (n > 100) {
                  return -1;
                }
                if ((paramInt >= k) && (paramInt < m)) {
                  return n;
                }
                j += 1;
              }
              else
              {
                return -1;
              }
            }
            else
            {
              return -1;
            }
          }
          else
          {
            return -1;
          }
        }
        else
        {
          return -1;
        }
      }
      return 0;
    }
    return -1;
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
    if (paramBoolean) {
      if (localConnectType == ConnectType.CT_WIFI) {
        Log.i("UpdateManager", "canUpdateSilently onReceiveUpdateCloud wifi");
      } else {
        Log.i("UpdateManager", "canUpdateSilently onReceiveUpdateCloud no wifi");
      }
    }
    if ((this.h.m()) && (localConnectType == ConnectType.CT_WIFI) && (u()))
    {
      Log.i("UpdateManager", "canUpdateSilently true");
      return true;
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
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    int m = ((Calendar)localObject).get(11);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("现在时间的小时数是：");
    ((StringBuilder)localObject).append(m);
    Log.d("UpdateManager", ((StringBuilder)localObject).toString());
    int j;
    try
    {
      j = b(m);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.e("UpdateManager", "APK静默下载配置文件解析异常，将使用本地默认控制");
      j = -1;
    }
    int k = j;
    if (j == -1) {
      if ((m >= 19) && (m < 23)) {
        k = 100;
      } else {
        k = 0;
      }
    }
    if (k == 0)
    {
      Log.d("UpdateManager", "配置文件中已设置为不过滤，本次可以下载APK");
      return true;
    }
    if (k == 100)
    {
      Log.d("UpdateManager", "配置文件中已设置为全部过滤，本次不可以下载任何APK");
      return false;
    }
    double d1 = k;
    Double.isNaN(d1);
    d1 /= 100.0D;
    double d2 = Math.random();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("配置文件中设置的过滤比例=");
    localStringBuilder.append(d1);
    localStringBuilder.append(",生成的随机数=");
    localStringBuilder.append(d2);
    Log.d("UpdateManager", localStringBuilder.toString());
    if (d2 < d1)
    {
      Log.d("UpdateManager", "随机数小于过滤比例，本次不能下载APK");
      return false;
    }
    Log.d("UpdateManager", "随机数大于等于过滤比例，本次可以下载APK");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasEnoughStorage info.availdSize :");
    localStringBuilder.append(localSizeInfo.availdSize);
    localStringBuilder.append(" info.percent:");
    localStringBuilder.append(localSizeInfo.percent());
    Log.i("UpdateManager", localStringBuilder.toString());
    if ((localSizeInfo.availdSize < 524288000L) && (localSizeInfo.percent() >= 90L))
    {
      Log.i("UpdateManager", "hasEnoughStorage false");
      return false;
    }
    Log.i("UpdateManager", "hasEnoughStorage true");
    return true;
  }
  
  private boolean v()
  {
    boolean bool = this.h.s();
    long l = this.h.v();
    if (bool)
    {
      if (System.currentTimeMillis() < l) {
        return false;
      }
      if ((g()) && (i.a()))
      {
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
      return false;
    }
    return false;
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
    if (localSoftUpdateInfo == null)
    {
      Log.i("UpdateManager", "handleSoftUpdate null");
      return;
    }
    if (paramBundle.getLong("taskId") > this.h.k()) {
      d();
    }
    if (g())
    {
      Log.i("UpdateManager", "handleSoftUpdate hasUpdateInfo return");
      if (this.b) {
        o();
      }
      return;
    }
    a(localSoftUpdateInfo, paramBundle);
  }
  
  public void a(final d paramd)
  {
    CSDCheckData localCSDCheckData = new CSDCheckData();
    localCSDCheckData.taskNo = this.h.k();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoubleCheck TaskNo : ");
    localStringBuilder.append(this.h.k());
    Log.i("UpdateManager", localStringBuilder.toString());
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DoubleCheck : ");
          localStringBuilder.append(paramAnonymousInt1);
          localStringBuilder.append("|");
          localStringBuilder.append(paramAnonymousInt2);
          localStringBuilder.append("|");
          localStringBuilder.append(paramAnonymousInt3);
          localStringBuilder.append("|");
          localStringBuilder.append(paramAnonymousInt4);
          Log.i("UpdateManager", localStringBuilder.toString());
          if (paramAnonymousInt2 == 13150) {
            try
            {
              paramAnonymousJceStruct = (SCDCheckRes)paramAnonymousJceStruct;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("DoubleCheck : ");
              localStringBuilder.append(paramAnonymousJceStruct.retCode);
              localStringBuilder.append("|");
              localStringBuilder.append(paramAnonymousJceStruct.res);
              Log.i("UpdateManager", localStringBuilder.toString());
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
              paramd.c();
              return;
            }
            catch (Exception paramAnonymousJceStruct)
            {
              paramd.c();
              paramAnonymousJceStruct.printStackTrace();
              return;
            }
          } else {
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
    if (this.c) {
      return;
    }
    if (!this.h.s())
    {
      if (this.h.t()) {
        return;
      }
      if (((paramBoolean) && (i())) || (!paramBoolean))
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
        RqdApplication.l().registerReceiver(this.i, localIntentFilter);
        this.c = true;
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt <= 0)
    {
      Log.i("UpdateManager", "hasUpdateInfo buildNumber <= 0");
      return false;
    }
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
    return false;
  }
  
  public a.a b(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.h.d());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(this.h.e());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(this.h.f());
    String str = ((StringBuilder)localObject).toString();
    int j = -this.h.g();
    if (paramBoolean) {
      localObject = this.h.r();
    } else if (f()) {
      localObject = this.h.j();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.token_");
    localStringBuilder.append(j);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    localObject = this.d.a((String)localObject, str);
    if (a.a().a((a.a)localObject)) {
      ((a.a)localObject).f = DownloaderTaskStatus.COMPLETE;
    }
    return localObject;
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
        if ((paramAnonymousConchPushInfo != null) && (paramAnonymousConchPushInfo.mConch != null))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onRecvPush info : ");
          ((StringBuilder)localObject).append(paramAnonymousConchPushInfo.mTaskId);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(paramAnonymousConchPushInfo.mTaskSeqno);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(paramAnonymousConchPushInfo.mConch.cmdId);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(ConchPushInfoUtil.getConchSeqno(paramAnonymousConchPushInfo.mConch));
          Log.i("UpdateManager", ((StringBuilder)localObject).toString());
          if (paramAnonymousConchPushInfo.mConch.cmdId != 200) {
            return;
          }
          Log.i("UpdateManager", "onRecvPush softUpdate");
          TMSDKContext.saveActionData(1150105);
          if (this.mErrorCode == 0)
          {
            localObject = (SoftUpdateInfo)JceStructUtil.getJceStruct(ConchPushInfoUtil.getConchParams(paramAnonymousConchPushInfo.mConch), new SoftUpdateInfo(), false);
            if (localObject != null) {
              localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 10, 1);
            } else {
              localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 10, 2);
            }
            Bundle localBundle = new Bundle();
            localBundle.putLong("valid_End_Time", ConchPushInfoUtil.getConchTime(paramAnonymousConchPushInfo.mConch).validEndTime);
            localBundle.putInt("ask_type", ConchPushInfoUtil.getConchTips(paramAnonymousConchPushInfo.mConch).bq);
            localBundle.putSerializable("update_info", (Serializable)localObject);
            localBundle.putInt("message_type", ConchPushInfoUtil.getConchTips(paramAnonymousConchPushInfo.mConch).type);
            localBundle.putString("message_title", ConchPushInfoUtil.getConchTips(paramAnonymousConchPushInfo.mConch).title);
            localBundle.putLong("taskId", paramAnonymousConchPushInfo.mTaskId);
            localBundle.putLong("task_seqno", paramAnonymousConchPushInfo.mTaskSeqno);
            localBundle.putInt("cmd_id", paramAnonymousConchPushInfo.mConch.cmdId);
            localBundle.putInt("conch_seqno", ConchPushInfoUtil.getConchSeqno(paramAnonymousConchPushInfo.mConch));
            f.a().a(localBundle);
            return;
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
          return;
        }
        Log.i("UpdateManager", "onRecvPush (conchPushInfo == null) || (conchPushInfo.mConch == null)");
        new Bundle().putInt("soft_update_ret", this.mErrorCode);
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
    if (locala == null) {
      return;
    }
    if (this.g != null) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          new UpdateDownloadDialog(f.a(f.this), 2131558791, locala).show();
          f.this.a(4, 1);
          f.b(f.this).e(System.currentTimeMillis() + f.b(f.this).u());
          TMSDKContext.saveActionData(1150106);
        }
      });
    }
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
          new UpdateDownloadDialog(f.a(f.this), 2131558791, locala).show();
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
      return false;
    }
    if (!a(this.h.g()))
    {
      Log.i("UpdateManager", "hasUpdateInfo build < now");
      if (this.h.g() > 0) {
        d();
      }
      return false;
    }
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
    if (t()) {
      return;
    }
    if (r()) {
      l();
    }
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
    for (;;)
    {
      synchronized (this.f)
      {
        if (this.d != null)
        {
          a.a locala = this.d.a();
          return locala;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void n()
  {
    Log.i("UpdateManager", "notifyUpdate");
    a(new d()
    {
      public void a()
      {
        if (f.b(f.this).o() != 6) {
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