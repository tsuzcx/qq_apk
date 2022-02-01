package com.tencent.qqmail.attachment.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.attachment.model.AttachmentUI;

class ZipOnlinePreviewActivity$7
  implements AdapterView.OnItemClickListener
{
  ZipOnlinePreviewActivity$7(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AttachmentUI localAttachmentUI = (AttachmentUI)ZipOnlinePreviewActivity.access$1100(this.this$0).getItem(paramInt);
    if (localAttachmentUI.getType().equals("back")) {
      this.this$0.back();
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (localAttachmentUI.getType().equals("dir")) {
        ZipOnlinePreviewActivity.access$1200(this.this$0, paramInt);
      } else {
        ZipOnlinePreviewActivity.access$1300(this.this$0, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.7
 * JD-Core Version:    0.7.0.1
 */