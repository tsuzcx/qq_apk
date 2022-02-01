import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinEngineLog;
import com.tencent.theme.SkinEngineHandler;
import java.util.HashMap;

public class swt
  implements ISkinEngineLog, SkinEngineHandler
{
  private BaseApplicationImpl app;
  private int bzM = -1;
  
  public swt(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.app = paramBaseApplicationImpl;
  }
  
  public boolean onDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean)
  {
    if (this.bzM == -1) {
      this.bzM = ((ActivityManager)this.app.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    paramOutOfMemoryError = new StringBuffer("decode resources oom, fileName: ");
    paramOutOfMemoryError.append(paramString);
    paramOutOfMemoryError.append(", is skin file: ");
    paramOutOfMemoryError.append(paramBoolean);
    paramOutOfMemoryError.append(", memory used:");
    paramOutOfMemoryError.append(l);
    paramOutOfMemoryError.append(" , heap size: ");
    paramOutOfMemoryError.append(this.bzM);
    paramOutOfMemoryError.append(", api level:");
    paramOutOfMemoryError.append(Build.VERSION.SDK_INT);
    if (BaseApplicationImpl.sImageCache != null)
    {
      paramOutOfMemoryError.append(", imageCache size:");
      paramOutOfMemoryError.append(BaseApplicationImpl.sImageCache.size());
    }
    QLog.e("res-OOM", 1, paramOutOfMemoryError.toString());
    paramOutOfMemoryError = new HashMap(4);
    paramOutOfMemoryError.put("param_FailCode", Integer.toString(89100));
    paramOutOfMemoryError.put("param_heapSize", Integer.toString(this.bzM));
    paramOutOfMemoryError.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramOutOfMemoryError.put("param_cacheUsed", Long.toString(l));
    try
    {
      anpc.a(this.app).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, paramOutOfMemoryError, "");
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramOutOfMemoryError)
    {
      for (;;)
      {
        paramOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public boolean onDecodeReturnNullBitmap(String paramString, boolean paramBoolean)
  {
    if (this.bzM == -1) {
      this.bzM = ((ActivityManager)this.app.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    StringBuffer localStringBuffer = new StringBuffer("decode resources return null, fileName: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(", is skin file: ");
    localStringBuffer.append(paramBoolean);
    localStringBuffer.append(", memory used:");
    localStringBuffer.append(l);
    localStringBuffer.append(" , heap size: ");
    localStringBuffer.append(this.bzM);
    localStringBuffer.append(", api level:");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (BaseApplicationImpl.sImageCache != null)
    {
      localStringBuffer.append(", imageCache size:");
      localStringBuffer.append(BaseApplicationImpl.sImageCache.size());
    }
    paramString = new HashMap(4);
    paramString.put("param_FailCode", Integer.toString(89102));
    paramString.put("param_heapSize", Integer.toString(this.bzM));
    paramString.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramString.put("param_cacheUsed", Long.toString(l));
    try
    {
      anpc.a(this.app).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, paramString, "");
      QLog.e("res-OOM", 1, localStringBuffer.toString());
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean onSecondDecodeOOM(OutOfMemoryError paramOutOfMemoryError, String paramString, boolean paramBoolean)
  {
    if (this.bzM == -1) {
      this.bzM = ((ActivityManager)this.app.getSystemService("activity")).getMemoryClass();
    }
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    StringBuffer localStringBuffer = new StringBuffer("decode resources second oom, fileName: ");
    localStringBuffer.append(paramString);
    localStringBuffer.append(", is skin file: ");
    localStringBuffer.append(paramBoolean);
    localStringBuffer.append(", memory used:");
    localStringBuffer.append(l);
    localStringBuffer.append(" , heap size: ");
    localStringBuffer.append(this.bzM);
    localStringBuffer.append(", api level:");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    if (BaseApplicationImpl.sImageCache != null)
    {
      localStringBuffer.append(", imageCache size:");
      localStringBuffer.append(BaseApplicationImpl.sImageCache.size());
    }
    paramString = new HashMap(4);
    paramString.put("param_FailCode", Integer.toString(89101));
    paramString.put("param_heapSize", Integer.toString(this.bzM));
    paramString.put("param_apiLevel", Integer.toString(Build.VERSION.SDK_INT));
    paramString.put("param_cacheUsed", Long.toString(l));
    try
    {
      anpc.a(this.app).collectPerformance(null, "report_resource_decode_OOM", false, 0L, 0L, paramString, "");
      QLog.e("res-OOM", 1, localStringBuffer.toString(), paramOutOfMemoryError);
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.evictAll();
      }
      System.gc();
      Thread.yield();
      System.gc();
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void trace(int paramInt1, String paramString1, int paramInt2, String paramString2, Throwable paramThrowable)
  {
    if ((1 == paramInt2) || (QLog.isColorLevel())) {}
    switch (paramInt1)
    {
    case 4: 
    default: 
      QLog.i(paramString1, paramInt2, paramString2, null);
      return;
    case 5: 
      QLog.w(paramString1, paramInt2, paramString2, null);
      return;
    case 6: 
      QLog.e(paramString1, paramInt2, paramString2, null);
      return;
    }
    QLog.d(paramString1, paramInt2, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swt
 * JD-Core Version:    0.7.0.1
 */