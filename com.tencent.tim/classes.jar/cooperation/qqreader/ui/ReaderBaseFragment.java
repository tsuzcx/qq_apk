package cooperation.qqreader.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import arcd;
import avms;
import avna;
import avof;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqreader.host.webview.ReaderWebView;
import java.util.HashMap;
import java.util.Map;

public abstract class ReaderBaseFragment
  extends WebViewFragment
{
  protected boolean dnC;
  protected boolean dnD;
  protected Handler mHandler;
  private ImageView mLoadingView;
  
  private void bgb()
  {
    if (this.a.mLoadingProgressBar != null) {
      this.a.mLoadingProgressBar.setVisibility(8);
    }
  }
  
  private void createLoadingView()
  {
    ViewGroup localViewGroup = (ViewGroup)this.j.getParent().getParent();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.mLoadingView = new ImageView(getActivity());
    this.mLoadingView.setBackgroundColor(-1);
    this.mLoadingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localViewGroup.addView(this.mLoadingView, 0, localLayoutParams);
  }
  
  protected boolean WJ()
  {
    if (this.j != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.j.getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
        return localWebViewPluginEngine.handleEvent(this.j.getUrl(), 8589934601L, localHashMap);
      }
    }
    return false;
  }
  
  public void a(int paramInt, KeyEvent paramKeyEvent)
  {
    super.a(paramInt, paramKeyEvent);
    if (paramInt == 4) {
      eBl();
    }
  }
  
  public void biT()
  {
    if (!WJ()) {
      super.getActivity().finish();
    }
  }
  
  public TouchWebView c()
  {
    return new ReaderWebView(getActivity());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (this.intent != null) {
      this.intent.putExtra("key_is_init_sonic_session", false);
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void eBl()
  {
    if (this.dnC)
    {
      if (this.j != null) {
        this.j.stopLoading();
      }
      return;
    }
    biT();
  }
  
  public String getUAMark()
  {
    return "QQReader";
  }
  
  protected boolean handleMessageImp(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (((Boolean)paramMessage.obj).booleanValue())
    {
      if (this.mLoadingView == null) {
        createLoadingView();
      }
      avms.a().a(getActivity(), this.mLoadingView, 600L);
    }
    for (;;)
    {
      return true;
      avms.a().eAO();
    }
  }
  
  public void initWebView()
  {
    super.initWebView();
    Object localObject = getActivity();
    if ((localObject instanceof ReaderBaseWebActivity))
    {
      localObject = ((ReaderBaseWebActivity)localObject).a(this.j);
      if ((localObject != null) && (this.mHandler != null)) {
        ((avna)localObject).a(this.mHandler);
      }
    }
    this.j.getView().setVerticalScrollBarEnabled(false);
  }
  
  public int o(Bundle paramBundle)
  {
    int i = super.o(paramBundle);
    bgb();
    return i;
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    super.onDetectedBlankScreen(paramString, paramInt);
    avof.N(getActivity(), paramInt, paramString);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.dnC = false;
    avms.a().eAO();
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    bgb();
    this.dnC = true;
    if (this.mLoadingView == null) {
      createLoadingView();
    }
    avms.a().a(getActivity(), this.mLoadingView);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    avms.a().eAO();
  }
  
  protected void setHandler(Handler paramHandler)
  {
    this.mHandler = paramHandler;
  }
  
  public boolean showPreview()
  {
    this.dnD = true;
    this.a.zP = false;
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderBaseFragment
 * JD-Core Version:    0.7.0.1
 */