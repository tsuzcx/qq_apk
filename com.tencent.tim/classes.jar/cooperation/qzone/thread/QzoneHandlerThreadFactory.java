package cooperation.qzone.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class QzoneHandlerThreadFactory
{
  public static final String BackGroundThread = "BackGround_HandlerThread";
  public static final String BusinessThread = "Business_HandlerThread";
  public static final String FeedDeleteOnTimeThread = "FeedDeleteOnTime_HandlerThread";
  public static final String FloatItemThread = "FloatItem_HandlerThread";
  public static final String IpcProxyThread = "QZone_IpcProxyThread";
  public static final String LocalPhotoThread = "QZone_LocalPhotoThread";
  public static final String NormalThread = "Normal_HandlerThread";
  public static final String ParticleThread = "Particle_HandlerThread";
  public static final String PreLoadThread = "Preload_HandlerThread";
  public static final String RealTimeThread = "RealTime_HandlerThread";
  public static final String ReportThread = "Report_HandlerThread";
  public static final String TAG = "QzoneThread";
  public static final String VideoThread = "Video_HandlerThread";
  public static final String YellowVipThread = "YellowVip_HandlerThread";
  static final Map<String, QzoneBaseThread> mHandlerThreadMap = new HashMap();
  public static volatile Handler mMainHandler;
  public static final Object mMainHandlerLock = new Object();
  
  public static QzoneBaseThread getHandlerThread(String paramString)
  {
    return getHandlerThread(paramString, false);
  }
  
  public static QzoneBaseThread getHandlerThread(String paramString, boolean paramBoolean)
  {
    synchronized (mHandlerThreadMap)
    {
      QzoneBaseThread localQzoneBaseThread = (QzoneBaseThread)mHandlerThreadMap.get(paramString);
      if (localQzoneBaseThread == null)
      {
        localQzoneBaseThread = new QzoneBaseThread(paramString, getPriority(paramString));
        if (paramBoolean) {
          localQzoneBaseThread.setDaemon(paramBoolean);
        }
        mHandlerThreadMap.put(paramString, localQzoneBaseThread);
        paramString = localQzoneBaseThread;
      }
      for (;;)
      {
        return paramString;
        paramString = localQzoneBaseThread;
        try
        {
          if (localQzoneBaseThread.isAlive()) {
            continue;
          }
          localQzoneBaseThread.start();
          paramString = localQzoneBaseThread;
        }
        catch (IllegalThreadStateException paramString)
        {
          QLog.e("QzoneThread", 1, paramString.getStackTrace().toString());
          paramString = localQzoneBaseThread;
        }
      }
    }
  }
  
  public static Looper getHandlerThreadLooper(String paramString)
  {
    return getHandlerThread(paramString).getLooper();
  }
  
  public static Handler getMainHandler()
  {
    synchronized (mMainHandlerLock)
    {
      if (mMainHandler == null) {
        mMainHandler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = mMainHandler;
      return localHandler;
    }
  }
  
  private static int getPriority(String paramString)
  {
    if ("BackGround_HandlerThread".equalsIgnoreCase(paramString)) {}
    do
    {
      do
      {
        return 10;
        if ("RealTime_HandlerThread".equalsIgnoreCase(paramString)) {
          return -1;
        }
        if ("Video_HandlerThread".equalsIgnoreCase(paramString)) {
          return 0;
        }
      } while ("Report_HandlerThread".equalsIgnoreCase(paramString));
      if ("Preload_HandlerThread".equalsIgnoreCase(paramString)) {
        return 1;
      }
      if ("QZone_LocalPhotoThread".equalsIgnoreCase(paramString)) {
        return 0;
      }
    } while ("QZone_IpcProxyThread".equalsIgnoreCase(paramString));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneHandlerThreadFactory
 * JD-Core Version:    0.7.0.1
 */