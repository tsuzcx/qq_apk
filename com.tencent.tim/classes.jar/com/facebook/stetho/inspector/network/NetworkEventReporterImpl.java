package com.facebook.stetho.inspector.network;

import android.os.SystemClock;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console.CallFrame;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;
import com.facebook.stetho.inspector.protocol.module.Network.DataReceivedParams;
import com.facebook.stetho.inspector.protocol.module.Network.Initiator;
import com.facebook.stetho.inspector.protocol.module.Network.InitiatorType;
import com.facebook.stetho.inspector.protocol.module.Network.LoadingFailedParams;
import com.facebook.stetho.inspector.protocol.module.Network.LoadingFinishedParams;
import com.facebook.stetho.inspector.protocol.module.Network.Request;
import com.facebook.stetho.inspector.protocol.module.Network.RequestWillBeSentParams;
import com.facebook.stetho.inspector.protocol.module.Network.Response;
import com.facebook.stetho.inspector.protocol.module.Network.ResponseReceivedParams;
import com.facebook.stetho.inspector.protocol.module.Page.ResourceType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkEventReporterImpl
  implements NetworkEventReporter
{
  private static NetworkEventReporter sInstance;
  @Nullable
  private ResourceTypeHelper mResourceTypeHelper;
  
  @Nullable
  static AsyncPrettyPrinter createPrettyPrinterForResponse(NetworkEventReporter.InspectorResponse paramInspectorResponse, @Nullable AsyncPrettyPrinterRegistry paramAsyncPrettyPrinterRegistry)
  {
    if (paramAsyncPrettyPrinterRegistry != null)
    {
      int i = 0;
      int j = paramInspectorResponse.headerCount();
      while (i < j)
      {
        AsyncPrettyPrinterFactory localAsyncPrettyPrinterFactory = paramAsyncPrettyPrinterRegistry.lookup(paramInspectorResponse.headerName(i));
        if (localAsyncPrettyPrinterFactory != null) {
          return localAsyncPrettyPrinterFactory.getInstance(paramInspectorResponse.headerName(i), paramInspectorResponse.headerValue(i));
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static Page.ResourceType determineResourceType(AsyncPrettyPrinter paramAsyncPrettyPrinter, String paramString, ResourceTypeHelper paramResourceTypeHelper)
  {
    if (paramAsyncPrettyPrinter != null) {
      return paramAsyncPrettyPrinter.getPrettifiedType().getResourceType();
    }
    if (paramString != null) {
      return paramResourceTypeHelper.determineResourceType(paramString);
    }
    return Page.ResourceType.OTHER;
  }
  
  private static JSONObject formatHeadersAsJSON(NetworkEventReporter.InspectorHeaders paramInspectorHeaders)
  {
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    for (;;)
    {
      if (i < paramInspectorHeaders.headerCount())
      {
        String str1 = paramInspectorHeaders.headerName(i);
        String str2 = paramInspectorHeaders.headerValue(i);
        try
        {
          if (localJSONObject.has(str1)) {
            localJSONObject.put(str1, localJSONObject.getString(str1) + "\n" + str2);
          } else {
            localJSONObject.put(str1, str2);
          }
        }
        catch (JSONException paramInspectorHeaders)
        {
          throw new RuntimeException(paramInspectorHeaders);
        }
      }
      else
      {
        return localJSONObject;
      }
      i += 1;
    }
  }
  
  public static NetworkEventReporter get()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NetworkEventReporterImpl();
      }
      NetworkEventReporter localNetworkEventReporter = sInstance;
      return localNetworkEventReporter;
    }
    finally {}
  }
  
  @Nullable
  private String getContentType(NetworkEventReporter.InspectorHeaders paramInspectorHeaders)
  {
    return paramInspectorHeaders.firstHeaderValue("Content-Type");
  }
  
  @Nullable
  private NetworkPeerManager getPeerManagerIfEnabled()
  {
    NetworkPeerManager localNetworkPeerManager = NetworkPeerManager.getInstanceOrNull();
    if ((localNetworkPeerManager != null) && (localNetworkPeerManager.hasRegisteredPeers())) {
      return localNetworkPeerManager;
    }
    return null;
  }
  
  @Nonnull
  private ResourceTypeHelper getResourceTypeHelper()
  {
    if (this.mResourceTypeHelper == null) {
      this.mResourceTypeHelper = new ResourceTypeHelper();
    }
    return this.mResourceTypeHelper;
  }
  
  @Nullable
  private static AsyncPrettyPrinter initAsyncPrettyPrinterForResponse(NetworkEventReporter.InspectorResponse paramInspectorResponse, NetworkPeerManager paramNetworkPeerManager)
  {
    AsyncPrettyPrinter localAsyncPrettyPrinter = createPrettyPrinterForResponse(paramInspectorResponse, paramNetworkPeerManager.getAsyncPrettyPrinterRegistry());
    if (localAsyncPrettyPrinter != null) {
      paramNetworkPeerManager.getResponseBodyFileManager().associateAsyncPrettyPrinterWithId(paramInspectorResponse.requestId(), localAsyncPrettyPrinter);
    }
    return localAsyncPrettyPrinter;
  }
  
  private void loadingFailed(String paramString1, String paramString2)
  {
    NetworkPeerManager localNetworkPeerManager = getPeerManagerIfEnabled();
    if (localNetworkPeerManager != null)
    {
      Network.LoadingFailedParams localLoadingFailedParams = new Network.LoadingFailedParams();
      localLoadingFailedParams.requestId = paramString1;
      localLoadingFailedParams.timestamp = (stethoNow() / 1000.0D);
      localLoadingFailedParams.errorText = paramString2;
      localLoadingFailedParams.type = Page.ResourceType.OTHER;
      localNetworkPeerManager.sendNotificationToPeers("Network.loadingFailed", localLoadingFailedParams);
    }
  }
  
  private void loadingFinished(String paramString)
  {
    NetworkPeerManager localNetworkPeerManager = getPeerManagerIfEnabled();
    if (localNetworkPeerManager != null)
    {
      Network.LoadingFinishedParams localLoadingFinishedParams = new Network.LoadingFinishedParams();
      localLoadingFinishedParams.requestId = paramString;
      localLoadingFinishedParams.timestamp = (stethoNow() / 1000.0D);
      localNetworkPeerManager.sendNotificationToPeers("Network.loadingFinished", localLoadingFinishedParams);
    }
  }
  
  @Nullable
  private static String readBodyAsString(NetworkPeerManager paramNetworkPeerManager, NetworkEventReporter.InspectorRequest paramInspectorRequest)
  {
    try
    {
      paramInspectorRequest = paramInspectorRequest.body();
      if (paramInspectorRequest != null)
      {
        paramInspectorRequest = new String(paramInspectorRequest, Utf8Charset.INSTANCE);
        return paramInspectorRequest;
      }
    }
    catch (OutOfMemoryError paramInspectorRequest)
    {
      CLog.writeToConsole(paramNetworkPeerManager, Console.MessageLevel.WARNING, Console.MessageSource.NETWORK, "Could not reproduce POST body: " + paramInspectorRequest);
      return null;
    }
    catch (IOException paramInspectorRequest)
    {
      label26:
      break label26;
    }
  }
  
  private static long stethoNow()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public void dataReceived(String paramString, int paramInt1, int paramInt2)
  {
    NetworkPeerManager localNetworkPeerManager = getPeerManagerIfEnabled();
    if (localNetworkPeerManager != null)
    {
      Network.DataReceivedParams localDataReceivedParams = new Network.DataReceivedParams();
      localDataReceivedParams.requestId = paramString;
      localDataReceivedParams.timestamp = (stethoNow() / 1000.0D);
      localDataReceivedParams.dataLength = paramInt1;
      localDataReceivedParams.encodedDataLength = paramInt2;
      localNetworkPeerManager.sendNotificationToPeers("Network.dataReceived", localDataReceivedParams);
    }
  }
  
  public void dataSent(String paramString, int paramInt1, int paramInt2)
  {
    dataReceived(paramString, paramInt1, paramInt2);
  }
  
  public void httpExchangeFailed(String paramString1, String paramString2)
  {
    loadingFailed(paramString1, paramString2);
  }
  
  public InputStream interpretResponseStream(String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable InputStream paramInputStream, ResponseHandler paramResponseHandler)
  {
    NetworkPeerManager localNetworkPeerManager = getPeerManagerIfEnabled();
    InputStream localInputStream = paramInputStream;
    if (localNetworkPeerManager != null)
    {
      if (paramInputStream == null)
      {
        paramResponseHandler.onEOF();
        localInputStream = null;
      }
    }
    else {
      return localInputStream;
    }
    if (paramString2 != null) {}
    for (paramString2 = getResourceTypeHelper().determineResourceType(paramString2);; paramString2 = null)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString2 == Page.ResourceType.IMAGE) {
          bool1 = true;
        }
      }
      try
      {
        paramString2 = DecompressionHelper.teeInputWithDecompression(localNetworkPeerManager, paramString1, paramInputStream, localNetworkPeerManager.getResponseBodyFileManager().openResponseBodyFile(paramString1, bool1), paramString3, paramResponseHandler);
        return paramString2;
      }
      catch (IOException paramString2)
      {
        CLog.writeToConsole(localNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Error writing response body data for request #" + paramString1);
      }
    }
    return paramInputStream;
  }
  
  public boolean isEnabled()
  {
    return getPeerManagerIfEnabled() != null;
  }
  
  public void requestWillBeSent(NetworkEventReporter.InspectorRequest paramInspectorRequest)
  {
    NetworkPeerManager localNetworkPeerManager = getPeerManagerIfEnabled();
    Network.Request localRequest;
    Object localObject;
    Integer localInteger;
    Network.Initiator localInitiator;
    List localList;
    if (localNetworkPeerManager != null)
    {
      localRequest = new Network.Request();
      localRequest.url = paramInspectorRequest.url();
      localRequest.method = paramInspectorRequest.method();
      localRequest.headers = formatHeadersAsJSON(paramInspectorRequest);
      localRequest.postData = readBodyAsString(localNetworkPeerManager, paramInspectorRequest);
      localObject = paramInspectorRequest.friendlyName();
      localInteger = paramInspectorRequest.friendlyNameExtra();
      localInitiator = new Network.Initiator();
      localInitiator.type = Network.InitiatorType.SCRIPT;
      localInitiator.stackTrace = new ArrayList();
      localList = localInitiator.stackTrace;
      if (localInteger == null) {
        break label241;
      }
    }
    label241:
    for (int i = localInteger.intValue();; i = 0)
    {
      localList.add(new Console.CallFrame((String)localObject, (String)localObject, i, 0));
      localObject = new Network.RequestWillBeSentParams();
      ((Network.RequestWillBeSentParams)localObject).requestId = paramInspectorRequest.id();
      ((Network.RequestWillBeSentParams)localObject).frameId = "1";
      ((Network.RequestWillBeSentParams)localObject).loaderId = "1";
      ((Network.RequestWillBeSentParams)localObject).documentURL = paramInspectorRequest.url();
      ((Network.RequestWillBeSentParams)localObject).request = localRequest;
      ((Network.RequestWillBeSentParams)localObject).timestamp = (stethoNow() / 1000.0D);
      ((Network.RequestWillBeSentParams)localObject).initiator = localInitiator;
      ((Network.RequestWillBeSentParams)localObject).redirectResponse = null;
      ((Network.RequestWillBeSentParams)localObject).type = Page.ResourceType.OTHER;
      localNetworkPeerManager.sendNotificationToPeers("Network.requestWillBeSent", localObject);
      return;
    }
  }
  
  public void responseHeadersReceived(NetworkEventReporter.InspectorResponse paramInspectorResponse)
  {
    NetworkPeerManager localNetworkPeerManager = getPeerManagerIfEnabled();
    Network.Response localResponse;
    String str;
    if (localNetworkPeerManager != null)
    {
      localResponse = new Network.Response();
      localResponse.url = paramInspectorResponse.url();
      localResponse.status = paramInspectorResponse.statusCode();
      localResponse.statusText = paramInspectorResponse.reasonPhrase();
      localResponse.headers = formatHeadersAsJSON(paramInspectorResponse);
      str = getContentType(paramInspectorResponse);
      if (str == null) {
        break label201;
      }
    }
    label201:
    for (Object localObject = getResourceTypeHelper().stripContentExtras(str);; localObject = "application/octet-stream")
    {
      localResponse.mimeType = ((String)localObject);
      localResponse.connectionReused = paramInspectorResponse.connectionReused();
      localResponse.connectionId = paramInspectorResponse.connectionId();
      localResponse.fromDiskCache = Boolean.valueOf(paramInspectorResponse.fromDiskCache());
      localObject = new Network.ResponseReceivedParams();
      ((Network.ResponseReceivedParams)localObject).requestId = paramInspectorResponse.requestId();
      ((Network.ResponseReceivedParams)localObject).frameId = "1";
      ((Network.ResponseReceivedParams)localObject).loaderId = "1";
      ((Network.ResponseReceivedParams)localObject).timestamp = (stethoNow() / 1000.0D);
      ((Network.ResponseReceivedParams)localObject).response = localResponse;
      ((Network.ResponseReceivedParams)localObject).type = determineResourceType(initAsyncPrettyPrinterForResponse(paramInspectorResponse, localNetworkPeerManager), str, getResourceTypeHelper());
      localNetworkPeerManager.sendNotificationToPeers("Network.responseReceived", localObject);
      return;
    }
  }
  
  public void responseReadFailed(String paramString1, String paramString2)
  {
    loadingFailed(paramString1, paramString2);
  }
  
  public void responseReadFinished(String paramString)
  {
    loadingFinished(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.network.NetworkEventReporterImpl
 * JD-Core Version:    0.7.0.1
 */