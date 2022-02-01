import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aopt
  implements aqda.a
{
  aopt(aops paramaops) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (!aops.a(this.b)) {
      return;
    }
    if (!aops.b(this.b))
    {
      aops.a(this.b, paramLong);
      aops.a(this.b, paramDouble);
      aops.b(this.b, acix.a.cpuUsage);
      if (aops.a(this.b) > aops.b(this.b))
      {
        if (!aops.c(this.b))
        {
          aops.a(this.b);
          if (aops.b(this.b) >= aops.c(this.b))
          {
            aops.a(this.b, true);
            aops.b(this.b, 0L);
          }
        }
        if (aops.c(this.b) >= aops.d(this.b)) {
          break label502;
        }
        if (!aops.d(this.b))
        {
          aops.d(this.b);
          if (aops.e(this.b) >= aops.c(this.b))
          {
            aops.b(this.b, true);
            aops.c(this.b, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!aops.d(this.b)) || (!aops.c(this.b))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(aops.f(this.b));
        ((StringBuilder)localObject).append(",mCurFPS=").append(aops.a(this.b));
        ((StringBuilder)localObject).append(",mCurCPU=").append(aops.c(this.b));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(aops.b(this.b));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(aops.e(this.b));
        ((StringBuilder)localObject).append(",mFPSReady=").append(aops.c(this.b));
        ((StringBuilder)localObject).append(",mCPUReady=").append(aops.d(this.b));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      aops.a(this.b).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((aops.d(this.b)) && (aops.c(this.b)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", aops.a(this.b));
        localBundle.putDouble("CPU", aops.c(this.b));
        ((Message)localObject).obj = localBundle;
        aops.a(this.b).sendMessage((Message)localObject);
      }
      aops.a(this.b, false);
      aops.b(this.b, 0L);
      break;
      label502:
      if ((aops.d(this.b)) && (aops.c(this.b)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", aops.a(this.b));
        localBundle.putDouble("CPU", aops.c(this.b));
        ((Message)localObject).obj = localBundle;
        aops.a(this.b).sendMessage((Message)localObject);
      }
      aops.b(this.b, false);
      aops.c(this.b, 0L);
      continue;
      aops.b(this.b, true);
      aops.a(this.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopt
 * JD-Core Version:    0.7.0.1
 */