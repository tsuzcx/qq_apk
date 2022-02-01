package com.tencent.mobileqq.ark.browser;

import adrw;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import araz;
import arbt;
import arbt.a;
import arcd.a;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import uaw;
import ubu;

public class ArkBrowserFragment
  extends WebViewFragment
{
  public String bvl;
  
  public void Qq()
  {
    arbt localarbt = (arbt)this.jdField_a_of_type_Araz.q(4);
    if (localarbt != null)
    {
      localarbt.a(new a());
      localarbt.a(a(), this.jdField_a_of_type_Arcd$a.gK);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = this.j.getPluginEngine();
    String str = getCurrentUrl();
    if (TextUtils.isEmpty(ubu.gZ(str))) {}
    do
    {
      do
      {
        return;
        localObject = ((WebViewPluginEngine)localObject).a(str);
      } while (localObject == null);
      localObject = (adrw)((uaw)localObject).a(adrw.class, false);
    } while (localObject == null);
    ((adrw)localObject).onActivityResult(paramIntent, (byte)paramInt1, paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    mg(bg() & 0xFFFFFFFB);
  }
  
  class a
    implements arbt.a
  {
    a() {}
    
    public void GN(String paramString)
    {
      ArkBrowserFragment.this.bvl = paramString;
      paramString = ArkBrowserFragment.this.getWebView();
      if (paramString != null) {
        paramString.callJs("NativeApi.lightappGetShareData();");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.browser.ArkBrowserFragment
 * JD-Core Version:    0.7.0.1
 */