package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.token.core.bean.OnlineDeviceResult.a;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.RqdApplication;
import com.tmsdk.TMSDKContext;
import com.tmsdk.common.util.TmsLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class sb
{
  public Handler a;
  long b;
  public volatile boolean c;
  
  private sb()
  {
    HandlerThread localHandlerThread = new HandlerThread("LoginTraceManager", 5);
    localHandlerThread.start();
    this.a = new Handler(localHandlerThread.getLooper());
  }
  
  final b a(long paramLong, final byte[] paramArrayOfByte)
  {
    Object localObject2 = new AtomicInteger(0);
    Object localObject1 = new CountDownLatch(1);
    localObject2 = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        StringBuilder localStringBuilder = new StringBuilder("handleMessage what:");
        localStringBuilder.append(paramAnonymousMessage.what);
        localStringBuilder.append(", ret:");
        localStringBuilder.append(paramAnonymousMessage.arg1);
        TmsLog.i("LoginTraceManager", localStringBuilder.toString());
        if (paramAnonymousMessage.what == 3005)
        {
          if (paramAnonymousMessage.arg1 == 0)
          {
            this.a.countDown();
            return;
          }
          if (((xt)paramAnonymousMessage.obj != null) && (this.b.get() < 2))
          {
            paramAnonymousMessage = this.b;
            paramAnonymousMessage.set(paramAnonymousMessage.get() + 1);
            paramAnonymousMessage = tv.a();
            byte b1 = tw.c;
            aay.a(paramArrayOfByte);
            paramAnonymousMessage.a(b1, this);
            TmsLog.i("LoginTraceManager", "K_MSG_GETSAFELGNMESSAGE retry");
            return;
          }
          TmsLog.i("LoginTraceManager", "K_MSG_GETSAFELGNMESSAGE failed");
          this.a.countDown();
        }
      }
    };
    tv localtv = tv.a();
    byte b1 = tw.c;
    aay.a(paramArrayOfByte);
    localtv.a(b1, (Handler)localObject2);
    try
    {
      ((CountDownLatch)localObject1).await(20L, TimeUnit.SECONDS);
    }
    catch (InterruptedException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    paramArrayOfByte = sc.a.a().a(paramLong);
    localObject2 = tv.a().f;
    localObject1 = new ArrayList();
    localObject2 = ((abi)localObject2).b();
    if (localObject2 != null) {
      ((List)localObject1).add(localObject2);
    }
    if (paramArrayOfByte == null)
    {
      TmsLog.i("LoginTraceManager", "@checkHasChanged, pull failed, return null this time.");
      return null;
    }
    return new b(paramArrayOfByte, (List)localObject1);
  }
  
  public static final class a
  {
    private static final sb a = new sb((byte)0);
  }
  
  public final class b
  {
    public List<OnlineDeviceResult.a> a;
    public List<SafeMsgItem> b;
    
    public b(List<SafeMsgItem> paramList)
    {
      this.a = paramList;
      Object localObject;
      this.b = localObject;
    }
    
    public final void a()
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
 * Qualified Name:     com.tencent.token.sb
 * JD-Core Version:    0.7.0.1
 */