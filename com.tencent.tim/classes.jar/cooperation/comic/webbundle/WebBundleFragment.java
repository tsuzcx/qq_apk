package cooperation.comic.webbundle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anot;
import arbz;
import avek;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.webbundle.sdk.IWebBundleWebView;
import com.tencent.webbundle.sdk.WebBundleClient;
import cooperation.comic.ui.QQComicFragment;
import jqo;

public class WebBundleFragment
  extends QQComicFragment
{
  private WebBundleClient a;
  private String preloadUrl = "";
  private String realUrl = "";
  
  public void aCP()
  {
    jqo.le("Web_readyToLoadUrl");
    if (this.j == null) {
      return;
    }
    aBA();
    if ((this.jdField_a_of_type_Arbz.cXQ) && (this.jdField_a_of_type_Arbz.auw > 0L))
    {
      anot.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Arbz.auw) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Arbz.flag);
      this.jdField_a_of_type_Arbz.auw = 0L;
    }
    this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Arbz.mTimeBeforeLoadUrl;
    l = this.jdField_a_of_type_Arbz.mClickTime;
    if (((this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient == null) || (!this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.interceptLoadUrl(this.intent))) && (!TextUtils.isEmpty(this.mUrl))) {
      this.j.loadUrl(this.mUrl);
    }
    jqo.lf("Web_readyToLoadUrl");
    this.jdField_a_of_type_Arbz.a(this.j, this.mUrl, 0, 0, 0, 0, 0, null);
  }
  
  public TouchWebView c()
  {
    if (this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient != null)
    {
      IWebBundleWebView localIWebBundleWebView = this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient.getValidWebView(super.getActivity(), this.preloadUrl);
      if ((localIWebBundleWebView instanceof TouchWebView))
      {
        avek.k(this.realUrl, true, avek.cKa);
        return (TouchWebView)localIWebBundleWebView;
      }
      avek.k(this.realUrl, false, avek.cKd);
    }
    return super.c();
  }
  
  public int n(Bundle paramBundle)
  {
    this.realUrl = this.intent.getStringExtra("real_url");
    this.preloadUrl = this.intent.getStringExtra("preload_url");
    String str = this.intent.getStringExtra("bundle_data");
    if ((!TextUtils.isEmpty(this.preloadUrl)) && (!TextUtils.isEmpty(this.realUrl)) && (!TextUtils.isEmpty(str))) {
      this.jdField_a_of_type_ComTencentWebbundleSdkWebBundleClient = new WebBundleClient("comic");
    }
    return super.n(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.comic.webbundle.WebBundleFragment
 * JD-Core Version:    0.7.0.1
 */