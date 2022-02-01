package com.tencent.qqmail.attachment.activity;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmail.attachment.model.AttachmentUI;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.util.Stack;

class ZipOnlinePreviewActivity$8
  extends Handler
{
  ZipOnlinePreviewActivity$8(ZipOnlinePreviewActivity paramZipOnlinePreviewActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      ZipOnlinePreviewActivity.access$1400(this.this$0).push(ZipOnlinePreviewActivity.access$300(this.this$0).getAttachmentUIs());
      ZipOnlinePreviewActivity.access$1500(this.this$0);
      ZipOnlinePreviewActivity.access$1600(this.this$0);
      return;
    case 1: 
      QMUIHelper.showToast(this.this$0, 2131696288, "");
      ZipOnlinePreviewActivity.access$1600(this.this$0);
      return;
    }
    QMUIHelper.showToast(this.this$0, 2131692375, "");
    ZipOnlinePreviewActivity.access$1600(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.activity.ZipOnlinePreviewActivity.8
 * JD-Core Version:    0.7.0.1
 */