package com.tencent.qqmini.minigame.debug;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent;
import com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent.DebuggerMessageListener;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQDebugWebSocket
  extends DebugWebSocket
  implements InspectorAgent
{
  private static final String DISCONNECT_TIPS = "真机调试断开连接";
  private static final String DISCONNECT_TIPS_NOT_RECOVERY = "真机调试断开连接，请退出重试";
  private static final String RECONNECT_TIPS = "真机调试断线重连...";
  private AtomicInteger count = new AtomicInteger();
  private MiniGameInfo gameInfo;
  Runnable heartbeatRunnable = new QQDebugWebSocket.4(this);
  private boolean isQQDebugReady = false;
  private DebugWebSocket.DebuggerStateListener mDebugListener;
  private InspectorAgent.DebuggerMessageListener mDebuggerMessageListener;
  private IMiniAppContext miniAppContext;
  private DebugWebSocket.DebugSocketListener qqSocketListener = new QQDebugWebSocket.1(this);
  private String sessionId;
  
  public QQDebugWebSocket(IMiniAppContext paramIMiniAppContext, MiniGameInfo paramMiniGameInfo)
  {
    this.miniAppContext = paramIMiniAppContext;
    this.gameInfo = paramMiniGameInfo;
    this.TAG = "[debugger].QQDebugWebSocket";
  }
  
  private String covertProfileToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":" + paramString + "}]}";
  }
  
  private String covertV8ToIdeData(String paramString)
  {
    return "{\"debug_message\":[{\"seq\":1,\"category\":\"chromeDevtools\",\"data\":" + paramString + "}]}";
  }
  
  private void dealWithQQMessage(String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString1, "SocketMessage")) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      this.sessionId = localJSONObject.getString("sessionId");
      if (TextUtils.equals(localJSONObject.getString("code"), "0002")) {
        setCanSendMsg(true);
      }
      if (TextUtils.equals(paramString1, "DebugArkMaster")) {
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      int i;
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  for (;;)
                  {
                    QMLog.e(this.TAG, "qq onSocketMessage", localJSONException);
                    continue;
                    if (TextUtils.equals(paramString1, "DebugPing"))
                    {
                      try
                      {
                        paramString1 = new JSONObject(paramString2).getString("ping_id");
                        i = NetworkUtil.getActiveNetworkType(this.miniAppContext.getContext());
                        if (this.isQQDebugReady) {
                          continue;
                        }
                        sendQQDebugMethodMsg("DebugPong", "{\"ping_id\":" + paramString1 + ",\"network_type\":" + i + "}");
                        this.isQQDebugReady = true;
                        notifyIdeSetUp();
                        checkDebuggerReady();
                        return;
                      }
                      catch (JSONException paramString1)
                      {
                        QMLog.e(this.TAG, "qq onSocketMessage", paramString1);
                        return;
                      }
                    }
                    else
                    {
                      if (!TextUtils.equals(paramString1, "DebugMessageMaster")) {
                        break label590;
                      }
                      try
                      {
                        QMLog.i(this.TAG, "qq onSocketMessage cmd:" + paramString1 + ",data:" + paramString2);
                        paramString1 = new JSONObject(paramString2).getJSONArray("debug_message");
                        if ((paramString1 != null) && (paramString1.getJSONObject(0) != null))
                        {
                          paramString2 = paramString1.getJSONObject(0);
                          if (paramString2 != null)
                          {
                            paramString1 = paramString2.getString("category");
                            if (TextUtils.equals(paramString1, "chromeDevtools"))
                            {
                              paramString1 = paramString2.getString("data");
                              if (TextUtils.isEmpty(paramString1)) {
                                continue;
                              }
                              paramString1 = new JSONObject(paramString1);
                              paramString2 = paramString1.getString("method");
                              if ((TextUtils.equals(paramString2, "Runtime.evaluate")) || (TextUtils.equals(paramString2, "Debugger.evaluateOnCallFrame")))
                              {
                                paramString2 = paramString1.getJSONObject("params");
                                if (paramString2 != null)
                                {
                                  paramString2.remove("timeout");
                                  paramString1.put("params", paramString2);
                                }
                              }
                              this.mDebuggerMessageListener.sendMessageToEngine(paramString1.toString());
                            }
                          }
                        }
                      }
                      catch (JSONException paramString1)
                      {
                        QMLog.e(this.TAG, "qq onSocketMessage", paramString1);
                        return;
                      }
                    }
                  }
                } while (!TextUtils.equals(paramString1, "performance"));
                if (this.miniAppContext.getAttachedActivity() == null)
                {
                  QMLog.e(this.TAG, "qq onSocketMessage performance fail, no gameRuntime");
                  return;
                }
                paramString1 = null;
                if ((this.miniAppContext instanceof GameRuntime)) {
                  paramString1 = ((GameRuntime)this.miniAppContext).getGameEngine();
                }
              } while (paramString1 == null);
              paramString1 = paramString1.getJsEngine();
            } while (paramString1 == null);
            paramString1 = paramString1.getJsRuntime(1);
          } while (paramString1 == null);
          paramString2 = paramString2.getString("data");
        } while (TextUtils.isEmpty(paramString2));
        paramString2 = new JSONObject(paramString2);
        str = paramString2.getString("method");
        i = paramString2.getInt("id");
        if (TextUtils.equals(str, "profile.start"))
        {
          paramString1.evaluateJs("global.q9zq.FrameProfileStart(" + i + ")");
          return;
        }
      } while (!TextUtils.equals(str, "profile.end"));
      paramString1.evaluateJs("global.q9zq.FrameProfileEnd(" + i + ")");
      return;
      label590:
      QMLog.i(this.TAG, "qq onSocketMessage cmd:" + paramString1 + ",data:" + paramString2);
    }
  }
  
  private long getAccount()
  {
    String str = LoginManager.getInstance().getAccount();
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  private String getAppVersion()
  {
    return ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAppVersion();
  }
  
  private JSONObject getDeviceInfo()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("device_name", Build.DEVICE);
      localJSONObject.put("device_model", Build.MODEL);
      localJSONObject.put("os", Build.VERSION.SDK_INT);
      localJSONObject.put("qq_version", getAppVersion());
      localJSONObject.put("pixel_ratio", "3");
      localJSONObject.put("screen_width", ViewUtils.getScreenWidth());
      localJSONObject.put("user_agent", "MiniGame");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "getSetupContexString error:" + localException);
    }
    return null;
  }
  
  private JSONObject getSetupContexData()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("configure_js", "");
      localJSONObject.put("device_info", getDeviceInfo());
      localJSONObject.put("support_compress_algo", 0);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Log.e(this.TAG, "getSetupContexString error:" + localException);
    }
    return null;
  }
  
  private void onQQDebuggerFail(int paramInt)
  {
    setCanSendMsg(false);
    if (paramInt == 1000)
    {
      if (this.mDebugListener != null) {
        this.mDebugListener.onDebuggerDisconnect("真机调试断开连接");
      }
      return;
    }
    if (this.mDebugListener != null) {
      this.mDebugListener.onDebuggerReconnecting("真机调试断线重连...");
    }
    reconnectQQDebugSocket();
  }
  
  private void reconnectQQDebugSocket()
  {
    postDelayed(new QQDebugWebSocket.2(this), 2000L);
  }
  
  private void sendQQDeviceMsgInfo()
  {
    String str = getSendCmdString("DebugMessageClient", "setupContext", getSetupContexData());
    QMLog.i(this.TAG, "sendQQDeviceMsgInfo deviceInfoCmd:" + str);
    sendStringMessage(str);
  }
  
  private void startConnectIDE(DebugWebSocket.DebuggerStateListener paramDebuggerStateListener, boolean paramBoolean)
  {
    post(new QQDebugWebSocket.3(this, paramDebuggerStateListener, paramBoolean));
  }
  
  public void checkDebuggerReady()
  {
    if (this.isQQDebugReady)
    {
      if (this.mDebugListener != null) {
        this.mDebugListener.onDebuggerConnectedNormal();
      }
      sendHeartBeat();
    }
  }
  
  public String getSendCmdString(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("seq", getSeq());
      localJSONObject.put("category", paramString2);
      localJSONObject.put("data", paramJSONObject);
      localJSONObject.put("compress_algo", 0);
      localJSONObject.put("original_size", 0);
      localJSONObject.put("delay", 0);
      paramString2 = new JSONArray();
      paramString2.put(localJSONObject);
      paramJSONObject = new JSONObject();
      paramJSONObject.put("debug_message", paramString2);
      paramString2 = new JSONObject();
      paramString2.put("cmd", paramString1);
      paramString2.put("data", paramJSONObject);
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.e(this.TAG, "send Cmd error:" + paramString1);
    }
    return "";
  }
  
  public int getSeq()
  {
    return this.count.incrementAndGet();
  }
  
  public void notifyIdeSetUp()
  {
    sendQQDebugMethodMsg("DebugMessageClient", "{\"debug_message\":[{}]}");
    sendQQDeviceMsgInfo();
  }
  
  public void sendHeartBeat()
  {
    sendQQDebugMethodMsg("HeartBeat", "{}");
    postDelayed(this.heartbeatRunnable, 10000L);
  }
  
  public void sendMessageToDebugger(@NonNull String paramString)
  {
    QMLog.i(this.TAG, "v8 onSocketMessage:" + paramString);
    DebugWebSocket.DebuggerStateListener localDebuggerStateListener = this.mDebugListener;
    if ((localDebuggerStateListener != null) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      String str = new JSONObject(paramString).optString("method");
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.equals(str, "Debugger.paused")) {
          break label93;
        }
        localDebuggerStateListener.onDebuggerBreakPointPaused();
      }
      for (;;)
      {
        sendQQDebugMethodMsg("DebugMessageClient", covertV8ToIdeData(paramString));
        return;
        label93:
        if (TextUtils.equals(str, "Debugger.resumed")) {
          localDebuggerStateListener.onDebuggerConnectedNormal();
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e(this.TAG, "v8 onSocketMessage error", localJSONException);
      }
    }
  }
  
  public void sendQQDebugMethodMsg(String paramString1, String paramString2)
  {
    sendStringMessage("{\"cmd\":\"" + paramString1 + "\",\"data\":" + paramString2 + "}");
  }
  
  public void sendQuitDebugMsgInfo()
  {
    sendQQDebugMethodMsg("QuitRoom", "{}");
  }
  
  public void setOnDebuggerMessageListener(@Nullable InspectorAgent.DebuggerMessageListener paramDebuggerMessageListener)
  {
    this.mDebuggerMessageListener = paramDebuggerMessageListener;
  }
  
  public void startConnectIDE(DebugWebSocket.DebuggerStateListener paramDebuggerStateListener)
  {
    startConnectIDE(paramDebuggerStateListener, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.debug.QQDebugWebSocket
 * JD-Core Version:    0.7.0.1
 */