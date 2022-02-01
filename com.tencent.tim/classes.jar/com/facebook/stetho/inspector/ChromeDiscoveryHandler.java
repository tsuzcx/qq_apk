package com.facebook.stetho.inspector;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChromeDiscoveryHandler
  implements HttpHandler
{
  private static final String PAGE_ID = "1";
  private static final String PATH_ACTIVATE = "/json/activate/1";
  private static final String PATH_PAGE_LIST = "/json";
  private static final String PATH_VERSION = "/json/version";
  private static final String PROTOCOL_VERSION = "1.1";
  private static final String USER_AGENT = "Stetho";
  private static final String WEBKIT_REV = "@188492";
  private static final String WEBKIT_VERSION = "537.36 (@188492)";
  private final Context mContext;
  private final String mInspectorPath;
  @Nullable
  private LightHttpBody mPageListResponse;
  @Nullable
  private LightHttpBody mVersionResponse;
  
  public ChromeDiscoveryHandler(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mInspectorPath = paramString;
  }
  
  private CharSequence getAppLabel()
  {
    return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getApplicationInfo());
  }
  
  private String getAppLabelAndVersion()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    PackageManager localPackageManager = this.mContext.getPackageManager();
    localStringBuilder.append(getAppLabel());
    localStringBuilder.append('/');
    try
    {
      localStringBuilder.append(localPackageManager.getPackageInfo(this.mContext.getPackageName(), 0).versionName);
      return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException(localNameNotFoundException);
    }
  }
  
  private void handleActivate(LightHttpResponse paramLightHttpResponse)
  {
    setSuccessfulResponse(paramLightHttpResponse, LightHttpBody.create("Target activation ignored\n", "text/plain"));
  }
  
  private void handlePageList(LightHttpResponse paramLightHttpResponse)
    throws JSONException
  {
    if (this.mPageListResponse == null)
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "app");
      localJSONObject.put("title", makeTitle());
      localJSONObject.put("id", "1");
      localJSONObject.put("description", "");
      localJSONObject.put("webSocketDebuggerUrl", "ws://" + this.mInspectorPath);
      localJSONObject.put("devtoolsFrontendUrl", new Uri.Builder().scheme("http").authority("chrome-devtools-frontend.appspot.com").appendEncodedPath("serve_rev").appendEncodedPath("@188492").appendEncodedPath("devtools.html").appendQueryParameter("ws", this.mInspectorPath).build().toString());
      localJSONArray.put(localJSONObject);
      this.mPageListResponse = LightHttpBody.create(localJSONArray.toString(), "application/json");
    }
    setSuccessfulResponse(paramLightHttpResponse, this.mPageListResponse);
  }
  
  private void handleVersion(LightHttpResponse paramLightHttpResponse)
    throws JSONException
  {
    if (this.mVersionResponse == null)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("WebKit-Version", "537.36 (@188492)");
      localJSONObject.put("User-Agent", "Stetho");
      localJSONObject.put("Protocol-Version", "1.1");
      localJSONObject.put("Browser", getAppLabelAndVersion());
      localJSONObject.put("Android-Package", this.mContext.getPackageName());
      this.mVersionResponse = LightHttpBody.create(localJSONObject.toString(), "application/json");
    }
    setSuccessfulResponse(paramLightHttpResponse, this.mVersionResponse);
  }
  
  private String makeTitle()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAppLabel());
    localStringBuilder.append(" (powered by Stetho)");
    String str = ProcessUtil.getProcessName();
    int i = str.indexOf(':');
    if (i >= 0) {
      localStringBuilder.append(str.substring(i));
    }
    return localStringBuilder.toString();
  }
  
  private static void setSuccessfulResponse(LightHttpResponse paramLightHttpResponse, LightHttpBody paramLightHttpBody)
  {
    paramLightHttpResponse.code = 200;
    paramLightHttpResponse.reasonPhrase = "OK";
    paramLightHttpResponse.body = paramLightHttpBody;
  }
  
  public boolean handleRequest(SocketLike paramSocketLike, LightHttpRequest paramLightHttpRequest, LightHttpResponse paramLightHttpResponse)
  {
    paramSocketLike = paramLightHttpRequest.uri.getPath();
    try
    {
      if ("/json/version".equals(paramSocketLike)) {
        handleVersion(paramLightHttpResponse);
      } else if ("/json".equals(paramSocketLike)) {
        handlePageList(paramLightHttpResponse);
      }
    }
    catch (JSONException paramSocketLike)
    {
      paramLightHttpResponse.code = 500;
      paramLightHttpResponse.reasonPhrase = "Internal server error";
      paramLightHttpResponse.body = LightHttpBody.create(paramSocketLike.toString() + "\n", "text/plain");
    }
    if ("/json/activate/1".equals(paramSocketLike))
    {
      handleActivate(paramLightHttpResponse);
    }
    else
    {
      paramLightHttpResponse.code = 501;
      paramLightHttpResponse.reasonPhrase = "Not implemented";
      paramLightHttpResponse.body = LightHttpBody.create("No support for " + paramSocketLike + "\n", "text/plain");
    }
    return true;
  }
  
  public void register(HandlerRegistry paramHandlerRegistry)
  {
    paramHandlerRegistry.register(new ExactPathMatcher("/json"), this);
    paramHandlerRegistry.register(new ExactPathMatcher("/json/version"), this);
    paramHandlerRegistry.register(new ExactPathMatcher("/json/activate/1"), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.ChromeDiscoveryHandler
 * JD-Core Version:    0.7.0.1
 */