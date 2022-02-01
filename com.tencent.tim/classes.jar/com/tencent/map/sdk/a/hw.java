package com.tencent.map.sdk.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.AuthorizeRequest;
import com.tencent.map.tools.net.NetResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hw
  extends AsyncTask<Object, Void, Void>
{
  private Handler a;
  private String b;
  private String c;
  private WeakReference<hv> d;
  
  public hw(Handler paramHandler, hv paramhv, String paramString1, String paramString2)
  {
    this.a = paramHandler;
    this.d = new WeakReference(paramhv);
    paramHandler = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramHandler = "";
    }
    this.b = paramHandler;
    paramHandler = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramHandler = "";
    }
    this.c = paramHandler;
  }
  
  private Void a()
  {
    Object localObject2 = ((AuthorizeRequest)((my)MapServiceManager.getService(my.class)).c()).checkAuth(pz.a, this.b, fz.g(), this.c, fz.c(), fz.a(), fz.d(), fz.e(), "4.2.8.1", fz.f(), "androidsdk", fz.b());
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((NetResponse)localObject2).charset;
      localObject2 = ((NetResponse)localObject2).data;
      if (localObject2 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(new String((byte[])localObject2, (String)localObject1));
        localObject1 = ((JSONObject)localObject2).optJSONObject("detail");
        if (localObject1 == null) {
          continue;
        }
        a(((JSONObject)localObject1).optJSONObject("cfg"));
        i = 0;
        localObject1 = null;
        localObject2 = ((JSONObject)localObject2).optJSONObject("info");
        if (localObject2 != null)
        {
          i = ((JSONObject)localObject2).optInt("error");
          localObject1 = ((JSONObject)localObject2).optString("msg");
        }
        if (i != 0) {
          continue;
        }
        fz.g = 0;
        fz.h = Calendar.getInstance().get(1);
        fz.i = Calendar.getInstance().get(2);
        fz.j = Calendar.getInstance().get(5);
        if (this.a != null)
        {
          localObject1 = new hj();
          ((hj)localObject1).a = 3;
          localObject1 = this.a.obtainMessage(((hj)localObject1).a, localObject1);
          this.a.sendMessage((Message)localObject1);
        }
      }
      catch (Exception localException)
      {
        int i;
        continue;
      }
      return null;
      a(null);
      continue;
      a(i, (String)localObject1);
      if (i < -400) {
        fz.g = -1;
      } else {
        fz.g = 1;
      }
    }
  }
  
  private static void a(int paramInt, String paramString)
  {
    Object localObject = new ArrayList(4);
    ((List)localObject).add("腾讯地图鉴权失败，请访问 lbs.qq.com 检查 key 配置");
    ((List)localObject).add("错误码：".concat(String.valueOf(paramInt)));
    ((List)localObject).add("错误信息：".concat(String.valueOf(paramString)));
    paramString = new StringBuilder(1024);
    paramString.append("Auth Fail:\n");
    char[] arrayOfChar = new char[81];
    Arrays.fill(arrayOfChar, '*');
    arrayOfChar[80] = '\n';
    paramString.append(arrayOfChar);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append((String)((Iterator)localObject).next()).append("\n");
    }
    paramString.append(arrayOfChar);
    Log.e("tencentmap", paramString.toString());
  }
  
  private void a(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {
      if ((this.d != null) && (this.d.get() != null)) {
        ((hv)this.d.get()).a(null, null);
      }
    }
    for (;;)
    {
      return;
      JSONArray localJSONArray = paramJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
      JSONObject localJSONObject = paramJSONObject.optJSONObject("indoor_map");
      if (localJSONObject == null) {
        paramJSONObject = localObject;
      }
      while ((this.d != null) && (this.d.get() != null))
      {
        ((hv)this.d.get()).a(localJSONArray, paramJSONObject);
        return;
        int i = localJSONObject.optInt("enable", -1);
        int j = localJSONObject.optInt("type", -1);
        paramJSONObject = localObject;
        if (i != -1)
        {
          paramJSONObject = localObject;
          if (j != -1) {
            paramJSONObject = new hh(i, j, localJSONObject.optJSONArray("building_list"));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.hw
 * JD-Core Version:    0.7.0.1
 */