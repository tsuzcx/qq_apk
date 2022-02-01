import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

public class ardm
{
  public static abstract interface a
    extends aqzv
  {
    public abstract void a(WebViewPlugin paramWebViewPlugin, Intent paramIntent, byte paramByte);
    
    public abstract String getPluginId();
    
    public abstract String getPluginName();
    
    public abstract boolean qc();
  }
  
  public static abstract interface b
    extends aqzv
  {
    public abstract String CI();
  }
  
  public static abstract interface c
    extends aqzv
  {
    public abstract int a(WebViewPlugin paramWebViewPlugin, byte paramByte, boolean paramBoolean);
    
    public abstract boolean aGb();
    
    public abstract Activity getTopActivity();
  }
  
  public static abstract interface d
    extends aqzv
  {
    public abstract void Wp(String paramString);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener);
    
    public abstract View getTitleBarView();
  }
  
  public static abstract interface e
    extends aqzv
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener);
  }
  
  public static abstract interface f
    extends aqzv
  {
    public abstract boolean hF(String paramString);
    
    public abstract long hY();
  }
  
  public static abstract interface g
    extends aqzv
  {
    public abstract View R(int paramInt);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, int paramInt3);
    
    public abstract void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt4);
    
    public abstract void gx(String paramString, int paramInt);
  }
  
  public static abstract interface h
    extends aqzv
  {
    public abstract void Tx(boolean paramBoolean);
    
    public abstract void Ty(boolean paramBoolean);
  }
  
  public static abstract interface i
    extends aqzv
  {
    public abstract boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
    
    public abstract String getOpenidBatch(String paramString);
  }
  
  public static abstract interface j
    extends aqzv
  {
    public abstract WebViewProgressBar b();
    
    public abstract void hideLoading();
    
    public abstract void showLoading();
  }
  
  public static abstract interface k
    extends aqzv
  {
    public abstract boolean a(String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle);
    
    public abstract svi b();
    
    public abstract boolean bw(String paramString);
  }
  
  public static abstract interface l
    extends aqzv
  {
    public abstract String CF();
    
    public abstract String CG();
    
    public abstract String CH();
  }
  
  public static abstract interface m
    extends aqzv
  {
    public abstract void HY(int paramInt);
    
    public abstract void gY(long paramLong);
    
    public abstract int zP();
  }
  
  public static abstract interface n
    extends aqzv
  {
    public abstract void E(JSONObject paramJSONObject);
    
    public abstract void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener, tzd paramtzd);
    
    public abstract long bg();
    
    public abstract void c(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract int getTitleBarHeight();
    
    public abstract View getTitleBarView();
    
    public abstract int jr();
  }
  
  public static abstract interface o
    extends aqzv
  {
    public abstract void QK();
    
    public abstract void Qq();
    
    public abstract void ff(boolean paramBoolean);
    
    public abstract String getCurrentUrl();
    
    public abstract CustomWebView getWebView();
    
    public abstract boolean mc();
  }
  
  public static abstract interface p
    extends aqzv
  {
    public abstract int MB();
    
    public abstract boolean aGm();
  }
  
  public static abstract interface q
    extends aqzv
  {
    public abstract long getDetect302Time();
    
    public abstract boolean getIsReloadUrl();
    
    public abstract long getOpenUrlAfterCheckOfflineTime();
    
    public abstract long getReadIndexFromOfflineTime();
    
    public abstract JSONObject getX5Performance();
    
    public abstract long getgetWebViewTime();
    
    public abstract long getinitBrowserTime();
    
    public abstract long getinitTBSTime();
    
    public abstract long getinitTime();
    
    public abstract boolean getisWebViewCache();
    
    public abstract long getmClickTime();
    
    public abstract long getmOnCreateMilliTimeStamp();
    
    public abstract boolean getmPerfFirstLoadTag();
    
    public abstract long getmStartLoadUrlMilliTimeStamp();
    
    public abstract long getmTimeBeforeLoadUrl();
    
    public abstract long getonCreateTime();
    
    public abstract long getpluginFinished();
    
    public abstract long getviewInflateTime();
    
    public abstract boolean isMainPageUseLocalFile();
    
    public abstract void setX5Performance(JSONObject paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ardm
 * JD-Core Version:    0.7.0.1
 */