package com.tencent.qqmail.attachment.util;

import android.os.Handler;
import android.os.Message;
import com.tencent.qqmail.utilities.ui.QMTips;

class AttachOperateMore$3
  extends Handler
{
  AttachOperateMore$3(AttachOperateMore paramAttachOperateMore) {}
  
  public void handleMessage(Message paramMessage)
  {
    AttachOperateMore.access$200(this.this$0).hide();
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (AttachOperateMore.SaveInfo)paramMessage.obj;
      AttachOperateMore.access$300(this.this$0, paramMessage.path, paramMessage.name, paramMessage.result, paramMessage.finish);
      return;
    }
    paramMessage = (AttachOperateMore.SaveInfo)paramMessage.obj;
    AttachOperateMore.access$300(this.this$0, "", "", paramMessage.result, paramMessage.finish);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore.3
 * JD-Core Version:    0.7.0.1
 */