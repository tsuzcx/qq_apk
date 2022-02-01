package com.huawei.updatesdk.a.b.d;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.a.a.a.b.a;
import com.huawei.updatesdk.a.a.c.g;
import com.huawei.updatesdk.a.b.d.a.d;
import com.huawei.updatesdk.a.b.d.a.d.a;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  extends AsyncTask<com.huawei.updatesdk.a.b.d.a.c, Void, d>
{
  protected com.huawei.updatesdk.a.b.d.a.c a = null;
  private d b = null;
  private com.huawei.updatesdk.a.b.d.a.a c = null;
  private com.huawei.updatesdk.a.a.a.b d = null;
  private int e = 0;
  private int f = 0;
  
  public b(com.huawei.updatesdk.a.b.d.a.c paramc, com.huawei.updatesdk.a.b.d.a.a parama)
  {
    this.a = paramc;
    this.c = parama;
  }
  
  private d a(String paramString1, String paramString2, d paramd)
  {
    try
    {
      paramd.fromJson(new JSONObject(paramString2));
      paramd.a(0);
      return paramd;
    }
    catch (JSONException paramString1)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "parse json error", paramString1);
      return paramd;
    }
    catch (ClassNotFoundException paramString1)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "parse json error", paramString1);
      return paramd;
    }
    catch (InstantiationException paramString1)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "parse json error", paramString1);
      return paramd;
    }
    catch (IllegalAccessException paramString1)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "parse json error", paramString1);
    }
    return paramd;
  }
  
  private void a(d paramd, int paramInt, d.a parama, Throwable paramThrowable)
  {
    if (paramd != null)
    {
      paramd.a(paramInt);
      paramd.a(parama);
      paramd.a(paramThrowable.toString());
    }
  }
  
  private void a(d paramd, Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof ConnectException)) {
      a(paramd, 1, d.a.f, paramThrowable);
    }
    for (;;)
    {
      a(paramString, paramThrowable);
      return;
      if ((paramThrowable instanceof SocketTimeoutException)) {
        a(paramd, 2, d.a.f, paramThrowable);
      } else if ((paramThrowable instanceof ConnectTimeoutException)) {
        a(paramd, 2, d.a.f, paramThrowable);
      } else if ((paramThrowable instanceof IOException)) {
        a(paramd, 1, d.a.e, paramThrowable);
      } else if ((paramThrowable instanceof IllegalArgumentException)) {
        a(paramd, 5, d.a.d, paramThrowable);
      } else if ((paramThrowable instanceof IllegalAccessException)) {
        a(paramd, 1, d.a.g, paramThrowable);
      } else if ((paramThrowable instanceof ArrayIndexOutOfBoundsException)) {
        a(paramd, 6, d.a.h, paramThrowable);
      } else if (paramd != null) {
        paramd.a(paramThrowable.toString());
      }
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invoke store error");
    localStringBuilder.append(", exceptionType:").append(paramThrowable.toString());
    localStringBuilder.append(", url:").append(paramString);
    localStringBuilder.append(", method:").append(this.a.a());
    localStringBuilder.append(", retryTimes:" + this.e);
    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", localStringBuilder.toString(), paramThrowable);
    Log.e("StoreTask", "UpdateSDK call store error: " + paramThrowable.toString());
  }
  
  private boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (!g.b(paramString));
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("StoreTask", "UpdateSDK response error, resData == null");
      return;
    }
    Log.e("StoreTask", "UpdateSDK response error, resData is not json string");
  }
  
  private boolean c(d paramd)
  {
    if (isCancelled()) {}
    while ((paramd.a() != 1) && (paramd.a() != 2)) {
      return false;
    }
    int i = this.e;
    this.e = (i + 1);
    if (i >= 3)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "retry completed total times = " + this.e + ",response.responseCode = " + paramd.a());
      return false;
    }
    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "retry times = " + this.e + ",response.responseCode = " + paramd.a());
    return true;
  }
  
  private void d(d paramd)
  {
    if ((!isCancelled()) && (this.c != null))
    {
      if (paramd == null) {
        com.huawei.updatesdk.a.a.b.a.a.a.d("StoreTask", "notifyResult, response is null");
      }
    }
    else
    {
      try
      {
        d locald = a.a(this.a.a());
        paramd = locald;
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "notifyResult, create response error, method:" + this.a.a(), localInstantiationException);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "notifyResult, create response error, method:" + this.a.a(), localIllegalAccessException);
          continue;
          paramd.a(d.a.g);
        }
      }
      if (paramd == null)
      {
        paramd = new d();
        paramd.a(d.a.d);
        paramd.a(1);
      }
    }
    for (;;)
    {
      this.c.b(this.a, paramd);
      return;
    }
  }
  
  private void e()
  {
    d(this.b);
  }
  
  public final d a()
  {
    Object localObject = null;
    d locald;
    do
    {
      if ((this.e > 0) && (localObject != null)) {
        com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "call store error! responseCode:" + localObject.a() + ", retryTimes:" + this.e);
      }
      locald = b();
      a(locald);
      localObject = locald;
    } while (c(locald));
    this.b = locald;
    return this.b;
  }
  
  protected d a(com.huawei.updatesdk.a.b.d.a.c... paramVarArgs)
  {
    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "doInBackground, method:" + this.a.a());
    com.huawei.updatesdk.service.d.a.c.a(this);
    paramVarArgs = a();
    if (this.c != null) {
      this.c.a(this.a, paramVarArgs);
    }
    return paramVarArgs;
  }
  
  public void a(d paramd) {}
  
  public final void a(Executor paramExecutor)
  {
    executeOnExecutor(paramExecutor, new com.huawei.updatesdk.a.b.d.a.c[] { this.a });
  }
  
  protected d b()
  {
    localObject1 = null;
    localObject3 = null;
    for (;;)
    {
      try
      {
        localObject2 = a.a(this.a.a());
        localObject1 = localObject2;
        localObject2 = localObject3;
        try
        {
          if (!com.huawei.updatesdk.a.a.c.b.b.a(com.huawei.updatesdk.a.b.a.a.a().b()))
          {
            localObject2 = localObject3;
            localObject1.a(3);
            localObject2 = localObject3;
            localObject1.a(d.a.b);
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = new d();
              ((d)localObject2).a(5);
              ((d)localObject2).a(d.a.d);
            }
            return localObject2;
          }
          localObject2 = localObject3;
          str1 = this.a.b();
          localObject2 = localObject3;
          localObject3 = this.a.d();
          localObject2 = localObject3;
          com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "callStore, method:" + this.a.a() + ", url:" + (String)localObject3 + ", body:" + str1);
          localObject2 = localObject3;
          this.d = new com.huawei.updatesdk.a.a.a.b();
          localObject2 = localObject3;
          b.a locala = this.d.a((String)localObject3, str1, "UTF-8", c(), com.huawei.updatesdk.a.b.a.a.a().b());
          localObject2 = localObject3;
          str2 = locala.a();
          localObject2 = localObject3;
          localObject1.b(locala.b());
          localObject2 = localObject3;
          Log.i("StoreTask", "UpdateSDK call store responsecode: " + localObject1.b());
          localObject2 = localObject3;
          if (locala.b() / 100 != 5) {
            continue;
          }
          localObject2 = localObject3;
          localObject1.a(0);
          return localObject1;
        }
        catch (Throwable localThrowable3)
        {
          localObject3 = localObject2;
          localObject2 = localThrowable3;
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject2;
        String str1;
        String str2;
        d locald = null;
        localObject3 = localObject1;
        localObject1 = locald;
        continue;
      }
      a(localObject1, (Throwable)localObject2, (String)localObject3);
      continue;
      localObject2 = localObject3;
      if (a(str2))
      {
        localObject2 = localObject3;
        localObject1.a(1);
        localObject2 = localObject3;
        localObject1.a(d.a.c);
        localObject2 = localObject3;
        b(str2);
      }
      else
      {
        localObject2 = localObject3;
        locald = a(str1, str2, localObject1);
        localObject1 = locald;
        try
        {
          com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "callStore response, method:" + this.a.a() + ", url:" + (String)localObject3 + ", body:" + str1 + ", Receive Json msg:" + localObject1.toJson());
        }
        catch (Throwable localThrowable1) {}
      }
    }
  }
  
  protected void b(d paramd)
  {
    com.huawei.updatesdk.a.a.b.a.a.a.a("StoreTask", "onPostExecute, method:" + this.a.a());
    com.huawei.updatesdk.service.d.a.c.a().remove(this);
    e();
  }
  
  protected String c()
  {
    String str2 = com.huawei.updatesdk.service.d.a.a.a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "Android/1.0";
    }
    return str1;
  }
  
  public void d()
  {
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.b
 * JD-Core Version:    0.7.0.1
 */