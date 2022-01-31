package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;

public class c
  implements Handler.Callback
{
  private static c a = null;
  private static String c = "";
  private static String d = "";
  private volatile boolean b = false;
  private Context e;
  private HandlerThread f;
  private Handler g;
  
  private c(Context paramContext)
  {
    this.e = paramContext;
    this.f = new HandlerThread("FileTracer");
    if (this.f != null) {
      this.f.start();
    }
    if (this.f.isAlive()) {
      this.g = new Handler(this.f.getLooper(), this);
    }
    this.g.sendEmptyMessage(1024);
  }
  
  private void a()
  {
    this.g.sendEmptyMessageDelayed(1024, 1000L);
  }
  
  public static void a(Context arg0, String paramString1, String paramString2)
  {
    if ((??? == null) || (paramString2 == null)) {
      return;
    }
    if (a == null) {
      a = new c(???);
    }
    synchronized (d)
    {
      if (d.length() > 4096) {
        d = "";
      }
      d = d + util.getDate() + util.getThreadId() + util.getLineInfo(3) + util.getSdkVersion() + util.getUser(paramString1) + paramString2 + "\n";
      return;
    }
  }
  
  private void b()
  {
    if (Thread.currentThread() != this.f) {}
    while (this.b) {
      return;
    }
    this.b = true;
    c();
    this.b = false;
  }
  
  private void c()
  {
    byte[] arrayOfByte1;
    if ((d != null) && (d.length() > 0))
    {
      c = d;
      d = "";
      arrayOfByte1 = util.compress(c.getBytes());
      if ((arrayOfByte1 != null) && (arrayOfByte1.length != 0)) {}
    }
    else
    {
      return;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    util.int32_to_buf(arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
    util.writeFile(util.getLogFileName(this.e, util.getCurrentDay()), arrayOfByte2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.c
 * JD-Core Version:    0.7.0.1
 */