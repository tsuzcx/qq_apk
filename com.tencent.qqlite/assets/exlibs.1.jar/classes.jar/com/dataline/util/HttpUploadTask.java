package com.dataline.util;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;

public class HttpUploadTask
  implements Runnable
{
  public static final int a = 20000;
  private static final String jdField_a_of_type_JavaLangString = "dlFileTransfer.upload";
  public static final int b = 60000;
  private long jdField_a_of_type_Long = 1024L;
  public HttpUpload.HttpTar a;
  public HttpUpload a;
  private SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM = null;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream = null;
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  private boolean jdField_b_of_type_Boolean = true;
  private long c;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  public HttpUploadTask()
  {
    this.jdField_c_of_type_Long = 0L;
  }
  
  private HttpResponse a()
  {
    boolean bool1 = this.jdField_b_of_type_Boolean;
    int i = 0;
    for (;;)
    {
      if (i < 3)
      {
        b();
        Object localObject1 = a(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long, this.jdField_a_of_type_Long);
        if (localObject1 == null) {
          return null;
        }
        if (this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 8;
          return null;
        }
        Object localObject2 = a(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar, (byte[])localObject1);
        if (this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 8;
          return null;
        }
        QLog.d("dlFileTransfer.upload", 2, "uploader: sendFilePackage BlockSize:" + localObject1.length);
        Object localObject3 = this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar;
        ((HttpUpload.HttpTar)localObject3).e += localObject1.length;
        try
        {
          localObject2 = a(bool1).execute((HttpUriRequest)localObject2);
          StatusLine localStatusLine = ((HttpResponse)localObject2).getStatusLine();
          if (localStatusLine.getStatusCode() == 200)
          {
            ((HttpResponse)localObject2).getEntity().consumeContent();
            this.d += localObject1.length;
            return localObject2;
          }
          localObject3 = localStatusLine.getReasonPhrase();
          localObject1 = "0";
          if (((HttpResponse)localObject2).containsHeader("User-ReturnCode")) {
            localObject1 = localObject2.getHeaders("User-ReturnCode")[0].getValue();
          }
          label275:
          boolean bool2;
          label305:
          int j;
          label389:
          return null;
        }
        catch (IOException localIOException)
        {
          try
          {
            this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Int = localStatusLine.getStatusCode();
            this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Int = Integer.parseInt((String)localObject1);
            if (!((String)localObject1).equals("-29212"))
            {
              bool2 = ((String)localObject1).equals("-29210");
              if (!bool2) {
                break label389;
              }
            }
            try
            {
              Thread.sleep(6000L);
              QLog.d("dlFileTransfer.upload", 1, "uploader: http error '" + (String)localObject3 + ", User-ReturnCode:" + (String)localObject1 + "'. session =" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Long + ",offset=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long + ",length=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long);
              break label777;
              this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 4;
              QLog.d("dlFileTransfer.upload", 1, "uploader: http error '" + (String)localObject3 + ", statusCode:" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Int + "'. session =" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Long + ",offset=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long + ",length=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long);
              ((HttpResponse)localObject2).getEntity().getContent().close();
              return null;
              localIOException = localIOException;
              QLog.d("dlFileTransfer.upload", 1, "uploader: http io error:" + localIOException.getMessage() + ". session =" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Long + ",offset=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long + ",length=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long);
              j = 3;
              for (;;)
              {
                try
                {
                  bool1 = this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Boolean;
                  if (!bool1) {
                    continue;
                  }
                }
                catch (InterruptedException localInterruptedException)
                {
                  localInterruptedException.printStackTrace();
                  continue;
                  if (!this.jdField_a_of_type_Boolean) {
                    break;
                  }
                }
                if (this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Boolean)
                {
                  this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 8;
                  return null;
                  Thread.sleep(1000L);
                  if (j > 0) {
                    if ((NetworkUtil.f(BaseApplication.getContext())) || (this.jdField_a_of_type_Boolean))
                    {
                      if (!NetworkUtil.g(BaseApplication.getContext()))
                      {
                        bool1 = this.jdField_a_of_type_Boolean;
                        if (!bool1) {
                          break;
                        }
                      }
                    }
                    else {
                      j -= 1;
                    }
                  }
                }
                else if (!NetworkUtil.g(BaseApplication.getContext()))
                {
                  this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 9;
                  QLog.d("dlFileTransfer.upload", 1, "uploader: network changed: wifi -> 3G. session =" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Long + ",offset=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long + ",length=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long);
                  return null;
                }
              }
            }
            catch (Exception localException1)
            {
              break label305;
            }
          }
          catch (Exception localException2)
          {
            break label275;
            bool1 = false;
          }
        }
      }
      label777:
      i += 1;
    }
  }
  
  private HttpClient a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient == null)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = HttpUtil.a(false, paramBoolean, 20000, 60000);
    }
    for (;;)
    {
      return this.jdField_a_of_type_OrgApacheHttpClientHttpClient;
      if (this.jdField_b_of_type_Boolean != paramBoolean)
      {
        c();
        this.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_OrgApacheHttpClientHttpClient = HttpUtil.a(false, paramBoolean, 20000, 60000);
      }
    }
  }
  
  private HttpPost a(HttpUpload.HttpTar paramHttpTar, byte[] paramArrayOfByte)
  {
    HttpPost localHttpPost = new HttpPost(String.format("%s&range=%d", new Object[] { paramHttpTar.jdField_a_of_type_JavaLangString, Long.valueOf(paramHttpTar.jdField_c_of_type_Long) }));
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComDatalineUtilHttpUpload.a)
      {
        paramHttpTar.jdField_a_of_type_OrgApacheHttpClientMethodsHttpPost = localHttpPost;
        localHttpPost.setHeader("Content-Type", "text/octet");
        localHttpPost.setHeader("Connection", "keep-alive");
        if (NetworkUtil.g(BaseApplication.getContext()))
        {
          localHttpPost.setHeader("Net-type", "Wifi");
          if (paramHttpTar.jdField_c_of_type_Long != 0L) {
            localHttpPost.setHeader("Range", String.format("bytes=%d-%d", new Object[] { Long.valueOf(paramHttpTar.jdField_c_of_type_Long), Long.valueOf(paramHttpTar.jdField_c_of_type_Long + paramArrayOfByte.length - 1L) }));
          }
          localHttpPost.setEntity(new ByteArrayEntity(paramArrayOfByte));
          return localHttpPost;
        }
      }
      localHttpPost.setHeader("Net-type", "gprs");
    }
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
        this.jdField_a_of_type_JavaIoFileInputStream.close();
      }
      this.jdField_a_of_type_JavaIoFileInputStream = null;
      this.e = 0L;
      this.f = 0L;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    if (paramLong > this.f) {}
    do
    {
      return false;
      if (paramLong > this.e) {
        try
        {
          this.jdField_a_of_type_JavaIoFileInputStream.skip(paramLong - this.e);
          this.e = paramLong;
          return true;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return false;
        }
      }
      if (paramLong == this.e) {
        return true;
      }
    } while (paramLong < 0L);
    a(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_JavaLangString, paramLong, this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_JavaIoFileInputStream != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(HttpUpload.HttpTar paramHttpTar, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComDatalineUtilHttpUpload.a(paramHttpTar);
    }
    for (;;)
    {
      return false;
      long l = System.currentTimeMillis() / 500L;
      if ((l != this.jdField_c_of_type_Long) || (paramHttpTar.jdField_c_of_type_Long == paramHttpTar.jdField_b_of_type_Long))
      {
        this.jdField_c_of_type_Long = l;
        l = System.currentTimeMillis() / 1000L;
        if (l != this.jdField_b_of_type_Long)
        {
          float f1 = (float)this.d / (float)(l - this.jdField_b_of_type_Long) / 1024.0F;
          QLog.d("dlFileTransfer.upload", 2, "uploader: onProgress[RT], filename = " + paramHttpTar.jdField_b_of_type_JavaLangString + " Speed = " + f1 + "KB/s");
        }
        this.jdField_a_of_type_ComDatalineUtilHttpUpload.b(paramHttpTar);
      }
    }
  }
  
  private boolean a(String paramString, long paramLong1, long paramLong2)
  {
    a();
    File localFile;
    try
    {
      localFile = new File(paramString);
      this.f = localFile.length();
      if (paramLong2 != this.f) {
        throw new Exception("uploader: file len is chage, may writing:" + paramString + ":" + paramLong2 + "->" + this.f);
      }
    }
    catch (Exception paramString)
    {
      QLog.d("dlFileTransfer.upload", 2, paramString.getMessage());
      a();
      return false;
    }
    this.e = paramLong1;
    this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(localFile);
    if (this.e > 0L) {
      this.jdField_a_of_type_JavaIoFileInputStream.skip(this.e);
    }
    return true;
  }
  
  private byte[] a(long paramLong1, long paramLong2)
  {
    if (!a(paramLong1)) {}
    for (;;)
    {
      return null;
      byte[] arrayOfByte1 = new byte[(int)Math.min(Math.min(Math.min(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long, this.jdField_a_of_type_Long), 1048576L), this.f - this.e)];
      try
      {
        int i = this.jdField_a_of_type_JavaIoFileInputStream.read(arrayOfByte1);
        this.e += i;
        if (i != -1) {
          if (i < arrayOfByte1.length)
          {
            byte[] arrayOfByte2 = new byte[i];
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
            return arrayOfByte2;
          }
        }
      }
      catch (IOException localIOException)
      {
        this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 3;
        localIOException.printStackTrace();
        return null;
      }
    }
    return localIOException;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWsttSSCMSSCM == null) {
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    }
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.f, this.e);
    int i = Utils.a(BaseApplication.getContext());
    if ((i == 1) || (i == 2)) {
      this.jdField_a_of_type_Long = Math.min(this.jdField_a_of_type_Long, 16384L);
    }
    this.jdField_a_of_type_Long = Math.min(this.jdField_a_of_type_Long, 1048576L);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient != null)
    {
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  public void run()
  {
    QLog.d("dlFileTransfer.upload", 2, "uploader: uploading file[" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_JavaLangString + "] url:" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_JavaLangString);
    boolean bool;
    Object localObject;
    if (HttpUtil.a() != null)
    {
      bool = true;
      a(bool);
      if (!a(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long, this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long)) {
        break label569;
      }
      this.jdField_b_of_type_Long = (System.currentTimeMillis() / 1000L);
      this.jdField_c_of_type_Long = (System.currentTimeMillis() / 500L);
      this.d = 0L;
      this.jdField_a_of_type_Boolean = NetworkUtil.g(BaseApplication.getContext());
      bool = true;
      localObject = a();
      if (localObject != null) {
        break label370;
      }
      label140:
      if (this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long != this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long) {
        break label564;
      }
      bool = true;
    }
    for (;;)
    {
      long l1;
      if (bool)
      {
        a(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar, false);
        long l2 = System.currentTimeMillis() / 1000L;
        l1 = l2;
        if (l2 == this.jdField_b_of_type_Long) {
          l1 = this.jdField_b_of_type_Long + 1L;
        }
        float f1 = (float)this.d / (float)(l1 - this.jdField_b_of_type_Long) / 1024.0F;
        QLog.d("dlFileTransfer.upload", 1, "uploader: upload done. session =" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Long + ",length=" + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long + ",speed=" + f1 + "KB/S");
      }
      QLog.d("dlFileTransfer.upload", 2, "uploader: uploading[isSuccess: " + bool + "] " + this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_JavaLangString);
      c();
      a();
      localObject = this.jdField_a_of_type_ComDatalineUtilHttpUpload;
      HttpUpload.HttpTar localHttpTar = this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar;
      this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar = null;
      this.jdField_a_of_type_ComDatalineUtilHttpUpload = null;
      ((HttpUpload)localObject).a(localHttpTar, bool);
      return;
      bool = false;
      break;
      label370:
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200)
      {
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
        this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long = this.e;
        localObject = ((HttpResponse)localObject).getFirstHeader("Range");
        if (localObject != null)
        {
          l1 = Long.parseLong(((Header)localObject).getValue());
          if (l1 < 0L)
          {
            this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 2;
            break label140;
          }
          if (l1 < this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long) {
            break label518;
          }
          this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long = this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long;
        }
      }
      for (;;)
      {
        bool = a(this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar, bool);
        if (this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long >= this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Long) {
          break label140;
        }
        if (!this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_b_of_type_Boolean) {
          break;
        }
        break label140;
        label518:
        if (l1 > this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long) {
          this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long = l1;
        } else if (l1 < this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long) {
          this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_c_of_type_Long = l1;
        }
      }
      label564:
      bool = false;
      continue;
      label569:
      this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpTar.jdField_a_of_type_Int = 3;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.util.HttpUploadTask
 * JD-Core Version:    0.7.0.1
 */