import android.os.Handler;
import android.os.Message;
import com.tencent.biz.qqstory.playvideo.FollowCaptureLauncher;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ttn
  extends Handler
{
  WeakReference<FollowCaptureLauncher> a;
  
  public ttn(FollowCaptureLauncher paramFollowCaptureLauncher)
  {
    this.a = new WeakReference(paramFollowCaptureLauncher);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    FollowCaptureLauncher localFollowCaptureLauncher = (FollowCaptureLauncher)this.a.get();
    if (localFollowCaptureLauncher == null) {}
    for (;;)
    {
      return;
      switch (paramMessage.what)
      {
      }
      while (i != 0)
      {
        FollowCaptureLauncher.f(localFollowCaptureLauncher);
        return;
        FollowCaptureLauncher.b(localFollowCaptureLauncher);
        continue;
        FollowCaptureLauncher.a(localFollowCaptureLauncher, (String)paramMessage.obj);
        i = 1;
        continue;
        FollowCaptureLauncher.c(localFollowCaptureLauncher);
        i = 1;
        continue;
        FollowCaptureLauncher.d(localFollowCaptureLauncher);
        i = 1;
        continue;
        FollowCaptureLauncher.b(localFollowCaptureLauncher, (String)paramMessage.obj);
        i = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FollowCaptureLauncher", 2, new Object[] { "showFollowCaptureError, ", Integer.valueOf(paramMessage.what) });
        }
        vei.a("FollowLaunchEvent", false, System.currentTimeMillis() - FollowCaptureLauncher.a(localFollowCaptureLauncher), new String[] { String.valueOf(paramMessage.what) });
        FollowCaptureLauncher.e(localFollowCaptureLauncher);
        continue;
        localFollowCaptureLauncher.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttn
 * JD-Core Version:    0.7.0.1
 */