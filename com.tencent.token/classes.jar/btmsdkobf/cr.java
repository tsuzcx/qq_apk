package btmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tmsdk.base.utils.NetworkUtil;

public class cr
  implements cz.a
{
  private static Object V = new Object();
  private static cr jdField_if = null;
  private int ig = -6;
  private long ih = 0L;
  private boolean ii = false;
  private long ij = 0L;
  private HandlerThread ik = null;
  private Handler mHandler = null;
  
  private cr()
  {
    this.ik.start();
    this.mHandler = new a(this.ik.getLooper());
    eh.f("NetworkDetector", "[detect_conn]init, register & start detect");
    cz.bS().a(this);
    this.mHandler.sendEmptyMessageDelayed(1, 5000L);
  }
  
  public static cr bq()
  {
    synchronized (V)
    {
      if (jdField_if == null) {
        jdField_if = new cr();
      }
      cr localcr = jdField_if;
      return localcr;
    }
  }
  
  private boolean bs()
  {
    return NetworkUtil.isNetworkConnected();
  }
  
  private boolean bt()
  {
    bool = true;
    eh.f("NetworkDetector", "[detect_conn]detectSync()");
    this.ii = true;
    Object localObject = null;
    try
    {
      String str = ef.a(new ef.a()
      {
        public void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          eh.f("NetworkDetector", "[detect_conn]detectSync(), network error? " + paramAnonymousBoolean2);
          if (paramAnonymousBoolean2)
          {
            cr.a(cr.this, -3);
            return;
          }
          if (paramAnonymousBoolean1)
          {
            cr.a(cr.this, -2);
            return;
          }
          cr.a(cr.this, 0);
        }
      });
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.ig = -3;
        eh.h("NetworkDetector", "[detect_conn]detectSync(), exception: " + localThrowable.toString());
        continue;
        bool = false;
      }
    }
    this.ii = false;
    this.ij = System.currentTimeMillis();
    if (!TextUtils.isEmpty(localObject))
    {
      eh.f("NetworkDetector", "[detect_conn]detectSync(),  isNeed wifi approve? " + bool + " url: " + localObject + " state: " + u(this.ig));
      return bool;
    }
  }
  
  public static String u(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "NETWORK_STATE_NOT_INIT";
    case 0: 
      return "NETWORK_STATE_OK";
    case -1: 
      return "NETWORK_STATE_NOCONNECT";
    case -2: 
      return "NETWORK_STATE_NEED_APPROVE_WIFI";
    case -3: 
      return "NETWORK_STATE_UNREACHABLE";
    case -4: 
      return "NETWORK_STATE_CHANGING";
    case -5: 
      return "NETWORK_STATE_UNRELIABLE";
    }
    return "NETWORK_STATE_NOT_INIT";
  }
  
  public int b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (bs()) {
      this.ig = -1;
    }
    for (;;)
    {
      eh.f("NetworkDetector", "[detect_conn]getNetworkState(), mNetworkState: " + u(this.ig));
      return this.ig;
      if ((this.ij > 0L) && (Math.abs(System.currentTimeMillis() - this.ij) <= 300000L)) {}
      for (int i = 1;; i = 0)
      {
        if (!paramBoolean1) {
          break label93;
        }
        bt();
        break;
      }
      label93:
      if ((paramBoolean2) && (i == 0) && (Math.abs(System.currentTimeMillis() - this.ij) > 60000L))
      {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
      }
      if ((this.ig == 0) && (i == 0)) {
        this.ig = -5;
      }
    }
  }
  
  public void br()
  {
    eh.f("NetworkDetector", "[detect_conn] onNetworkingchanging");
    this.ig = -4;
    this.ih = System.currentTimeMillis();
  }
  
  public boolean e(long paramLong)
  {
    return (this.ig == -4) && (Math.abs(System.currentTimeMillis() - this.ih) < paramLong);
  }
  
  public void onConnected()
  {
    br();
    if ((this.ij > 0L) && (Math.abs(System.currentTimeMillis() - this.ij) < 60000L)) {}
    for (int i = 1; (i != 0) || (this.ii); i = 0)
    {
      eh.f("NetworkDetector", "[detect_conn]onConnected(), trigger detect in 60000");
      this.mHandler.removeMessages(1);
      this.mHandler.sendEmptyMessageDelayed(1, 60000L);
      return;
    }
    eh.f("NetworkDetector", "[detect_conn]onConnected(), trigger detect in 5s");
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessageDelayed(1, 5000L);
  }
  
  public void onDisconnected()
  {
    eh.f("NetworkDetector", "[detect_conn]onDisconnected()");
    br();
    this.mHandler.removeMessages(1);
    this.ig = -1;
  }
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      cr.a(cr.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cr
 * JD-Core Version:    0.7.0.1
 */