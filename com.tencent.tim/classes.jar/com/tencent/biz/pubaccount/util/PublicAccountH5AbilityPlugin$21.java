package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import arhz;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import jqg;
import obw;
import rwt;

public class PublicAccountH5AbilityPlugin$21
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$21(obw paramobw, String paramString, Bundle paramBundle, arhz paramarhz) {}
  
  public void run()
  {
    Object localObject = jqg.a(this.this$0.mRuntime.getActivity(), this.val$imageUrl, this.G);
    int i;
    if ((this.val$loadingDialog != null) && (this.val$loadingDialog.isShowing()))
    {
      i = 1;
      if (i != 0)
      {
        this.this$0.mHandler.post(new PublicAccountH5AbilityPlugin.21.1(this));
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label179;
        }
      }
    }
    for (;;)
    {
      Bitmap localBitmap;
      try
      {
        localBitmap = BitmapFactory.decodeFile((String)localObject);
        if (WXShareHelper.a().isWXinstalled()) {
          break label153;
        }
        i = 2131721935;
        if (i == -1) {
          break label168;
        }
        rwt.ez(0, i);
        localObject = new Intent(this.this$0.mRuntime.getActivity(), PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("url", "https://weixin.qq.com/download");
        this.this$0.mRuntime.getActivity().startActivity((Intent)localObject);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
        return;
      }
      i = 0;
      break;
      label153:
      if (!WXShareHelper.a().isWXsupportApi())
      {
        i = 2131721936;
        continue;
        label168:
        WXShareHelper.a().a(localOutOfMemoryError, localBitmap, 1, true);
        return;
        label179:
        rwt.ez(1, 2131697453);
      }
      else
      {
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.21
 * JD-Core Version:    0.7.0.1
 */