package com.tencent.qqmail.activity.setting;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class SettingBottleActivity$7
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  SettingBottleActivity$7(SettingBottleActivity paramSettingBottleActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new SettingBottleActivity.7.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingBottleActivity.7
 * JD-Core Version:    0.7.0.1
 */