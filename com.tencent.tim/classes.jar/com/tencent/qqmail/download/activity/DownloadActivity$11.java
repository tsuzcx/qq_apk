package com.tencent.qqmail.download.activity;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.qqmail.activity.sdcardfileexplorer.SdcardFileExplorer;
import com.tencent.qqmail.activity.setting.SettingAutoClearAttachmentsActivity;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import org.apache.commons.lang3.StringUtils;

class DownloadActivity$11
  extends QMListPopupWindow
{
  DownloadActivity$11(DownloadActivity paramDownloadActivity, Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    QMLog.log(4, "DownloadActivity", "click popupWindow view: " + paramAdapterView);
    if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131692962)))
    {
      QMLog.log(4, "DownloadActivity", "default download path:" + FileUtil.getAttachDownloadDir());
      IntentUtil.openFileLocation(this.this$0.getActivity(), FileUtil.getAttachDownloadDir());
      DataCollector.logEvent("Event_Click_Open_Download_Path_In_DownloadManager");
    }
    do
    {
      return;
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131692959)))
      {
        paramAdapterView = SdcardFileExplorer.createIntentToSelectPath(this.this$0, FileUtil.getAttachDownloadDir(), this.this$0.getString(2131692946));
        this.this$0.startActivityForResult(paramAdapterView, 1);
        DataCollector.logEvent("Event_Click_Change_Download_Path_In_DownloadManager");
        return;
      }
      if (StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131692958)))
      {
        paramAdapterView = SettingAutoClearAttachmentsActivity.createIntent();
        this.this$0.startActivity(paramAdapterView);
        DataCollector.logEvent("Event_Click_Reset_Default_Download_Path_In_DownloadManager");
        return;
      }
    } while (!StringUtils.equalsIgnoreCase(paramAdapterView, this.this$0.getString(2131692961)));
    DownloadActivity.access$1800(this.this$0, QMPathManager.sharedInstance().getAttachDownloadPath());
    DataCollector.logEvent("Event_Click_Change_Period_Clear_Time_In_DownloadManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.download.activity.DownloadActivity.11
 * JD-Core Version:    0.7.0.1
 */