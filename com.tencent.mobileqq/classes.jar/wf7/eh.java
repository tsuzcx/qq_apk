package wf7;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

public class eh
  implements ei.a
{
  private static eh mg = null;
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
    return "" + paramInt;
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
    Object localObject = null;
    try
    {
      NetworkInfo localNetworkInfo = fi.getActiveNetworkInfo();
      localObject = localNetworkInfo;
    }
    catch (NullPointerException localNullPointerException)
    {
      label8:
      break label8;
    }
    return (localObject == null) || (!localObject.isConnected());
  }
  
  private boolean cH()
  {
    this.mi = true;
    Object localObject = null;
    try
    {
      String str = fj.a(new eh.1(this));
      localObject = str;
    }
    catch (ex localex)
    {
      for (;;)
      {
        this.hG = -3;
      }
    }
    this.mi = false;
    this.mj = System.currentTimeMillis();
    return !TextUtils.isEmpty(localObject);
  }
  
  public int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (cG()) {
      this.hG = -1;
    }
    for (;;)
    {
      return this.hG;
      if ((this.mj > 0L) && (Math.abs(System.currentTimeMillis() - this.mj) <= 300000L)) {}
      for (int i = 1;; i = 0)
      {
        if (!paramBoolean1) {
          break label63;
        }
        cH();
        break;
      }
      label63:
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
  
  public void cF()
  {
    this.hG = -4;
    this.mh = System.currentTimeMillis();
  }
  
  public void onConnected()
  {
    cF();
    if ((this.mj > 0L) && (Math.abs(System.currentTimeMillis() - this.mj) < 60000L)) {}
    for (int i = 1; (i != 0) || (this.mi); i = 0)
    {
      this.mHandler.removeMessages(1);
      this.mHandler.sendEmptyMessageDelayed(1, 60000L);
      return;
    }
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessageDelayed(1, 5000L);
  }
  
  public void onDisconnected()
  {
    cF();
    this.mHandler.removeMessages(1);
    this.hG = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.eh
 * JD-Core Version:    0.7.0.1
 */