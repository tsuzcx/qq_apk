package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;

class GetTextDraftJob$1
  implements Runnable
{
  GetTextDraftJob$1(GetTextDraftJob paramGetTextDraftJob, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)GetTextDraftJob.a(this.this$0).get();
    if (localBaseChatPie == null)
    {
      QLog.i("GetTextDraftJob", 1, "base chat pie has been recycled");
      return;
    }
    if (QLog.isColorLevel())
    {
      if (this.a == null) {
        break label89;
      }
      QLog.i("GetTextDraftJob", 2, "source seq=" + this.a.sourceMsgSeq);
    }
    for (;;)
    {
      localBaseChatPie.a.post(new GetTextDraftJob.1.1(this, localBaseChatPie));
      return;
      label89:
      QLog.i("GetTextDraftJob", 2, "draft text info is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob.1
 * JD-Core Version:    0.7.0.1
 */