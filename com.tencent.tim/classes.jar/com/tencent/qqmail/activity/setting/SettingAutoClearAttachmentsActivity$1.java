package com.tencent.qqmail.activity.setting;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;

class SettingAutoClearAttachmentsActivity$1
  implements UITableView.ClickListener
{
  SettingAutoClearAttachmentsActivity$1(SettingAutoClearAttachmentsActivity paramSettingAutoClearAttachmentsActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool2 = true;
    if (SettingAutoClearAttachmentsActivity.access$000(this.this$0) == paramUITableItemView) {
      DataCollector.logEvent("Event_Click_Clear_Cache_No");
    }
    if (SettingAutoClearAttachmentsActivity.access$100(this.this$0) == paramUITableItemView) {
      DataCollector.logEvent("Event_Click_Clear_Cache_Threeday");
    }
    if (SettingAutoClearAttachmentsActivity.access$200(this.this$0) == paramUITableItemView) {
      DataCollector.logEvent("Event_Click_Clear_Cache_Oneweek");
    }
    if (SettingAutoClearAttachmentsActivity.access$300(this.this$0) == paramUITableItemView) {
      DataCollector.logEvent("Event_Click_Clear_Cache_Tenday");
    }
    Object localObject = SettingAutoClearAttachmentsActivity.access$000(this.this$0);
    if (SettingAutoClearAttachmentsActivity.access$000(this.this$0) == paramUITableItemView)
    {
      bool1 = true;
      ((UITableItemView)localObject).setChecked(bool1);
      localObject = SettingAutoClearAttachmentsActivity.access$100(this.this$0);
      if (SettingAutoClearAttachmentsActivity.access$100(this.this$0) != paramUITableItemView) {
        break label259;
      }
      bool1 = true;
      label118:
      ((UITableItemView)localObject).setChecked(bool1);
      localObject = SettingAutoClearAttachmentsActivity.access$200(this.this$0);
      if (SettingAutoClearAttachmentsActivity.access$200(this.this$0) != paramUITableItemView) {
        break label264;
      }
      bool1 = true;
      label147:
      ((UITableItemView)localObject).setChecked(bool1);
      localObject = SettingAutoClearAttachmentsActivity.access$300(this.this$0);
      if (SettingAutoClearAttachmentsActivity.access$300(this.this$0) != paramUITableItemView) {
        break label269;
      }
    }
    label259:
    label264:
    label269:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((UITableItemView)localObject).setChecked(bool1);
      localObject = this.this$0.getSharedPreferences("clear_attachment_period", 0);
      QMSharedPreferenceManager.getInstance().setClearAttachmentCacheTimeByUser(((Integer)paramUITableItemView.getTag()).intValue() * 24 * 3600 * 1000);
      ((SharedPreferences)localObject).edit().putInt("clear_attachment_period_level", ((Integer)paramUITableItemView.getTag()).intValue()).apply();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label118;
      bool1 = false;
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAutoClearAttachmentsActivity.1
 * JD-Core Version:    0.7.0.1
 */