package com.tencent.mobileqq.msf.core.net.b;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class b
  extends a
{
  private static final String h = "HttpEchoTask";
  private String i;
  private URL j;
  private String k;
  private int l = 10000;
  private HttpURLConnection m;
  private int n;
  private String o;
  
  public b(int paramInt1, String paramString1, String paramString2, int paramInt2, a.a parama)
  {
    super(paramInt1, parama);
    this.i = (paramString1 + b(paramString1));
    this.i = MsfSdkUtils.insertMtype("netdetect", this.i);
    this.k = paramString2;
    this.l = paramInt2;
  }
  
  private String b(String paramString)
  {
    Object localObject = new Random(System.currentTimeMillis());
    localObject = "r=" + String.valueOf(((Random)localObject).nextInt(100000));
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?")) {
        return paramString + (String)localObject;
      }
      return (String)localObject + "&" + (String)localObject;
    }
    return "?" + (String)localObject;
  }
  
  protected int a(String paramString)
  {
    if ((this.n == 200) && (this.j.getHost().equals(this.o)) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.k)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " valid succ");
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " valid failed.");
    }
    return -3;
  }
  
  protected boolean a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " try connect " + this.i);
      }
      this.j = new URL(this.i);
      this.m = ((HttpURLConnection)this.j.openConnection());
      this.m.setDoOutput(true);
      this.m.setDoInput(true);
      this.m.setUseCaches(false);
      this.m.setRequestMethod("GET");
      this.m.setConnectTimeout(this.l);
      this.m.setReadTimeout(10000);
      this.m.connect();
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " connect " + this.i + " succ.");
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " connect " + this.i + " failed.", localThrowable);
      }
      if (this.m != null) {
        this.m.disconnect();
      }
    }
    return false;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " disconnect " + this.i);
    }
    if (this.m != null) {
      this.m.disconnect();
    }
  }
  
  protected String c()
  {
    try
    {
      this.n = this.m.getResponseCode();
      this.o = this.m.getURL().getHost();
      Object localObject1 = new BufferedReader(new InputStreamReader(this.m.getInputStream()));
      Object localObject2;
      for (String str = "";; str = str + (String)localObject2)
      {
        localObject2 = ((BufferedReader)localObject1).readLine();
        if (localObject2 == null) {
          break;
        }
      }
      ((BufferedReader)localObject1).close();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("WIFI detect, HttpEchoTask ").append(this.e).append(" echo content: ");
        if (str.length() <= 10) {
          break label149;
        }
      }
      label149:
      for (localObject1 = str.substring(0, 10);; localObject1 = str)
      {
        QLog.d("HttpEchoTask", 2, (String)localObject1);
        return str;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " echo failed", localThrowable);
      }
    }
  }
  
  protected Object d()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.b
 * JD-Core Version:    0.7.0.1
 */