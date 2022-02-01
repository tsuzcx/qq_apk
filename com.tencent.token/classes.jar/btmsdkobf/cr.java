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
    eh.f("NetworkDetector", "[detect_conn]detectSync()");
    this.ii = true;
    CharSequence localCharSequence;
    try
    {
      String str = ef.a(new ef.a()
      {
        public final void c(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          eh.f("NetworkDetector", "[detect_conn]detectSync(), network error? ".concat(String.valueOf(paramAnonymousBoolean2)));
          cr localcr;
          int i;
          if (paramAnonymousBoolean2)
          {
            localcr = cr.this;
            i = -3;
          }
          for (;;)
          {
            cr.a(localcr, i);
            return;
            if (paramAnonymousBoolean1)
            {
              localcr = cr.this;
              i = -2;
            }
            else
            {
              localcr = cr.this;
              i = 0;
            }
          }
        }
      });
    }
    catch (Throwable localThrowable)
    {
      this.ig = -3;
      localStringBuilder = new StringBuilder("[detect_conn]detectSync(), exception: ");
      localStringBuilder.append(localThrowable.toString());
      eh.h("NetworkDetector", localStringBuilder.toString());
      localCharSequence = null;
    }
    this.ii = false;
    this.ij = System.currentTimeMillis();
    boolean bool = true ^ TextUtils.isEmpty(localCharSequence);
    StringBuilder localStringBuilder = new StringBuilder("[detect_conn]detectSync(),  isNeed wifi approve? ");
    localStringBuilder.append(bool);
    localStringBuilder.append(" url: ");
    localStringBuilder.append(localCharSequence);
    localStringBuilder.append(" state: ");
    localStringBuilder.append(u(this.ig));
    eh.f("NetworkDetector", localStringBuilder.toString());
    return bool;
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
    if (bs()) {}
    for (int i = -1;; i = -5)
    {
      this.ig = i;
      break;
      if ((this.ij > 0L) && (Math.abs(System.currentTimeMillis() - this.ij) <= 300000L)) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramBoolean1)
      {
        bt();
        break;
      }
      if ((paramBoolean2) && (i == 0) && (Math.abs(System.currentTimeMillis() - this.ij) > 60000L))
      {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
      }
      if ((this.ig != 0) || (i != 0)) {
        break;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder("[detect_conn]getNetworkState(), mNetworkState: ");
    localStringBuilder.append(u(this.ig));
    eh.f("NetworkDetector", localStringBuilder.toString());
    return this.ig;
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
    int i;
    if ((this.ij > 0L) && (Math.abs(System.currentTimeMillis() - this.ij) < 60000L)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!this.ii))
    {
      eh.f("NetworkDetector", "[detect_conn]onConnected(), trigger detect in 5s");
      this.mHandler.removeMessages(1);
      this.mHandler.sendEmptyMessageDelayed(1, 5000L);
      return;
    }
    eh.f("NetworkDetector", "[detect_conn]onConnected(), trigger detect in 60000");
    this.mHandler.removeMessages(1);
    this.mHandler.sendEmptyMessageDelayed(1, 60000L);
  }
  
  public void onDisconnected()
  {
    eh.f("NetworkDetector", "[detect_conn]onDisconnected()");
    br();
    this.mHandler.removeMessages(1);
    this.ig = -1;
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1) {
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