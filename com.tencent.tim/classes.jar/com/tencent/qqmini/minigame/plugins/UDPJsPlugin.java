package com.tencent.qqmini.minigame.plugins;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread;
import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread.NioHandler;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class UDPJsPlugin
  extends BaseJsPlugin
{
  private static final Pattern IPV4_ADDRESS_REGEX = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}.\\d{1,3}");
  private static final Pattern IPV6_ADDRESS_REGEX;
  private static final String TAG = "UDPPlugin";
  private static final AtomicInteger UDP_TASK_ID_COUNTER = new AtomicInteger();
  private final SparseArray<UDPTask> mTaskRegistry = new SparseArray();
  private volatile Set<String> mUdpIpWhiteSet;
  
  static
  {
    IPV6_ADDRESS_REGEX = Pattern.compile("\\[?(([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]+|::(ffff(:0{1,4})?:)?((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9]))]?");
  }
  
  private void callbackError(String paramString, int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", paramInt);
      localJSONObject.put("event", "error");
      localJSONObject.put("errMsg", paramString);
      sendSubscribeEvent("onUDPTaskEventCallback", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private boolean getEnableDebug(String paramString)
  {
    return StorageUtil.getPreference().getBoolean(paramString + "_debug", false);
  }
  
  private void handleTaskOperation(JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString, int paramInt, UDPTask paramUDPTask)
    throws IOException, JSONException
  {
    if ("bind".equals(paramString)) {
      paramJSONObject1.put("port", paramUDPTask.bind());
    }
    do
    {
      return;
      if ("close".equals(paramString))
      {
        paramUDPTask.close();
        this.mTaskRegistry.remove(paramInt);
        return;
      }
    } while (!"send".equals(paramString));
    performSend(paramJSONObject1, paramJSONObject2, paramUDPTask);
  }
  
  private void performSend(JSONObject paramJSONObject1, JSONObject paramJSONObject2, UDPTask paramUDPTask)
    throws JSONException, IOException
  {
    Object localObject2 = null;
    String str = paramJSONObject2.optString("address");
    int n = paramJSONObject2.optInt("port", -1);
    if (!paramJSONObject2.isNull("message")) {}
    for (Object localObject1 = paramJSONObject2.optString("message", null);; localObject1 = null)
    {
      int j;
      int i;
      if (localObject1 != null)
      {
        paramJSONObject2 = ((String)localObject1).getBytes("UTF-8");
        j = 0;
        i = paramJSONObject2.length;
      }
      for (;;)
      {
        localObject1 = validAddress(str);
        if (localObject1 != null) {
          break;
        }
        paramJSONObject1.put("errMsg", "invalid address :[" + str + "]");
        QMLog.d("UDPPlugin", "invalid address :[" + str + "]");
        return;
        localObject1 = NativeBuffer.unpackNativeBuffer(this.mMiniAppContext, paramJSONObject2, "message");
        int k = paramJSONObject2.optInt("offset");
        int m = paramJSONObject2.optInt("length", -1);
        i = m;
        j = k;
        paramJSONObject2 = localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((NativeBuffer)localObject1).buf;
          i = m;
          j = k;
          paramJSONObject2 = (JSONObject)localObject1;
          if (m == -1)
          {
            i = localObject1.length;
            j = k;
            paramJSONObject2 = (JSONObject)localObject1;
          }
        }
      }
      if (n < 0)
      {
        paramJSONObject1.put("errMsg", "invalid port");
        return;
      }
      if (paramJSONObject2 == null)
      {
        paramJSONObject1.put("errMsg", "undefined message");
        return;
      }
      if ((j < 0) || (j >= i))
      {
        paramJSONObject1.put("errMsg", "invalid offset");
        return;
      }
      if (i > paramJSONObject2.length)
      {
        paramJSONObject1.put("errMsg", "invalid length");
        return;
      }
      paramUDPTask.send(paramJSONObject2, j, i, new InetSocketAddress((InetAddress)localObject1, n));
      return;
    }
  }
  
  private InetAddress validAddress(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      if ((IPV4_ADDRESS_REGEX.matcher(paramString).matches()) || (IPV6_ADDRESS_REGEX.matcher(paramString).matches())) {
        try
        {
          InetAddress localInetAddress = InetAddress.getByName(paramString);
          if ((!localInetAddress.isLoopbackAddress()) && (!localInetAddress.isAnyLocalAddress()) && (!localInetAddress.isMulticastAddress()))
          {
            if (localInetAddress.isSiteLocalAddress()) {
              return localInetAddress;
            }
            boolean bool = isUdpIpValid(paramString);
            if (bool) {
              return localInetAddress;
            }
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          QMLog.d("UDPPlugin", "valid address [" + paramString + "]", localUnknownHostException);
        }
      }
    }
    return null;
  }
  
  @JsEvent({"createUDPTask"})
  public String createUDPTask(RequestEvent paramRequestEvent)
  {
    paramRequestEvent = new JSONObject();
    try
    {
      UDPTask localUDPTask = new UDPTask();
      this.mTaskRegistry.put(localUDPTask.taskId, localUDPTask);
      paramRequestEvent.put("udpTaskId", localUDPTask.taskId);
      return paramRequestEvent.toString();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          paramRequestEvent.put("errMsg", localIOException.getMessage());
        }
        catch (JSONException localJSONException1) {}
      }
    }
    catch (JSONException localJSONException2)
    {
      for (;;)
      {
        try
        {
          paramRequestEvent.put("errMsg", localJSONException2.getMessage());
        }
        catch (JSONException localJSONException3) {}
      }
    }
  }
  
  public boolean isUdpIpValid(String paramString)
  {
    if (this.mMiniAppInfo == null) {
      return false;
    }
    if (this.mMiniAppInfo.skipDomainCheck == 1)
    {
      QMLog.d("[mini] http.udp", "udp ip检查 skip: " + paramString);
      return true;
    }
    if ((this.mMiniAppInfo.verType != 3) && (getEnableDebug(this.mMiniAppInfo.appId)))
    {
      QMLog.d("[mini] http.udp", "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if (this.mUdpIpWhiteSet == null) {}
    try
    {
      if (this.mUdpIpWhiteSet == null) {
        this.mUdpIpWhiteSet = new HashSet(this.mMiniAppInfo.udpIpList);
      }
      return this.mUdpIpWhiteSet.contains(paramString);
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.mUdpIpWhiteSet = null;
    super.onDestroy();
  }
  
  @JsEvent({"operateUDPTask"})
  public String operateUDPTask(RequestEvent paramRequestEvent)
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramRequestEvent = new JSONObject(paramRequestEvent.jsonParams);
        String str = paramRequestEvent.optString("operation");
        int i = paramRequestEvent.optInt("udpTaskId");
        UDPTask localUDPTask = (UDPTask)this.mTaskRegistry.get(i);
        if (localUDPTask == null) {
          continue;
        }
        handleTaskOperation(localJSONObject, paramRequestEvent, str, i, localUDPTask);
        paramRequestEvent = localJSONObject.optString("errMsg", null);
        if (paramRequestEvent != null) {
          callbackError(paramRequestEvent, i);
        }
      }
      catch (IOException paramRequestEvent)
      {
        try
        {
          localJSONObject.put("errMsg", paramRequestEvent.getMessage());
        }
        catch (JSONException paramRequestEvent) {}
        continue;
      }
      catch (JSONException paramRequestEvent)
      {
        try
        {
          localJSONObject.put("errMsg", paramRequestEvent.getMessage());
        }
        catch (JSONException paramRequestEvent) {}
        continue;
      }
      return localJSONObject.toString();
      localJSONObject.put("errMsg", "task already closed");
    }
  }
  
  class UDPTask
    implements NioSelectorThread.NioHandler
  {
    private final DatagramChannel channel;
    private final ByteBuffer receiveBuffer;
    private final byte[] receiveByteArray;
    final int taskId;
    
    UDPTask()
      throws IOException
    {
      try
      {
        this.taskId = UDPJsPlugin.UDP_TASK_ID_COUNTER.getAndIncrement();
        this.channel = DatagramChannel.open();
        this.channel.configureBlocking(false);
        this.receiveByteArray = new byte[8192];
        this.receiveBuffer = ByteBuffer.wrap(this.receiveByteArray);
        return;
      }
      catch (IOException this$1)
      {
        onError(UDPJsPlugin.this.getMessage());
        throw UDPJsPlugin.this;
      }
    }
    
    public int bind()
      throws IOException
    {
      try
      {
        this.channel.socket().bind(null);
        NioSelectorThread.getInstance().registerChannel(this.channel, 1, this);
        onListening();
        int i = this.channel.socket().getLocalPort();
        return i;
      }
      catch (IOException localIOException)
      {
        onError(localIOException.getMessage());
        throw localIOException;
      }
    }
    
    public void close()
      throws IOException
    {
      try
      {
        this.channel.close();
        onClose();
        return;
      }
      catch (IOException localIOException)
      {
        onError(localIOException.getMessage());
        throw localIOException;
      }
    }
    
    public boolean handle(SelectionKey paramSelectionKey)
    {
      try
      {
        if (paramSelectionKey.isReadable())
        {
          this.receiveBuffer.clear();
          paramSelectionKey = this.channel.receive(this.receiveBuffer);
          this.receiveBuffer.flip();
          onReceive(this.receiveByteArray, this.receiveBuffer.limit(), paramSelectionKey);
        }
        return true;
      }
      catch (IOException paramSelectionKey)
      {
        for (;;)
        {
          onError(paramSelectionKey.getMessage());
        }
      }
    }
    
    void onClose()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("udpTaskId", this.taskId);
        localJSONObject.put("event", "close");
        UDPJsPlugin.this.sendSubscribeEvent("onUDPTaskEventCallback", localJSONObject.toString());
        return;
      }
      catch (JSONException localJSONException) {}
    }
    
    void onError(String paramString)
    {
      UDPJsPlugin.this.callbackError(paramString, this.taskId);
    }
    
    void onListening()
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("udpTaskId", this.taskId);
        localJSONObject.put("event", "listening");
        UDPJsPlugin.this.sendSubscribeEvent("onUDPTaskEventCallback", localJSONObject.toString());
        return;
      }
      catch (JSONException localJSONException) {}
    }
    
    void onReceive(byte[] paramArrayOfByte, int paramInt, SocketAddress paramSocketAddress)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("udpTaskId", this.taskId);
        localJSONObject.put("event", "message");
        NativeBuffer.packNativeBuffer(UDPJsPlugin.this.mMiniAppContext, paramArrayOfByte, 0, paramInt, NativeBuffer.TYPE_BUFFER_NATIVE, "message", localJSONObject);
        paramArrayOfByte = new JSONObject();
        InetAddress localInetAddress;
        if ((paramSocketAddress instanceof InetSocketAddress))
        {
          paramSocketAddress = (InetSocketAddress)paramSocketAddress;
          localInetAddress = paramSocketAddress.getAddress();
          if (!(localInetAddress instanceof Inet4Address)) {
            break label149;
          }
          paramArrayOfByte.put("family", "IPv4");
        }
        for (;;)
        {
          paramArrayOfByte.put("address", localInetAddress.getHostAddress());
          paramArrayOfByte.put("port", paramSocketAddress.getPort());
          paramArrayOfByte.put("size", paramInt);
          localJSONObject.put("remoteInfo", paramArrayOfByte);
          UDPJsPlugin.this.sendSubscribeEvent("onUDPTaskEventCallback", localJSONObject.toString());
          return;
          label149:
          paramArrayOfByte.put("family", "IPv6");
        }
        return;
      }
      catch (JSONException paramArrayOfByte) {}
    }
    
    public void send(byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketAddress paramSocketAddress)
      throws IOException
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      paramArrayOfByte.position(paramInt1);
      paramArrayOfByte.limit(paramInt1 + paramInt2);
      this.channel.send(paramArrayOfByte, paramSocketAddress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.UDPJsPlugin
 * JD-Core Version:    0.7.0.1
 */