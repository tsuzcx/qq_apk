package com.tencent.qqmail;

import com.tencent.qqmail.activity.watcher.ForwardToWeiYunWatcher;
import com.tencent.qqmail.attachment.activity.AttachSaveToWeiYunActivity;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.thread.Threads;

class BaseActivityImpl$19
  implements ForwardToWeiYunWatcher
{
  BaseActivityImpl$19(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void onError(int paramInt)
  {
    if ((!AppStatusUtil.isAppOnForeground()) || ((BaseActivityImpl.access$000(this.this$0).getActivity() instanceof AttachSaveToWeiYunActivity))) {
      return;
    }
    Threads.runOnMainThread(new BaseActivityImpl.19.2(this));
  }
  
  public void onSuccess()
  {
    if ((!AppStatusUtil.isAppOnForeground()) || ((BaseActivityImpl.access$000(this.this$0).getActivity() instanceof AttachSaveToWeiYunActivity))) {
      return;
    }
    Threads.runOnMainThread(new BaseActivityImpl.19.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.19
 * JD-Core Version:    0.7.0.1
 */