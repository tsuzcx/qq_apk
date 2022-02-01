package com.tencent.service;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.push.a;
import com.tencent.push.d;
import com.tencent.token.bz;
import com.tencent.token.core.bean.OnlineDeviceResult.a;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.cr;
import com.tencent.token.ct;
import com.tencent.token.cu;
import com.tencent.token.dk;
import com.tencent.token.ed;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.utils.l;
import com.tmsdk.TMSDKContext;
import com.tmsdk.common.util.TmsLog;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class f
{
  private Handler a;
  private long b;
  private volatile boolean c;
  
  private f()
  {
    HandlerThread localHandlerThread = new HandlerThread("LoginTraceManager", 5);
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper());
  }
  
  private b a(long paramLong)
  {
    List localList1 = g.a().a(paramLong);
    List localList2 = ct.a().f.c(paramLong);
    if ((localList1 != null) && (localList2 != null)) {
      return new b(localList1, localList2);
    }
    TmsLog.i("LoginTraceManager", "@checkHasChanged, pull failed, return null this time.");
    return null;
  }
  
  private b a(long paramLong, final byte[] paramArrayOfByte)
  {
    Object localObject = new AtomicInteger(0);
    final CountDownLatch localCountDownLatch = new CountDownLatch(1);
    localObject = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage what:");
        localStringBuilder.append(paramAnonymousMessage.what);
        localStringBuilder.append(", ret:");
        localStringBuilder.append(paramAnonymousMessage.arg1);
        TmsLog.i("LoginTraceManager", localStringBuilder.toString());
        if (paramAnonymousMessage.what == 3005)
        {
          if (paramAnonymousMessage.arg1 == 0)
          {
            localCountDownLatch.countDown();
            return;
          }
          if (((e)paramAnonymousMessage.obj != null) && (this.b.get() < 2))
          {
            paramAnonymousMessage = this.b;
            paramAnonymousMessage.set(paramAnonymousMessage.get() + 1);
            ct.a().a(cu.c, l.a(paramArrayOfByte), this);
            TmsLog.i("LoginTraceManager", "K_MSG_GETSAFELGNMESSAGE retry");
            return;
          }
          TmsLog.i("LoginTraceManager", "K_MSG_GETSAFELGNMESSAGE failed");
          localCountDownLatch.countDown();
        }
      }
    };
    ct.a().a(cu.c, l.a(paramArrayOfByte), (Handler)localObject);
    try
    {
      localCountDownLatch.await(20L, TimeUnit.SECONDS);
    }
    catch (InterruptedException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return a(paramLong);
  }
  
  public static f a()
  {
    return a.a();
  }
  
  private boolean c()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    int i = localCalendar.get(11);
    return (i > 19) && (i < 22);
  }
  
  public void a(final Context paramContext)
  {
    if (this.c)
    {
      TmsLog.i("LoginTraceManager", "@checkHasChanged, has job doing, cancel this time.");
      return;
    }
    if (System.currentTimeMillis() - ed.b("login_trace_push_timestamp", 0L) < 432000000L)
    {
      TmsLog.i("LoginTraceManager", "@checkHasChanged, time since last push is less than 5 day, cancel this time.");
      return;
    }
    if (ed.c())
    {
      TmsLog.i("LoginTraceManager", "@checkHasChanged, user has launch today, cancel this time.");
      return;
    }
    if (ed.a())
    {
      TmsLog.i("LoginTraceManager", "@checkHasChanged, qqpimsecure is installed, cancel this time.");
      return;
    }
    this.a.post(new Runnable()
    {
      public void run()
      {
        if (f.a(f.this))
        {
          TmsLog.i("LoginTraceManager", "@checkHasChanged, has job doing, cancel this time.");
          return;
        }
        f.a(f.this, true);
        String str2 = ed.c("login_trace_md5", "");
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("@checkHasChanged, oldMd5: ");
        ((StringBuilder)localObject1).append(str2);
        TmsLog.i("LoginTraceManager", ((StringBuilder)localObject1).toString());
        String str1 = null;
        try
        {
          localObject1 = f.this.b();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          localObject2 = null;
        }
        if (localObject2 != null)
        {
          str1 = ((f.b)localObject2).a();
          ((f.b)localObject2).b();
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("@checkHasChanged, newMd5: ");
        ((StringBuilder)localObject2).append(str1);
        TmsLog.i("LoginTraceManager", ((StringBuilder)localObject2).toString());
        if (TextUtils.isEmpty(str1))
        {
          TmsLog.i("LoginTraceManager", "*********@checkHasChanged, login trace no change.*********");
          f.a(f.this, false);
          return;
        }
        if (!f.b(f.this))
        {
          TmsLog.i("LoginTraceManager", "time not ok, not record trace this time.");
          f.a(f.this, false);
          return;
        }
        ed.b("login_trace_md5", str1);
        if (!str1.equals(str2))
        {
          TmsLog.i("LoginTraceManager", "=========@checkHasChanged, login trace changed.=========");
          localObject2 = new a();
          com.tencent.push.c.a().a(paramContext, (d)localObject2);
          ed.a("login_trace_push_timestamp", System.currentTimeMillis());
          TMSDKContext.saveActionData(1150173);
        }
        f.a(f.this, false);
      }
    });
  }
  
  public b b()
  {
    TmsLog.i("LoginTraceManager", "@refreshSync invoke.");
    QQUser localQQUser = cr.a().e();
    if (localQQUser == null)
    {
      TmsLog.i("LoginTraceManager", "refresh empty login user");
      return null;
    }
    if (System.currentTimeMillis() - this.b < 21600000L)
    {
      TmsLog.i("LoginTraceManager", "@refreshSync, time since last check is less than 21600000 ,  cancel this time.");
      return null;
    }
    byte[] arrayOfByte = bz.a(RqdApplication.l()).b(localQQUser.mRealUin);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      TmsLog.i("LoginTraceManager", "@refreshSync a2 not null, getMsg sync.");
      this.b = System.currentTimeMillis();
      return a(localQQUser.mUin, arrayOfByte);
    }
    TmsLog.i("LoginTraceManager", "@refreshSync a2 null, return null");
    return null;
  }
  
  private static final class a
  {
    private static final f a = new f(null);
  }
  
  public class b
  {
    public List<OnlineDeviceResult.a> a;
    public List<SafeMsgItem> b;
    
    public b(List<SafeMsgItem> paramList)
    {
      this.a = paramList;
      Object localObject;
      this.b = localObject;
    }
    
    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.a;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OnlineDeviceResult.a)((Iterator)localObject1).next();
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).e);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).d);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).a);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).f);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).g);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).h);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).c);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).b);
        }
      }
      localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SafeMsgItem)((Iterator)localObject1).next();
          localStringBuilder.append(((SafeMsgItem)localObject2).mTitle);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mContent);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mTime);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mTextBeforeTable);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mTextAfterTable);
          localStringBuilder.append("|");
        }
      }
      return com.tencent.token.utils.encrypt.c.b(localStringBuilder.toString());
    }
    
    public void b()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.a;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OnlineDeviceResult.a)((Iterator)localObject1).next();
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).e);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).d);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).a);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).f);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).g);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).h);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).c);
          localStringBuilder.append("|");
          localStringBuilder.append(((OnlineDeviceResult.a)localObject2).b);
        }
      }
      localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SafeMsgItem)((Iterator)localObject1).next();
          localStringBuilder.append(((SafeMsgItem)localObject2).mTitle);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mContent);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mTime);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mTextBeforeTable);
          localStringBuilder.append("|");
          localStringBuilder.append(((SafeMsgItem)localObject2).mTextAfterTable);
          localStringBuilder.append("|");
        }
      }
      TmsLog.i("trace_detail", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.service.f
 * JD-Core Version:    0.7.0.1
 */