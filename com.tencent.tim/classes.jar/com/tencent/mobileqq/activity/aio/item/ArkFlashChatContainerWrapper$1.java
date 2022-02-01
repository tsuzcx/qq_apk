package com.tencent.mobileqq.activity.aio.item;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.qphone.base.util.QLog;

class ArkFlashChatContainerWrapper$1
  implements Runnable
{
  ArkFlashChatContainerWrapper$1(ArkFlashChatContainerWrapper paramArkFlashChatContainerWrapper, String paramString) {}
  
  public void run()
  {
    this.this$0.mExtraTimerRecord.getAppFromLocal = true;
    this.this$0.mExtraTimerRecord.endOfGetApp = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
    }
    ArkDispatchTask.getInstance().postToMainThread(new ArkFlashChatContainerWrapper.1.1(this));
    this.this$0.loadArkApp(this.val$appPath, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.1
 * JD-Core Version:    0.7.0.1
 */