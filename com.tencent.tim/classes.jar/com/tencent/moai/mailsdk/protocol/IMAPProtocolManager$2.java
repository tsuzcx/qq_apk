package com.tencent.moai.mailsdk.protocol;

import android.util.Log;
import com.tencent.moai.mailsdk.callback.FolderListCallBack;
import com.tencent.moai.mailsdk.callback.TaskCallBack;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.util.log.Logger;

class IMAPProtocolManager$2
  implements TaskCallBack
{
  IMAPProtocolManager$2(IMAPProtocolManager paramIMAPProtocolManager, Profile paramProfile, FolderListCallBack paramFolderListCallBack) {}
  
  public void onError(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MessageException))
    {
      paramThrowable = (MessageException)paramThrowable;
      Logger.log(6, "IMAPProtocolManager", "fetch folder list error:" + paramThrowable.getResultCode() + ":" + paramThrowable.getDetailCode() + ":" + paramThrowable.getDetailMessage());
      Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramThrowable));
      if (IMAPProtocolManager.access$000(this.this$0, paramThrowable)) {
        IMAPProtocolManager.access$100(this.this$0, this.val$profile, paramThrowable);
      }
      if (this.val$folderListCallBack != null) {
        this.val$folderListCallBack.onRetrieveFoldersError(paramThrowable.getResultCode(), paramThrowable.getDetailCode(), paramThrowable.getDetailMessage());
      }
    }
    do
    {
      return;
      Logger.log(6, "IMAPProtocolManager", Log.getStackTraceString(paramThrowable));
    } while (this.val$folderListCallBack == null);
    this.val$folderListCallBack.onRetrieveFoldersError(1, 200001, paramThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.IMAPProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */