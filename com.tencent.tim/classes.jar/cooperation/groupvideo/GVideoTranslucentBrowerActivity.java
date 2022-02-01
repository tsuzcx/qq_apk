package cooperation.groupvideo;

import aids;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import anot;
import aqzl;
import arcd;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class GVideoTranslucentBrowerActivity
  extends QQTranslucentBrowserActivity
{
  public GVideoTranslucentBrowerActivity()
  {
    this.s = GVideoBrowserFragment.class;
  }
  
  public static class GVideoBrowserFragment
    extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
  {
    private boolean bfv;
    
    public int a(Bundle paramBundle)
    {
      int i = super.a(paramBundle);
      this.jdField_a_of_type_Aqzl.bC(false);
      this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
      return i;
    }
    
    public boolean doOnCreate(Bundle paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment doOnCreate = ");
      }
      boolean bool = super.doOnCreate(paramBundle);
      this.mPluginEngine.aa(new String[] { "groupVideo" });
      return bool;
    }
    
    public int o(Bundle paramBundle)
    {
      this.jdField_a_of_type_Arcd$a.Dr = 0L;
      return super.o(paramBundle);
    }
    
    public void onDestroy()
    {
      super.onDestroy();
      aids.Lb("2729128");
      if (!this.bfv)
      {
        aids.Lb("2489207");
        anot.a(null, "dc00899", "Huayang_video", "", "group_video", "loadHideWeb", 1, 0, "", "3.4.4", "", "");
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "GVideoBrowserFragment onReceivedError = ");
      }
      this.bfv = true;
      if (getActivity() != null) {
        getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity
 * JD-Core Version:    0.7.0.1
 */