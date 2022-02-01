package com.tencent.qqmail.attachment.activity;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;

class ZipInnerAttachDownloadActivity$3
  extends QMListPopupWindow
{
  ZipInnerAttachDownloadActivity$3(ZipInnerAttachDownloadActivity paramZipInnerAttachDownloadActivity, Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = ((TextView)paramView.findViewById(2131373495)).getText().toString();
    if (paramAdapterView.equals(this.this$0.getString(2131690582)))
    {
      ZipInnerAttachDownloadActivity.access$100(this.this$0);
      if (ZipInnerAttachDownloadActivity.access$200(this.this$0) != null) {
        DataCollector.logEvent("Event_Click_SaveAs_From_FtnDetail");
      }
    }
    while (!paramAdapterView.equals(this.this$0.getString(2131690558)))
    {
      return;
      DataCollector.logEvent("Event_Click_SaveAs_From_AttachDetail");
      return;
    }
    ZipInnerAttachDownloadActivity.access$300(this.this$0);
    DataCollector.logEvent("Event_Attach_Open_Save_Path_From_AttachDetail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipInnerAttachDownloadActivity.3
 * JD-Core Version:    0.7.0.1
 */