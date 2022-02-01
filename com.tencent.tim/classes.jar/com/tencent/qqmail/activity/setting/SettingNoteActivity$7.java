package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup;
import com.tencent.qqmail.utilities.uitableview.QMRadioGroup.OnCheckedChangeListener;

class SettingNoteActivity$7
  implements QMRadioGroup.OnCheckedChangeListener
{
  SettingNoteActivity$7(SettingNoteActivity paramSettingNoteActivity) {}
  
  public void onCheckedChanged(QMRadioGroup paramQMRadioGroup, int paramInt)
  {
    QMSettingManager.sharedInstance().setNoteImgCompressRatio(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingNoteActivity.7
 * JD-Core Version:    0.7.0.1
 */