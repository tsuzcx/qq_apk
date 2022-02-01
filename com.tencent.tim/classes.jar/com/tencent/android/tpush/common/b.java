package com.tencent.android.tpush.common;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.concurrent.locks.ReentrantLock;

public class b
{
  private static int a = 0;
  private static int b = 0;
  private static Handler c;
  private static ReentrantLock d = new ReentrantLock();
  
  public static void a(Context paramContext)
  {
    b(paramContext, 0);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor())) {}
    try
    {
      d.lock();
      if (c == null) {
        c = new a(paramContext.getApplicationContext());
      }
      b += 1;
      a += paramInt;
      paramContext = new Message();
      paramContext.what = 1;
      c.sendMessageDelayed(paramContext, 200L);
      try
      {
        d.unlock();
        return;
      }
      catch (Throwable paramContext)
      {
        TLogger.e("BadgeUtils", "change huawei badge unlock error: " + paramContext.toString());
        return;
      }
      try
      {
        d.unlock();
        throw paramContext;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          TLogger.e("BadgeUtils", "change huawei badge unlock error: " + localThrowable.toString());
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext = paramContext;
      TLogger.w("BadgeUtils", "change huawei badge error: " + paramContext.toString());
      try
      {
        d.unlock();
        return;
      }
      catch (Throwable paramContext)
      {
        TLogger.e("BadgeUtils", "change huawei badge unlock error: " + paramContext.toString());
        return;
      }
    }
    finally {}
  }
  
  public static void b(Context paramContext)
  {
    b(paramContext, 0);
    d(paramContext, 0);
    e(paramContext, 0);
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    if ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor())) {}
    try
    {
      if (c == null) {
        c = new a(paramContext.getApplicationContext());
      }
      paramContext = new Message();
      paramContext.what = 2;
      paramContext.arg1 = paramInt;
      c.sendMessage(paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.w("BadgeUtils", "set huawei badge error: " + paramContext.toString());
    }
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    b(paramContext, paramInt);
    e(paramContext, paramInt);
    d(paramContext, paramInt);
  }
  
  public static void d(Context paramContext, int paramInt)
  {
    String str = i.b();
    if ((!TextUtils.isEmpty(str)) && ("oppo".equals(str))) {
      CommonWorkingThread.getInstance().execute(new b.3(paramInt, paramContext));
    }
  }
  
  public static void e(Context paramContext, int paramInt)
  {
    String str = i.b();
    if ((!TextUtils.isEmpty(str)) && ("vivo".equals(str))) {
      CommonWorkingThread.getInstance().execute(new b.4(paramInt, paramContext));
    }
  }
  
  private static void h(Context paramContext, int paramInt)
  {
    if ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor())) {
      CommonWorkingThread.getInstance().execute(new b.1(paramInt, paramContext));
    }
  }
  
  private static void i(Context paramContext, int paramInt)
  {
    if ((ChannelUtils.isBrandHuaWei()) || (ChannelUtils.isBrandHonor())) {
      CommonWorkingThread.getInstance().execute(new b.2(paramInt, paramContext));
    }
  }
  
  static class a
    extends Handler
  {
    private Context a;
    
    a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (this.a == null) {
        super.handleMessage(paramMessage);
      }
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          super.handleMessage(paramMessage);
          return;
        case 1: 
          if (b.a() > 0) {
            b.a(b.a() - 1);
          }
          break;
        }
      } while (b.a() != 0);
      b.f(this.a, b.b());
      b.b(0);
      b.c().removeCallbacks(null);
      return;
      int i = paramMessage.arg1;
      b.g(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.b
 * JD-Core Version:    0.7.0.1
 */