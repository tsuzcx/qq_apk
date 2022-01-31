package com.tencent.mobileqq.testassister;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Time;
import gqm;
import gqn;
import gqo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ShareAppLogHelper
  implements Runnable
{
  public static final int a = 0;
  private static final String jdField_a_of_type_JavaLangString = "logs_zip_";
  public static final int b = 1;
  private static final String jdField_b_of_type_JavaLangString = "/data/anr/traces.txt";
  public static final int c = -1;
  public static final int d = -2;
  public static final int e = -3;
  public static final int f = 1048576;
  private static final int g = 1000;
  private static final int h = 1001;
  private static final int i = 1002;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new gqm(this, Looper.getMainLooper());
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener;
  volatile Object jdField_a_of_type_JavaLangObject = new Object();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{2}.\\d{2}.\\d{2}.\\d{2}");
  private boolean jdField_a_of_type_Boolean;
  File[] jdField_a_of_type_ArrayOfJavaIoFile;
  private Time jdField_b_of_type_AndroidTextFormatTime;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  
  public ShareAppLogHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = (Environment.getExternalStorageDirectory().getPath() + "/tencent/" + this.jdField_a_of_type_AndroidContentContext.getPackageName().replace(".", "/") + "/");
  }
  
  private int a()
  {
    Object localObject = new File(this.c);
    if (!((File)localObject).exists()) {
      return -1;
    }
    this.jdField_a_of_type_ArrayOfJavaIoFile = ((File)localObject).listFiles(new gqn(this));
    File localFile;
    if (this.jdField_a_of_type_Boolean)
    {
      localFile = new File("/data/anr/traces.txt");
      if (localFile.exists())
      {
        if ((this.jdField_a_of_type_ArrayOfJavaIoFile == null) || (this.jdField_a_of_type_ArrayOfJavaIoFile.length <= 0)) {
          break label133;
        }
        localObject = new File[this.jdField_a_of_type_ArrayOfJavaIoFile.length + 1];
        System.arraycopy(this.jdField_a_of_type_ArrayOfJavaIoFile, 0, localObject, 0, this.jdField_a_of_type_ArrayOfJavaIoFile.length);
        localObject[this.jdField_a_of_type_ArrayOfJavaIoFile.length] = localFile;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfJavaIoFile = ((File[])localObject);
      if ((this.jdField_a_of_type_ArrayOfJavaIoFile != null) && (this.jdField_a_of_type_ArrayOfJavaIoFile.length > 0)) {
        break;
      }
      return -2;
      label133:
      localObject = new File[1];
      localObject[0] = localFile;
    }
    return 0;
  }
  
  private Time a(String paramString)
  {
    paramString = this.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    if (paramString.find())
    {
      paramString = a(paramString.group(), "\\.");
      if (paramString != null)
      {
        if (paramString.year < 100) {
          paramString.year += 2000;
        }
        return paramString;
      }
    }
    return null;
  }
  
  public static Time a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split(paramString2);
      if (paramString1.length == 4)
      {
        paramString2 = new Time();
        paramString2.year = Integer.parseInt(paramString1[0]);
        paramString2.month = (Integer.parseInt(paramString1[1]) - 1);
        paramString2.monthDay = Integer.parseInt(paramString1[2]);
        paramString2.hour = Integer.parseInt(paramString1[3]);
        return paramString2;
      }
      if (paramString1.length == 3)
      {
        paramString2 = new Time();
        paramString2.year = Integer.parseInt(paramString1[0]);
        paramString2.month = (Integer.parseInt(paramString1[1]) - 1);
        paramString2.monthDay = Integer.parseInt(paramString1[2]);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private String a(Time paramTime)
  {
    return String.format("%4d_%2d_%2d_%2d", new Object[] { Integer.valueOf(paramTime.year), Integer.valueOf(paramTime.month + 1), Integer.valueOf(paramTime.monthDay), Integer.valueOf(paramTime.hour) });
  }
  
  private String a(Time paramTime1, Time paramTime2)
  {
    return "logs_zip_" + a(paramTime1) + "-" + a(paramTime2) + ".zip";
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidTextFormatTime = null;
    this.jdField_b_of_type_AndroidTextFormatTime = null;
    this.jdField_a_of_type_ArrayOfJavaIoFile = null;
    this.d = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  private void a(int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1001;
    localMessage.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void a(String paramString)
  {
    new gqo(this, paramString).start();
  }
  
  private int b()
  {
    int k = 0;
    this.d = (this.c + a(this.jdField_a_of_type_AndroidTextFormatTime, this.jdField_b_of_type_AndroidTextFormatTime));
    long l;
    do
    {
      ZipOutputStream localZipOutputStream;
      for (;;)
      {
        try
        {
          File localFile = new File(this.d);
          localZipOutputStream = new ZipOutputStream(new FileOutputStream(localFile));
          byte[] arrayOfByte = new byte[1024];
          File[] arrayOfFile = this.jdField_a_of_type_ArrayOfJavaIoFile;
          int m = arrayOfFile.length;
          j = 0;
          if (j >= m) {
            break;
          }
          Object localObject = arrayOfFile[j];
          ZipEntry localZipEntry = new ZipEntry(((File)localObject).getName());
          localZipEntry.setSize(((File)localObject).length());
          localZipEntry.setTime(((File)localObject).lastModified());
          localZipOutputStream.putNextEntry(localZipEntry);
          localObject = new BufferedInputStream(new FileInputStream((File)localObject));
          int n = ((InputStream)localObject).read(arrayOfByte, 0, 1024);
          if (n != -1)
          {
            localZipOutputStream.write(arrayOfByte, 0, n);
            continue;
          }
          ((InputStream)localObject).close();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = -3;
          return j;
        }
        j += 1;
      }
      localZipOutputStream.close();
      l = localException.length();
      int j = k;
    } while (l < 1048576L);
    return 1;
  }
  
  private void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  private void b(int paramInt)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1002;
    localMessage.obj = Integer.valueOf(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private void b(String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
    localMessage.what = 1000;
    if (paramString == null) {}
    for (localMessage.obj = "";; localMessage.obj = paramString)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return "Failed!";
    case -1: 
      return "日志路径不存在！";
    case -2: 
      return "没有符合条件的日志文件！";
    case -3: 
      return "压缩失败！";
    }
    return "你的日志大小已经超过1M，确认发送？";
  }
  
  public void a(ShareAppLogHelper.OnGetLocalLogListener paramOnGetLocalLogListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = paramOnGetLocalLogListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public boolean a(Time paramTime1, Time paramTime2, boolean paramBoolean)
  {
    return false;
  }
  
  public void run()
  {
    int j = a();
    if (j != 0)
    {
      a(j);
      a();
      return;
    }
    j = b();
    if (j == 1)
    {
      b(j);
      b();
      if (!this.jdField_b_of_type_Boolean) {
        b(this.d);
      }
    }
    for (;;)
    {
      a();
      return;
      a(this.d);
      continue;
      if (j == 0) {
        b(this.d);
      } else {
        a(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper
 * JD-Core Version:    0.7.0.1
 */