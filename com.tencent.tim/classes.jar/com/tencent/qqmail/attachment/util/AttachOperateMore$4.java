package com.tencent.qqmail.attachment.util;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.qqmail.utilities.ui.QMTips;

class AttachOperateMore$4
  extends Handler
{
  AttachOperateMore$4(AttachOperateMore paramAttachOperateMore) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 4: 
    default: 
      return;
    case 0: 
      AttachOperateMore.access$200(this.this$0).showSuccess(AttachOperateMore.access$100(this.this$0).getString(2131718941));
      return;
    case 2: 
      AttachOperateMore.access$200(this.this$0).showError(AttachOperateMore.access$100(this.this$0).getString(2131694072));
      return;
    case 5: 
      AttachOperateMore.access$200(this.this$0).showError(AttachOperateMore.access$100(this.this$0).getString(2131694053));
      return;
    case 3: 
      AttachOperateMore.access$200(this.this$0).showSuccess(AttachOperateMore.access$100(this.this$0).getString(2131718940));
      return;
    case 1: 
      AttachOperateMore.access$200(this.this$0).showError(AttachOperateMore.access$100(this.this$0).getString(2131718938));
      return;
    }
    AttachOperateMore.access$200(this.this$0).showError(AttachOperateMore.access$100(this.this$0).getString(2131694069));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore.4
 * JD-Core Version:    0.7.0.1
 */