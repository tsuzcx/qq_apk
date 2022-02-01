package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

class ImageJsPlugin$2
  implements Runnable
{
  ImageJsPlugin$2(ImageJsPlugin paramImageJsPlugin, RequestEvent paramRequestEvent, int paramInt) {}
  
  public void run()
  {
    MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(ImageJsPlugin.access$200(this.this$0).getAttachedActivity(), 230, "图片选择", "请选择获取图片方式", "相册", "拍照", new ImageJsPlugin.2.1(this), new ImageJsPlugin.2.2(this));
    localMiniCustomDialog.setCanceledOnTouchOutside(false);
    localMiniCustomDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ImageJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */