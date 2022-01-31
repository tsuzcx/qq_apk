package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpContinueDownloadFileProcessor
  extends BaseTransProcessor
  implements IHttpCommunicatorListener
{
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[^\\d]*(\\d+)\\-(\\d+)/(\\d+)[^\\d]*");
  private static final int aj = 100;
  private static final String jdField_c_of_type_JavaLangString = HttpContinueDownloadFileProcessor.class.getSimpleName();
  private static final String jdField_d_of_type_JavaLangString = "http://imgcache.qq.com";
  private static final long jdField_f_of_type_Long = 50L;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map b = new HashMap();
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  private Map jdField_d_of_type_JavaUtilMap;
  private Map e = new HashMap();
  private Map jdField_f_of_type_JavaUtilMap;
  private long g;
  private long h;
  private long i;
  private long j = -1L;
  
  public HttpContinueDownloadFileProcessor(String paramString1, String paramString2, long paramLong, TransFileController paramTransFileController)
  {
    super(paramTransFileController);
    this.d = new HashMap();
    this.f = new HashMap();
    if ((paramString1 == null) || (paramString1.trim().length() == 0) || (paramString2 == null) || (paramString2.trim().length() == 0)) {
      throw new IllegalArgumentException("url and filePath must not be empty");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg = new FileMsg("", paramString1, 1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong;
    if (paramLong % 2048L == 0L) {}
    for (paramLong /= 2048L;; paramLong = paramLong / 2048L + 1L)
    {
      this.g = (paramLong / 100L);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "perPkgNum is:" + this.g);
      }
      return;
    }
  }
  
  public static File a(String paramString)
  {
    return new File(paramString + ".tmp");
  }
  
  private void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException paramOutputStream) {}
  }
  
  private void a(Exception paramException)
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k)) {}
    for (String str1 = "report_theme_file_download";; str1 = "report_copycat_theme_file_download")
    {
      HashMap localHashMap = new HashMap();
      int m = this.at;
      String str3 = this.J;
      String str2 = str3;
      int k = m;
      if (paramException != null)
      {
        str2 = str3;
        k = m;
        if ((paramException instanceof HttpContinueDownloadFileProcessor.ThemeDownloadException))
        {
          paramException = (HttpContinueDownloadFileProcessor.ThemeDownloadException)paramException;
          k = HttpContinueDownloadFileProcessor.ThemeDownloadException.access$000(paramException);
          str2 = paramException.getMessage();
        }
      }
      localHashMap.put("param_FailCode", String.valueOf(k));
      localHashMap.put("param_FailMsg", str2);
      localHashMap.put("theme_url", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str1, false, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.trim().startsWith("http://imgcache.qq.com"));
  }
  
  private long[] a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (paramString.trim().length() != 0) {
        break label28;
      }
      localObject1 = localObject2;
    }
    label28:
    Matcher localMatcher;
    do
    {
      return localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "contentRange is:" + paramString);
      }
      localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
      localObject1 = localObject2;
    } while (!localMatcher.matches());
    int m = localMatcher.groupCount();
    paramString = new long[m];
    int k = 1;
    for (;;)
    {
      localObject1 = paramString;
      if (k > m) {
        break;
      }
      paramString[(k - 1)] = Long.parseLong(localMatcher.group(k));
      k += 1;
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.trim().length() == 0)) {}
    for (;;)
    {
      return;
      paramString1 = new File(paramString1);
      if ((paramString1.exists()) && (paramString1.isDirectory()))
      {
        paramString1 = paramString1.listFiles();
        if (paramString1.length > 0)
        {
          int k = 0;
          while (k < paramString1.length)
          {
            String str = paramString1[k].getName();
            if ((str.startsWith(paramString2)) && (str.endsWith(".tmp"))) {
              paramString1[k].delete();
            }
            k += 1;
          }
        }
      }
    }
  }
  
  private void c()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k)) {}
    for (String str = "report_theme_file_download";; str = "report_copycat_theme_file_download")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("theme_url", this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str, true, 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  public static void c(String paramString)
  {
    new File(paramString + ".tmp").delete();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "start download using " + jdField_c_of_type_JavaLangString);
    }
    boolean bool;
    try
    {
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k, null, this, true);
      localHttpMsg.b(5);
      localHttpMsg.a(true);
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp");
      File localFile = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.getParentFile();
      if ((localFile == null) || (localFile.exists())) {
        break label265;
      }
      bool = localFile.mkdirs();
      if (!bool) {
        throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89069, "failed to make dirs " + localFile.getAbsolutePath());
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "start download failed", localException);
      }
      a(9003, localException.getMessage());
      b(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, jdField_c_of_type_JavaLangString + "make dirs failed,stop download" + bool);
    }
    label265:
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    localException.a("Accept-Encoding", "identity");
    long l = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = l;
    localException.a("Range", "bytes=" + l + "-");
    localException.a("Accept", "application/octet-stream");
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "start download success,url is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k + ",filePath is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ",fileLength is:" + l);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "start send msg to HttpCommunicator");
    }
    this.d.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
    localException.d = 131072;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localException);
    d(2001);
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    for (boolean bool = false;; bool = true)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject2 = (Boolean)this.b.get(paramHttpMsg1);
        localObject3 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramHttpMsg1);
        Boolean localBoolean = (Boolean)this.jdField_c_of_type_JavaUtilMap.get(paramHttpMsg1);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("result is:");
          if ((paramHttpMsg2.c() == 200) || (paramHttpMsg2.c() == 206)) {
            continue;
          }
          QLog.d("ThemeDownloadTrace", 2, bool + ",transferedSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d + ",fileSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + ",requestPause is:" + localObject2 + ",requestStop is:" + localObject3 + ",hasError is:" + localBoolean);
        }
        if (((localObject2 != null) && (((Boolean)localObject2).booleanValue())) || ((localObject3 != null) && (((Boolean)localObject3).booleanValue()))) {
          return;
        }
        if ((localBoolean != null) && (localBoolean.booleanValue())) {
          return;
        }
      }
      try
      {
        if (this.j != -1L) {
          break label504;
        }
        if (paramHttpMsg2.c() != 206) {
          break label721;
        }
        localObject2 = paramHttpMsg2.a("content-range");
        localObject3 = a((String)localObject2);
        if ((localObject3 == null) || (localObject3.length < 3)) {
          throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89065, "Content-Range is illegal,contentRange is:" + (String)localObject2);
        }
      }
      catch (Exception paramHttpMsg2)
      {
        if ((paramHttpMsg2 instanceof HttpContinueDownloadFileProcessor.ThemeDownloadException)) {
          this.f.put(paramHttpMsg1, paramHttpMsg2);
        }
        throw new RuntimeException(paramHttpMsg2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long != localObject3[2]) {
        throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89066, "fileSize not equal content length,content length is:" + localObject3[2] + ",fileSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp", true));
      this.j = (localObject3[2] - localObject3[0]);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "totalLen is:" + this.j);
      }
      label504:
      Object localObject2 = paramHttpMsg2.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.write((byte[])localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      ((FileMsg)localObject2).d += paramHttpMsg2.a().length;
      this.i += paramHttpMsg2.a().length;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "thisTimeReadByteNum is:" + this.i + ",totalLen is:" + this.j);
      }
      if (this.i == this.j)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
        paramHttpMsg2 = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.renameTo(paramHttpMsg2))
        {
          this.e.put(paramHttpMsg1, Boolean.TRUE);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.setLastModified(System.currentTimeMillis());
          d(2003);
          c();
        }
      }
      for (;;)
      {
        return;
        label721:
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.d = 0L;
        this.j = paramHttpMsg2.a();
        if (this.j != this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long) {
          throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89066, "fileSize not equal content length,content length is:" + this.j + ",fileSize is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream = new BufferedOutputStream(new FileOutputStream(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e + ".tmp", false));
        break;
        throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89067, "rename file failed,file path is:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e);
        if (this.i > this.j)
        {
          a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoFile.delete();
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDownloadTrace", 2, "thisTimeReadByteNum less than totalLen,thisTimeReadByteNum is:" + this.i + ",totalLen is:" + this.j);
          }
          throw new HttpContinueDownloadFileProcessor.ThemeDownloadException(89068, "data that server send is wrong,thisTimeReadByteNum is:" + this.i + ",thisTimeTotalByteNum is:" + this.j);
        }
        if (this.g < 2L)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.flush();
          f();
        }
        else
        {
          this.h += 1L;
          if (this.h >= this.g)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream.flush();
            f();
          }
        }
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, jdField_c_of_type_JavaLangString + " statusChanged(),status is:" + paramInt);
    }
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg arg2)
  {
    do
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.e.put(paramHttpMsg1, Boolean.TRUE);
        if (this.at != 9037) {
          this.jdField_c_of_type_JavaUtilMap.put(paramHttpMsg1, Boolean.TRUE);
        }
        Boolean localBoolean1 = (Boolean)this.b.get(paramHttpMsg1);
        Boolean localBoolean2 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramHttpMsg1);
        if (((localBoolean1 != null) && (localBoolean1.booleanValue())) || ((localBoolean2 != null) && (localBoolean2.booleanValue()))) {}
        do
        {
          ??? = (Boolean)this.b.get(paramHttpMsg1);
          localBoolean1 = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramHttpMsg1);
          if (((??? == null) || (!???.booleanValue())) && ((localBoolean1 == null) || (!localBoolean1.booleanValue()))) {
            break;
          }
          return;
          a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
        } while (this.at == 9037);
        d(2005);
      }
    } while (this.at == 9037);
    a((Exception)this.f.get(paramHttpMsg1));
  }
  
  public boolean f()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
        if ((Boolean)this.d.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null)
        {
          bool = true;
          this.e.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
          return bool;
        }
        if ((Boolean)this.e.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null) {
          bool = true;
        }
      }
      boolean bool = false;
    }
  }
  
  public void g() {}
  
  public boolean g()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.b.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_JavaIoOutputStream);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.k);
        if ((Boolean)this.d.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null)
        {
          bool = true;
          this.e.put(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg, Boolean.TRUE);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
          return bool;
        }
        if ((Boolean)this.e.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) == null) {
          bool = true;
        }
      }
      boolean bool = false;
    }
  }
  
  public void h()
  {
    f();
  }
  
  public boolean h()
  {
    Boolean localBoolean1 = (Boolean)this.d.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    Boolean localBoolean2 = (Boolean)this.e.get(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    if (localBoolean1 == null) {
      return false;
    }
    return localBoolean2 == null;
  }
  
  public void i()
  {
    g();
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpContinueDownloadFileProcessor
 * JD-Core Version:    0.7.0.1
 */