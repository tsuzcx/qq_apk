package com.tencent.qqmail.activity.setting;

import android.graphics.Bitmap;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottleManager;
import com.tencent.qqmail.bottle.controller.BottlerController;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingBottleActivity$1
  implements AvatarSelector.OnAvatarChange
{
  SettingBottleActivity$1(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onAvatarChange(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance())) {
        Threads.runOnMainThread(new SettingBottleActivity.1.1(this));
      }
    }
    else {
      return;
    }
    SettingBottleActivity.access$002(this.this$0, paramBitmap);
    this.this$0.getTips().showLoading(this.this$0.getString(2131719639));
    SettingBottleActivity.access$102(this.this$0, true);
    BottleManager.getInstance().getBottlerController().submitMyInformcation(null, SettingBottleActivity.access$000(this.this$0));
  }
  
  public void onDefaultAvatar(Bitmap paramBitmap)
  {
    SettingBottleActivity.access$200(this.this$0).setAvatar(paramBitmap, "");
    SettingBottleActivity.access$300(this.this$0).setDetail(SettingBottleActivity.access$200(this.this$0).getBitmap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.1
 * JD-Core Version:    0.7.0.1
 */