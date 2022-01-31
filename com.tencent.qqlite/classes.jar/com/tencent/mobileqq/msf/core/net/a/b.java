package com.tencent.mobileqq.msf.core.net.a;

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
  private static final String g = "HttpEchoTask";
  private String h;
  private URL i;
  private String j;
  private int k = 10000;
  private HttpURLConnection l;
  private int m;
  private String n;
  
  public b(int paramInt1, String paramString1, String paramString2, int paramInt2, a.a parama)
  {
    super(paramInt1, parama);
    this.h = (paramString1 + b(paramString1));
    this.h = MsfSdkUtils.insertMtype("netdetect", this.h);
    this.j = paramString2;
    this.k = paramInt2;
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
    if ((this.m == 200) && (this.i.getHost().equals(this.n)) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.j)))
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
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " try connect " + this.h);
      }
      this.i = new URL(this.h);
      this.l = ((HttpURLConnection)this.i.openConnection());
      this.l.setDoOutput(true);
      this.l.setDoInput(true);
      this.l.setUseCaches(false);
      this.l.setRequestMethod("GET");
      this.l.setConnectTimeout(this.k);
      this.l.setReadTimeout(10000);
      this.l.connect();
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " connect " + this.h + " succ.");
      }
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " connect " + this.h + " failed.");
      }
      if (this.l != null) {
        this.l.disconnect();
      }
    }
    return false;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " disconnect " + this.h);
    }
    if (this.l != null) {
      this.l.disconnect();
    }
  }
  
  protected String c()
  {
    try
    {
      this.m = this.l.getResponseCode();
      this.n = this.l.getURL().getHost();
      Object localObject1 = new BufferedReader(new InputStreamReader(this.l.getInputStream()));
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
      localThrowable.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("HttpEchoTask", 2, "WIFI detect, HttpEchoTask " + this.e + " echo failed");
      }
    }
  }
  
  protected Object d()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.b
 * JD-Core Version:    0.7.0.1
 */