package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadStatics;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
{
  private static a k = new a();
  private final ConcurrentHashMap<String, String> a;
  private final ArrayList<ScriptLoadStatics> b = new ArrayList();
  private String c;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private long f;
  private long g;
  private TTEngine h;
  private String i;
  private a j;
  
  static
  {
    a locala = k;
    locala.a = new String[] { "QGame.js" };
    locala.b = new String[] { "QGameOpenDataContext.js" };
  }
  
  public c(TTEngine paramTTEngine, String paramString)
  {
    this.h = paramTTEngine;
    this.i = paramString;
    this.a = new ConcurrentHashMap();
  }
  
  private a a(String paramString)
  {
    int n = 0;
    if (TextUtils.isEmpty(paramString))
    {
      TTLog.b("JsRuntimeLoader", "getRuntimeConfig error, runtimeLibDir: " + paramString);
      return null;
    }
    paramString = this.h.l().readFileToString(new File(paramString, "preload.json"));
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new a();
        JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("preloadJS");
        paramString.a = new String[localJSONArray.length()];
        int m = 0;
        while (m < localJSONArray.length())
        {
          paramString.a[m] = localJSONArray.getString(m);
          m += 1;
        }
        localObject = ((JSONObject)localObject).getJSONArray("preloadJSForOpendata");
        paramString.b = new String[((JSONArray)localObject).length()];
        m = n;
        while (m < ((JSONArray)localObject).length())
        {
          paramString.b[m] = ((JSONArray)localObject).getString(m);
          m += 1;
        }
      }
      finally
      {
        TTLog.b("JsRuntimeLoader", "getRuntimeConfig exception, load default config, exception:", paramString);
        return k;
      }
    }
    TTLog.c("JsRuntimeLoader", "getRuntimeConfig preloadConfig empty, load default config, mainInjectJs " + Arrays.toString(k.a) + ", openDataInjectJs " + Arrays.toString(k.b));
    return k;
  }
  
  private void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.c)) {
      if (this.h.l() == null) {
        break label56;
      }
    }
    label56:
    for (String str = this.h.l().getGlobalConfig();; str = "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = 'wxfile://usr';\n__wxConfig.platform = 'android';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n")
    {
      this.c = str;
      this.h.getJsRuntime(paramInt).evaluateJs(this.c);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!this.a.containsKey(paramString1)))
    {
      paramString2 = new File(paramString2, paramString1);
      if (!paramString2.exists()) {
        TTLog.b("JsRuntimeLoader", "prepare js error, get js " + paramString1 + " file is not exist");
      }
    }
    else
    {
      return;
    }
    TTLog.c("JsRuntimeLoader", "prepare js collect " + paramString1);
    this.a.put(paramString1, paramString2.getAbsolutePath());
  }
  
  public boolean a()
  {
    if (this.e)
    {
      TTLog.d("JsRuntimeLoader", "already has preload js, return directly");
      return true;
    }
    try
    {
      String str = this.i;
      TTLog.c("JsRuntimeLoader", "preload js, use runtimeLibPath " + str);
      Object localObject = a(str);
      if ((localObject == null) || (((a)localObject).a == null) || (((a)localObject).a.length == 0) || (((a)localObject).b == null) || (((a)localObject).b.length == 0)) {
        return false;
      }
      this.j = ((a)localObject);
      String[] arrayOfString = ((a)localObject).a;
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        a(arrayOfString[m], str);
        m += 1;
      }
      localObject = ((a)localObject).b;
      n = localObject.length;
      m = 0;
      while (m < n)
      {
        a(localObject[m], str);
        m += 1;
      }
      this.e = true;
      return true;
    }
    finally
    {
      TTLog.b("JsRuntimeLoader", "preload js error", localThrowable);
    }
    return false;
  }
  
  public ArrayList<ScriptLoadStatics> b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.g;
  }
  
  public long d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    if (this.d)
    {
      TTLog.d("JsRuntimeLoader", "already has init js runtime, return directly");
      return true;
    }
    long l = SystemClock.uptimeMillis();
    a();
    Object localObject = this.j;
    if (localObject != null)
    {
      arrayOfString = ((a)localObject).a;
      if ((arrayOfString != null) && (arrayOfString.length != 0))
      {
        localObject = ((a)localObject).b;
        if ((localObject != null) && (localObject.length != 0)) {
          break label83;
        }
      }
    }
    TTLog.b("JsRuntimeLoader", "init js runtime, get mRuntimeConfig error");
    return false;
    label83:
    a(1);
    localObject = "/game_preload" + File.separator;
    String[] arrayOfString = this.j.a;
    int n = arrayOfString.length;
    int m = 0;
    String str1;
    String str2;
    while (m < n)
    {
      str1 = arrayOfString[m];
      str2 = (String)this.a.get(str1);
      if (str2 != null)
      {
        this.b.add(this.h.a(1, str2, (String)localObject + str1, str2 + ".cc"));
        m += 1;
      }
      else
      {
        TTLog.b("JsRuntimeLoader", "inject mainContext js error, mJsStrs Cache do not have " + str1);
        return false;
      }
    }
    a(2);
    arrayOfString = this.j.b;
    n = arrayOfString.length;
    m = 0;
    while (m < n)
    {
      str1 = arrayOfString[m];
      str2 = (String)this.a.get(str1);
      if (str2 != null)
      {
        this.b.add(this.h.a(2, str2, (String)localObject + str1, str2 + ".cc"));
        m += 1;
      }
      else
      {
        TTLog.b("JsRuntimeLoader", "inject openDataContext js error, mJsStrs Cache do not have " + str1);
        return false;
      }
    }
    this.a.clear();
    this.d = true;
    this.g = SystemClock.uptimeMillis();
    this.f = (SystemClock.uptimeMillis() - l);
    return true;
  }
  
  static class a
  {
    public String[] a;
    public String[] b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.c
 * JD-Core Version:    0.7.0.1
 */