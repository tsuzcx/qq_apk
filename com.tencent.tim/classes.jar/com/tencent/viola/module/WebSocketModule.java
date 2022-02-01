package com.tencent.viola.module;

import android.text.TextUtils;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter.EventListener;
import com.tencent.viola.adapter.WebSocketCloseCodes;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSocketModule
  extends BaseModule
  implements Destroyable
{
  private static final String KEY_CODE = "code";
  private static final String KEY_DATA = "data";
  private static final String KEY_REASON = "reason";
  private static final String KEY_WAS_CLEAN = "wasClean";
  public static final String MODULE_NAME = "webSocket";
  private static final String TAG = "WebSocketModule";
  private WebSocketEventListener eventListener;
  private VWebSocketAdapter webSocketAdapter;
  
  private VWebSocketAdapter newInstance()
  {
    if (ViolaEnvironment.isDebugable()) {
      try
      {
        VWebSocketAdapter localVWebSocketAdapter = ViolaSDKManager.getInstance().getWebSocketAdapter();
        if (localVWebSocketAdapter == null) {
          return null;
        }
        localVWebSocketAdapter = (VWebSocketAdapter)localVWebSocketAdapter.getClass().newInstance();
        return localVWebSocketAdapter;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.d("WebSocketModule", "webSocket adapter newInstance error " + localException.getMessage());
      }
    }
    return null;
  }
  
  private boolean reportErrorIfNoAdapter()
  {
    if (this.webSocketAdapter == null)
    {
      if (this.eventListener != null) {
        this.eventListener.onError("No implementation found for IWebSocketAdapter");
      }
      return true;
    }
    return false;
  }
  
  @JSMethod(uiThread=false)
  public void WebSocket(String paramString1, String paramString2)
  {
    if (this.webSocketAdapter != null) {}
    this.webSocketAdapter = newInstance();
    if (!reportErrorIfNoAdapter())
    {
      this.eventListener = new WebSocketEventListener(null);
      this.webSocketAdapter.connect(paramString1, paramString2, this.eventListener);
    }
  }
  
  @JSMethod(uiThread=false)
  public void close(String paramString1, String paramString2)
  {
    int j;
    int i;
    if (!reportErrorIfNoAdapter())
    {
      j = WebSocketCloseCodes.CLOSE_NORMAL.getCode();
      i = j;
      if (paramString1 == null) {}
    }
    try
    {
      i = Integer.parseInt(paramString1);
      this.webSocketAdapter.close(i, paramString2);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public void destroy() {}
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if (ViolaEnvironment.isDebugable())
    {
      if (this.webSocketAdapter != null) {
        this.webSocketAdapter.destroy();
      }
      this.webSocketAdapter = null;
      this.eventListener = null;
    }
  }
  
  @JSMethod(uiThread=false)
  public void onclose(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketEventListener.access$302(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void onerror(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketEventListener.access$402(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void onmessage(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketEventListener.access$202(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void onopen(String paramString)
  {
    if (this.eventListener != null) {
      WebSocketEventListener.access$102(this.eventListener, paramString);
    }
  }
  
  @JSMethod(uiThread=false)
  public void send(String paramString)
  {
    if (!reportErrorIfNoAdapter()) {
      this.webSocketAdapter.send(paramString);
    }
  }
  
  class WebSocketEventListener
    implements VWebSocketAdapter.EventListener
  {
    private String onClose;
    private String onError;
    private String onMessage;
    private String onOpen;
    
    private WebSocketEventListener() {}
    
    public void onClose(int paramInt, String paramString, boolean paramBoolean)
    {
      JSONObject localJSONObject;
      if ((!TextUtils.isEmpty(this.onClose)) && (WebSocketModule.this.getViolaInstance() != null)) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("code", paramInt);
        localJSONObject.put("reason", paramString);
        localJSONObject.put("wasClean", paramBoolean);
        ViolaBridgeManager.getInstance().callbackJavascript(WebSocketModule.this.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onClose, localJSONObject, true);
        return;
      }
      catch (JSONException paramString) {}
    }
    
    public void onError(String paramString)
    {
      JSONObject localJSONObject;
      if ((!TextUtils.isEmpty(this.onError)) && (WebSocketModule.this.getViolaInstance() != null)) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("data", paramString);
        ViolaBridgeManager.getInstance().callbackJavascript(WebSocketModule.this.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onError, localJSONObject, true);
        return;
      }
      catch (JSONException paramString) {}
    }
    
    public void onMessage(String paramString)
    {
      JSONObject localJSONObject;
      if ((!TextUtils.isEmpty(this.onMessage)) && (WebSocketModule.this.getViolaInstance() != null)) {
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("data", paramString);
        ViolaBridgeManager.getInstance().callbackJavascript(WebSocketModule.this.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onMessage, localJSONObject, true);
        return;
      }
      catch (JSONException paramString) {}
    }
    
    public void onOpen()
    {
      if ((!TextUtils.isEmpty(this.onOpen)) && (WebSocketModule.this.getViolaInstance() != null)) {
        ViolaBridgeManager.getInstance().callbackJavascript(WebSocketModule.this.getViolaInstance().getInstanceId(), "webSocket", "callback", this.onOpen, new JSONObject(), true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.WebSocketModule
 * JD-Core Version:    0.7.0.1
 */