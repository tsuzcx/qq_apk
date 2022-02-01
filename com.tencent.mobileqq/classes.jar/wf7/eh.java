package wf7;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

public class eh
  implements ei.a
{
  private static eh mg;
  private int hG = -6;
  private Handler mHandler = null;
  private long mh = 0L;
  private boolean mi = false;
  private long mj = 0L;
  private HandlerThread mk = null;
  
  private eh()
  {
    this.mk.start();
    this.mHandler = new eh.a(this, this.mk.getLooper());
    ei.cI().a(this);
    this.mHandler.sendEmptyMessageDelayed(1, 5000L);
  }
  
  public static String ag(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static eh cE()
  {
    try
    {
      if (mg == null) {
        mg = new eh();
      }
      eh localeh = mg;
      return localeh;
    }
    finally {}
  }
  
  private boolean cG()
  {
    try
    {
      localNetworkInfo = fi.getActiveNetworkInfo();
    }
    catch (NullPointerException localNullPointerException)
    {
      NetworkInfo localNetworkInfo;
      label7:
      break label7;
    }
    localNetworkInfo = null;
    return (localNetworkInfo == null) || (!localNetworkInfo.isConnected());
  }
  
  private boolean cH()
  {
    this.mi = true;
    try
    {
      str = fj.a(new eh.1(this));
    }
    catch (ex localex)
    {
      String str;
      label20:
      break label20;
    }
    this.hG = -3;
    str = null;
    this.mi = false;
    this.mj = System.currentTimeMillis();
    return true ^ TextUtils.isEmpty(str);
  }
  
  public int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (cG())
    {
      this.hG = -1;
    }
    else
    {
      int i;
      if ((this.mj > 0L) && (Math.abs(System.currentTimeMillis() - this.mj) <= 300000L)) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramBoolean1)
      {
        cH();
      }
      else
      {
        if ((paramBoolean2) && (i == 0) && (Math.abs(System.currentTimeMillis() - this.mj) > 60000L))
        {
          this.mHandler.removeMessages(1);
          this.mHandler.sendEmptyMessage(1);
        }
        if ((this.hG == 0) && (i == 0)) {
          this.hG = -5;
        }
      }
    }
    return this.hG;
  }
  
  public void cF()
  {
    this.hG = -4;
    this.mh = System.currentTimeMillis();
  }
  
  public void onConnected()
  {
    cF();
    int i;
    if ((this.mj > 0L) && (Math.abs(System.currentTimeMillis() - this.mj) < 60000L)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!this.mi))
    {
      this.mHandler.removeMessages(1);
      this.mHandler.sendEmptyMessageDelayed(1, 5000L);
      return;
    }
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessageDelayed(1, 60000L);
  }
  
  public void onDisconnected()
  {
    cF();
    this.mHandler.removeMessages(1);
    this.hG = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.eh
 * JD-Core Version:    0.7.0.1
 */