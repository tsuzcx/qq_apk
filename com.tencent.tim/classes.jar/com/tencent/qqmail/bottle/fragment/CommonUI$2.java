package com.tencent.qqmail.bottle.fragment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottleManager.AvatarCallback;

final class CommonUI$2
  implements BottleManager.AvatarCallback
{
  CommonUI$2(boolean[] paramArrayOfBoolean, String paramString1, String paramString2, ImageView paramImageView) {}
  
  public void onErrorInMainThread2(String paramString, Bitmap paramBitmap) {}
  
  public void onSuccessInMainThread2(String paramString, Bitmap paramBitmap)
  {
    BottleManager.log("showBottlerDetail small:" + this.val$showBigAvatar[0] + ", " + this.val$avatarUin + ", " + this.val$avatarUrl);
    if (this.val$showBigAvatar[0] == 0) {
      this.val$avatarView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.CommonUI.2
 * JD-Core Version:    0.7.0.1
 */