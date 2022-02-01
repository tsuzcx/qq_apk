package com.tencent.mobileqq.triton.bridge.d;

import android.content.Context;
import com.tencent.mobileqq.triton.audio.e;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.audio.IAudioStateChangeListener;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.utils.ApiUtil;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends c
{
  public AtomicInteger c = new AtomicInteger();
  private e d;
  private boolean e;
  
  public a(TTEngine paramTTEngine)
  {
    super(paramTTEngine);
    getEventMap().addAll(Arrays.asList(new String[] { "createAudioInstance", "setAudioState", "getAudioState", "operateAudio", "destroyAudioInstance", "setInnerAudioOptionQGame", "getAvailableAudioSources" }));
    this.e = false;
    this.d = new e(paramTTEngine);
  }
  
  private String a(ITTJSRuntime paramITTJSRuntime)
  {
    int i = this.c.incrementAndGet();
    com.tencent.mobileqq.triton.audio.a.a().a(new a.d(this, i, paramITTJSRuntime));
    paramITTJSRuntime = new JSONObject();
    try
    {
      return ApiUtil.wrapCallbackOk("createAudioInstance", paramITTJSRuntime).toString();
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "createAudioInstance exception:", paramITTJSRuntime);
    }
    return ApiUtil.wrapCallbackFail("createAudioInstance", null).toString();
  }
  
  private String a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("audioId", -1);
      com.tencent.mobileqq.triton.audio.a.a().a(new a.e(this, i));
      paramString = ApiUtil.wrapCallbackOk("destroyAudioInstance", null).toString();
      return paramString;
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "destroyAudioInstance exception:", paramString);
    }
    return ApiUtil.wrapCallbackFail("destroyAudioInstance", null).toString();
  }
  
  private void a(int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("audioSources", Arrays.toString(new String[] { "auto" }));
      b(paramITTJSRuntime, "getAvailableAudioSources", localJSONObject, paramInt);
      return;
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "API_GET_AVAILABLE_AUDIO_SOURCES exception:", localThrowable);
      a(paramITTJSRuntime, "getAvailableAudioSources", null, paramInt);
    }
  }
  
  private void a(String paramString, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    try
    {
      paramString = new JSONObject(paramString);
      boolean bool1 = paramString.optBoolean("mixWithOther", true);
      boolean bool2 = paramString.optBoolean("obeyMuteSwitch", true);
      this.d.a(bool1);
      this.d.b(bool2);
      b(paramITTJSRuntime, "setInnerAudioOptionQGame", null, paramInt);
      return;
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "API_SET_INNER_AUDIO_OPTION exception:", paramString);
      a(paramITTJSRuntime, "setInnerAudioOptionQGame", null, paramInt);
    }
  }
  
  private String b(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("audioId", -1);
      if (i == -1) {
        return ApiUtil.wrapCallbackFail("getAudioState", null, "param error").toString();
      }
      paramString = new JSONObject();
      paramString.put("duration", this.d.e(i));
      paramString.put("currentTime", this.d.d(i));
      paramString.put("buffered", this.d.c(i));
      paramString.put("paused", this.d.g(i));
      paramString.put("startTime", this.d.h(i));
      paramString.put("autoplay", this.d.b(i));
      paramString.put("loop", this.d.f(i));
      paramString = ApiUtil.wrapCallbackOk("getAudioState", paramString).toString();
      return paramString;
    }
    finally
    {
      TTLog.b("[audio] AudioPlugin", "API_GET_AUDIO_STATE exception:", paramString);
    }
    return ApiUtil.wrapCallbackFail("getAudioState", null).toString();
  }
  
  private String c(String paramString)
  {
    com.tencent.mobileqq.triton.audio.a.a().a(new a.f(this, paramString));
    return ApiUtil.wrapCallbackOk("operateAudio", null).toString();
  }
  
  private String d(String paramString)
  {
    com.tencent.mobileqq.triton.audio.a.a().a(new a.g(this, paramString));
    return ApiUtil.wrapCallbackOk("setAudioState", null).toString();
  }
  
  public void b()
  {
    super.b();
    com.tencent.mobileqq.triton.audio.a.a().a(new a.a(this));
    this.e = true;
  }
  
  public void c()
  {
    super.c();
    com.tencent.mobileqq.triton.audio.a.a().a(new a.b(this));
    this.e = false;
  }
  
  public e d()
  {
    return this.d;
  }
  
  public String handleScriptRequest(String paramString1, String paramString2, int paramInt, ITTJSRuntime paramITTJSRuntime)
  {
    String str = "{}";
    if ("createAudioInstance".equals(paramString1)) {
      paramString2 = a(paramITTJSRuntime);
    }
    do
    {
      return paramString2;
      if ("destroyAudioInstance".equals(paramString1)) {
        return a(paramString2);
      }
      if ("operateAudio".equals(paramString1)) {
        return c(paramString2);
      }
      if ("setAudioState".equals(paramString1)) {
        return d(paramString2);
      }
      if ("getAudioState".equals(paramString1)) {
        return b(paramString2);
      }
      if ("setInnerAudioOptionQGame".equals(paramString1))
      {
        a(paramString2, paramInt, paramITTJSRuntime);
        return "{}";
      }
      paramString2 = str;
    } while (!"getAvailableAudioSources".equals(paramString1));
    a(paramInt, paramITTJSRuntime);
    return "{}";
  }
  
  public void onCreate(Context paramContext, ITTEngine paramITTEngine)
  {
    super.onCreate(paramContext, paramITTEngine);
    this.d.a(paramContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mobileqq.triton.audio.a.a().a(new a.c(this));
  }
  
  public class h
    implements IAudioStateChangeListener
  {
    private ITTJSRuntime a;
    private int b;
    
    public h(int paramInt, ITTJSRuntime paramITTJSRuntime)
    {
      this.b = paramInt;
      this.a = paramITTJSRuntime;
    }
    
    private void a(int paramInt)
    {
      int i = paramInt;
      switch (paramInt)
      {
      default: 
        i = -1;
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("audioId", this.b);
        localJSONObject.put("state", "error");
        localJSONObject.put("errCode", i);
        Object localObject2;
        if ((i == 10001) || (i == -1))
        {
          localObject2 = new StringBuilder();
          if (i != 10001) {
            break label233;
          }
        }
        label233:
        for (Object localObject1 = "系统错误";; localObject1 = "未知错误")
        {
          localJSONObject.put("errMsg", (String)localObject1 + ", 请复用InnerAudioContext实例、及时释放无用实例");
          localObject1 = a.this;
          localObject2 = this.a;
          ((c)localObject1).a((ITTJSRuntime)localObject2, "onAudioStateChange", localJSONObject.toString());
          return;
          i = 10002;
          break;
          i = 10001;
          break;
          i = 10003;
          break;
        }
        return;
      }
      finally
      {
        TTLog.b("[audio] AudioPlugin", "evaluateAudioError exception:", localThrowable);
      }
    }
    
    private void a(String paramString)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("audioId", this.b);
        localJSONObject.put("state", paramString);
        a.this.a(this.a, "onAudioStateChange", localJSONObject.toString());
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    
    public void onCanPlay()
    {
      a("canplay");
    }
    
    public void onEnded()
    {
      a("ended");
    }
    
    public void onError(int paramInt)
    {
      a(paramInt);
    }
    
    public void onPause()
    {
      a("pause");
    }
    
    public void onPlay()
    {
      a("play");
    }
    
    public void onSeeked()
    {
      a("seeked");
    }
    
    public void onSeeking()
    {
      a("seeking");
    }
    
    public void onStop()
    {
      a("stop");
    }
    
    public void onTimeUpdate()
    {
      a("timeUpdate");
    }
    
    public void onWaiting()
    {
      a("waiting");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.bridge.d.a
 * JD-Core Version:    0.7.0.1
 */