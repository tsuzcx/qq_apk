package com.tencent.mobileqq.vaswebviewplugin;

import acbn;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import aqep;
import ausj;
import ausj.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import ilp;
import java.io.File;

class AvatarPendantJsPlugin$5
  implements ausj.a
{
  AvatarPendantJsPlugin$5(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.val$sheet.dismiss();
        return;
      }
      catch (Exception paramView) {}
      if (!ilp.checkAVCameraUsed(BaseApplicationImpl.getContext()))
      {
        paramView = new File(acbn.SDCARD_PATH + "photo/");
        if (!paramView.exists()) {
          paramView.mkdirs();
        }
        paramView = new Intent();
        Uri localUri = FileProvider7Helper.setSystemCapture(this.this$0.mRuntime.getActivity(), new File(acbn.SDCARD_PATH + "photo/" + System.currentTimeMillis() + ".jpg"), paramView);
        this.this$0.mRuntime.getActivity().startActivityForResult(paramView, 1);
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
        AvatarPendantUiPlugin.sUploadPhotoUri = localUri;
        continue;
        paramView = new Intent();
        paramView.putExtra("keyFromPendantPhoto", true);
        paramView.putExtra("Business_Origin", 100);
        paramInt = Math.min(482, aqep.v(this.this$0.mRuntime.getActivity()));
        PhotoUtils.a(paramView, this.this$0.mRuntime.getActivity(), QQBrowserActivity.class.getName(), paramInt, paramInt, 1080, 1080, aqep.BR());
        AvatarPendantUiPlugin.sJsHandler = this.this$0;
        AvatarPendantUiPlugin.sCallbackId = this.val$callbackId;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */