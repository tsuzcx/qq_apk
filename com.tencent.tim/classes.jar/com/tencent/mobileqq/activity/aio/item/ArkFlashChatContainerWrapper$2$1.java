package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import wyw;
import wzw;

public class ArkFlashChatContainerWrapper$2$1
  implements Runnable
{
  public ArkFlashChatContainerWrapper$2$1(wzw paramwzw, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    int i;
    if (this.val$success) {
      if (this.val$data != null)
      {
        i = this.val$data.getInt("resourceId");
        if ((i != -1) && (this.a.this$0.bSD == i))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp", 2, "onDownloadRes onSuccess resouceId " + i);
          }
          FlashChatManager localFlashChatManager = (FlashChatManager)wyw.getAppInterface().getManager(217);
          ArkFlashChatContainerWrapper.b(this.a.this$0).path = localFlashChatManager.i(this.a.this$0.bSD, ArkFlashChatContainerWrapper.c(this.a.this$0).name, ArkFlashChatContainerWrapper.d(this.a.this$0).appMinVersion);
          this.a.this$0.loadArkApp(ArkFlashChatContainerWrapper.e(this.a.this$0).path, 0, null);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (this.val$data == null);
      i = this.val$data.getInt("resourceId");
    } while ((i == -1) || (this.a.this$0.bSD != i));
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 2, "onDownloadRes onError resouceId " + i);
    }
    this.a.this$0.loadArkApp(ArkFlashChatContainerWrapper.f(this.a.this$0).path, -2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.2.1
 * JD-Core Version:    0.7.0.1
 */