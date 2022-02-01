package com.qq.ac.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.b.a.j;
import com.qq.ac.sdk.bean.BaseResponse;
import com.qq.ac.sdk.listener.BaseInfoListener;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  protected SparseArray<BaseInfoListener> a = new SparseArray();
  int b = 0;
  
  public b(int paramInt) {}
  
  protected static JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("req_type", paramInt);
      localJSONObject.put("imei", j.i());
      localJSONObject.put("app_id", j.b());
      localJSONObject.put("pk_name", j.c().getPackageName());
      localJSONObject.put("pk_ver", com.b.a.b.a.a(j.c()));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  private static void a(com.qq.ac.sdk.e.b paramb, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("SjMF7P5KpY");
    paramString = com.b.a.b.a.b(localStringBuilder.toString());
    paramb.a("Ver", com.qq.ac.sdk.g.a.b);
    paramb.a("Api-Ver", com.qq.ac.sdk.g.a.c);
    paramb.a("Sc", paramString);
    paramb.a("Gender", j.h());
    paramb.a("Uid-Type", j.g());
    paramb.a("Uid", j.f());
    paramb.a("Accept-Encoding", "gzip");
    paramb.a("Content-Type", "application/x-www-form-urlencoded");
  }
  
  protected final BaseResponse a(String paramString, int paramInt, BaseInfoListener paramBaseInfoListener)
  {
    com.qq.ac.sdk.d.a.a();
    String str = com.qq.ac.sdk.g.a.e;
    paramString = com.b.a.b.a.a(j.b(), j.d(), paramString);
    Object localObject = new com.qq.ac.sdk.e.b();
    a((com.qq.ac.sdk.e.b)localObject, paramString);
    ((com.qq.ac.sdk.e.b)localObject).b("data", paramString).a(paramInt).a(str);
    localObject = new com.qq.ac.sdk.e.a.a().b((com.qq.ac.sdk.e.b)localObject);
    str = "";
    paramString = str;
    try
    {
      if (new JSONObject((String)localObject).getInt("ret") == 0) {
        paramString = com.b.a.b.a.a((String)localObject);
      }
      return paramBaseInfoListener.onSyncResponse(paramString);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
  }
  
  protected final void a(String paramString, int paramInt)
  {
    com.qq.ac.sdk.d.a.a();
    String str = com.qq.ac.sdk.g.a.e;
    paramString = com.b.a.b.a.a(j.b(), j.d(), paramString);
    a locala = new a();
    locala.a(Integer.valueOf(this.b));
    com.qq.ac.sdk.e.b localb = new com.qq.ac.sdk.e.b();
    a(localb, paramString);
    localb.b("data", paramString).a(paramInt).a(str).a(locala);
    new com.qq.ac.sdk.e.a.a().a(localb);
  }
  
  public final class a
    implements BaseInfoListener
  {
    private int a;
    
    public a() {}
    
    public final void a(Integer paramInteger)
    {
      this.a = paramInteger.intValue();
    }
    
    public final void onFailure(int paramInt)
    {
      BaseInfoListener localBaseInfoListener = (BaseInfoListener)b.this.a.get(this.a);
      if (localBaseInfoListener == null)
      {
        com.qq.ac.sdk.g.b.b("DataInfoImplProxy", "baseInfoListener BaseInfoListener is null mType = " + this.a);
        return;
      }
      localBaseInfoListener.onFailure(-60001);
      b.this.a.remove(this.a);
    }
    
    public final void onResponse(String paramString)
    {
      BaseInfoListener localBaseInfoListener = (BaseInfoListener)b.this.a.get(this.a);
      if (localBaseInfoListener == null)
      {
        com.qq.ac.sdk.g.b.b("DataInfoImplProxy", "baseInfoListener BaseInfoListener is null mType = " + this.a);
        return;
      }
      com.qq.ac.sdk.g.b.a("DataInfoImplProxy", "onResponse response = " + paramString);
      if (!TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        try
        {
          i = new JSONObject(paramString).getInt("ret");
          if (i != 0) {
            continue;
          }
          paramString = com.b.a.b.a.a(paramString);
          com.qq.ac.sdk.g.b.a("DataInfoImplProxy", "onResponse result = " + paramString);
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          localBaseInfoListener.onResponse(paramString);
        }
        catch (JSONException paramString)
        {
          int i;
          localBaseInfoListener.onFailure(-60005);
          continue;
          localBaseInfoListener.onFailure(i);
          continue;
        }
        b.this.a.remove(this.a);
        return;
        localBaseInfoListener.onFailure(-60003);
        continue;
        localBaseInfoListener.onFailure(-60004);
      }
    }
    
    public final BaseResponse onSyncResponse(String paramString)
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */