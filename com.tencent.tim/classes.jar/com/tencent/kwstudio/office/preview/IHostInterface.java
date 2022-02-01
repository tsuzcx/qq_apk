package com.tencent.kwstudio.office.preview;

import android.content.Context;
import com.tencent.kwstudio.office.base.IGlobal;
import com.tencent.kwstudio.office.base.ILog;

public abstract interface IHostInterface
{
  public static final String APP_ID_4_MQQ_ANDROID = "1001";
  public static final String CONFIG_KEY_DOCS_FONT_INFO = "docs_font_info";
  public static final String CONFIG_KEY_DOCS_PLUGIN_INFO = "docs_plugin_info";
  public static final String CONFIG_KEY_FACADE_PLUGIN_ENTRY_CLASS = "facade_plugin_entry_class";
  public static final String CONFIG_KEY_FACADE_PLUGIN_MD5 = "facade_plugin_md5";
  public static final String CONFIG_KEY_FACADE_PLUGIN_NAME = "facade_plugin_name";
  public static final String CONFIG_KEY_FACADE_PLUGIN_NAME_PREFIX = "facade_plugin_name_prefix";
  public static final String CONFIG_KEY_FACADE_PLUGIN_URL = "facade_plugin_url";
  public static final String CONFIG_KEY_GLOBAL_REQUIRED_RES_INFO = "global_required_res_info";
  public static final String CONFIG_KEY_PRE_LOAD_INFO = "pre_load_info";
  public static final String CONFIG_KEY_SHEETS_PLUGIN_INFO = "sheets_plugin_info";
  public static final String CONFIG_KEY_SLIDES_PLUGIN_INFO = "slides_plugin_info";
  public static final String CONFIG_KEY_SLIDES_RES_INFO = "slides_res_info";
  
  public abstract void commitPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract IGlobal createGlobal();
  
  public abstract ILog createLog();
  
  public abstract Object createRecyclerView(Context paramContext);
  
  public abstract Object createWebView(Context paramContext, IWebClient paramIWebClient);
  
  public abstract void downloadResource(String paramString1, String paramString2, String paramString3, IDownloadListener paramIDownloadListener);
  
  public abstract String getAppId();
  
  public abstract String getConfig(String paramString);
  
  public abstract String getUserId();
  
  public abstract void queryPreferences(String paramString, boolean paramBoolean1, boolean paramBoolean2, IPreferencesCallback paramIPreferencesCallback);
  
  public abstract void reportEvent(String paramString1, int paramInt, String paramString2);
  
  public abstract void sendHttpRequest(String paramString1, boolean paramBoolean, String paramString2, IHttpListener paramIHttpListener);
  
  public static abstract interface IDownloadListener
  {
    public abstract void onDownloadFinished(String paramString, boolean paramBoolean, int paramInt);
    
    public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
  }
  
  public static abstract interface IHttpListener
  {
    public abstract void onResponse(int paramInt, String paramString);
  }
  
  public static abstract interface IPreferencesCallback
  {
    public abstract void onResult(boolean paramBoolean);
  }
  
  public static abstract interface IWebClient
  {
    @Deprecated
    public abstract boolean onConsoleMessage(String paramString);
    
    public abstract boolean onConsoleMessage(String paramString1, int paramInt, String paramString2);
    
    public abstract boolean onJsPrompt(Object paramObject, String paramString1, String paramString2, String paramString3);
    
    public abstract boolean onPageFinished(Object paramObject, String paramString);
    
    public abstract boolean shouldOverrideUrlLoading(Object paramObject, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.IHostInterface
 * JD-Core Version:    0.7.0.1
 */