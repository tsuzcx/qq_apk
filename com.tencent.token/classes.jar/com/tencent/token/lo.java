package com.tencent.token;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class lo
{
  private static volatile boolean a = true;
  private static volatile boolean b = false;
  private static FileWriter c;
  
  public static void a(String paramString1, String paramString2)
  {
    if (b) {
      a("D", paramString1, paramString2, null);
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (lv.a() == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\t");
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    paramString1 = new StringBuilder();
    paramString1.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis())));
    paramString1.append("\t");
    localStringBuilder.append(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append("\t");
    localStringBuilder.append(paramString1.toString());
    if (paramString3 != null)
    {
      paramString1 = new StringBuilder("[MSG]");
      paramString1.append(paramString3);
      paramString1.append("\t");
      localStringBuilder.append(paramString1.toString());
    }
    if (paramThrowable != null)
    {
      paramString1 = new StringBuilder("[Throwable]");
      paramString1.append(Log.getStackTraceString(paramThrowable));
      localStringBuilder.append(paramString1.toString());
    }
    localStringBuilder.append("\r\n");
    for (;;)
    {
      try
      {
        paramString1 = c;
        if (paramString1 != null) {
          try
          {
            c.write(localStringBuilder.toString());
            c.flush();
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            try
            {
              c.close();
            }
            catch (IOException paramString1)
            {
              paramString1.printStackTrace();
            }
            c = null;
          }
        }
        if (c == null)
        {
          paramString2 = "halley_log_file_".concat(String.valueOf(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date(System.currentTimeMillis()))));
          if (lx.a())
          {
            paramString3 = new StringBuilder();
            if (!lx.a()) {
              break label554;
            }
            paramString1 = lx.e();
            paramThrowable = new StringBuilder();
            paramThrowable.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            paramThrowable.append("/");
            paramThrowable.append(paramString1);
            paramString1 = paramThrowable.toString();
            paramString3.append(paramString1);
            paramString3.append("/Log");
            paramString1 = paramString3.toString();
            paramString3 = new File(paramString1);
            if (!paramString3.exists()) {
              paramString3.mkdirs();
            }
            paramString1 = new File(paramString1, paramString2);
            if (paramString1.isDirectory()) {
              paramString1.delete();
            }
            boolean bool = paramString1.exists();
            if (!bool) {
              try
              {
                paramString1.createNewFile();
              }
              catch (IOException paramString1)
              {
                paramString1.printStackTrace();
                paramString1 = c;
                if (paramString1 != null)
                {
                  try
                  {
                    c.close();
                  }
                  catch (Exception paramString1)
                  {
                    paramString1.printStackTrace();
                  }
                  c = null;
                }
                return;
              }
            }
            try
            {
              paramString1 = new FileWriter(paramString1);
              c = paramString1;
              paramString1.write(localStringBuilder.toString());
              c.flush();
            }
            catch (IOException paramString1)
            {
              paramString1.printStackTrace();
              paramString1 = c;
              if (paramString1 != null)
              {
                try
                {
                  c.close();
                }
                catch (Exception paramString1)
                {
                  paramString1.printStackTrace();
                }
                c = null;
              }
            }
          }
        }
        return;
      }
      finally {}
      label554:
      paramString1 = "";
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b) {
      a("W", paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (b) {
      a("W", paramString, null, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (b) {
      a("I", paramString1, paramString2, null);
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (b) {
      a("E", paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (b) {
      a("W", paramString1, paramString2, null);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (b) {
      a("E", paramString1, paramString2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lo
 * JD-Core Version:    0.7.0.1
 */