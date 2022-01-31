package com.tencent.apkupdate.logic.protocol;

import android.util.Log;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.apkupdate.c.b;
import com.tencent.apkupdate.logic.protocol.jce.JceCmd;
import com.tencent.apkupdate.logic.protocol.jce.Net;
import com.tencent.apkupdate.logic.protocol.jce.ReqHead;
import com.tencent.apkupdate.logic.protocol.jce.Request;
import com.tencent.apkupdate.logic.protocol.jce.Response;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;

public abstract class a
  implements Runnable
{
  private static String a = "BaseHttpRequest";
  private JceStruct b = null;
  private boolean c = false;
  
  protected void a() {}
  
  public final void a(JceStruct paramJceStruct)
  {
    this.b = paramJceStruct;
  }
  
  protected abstract void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2);
  
  protected abstract void b();
  
  public void run()
  {
    Object localObject3 = null;
    a();
    if (this.b == null) {
      return;
    }
    Object localObject5 = this.b;
    Object localObject1;
    if (localObject5 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label434;
      }
    }
    for (;;)
    {
      localObject1 = new HttpPost("http://masdk.3g.qq.com/");
      ((HttpPost)localObject1).addHeader("User-Agent", "AssistantDownloader");
      ((HttpPost)localObject1).setEntity(new ByteArrayEntity((byte[])localObject3));
      int i;
      try
      {
        localObject3 = com.tencent.apkupdate.b.a.a();
        Log.i(a, "url:http://masdk.3g.qq.com/");
        localObject1 = ((HttpClient)localObject3).execute((HttpUriRequest)localObject1);
        if (localObject1 == null) {
          break label632;
        }
        Log.i(a, "url:http://masdk.3g.qq.com/; httpCode=" + ((HttpResponse)localObject1).getStatusLine().getStatusCode());
        if (((HttpResponse)localObject1).getStatusLine().getStatusCode() != 200) {
          break label632;
        }
        localObject3 = ((HttpResponse)localObject1).getEntity();
        if (localObject3 == null) {
          break label632;
        }
        localObject1 = new ByteArrayBuffer((int)((HttpEntity)localObject3).getContentLength());
        localObject3 = ((HttpEntity)localObject3).getContent();
        localObject4 = new byte[2048];
        for (;;)
        {
          i = ((InputStream)localObject3).read((byte[])localObject4);
          if (i == -1) {
            break;
          }
          ((ByteArrayBuffer)localObject1).append((byte[])localObject4, 0, i);
        }
        localObject4 = new Request();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        b();
        return;
      }
      if (localObject5 == null)
      {
        localObject2 = null;
        ((Request)localObject4).head = ((ReqHead)localObject2);
        if (localObject5 != null) {
          break label405;
        }
      }
      for (localObject2 = null;; localObject2 = ((JceOutputStream)localObject2).toByteArray())
      {
        ((Request)localObject4).body = ((byte[])localObject2);
        localObject2 = localObject4;
        break;
        byte b1 = (byte)b.a().e();
        localObject2 = b.a().d();
        b.a();
        Net localNet = new Net(b1, (String)localObject2, 0, b.c());
        localObject2 = new ReqHead();
        ((ReqHead)localObject2).requestId = b.i();
        if (localObject5 == null) {}
        String str;
        for (i = -1;; i = JceCmd.convert(str.substring(0, str.length() - 7)).value())
        {
          ((ReqHead)localObject2).cmdId = i;
          b.a();
          ((ReqHead)localObject2).qua = b.f();
          ((ReqHead)localObject2).phoneGuid = b.a().h();
          ((ReqHead)localObject2).terminal = b.a().g();
          ((ReqHead)localObject2).assistantAPILevel = 0;
          ((ReqHead)localObject2).assistantVersionCode = 0;
          ((ReqHead)localObject2).net = localNet;
          break;
          str = localObject5.getClass().getSimpleName();
        }
        label405:
        localObject2 = new JceOutputStream();
        ((JceOutputStream)localObject2).setServerEncoding("utf-8");
        ((JceStruct)localObject5).writeTo((JceOutputStream)localObject2);
      }
      label434:
      ((Request)localObject2).head.encryptWithPack = 0;
      if (((Request)localObject2).body.length > 256)
      {
        ((Request)localObject2).body = com.tencent.apkupdate.a.a.b(((Request)localObject2).body);
        ((Request)localObject2).head.encryptWithPack = ((byte)(((Request)localObject2).head.encryptWithPack | 0x1));
      }
      Object localObject4 = ((Request)localObject2).body;
      localObject5 = "ji*9^&43U0X-~./(".getBytes();
      ((Request)localObject2).body = new com.tencent.apkupdate.c.a().b((byte[])localObject4, 0, localObject4.length, (byte[])localObject5);
      ((Request)localObject2).head.encryptWithPack = ((byte)(((Request)localObject2).head.encryptWithPack | 0x2));
      if (localObject2 != null)
      {
        localObject3 = new JceOutputStream();
        ((JceOutputStream)localObject3).setServerEncoding("utf-8");
        ((JceStruct)localObject2).writeTo((JceOutputStream)localObject3);
        localObject3 = ((JceOutputStream)localObject3).toByteArray();
      }
    }
    Object localObject2 = ((ByteArrayBuffer)localObject2).buffer();
    if ((localObject2 != null) && (localObject2.length > 4))
    {
      localObject2 = com.tencent.apkupdate.a.a.a((byte[])localObject2);
      if ((localObject2 != null) && (((Response)localObject2).body != null))
      {
        localObject2 = com.tencent.apkupdate.a.a.a(this.b, ((Response)localObject2).body);
        if (localObject2 != null) {
          a(this.b, (JceStruct)localObject2);
        }
      }
    }
    else
    {
      b();
    }
    label632:
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a
 * JD-Core Version:    0.7.0.1
 */