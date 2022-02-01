package com.tencent.qqmail.activity.setting;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.BottlerController.MyInformationUpdatedWatcher;
import com.tencent.qqmail.bottle.model.Bottler;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingBottleActivity$3
  implements BottlerController.MyInformationUpdatedWatcher
{
  SettingBottleActivity$3(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131691003, 1).show();
  }
  
  public void onMyInformationUpdatedInMainThread(Bottler paramBottler)
  {
    if (SettingBottleActivity.access$100(this.this$0) == true)
    {
      SettingBottleActivity.access$102(this.this$0, false);
      this.this$0.getTips().hide();
      this.this$0.getTips().showSuccess(this.this$0.getString(2131719978));
      if (SettingBottleActivity.access$000(this.this$0) != null)
      {
        SettingBottleActivity.access$200(this.this$0).setAvatar(SettingBottleActivity.access$000(this.this$0));
        SettingBottleActivity.access$300(this.this$0).setDetail(SettingBottleActivity.access$200(this.this$0).getBitmap());
      }
      return;
    }
    SettingBottleActivity.access$400(this.this$0, paramBottler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.3
 * JD-Core Version:    0.7.0.1
 */