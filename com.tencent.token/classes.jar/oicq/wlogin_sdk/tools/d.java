package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class d
{
  static a a;
  static LinkedList<String> b = new LinkedList();
  private static boolean c = false;
  private static String d = "";
  private static BufferedWriter e;
  private static HandlerThread f;
  
  public static void a(Context paramContext)
  {
    if (true == c) {
      return;
    }
    f = new HandlerThread("WTLog");
    try
    {
      f.start();
      if (true == f.isAlive()) {
        a = new a(f.getLooper());
      }
      d = util.getLogFileName(paramContext, util.getCurrentDay());
      c = true;
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(util.getDate()).append(util.getThreadId()).append(util.getLineInfo(3)).append(util.getSdkVersion()).append(util.getUser(paramString2)).append(paramString1).append("\n");
    paramString1 = new Bundle();
    paramString1.putString("msg", localStringBuilder.toString());
    paramString2 = new Message();
    paramString2.setData(paramString1);
    paramString2.what = 2;
    a.sendMessage(paramString2);
  }
  
  private static void b()
  {
    try
    {
      Object localObject;
      if (e == null)
      {
        localObject = new File(d);
        if (!((File)localObject).exists())
        {
          File localFile = ((File)localObject).getParentFile();
          if (localFile == null) {
            return;
          }
          localFile.mkdirs();
          if (localFile.isDirectory()) {
            ((File)localObject).createNewFile();
          }
        }
        else
        {
          e = new BufferedWriter(new FileWriter((File)localObject, true));
        }
      }
      else
      {
        for (;;)
        {
          localObject = (String)b.removeFirst();
          e.write((String)localObject);
        }
      }
      label91:
      return;
    }
    catch (NoSuchElementException localNoSuchElementException)
    {
      try
      {
        e.close();
        e = null;
        return;
      }
      catch (Exception localException1)
      {
        e = null;
        return;
      }
    }
    catch (Exception localException2)
    {
      break label91;
    }
  }
  
  static class a
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
      case 2: 
        paramMessage = paramMessage.getData();
        if (paramMessage != null)
        {
          paramMessage = paramMessage.getString("msg");
          if (paramMessage != null) {
            d.b.add(paramMessage);
          }
        }
        d.a.sendEmptyMessageDelayed(1, 5000L);
        return;
      }
      d.a();
      d.a.removeMessages(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.d
 * JD-Core Version:    0.7.0.1
 */