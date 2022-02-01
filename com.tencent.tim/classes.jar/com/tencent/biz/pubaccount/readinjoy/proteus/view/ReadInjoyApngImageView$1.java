package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import aqqx;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import lsp;

public class ReadInjoyApngImageView$1
  implements Runnable
{
  public ReadInjoyApngImageView$1(lsp paramlsp, String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$url)) && (this.val$url.startsWith("http")))
    {
      Object localObject1 = BaseApplicationImpl.getContext().getFilesDir() + "/shortvideo_opt_png/";
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      int i = this.val$url.lastIndexOf("/");
      int j = this.val$url.lastIndexOf(".");
      localObject2 = this.val$url.substring(i + 1, j);
      Bundle localBundle = new Bundle();
      localBundle.putInt("key_loop", 1);
      localBundle.putBoolean("key_once_clear", true);
      localObject1 = aqqx.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1 + (String)localObject2, this.val$url, lsp.a(this.this$0), new int[] { 31 }, "-kandianopt-", localBundle);
      if (localObject1 != null)
      {
        this.this$0.l.setImageDrawable((Drawable)localObject1);
        if (((URLDrawable)localObject1).getStatus() == 2) {
          ((URLDrawable)localObject1).restartDownload();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyApngImageView.1
 * JD-Core Version:    0.7.0.1
 */