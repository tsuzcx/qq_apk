package com.tencent.qqmail.attachment.util;

import android.content.Context;
import com.tencent.qqmail.utilities.observer.ICallBack;
import com.tencent.qqmail.utilities.observer.IObserver;
import com.tencent.qqmail.utilities.ui.QMTips;
import java.util.Observable;

class AttachOperateMore$2
  extends IObserver
{
  AttachOperateMore$2(AttachOperateMore paramAttachOperateMore, ICallBack paramICallBack)
  {
    super(paramICallBack);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    AttachOperateMore.access$200(this.this$0).showError(AttachOperateMore.access$100(this.this$0).getString(2131718938));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachOperateMore.2
 * JD-Core Version:    0.7.0.1
 */