package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import java.io.File;

public class b
  implements Handler.Callback
{
  private static b a;
  private static final Object c = new Object();
  private static StringBuilder d = new StringBuilder();
  private static StringBuilder e = new StringBuilder();
  private volatile boolean b = false;
  private Context f;
  private HandlerThread g;
  private Handler h;
  
  private b(Context paramContext)
  {
    this.f = paramContext;
    this.g = new HandlerThread("FileTracer");
    try
    {
      this.g.start();
      if (this.g.isAlive()) {
        this.h = new Handler(this.g.getLooper(), this);
      }
      this.h.sendEmptyMessage(1024);
      this.h.sendEmptyMessageDelayed(1025, 5000L);
      return;
    }
    catch (Error paramContext) {}
  }
  
  public static void a(Context arg0, String paramString1, String paramString2)
  {
    if (??? != null)
    {
      if (paramString2 == null) {
        return;
      }
      if (a == null) {
        a = new b(???);
      }
      synchronized (c)
      {
        StringBuilder localStringBuilder;
        if (e.length() > 40960)
        {
          e.delete(0, e.length() / 2);
          localStringBuilder = e;
          localStringBuilder.append("log has been cut len ");
          localStringBuilder.append(e.length());
          localStringBuilder.append("\n");
        }
        try
        {
          localStringBuilder = e;
          localStringBuilder.append(util.getDate());
          localStringBuilder.append(util.getCurrentPid());
          localStringBuilder.append(util.getThreadId());
          localStringBuilder.append(util.getLineInfo(3));
          localStringBuilder.append(util.getUser(paramString1));
          localStringBuilder.append(paramString2);
          localStringBuilder.append("\n");
        }
        catch (Exception paramString1)
        {
          label150:
          break label150;
        }
        e = new StringBuilder();
        return;
      }
    }
    else
    {
      return;
    }
  }
  
  private void b()
  {
    try
    {
      this.h.sendEmptyMessageDelayed(1024, 2000L);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void c()
  {
    if (Thread.currentThread() != this.g) {
      return;
    }
    if (this.b) {
      return;
    }
    this.b = true;
    d();
    this.b = false;
  }
  
  private void d()
  {
    try
    {
      if ((e != null) && (e.length() != 0))
      {
        d = e;
        e = new StringBuilder();
        byte[] arrayOfByte1 = util.compress(d.toString().getBytes());
        if (arrayOfByte1 != null)
        {
          if (arrayOfByte1.length == 0) {
            return;
          }
          byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
          util.int32_to_buf(arrayOfByte2, 0, arrayOfByte1.length);
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
          util.writeFile(util.getLogFileName(this.f, util.getCurrentDay()), arrayOfByte2);
          return;
        }
        return;
      }
      return;
    }
    catch (Error localError) {}
  }
  
  public void a()
  {
    try
    {
      if (util.ExistSDCard())
      {
        Object localObject1 = Environment.getExternalStorageDirectory();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
        ((StringBuilder)localObject2).append("/tencent/wtlogin/");
        ((StringBuilder)localObject2).append(this.f.getPackageName());
        localObject1 = ((StringBuilder)localObject2).toString();
        util.LOGI("oldPath:".concat(String.valueOf(localObject1)), "");
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists())
        {
          localObject2 = ((File)localObject1).listFiles();
          if ((localObject2 != null) && (localObject2.length > 0))
          {
            StringBuilder localStringBuilder = new StringBuilder("oldPath delete ");
            localStringBuilder.append(localObject2.length);
            util.LOGI(localStringBuilder.toString(), "");
            int i = 0;
            while (i < localObject2.length)
            {
              localObject2[i].delete();
              i += 1;
            }
          }
          ((File)localObject1).delete();
          return;
        }
        util.LOGI("oldPath not exist", "");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      util.LOGI(Log.getStackTraceString(localThrowable), "");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 1025: 
      a();
      break;
    case 1024: 
      c();
      b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.b
 * JD-Core Version:    0.7.0.1
 */