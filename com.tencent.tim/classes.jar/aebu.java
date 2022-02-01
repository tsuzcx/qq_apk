import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Point;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.util.WeakReference;

public class aebu
{
  private static aebu a;
  private static final byte[] dA = new byte[0];
  private static final byte[] dB = new byte[0];
  private WeakReference<aeaz.b> at;
  private WeakReference<aeeg> au;
  private boolean bSR = true;
  private boolean bSS = true;
  private Set<String> ci = new HashSet();
  private Point f = new Point();
  private BroadcastReceiver mReceiver = new aebv(this);
  
  public static aebu a()
  {
    if (a == null) {}
    synchronized (dA)
    {
      if (a == null) {
        a = new aebu();
      }
      return a;
    }
  }
  
  public void Hd(boolean paramBoolean)
  {
    aebd.Hd(paramBoolean);
  }
  
  public void Hg(boolean paramBoolean)
  {
    this.bSS = paramBoolean;
  }
  
  public void Hh(boolean paramBoolean)
  {
    this.bSR = paramBoolean;
  }
  
  public Point a()
  {
    return this.f;
  }
  
  public void a(int paramInt1, String paramString, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 2, aebs.getTraceInfo());
    }
    if (paramInt2 == 2) {
      return;
    }
    paramString = paramInt1 + paramString + paramInt2;
    if (paramBoolean)
    {
      this.ci.add(paramString);
      return;
    }
    this.ci.remove(paramString);
  }
  
  public void a(aeaz.b paramb)
  {
    this.at = new WeakReference(paramb);
  }
  
  public void a(aeeg paramaeeg)
  {
    this.au = new WeakReference(paramaeeg);
  }
  
  public void a(Point paramPoint)
  {
    if ((paramPoint != null) && (paramPoint.x != 0) && (paramPoint.y != 0)) {
      this.f = paramPoint;
    }
  }
  
  public boolean agm()
  {
    return aebd.agm();
  }
  
  public boolean agq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteQIPCModule", 2, aebs.getTraceInfo());
    }
    return this.bSR;
  }
  
  public void cVD()
  {
    try
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.mReceiver);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteQIPCModule", 1, "unregister broadcast");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteQIPCModule", 2, "unregister failed", localException);
      }
    }
  }
  
  public boolean d(int paramInt1, String paramString, int paramInt2)
  {
    return (paramInt2 != 2) && (this.ci.contains(paramInt1 + paramString + paramInt2));
  }
  
  public boolean getSyncState()
  {
    return this.bSS;
  }
  
  public void o(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, paramString, paramBoolean, 0);
  }
  
  public void registerBroadcast()
  {
    IntentFilter localIntentFilter = new IntentFilter("key_float_window_position");
    localIntentFilter.addAction("key_delete_item_call");
    localIntentFilter.addAction("key_after_sync_msg");
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(this.mReceiver, localIntentFilter);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteQIPCModule", 1, "register broadcast");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ColorNoteQIPCModule", 2, "register failed", localException);
      }
    }
  }
  
  public boolean u(int paramInt, String paramString)
  {
    return d(paramInt, paramString, 0);
  }
  
  public void z(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    aebd.Hd(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebu
 * JD-Core Version:    0.7.0.1
 */