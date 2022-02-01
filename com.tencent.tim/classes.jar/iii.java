import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class iii
{
  ComponentCallbacks componentCallbacks;
  VideoAppInterface mApp;
  
  public iii(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void amw()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.componentCallbacks != null)
      {
        this.mApp.getApplication().unregisterComponentCallbacks(this.componentCallbacks);
        this.componentCallbacks = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GMemoryMonitor", 2, "onDestroy unregisterComponentCallbacks failed", localThrowable);
    }
  }
  
  public void amx()
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      if (this.componentCallbacks == null)
      {
        this.componentCallbacks = new iij(this);
        BaseApplicationImpl.getApplication().getApplicationContext().registerComponentCallbacks(this.componentCallbacks);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("GMemoryMonitor", 1, "registerComponentCallbacks failed", localThrowable);
    }
  }
  
  void z(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GMemoryMonitor", 2, "reportLowMemory  level = " + paramInt + ",isExit = " + paramBoolean);
    }
    try
    {
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("lowMemoryLevel", String.valueOf(paramInt));
      ((HashMap)localObject1).put("isExit", String.valueOf(paramBoolean));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "av_qua_low_memory", true, 0L, 0L, (HashMap)localObject1, "", true);
      localObject1 = Build.MODEL;
      String str1 = String.valueOf(Build.VERSION.SDK_INT);
      String str2 = this.mApp.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = this.mApp.b().b();
      if (localObject2 != null)
      {
        String str3 = ((iiv)localObject2).peerUin;
        localObject2 = ((iiv)localObject2).sessionId;
        String str4 = this.mApp.b().getChatRoomId(str3) + "";
        if (QLog.isColorLevel()) {
          QLog.d("GMemoryMonitor", 2, "reportLowMemory  ,roomID = " + str4);
        }
        localStringBuilder.append("Android").append('|');
        localStringBuilder.append((String)localObject1).append('|');
        localStringBuilder.append(str1).append('|');
        localStringBuilder.append(str1).append('|');
        localStringBuilder.append(str2).append('|');
        localStringBuilder.append(str3).append('|');
        localStringBuilder.append(str4).append('|');
        localStringBuilder.append((String)localObject2).append('|');
        localStringBuilder.append(paramInt);
      }
      localObject1 = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("GMemoryMonitor", 2, "reportLowMemory  dcDetail = " + (String)localObject1);
      }
      annx.o(null, "dc02660", (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("GMemoryMonitor", 1, "reportLowMemory  Exception", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iii
 * JD-Core Version:    0.7.0.1
 */