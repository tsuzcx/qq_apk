package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper.QuicBundle;
import com.tencent.mobileqq.msf.core.quic.a;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;

public class f
  implements b
{
  private static final String d = "LightQuicEngine";
  boolean a = false;
  boolean b = false;
  Object c = null;
  private a e = null;
  private long f = -1L;
  private String g;
  private int h;
  private int i = 10000;
  private int j = 10000;
  private String k;
  
  private String a(String paramString, int paramInt)
  {
    Object localObject = new Random(System.currentTimeMillis());
    localObject = "r=" + paramInt + "_" + String.valueOf(((Random)localObject).nextInt(100000));
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?")) {
        return paramString + (String)localObject;
      }
      return (String)localObject + "&" + (String)localObject;
    }
    return "?" + (String)localObject;
  }
  
  private int[] a(String paramString)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new CharArrayReader(paramString.toCharArray()));
    int m = 0;
    for (;;)
    {
      try
      {
        Object localObject = localBufferedReader.readLine();
        if (localObject != null)
        {
          if (((String)localObject).startsWith("Content-Length"))
          {
            localObject = ((String)localObject).split(":");
            if ((localObject == null) || (localObject.length != 2)) {
              continue;
            }
            m = Integer.parseInt(localObject[1].trim());
            continue;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          n = paramString.indexOf("\r\n\r\n");
          int i1 = "\r\n\r\n".length();
          n += i1;
          localBufferedReader.close();
          return new int[] { m, n };
        }
      }
      finally
      {
        localBufferedReader.close();
      }
      int n = 0;
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(Object paramObject)
  {
    this.c = paramObject;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, com.tencent.mobileqq.msf.core.quicksend.f paramf)
  {
    this.g = paramString1;
    this.h = paramInt;
    long l = System.currentTimeMillis();
    this.f = this.e.a();
    this.b = this.e.a(this.f, this.g, this.h, this.i);
    paramf.j = (System.currentTimeMillis() - l);
    QLog.d("LightQuicEngine", 1, "connect " + this.g + ":" + this.h + " " + this.b);
    return this.b;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, com.tencent.mobileqq.msf.core.quicksend.f paramf)
  {
    int i8 = paramToServiceMsg.getRequestSsoSeq();
    long l1 = SystemClock.elapsedRealtime();
    paramToServiceMsg = "http://" + this.g + ":" + this.h;
    this.k = (paramToServiceMsg + a(paramToServiceMsg, i8));
    this.k = MsfSdkUtils.insertMtype(paramString, this.k);
    QLog.d("LightQuicEngine", 1, "try connect " + this.k + " timeout:" + this.i + " ssoseq:" + i8 + " sendByXG:" + this.a);
    paramToServiceMsg = "/" + this.k.substring(this.k.indexOf("?"));
    paramString = new StringBuffer();
    paramString.append("POST ").append(paramToServiceMsg).append(" HTTP/1.1\r\n");
    paramString.append("User-Agent: aqq\r\n");
    paramString.append("content-type: oct\r\n");
    paramString.append("Connection: Keep-Alive\r\n");
    paramString.append("Accept-Encoding: \r\n");
    paramString.append("Host: ").append(this.g).append("\r\n");
    paramString.append("Content-Length: ").append(paramArrayOfByte.length).append("\r\n\r\n");
    paramToServiceMsg = paramString.toString().getBytes();
    for (;;)
    {
      int i4;
      int i2;
      int i3;
      int i6;
      int i7;
      try
      {
        m = this.e.a(this.f, paramToServiceMsg, paramToServiceMsg.length, this.j);
        n = this.e.a(this.f, paramArrayOfByte, paramArrayOfByte.length, this.j);
        QLog.d("LightQuicEngine", 1, "httpSend sendByXG:" + this.a + " ssoseq:" + i8 + " len:" + (m + n));
        paramToServiceMsg = new ByteArrayBuffer(512);
        m = 0;
        n = 0;
        i1 = 0;
        paramArrayOfByte = this.e.a(this.f, 512, this.j);
        i5 = paramArrayOfByte.retcode;
        if (paramArrayOfByte.retcode <= 0)
        {
          this.b = false;
          if (QLog.isDevelopLevel())
          {
            paramArrayOfByte = new byte[n];
            System.arraycopy(paramToServiceMsg.toByteArray(), 0, paramArrayOfByte, 0, n);
            QLog.d("LightQuicEngine", 2, new String(paramArrayOfByte));
          }
          long l2 = SystemClock.elapsedRealtime();
          QLog.d("LightQuicEngine", 1, "httpRecv ssoseq:" + i8 + " content_len:" + i1 + " costtime:" + (l2 - l1) + " ret=" + i5 + " data_len=" + m);
          paramArrayOfByte = new byte[i1];
          System.arraycopy(paramToServiceMsg.toByteArray(), n, paramArrayOfByte, 0, i1);
          return paramArrayOfByte;
        }
        i4 = m + paramArrayOfByte.data_len;
        paramToServiceMsg.append(paramArrayOfByte.data, 0, paramArrayOfByte.data_len);
        paramArrayOfByte = a(new String(paramToServiceMsg.toByteArray()));
        i2 = paramArrayOfByte[0];
        i3 = paramArrayOfByte[1];
        m = i4;
        n = i3;
        i1 = i2;
        if (i2 <= 0) {
          continue;
        }
        m = i4;
        n = i3;
        i1 = i2;
        if (i3 <= 0) {
          continue;
        }
        i6 = i2 - (paramToServiceMsg.length() - i3);
        if (QLog.isColorLevel()) {
          QLog.d("LightQuicEngine", 2, "parseHttpHeader contentLen=" + i2 + " bodyOffset=" + i3 + " remainBytes=" + i6);
        }
        m = i4;
        n = i3;
        i1 = i2;
        if (i6 <= 0) {
          continue;
        }
        paramArrayOfByte = this.e.a(this.f, i6, this.j);
        i7 = paramArrayOfByte.retcode;
        if (paramArrayOfByte.retcode <= 0)
        {
          this.b = false;
          m = i4;
          i5 = i7;
          n = i3;
          i1 = i2;
          continue;
        }
        i4 += paramArrayOfByte.data_len;
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightQuicEngine", 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
        }
        c();
        paramToServiceMsg.printStackTrace();
        return null;
      }
      paramToServiceMsg.append(paramArrayOfByte.data, 0, paramArrayOfByte.data_len);
      int i5 = i6;
      if (paramArrayOfByte.data_len > 0)
      {
        m = paramArrayOfByte.data_len;
        i5 = i6 - m;
      }
      int m = i4;
      int n = i3;
      int i1 = i2;
      if (i5 <= 0)
      {
        m = i4;
        i5 = i7;
        n = i3;
        i1 = i2;
      }
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.b = false;
    this.e.a(this.f);
    this.e.b(this.f);
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.f
 * JD-Core Version:    0.7.0.1
 */