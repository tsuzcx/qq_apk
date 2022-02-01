package com.tencent.qqmail.activity.setting;

import android.graphics.Bitmap;
import com.tencent.qqmail.bottle.controller.BottleManager.AvatarCallback;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingBottleActivity$2
  implements BottleManager.AvatarCallback
{
  SettingBottleActivity$2(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onErrorInMainThread2(String paramString, Bitmap paramBitmap) {}
  
  public void onSuccessInMainThread2(String paramString, Bitmap paramBitmap)
  {
    SettingBottleActivity.access$300(this.this$0).setDetail(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.2
 * JD-Core Version:    0.7.0.1
 */