package com.tencent.mobileqq.mini.share;

import android.text.TextUtils;
import aqhq;
import com.tencent.qphone.base.util.QLog;

final class MiniArkShareAsyncManager$2
  implements Runnable
{
  MiniArkShareAsyncManager$2(String paramString) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.val$filePath)) && (aqhq.deleteFile(this.val$filePath))) {
      QLog.d("MiniArkShareAsyncManage [miniappArkShare]", 2, "removeArkShareLocalTemporaryFile() called with: filePath = [" + this.val$filePath + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager.2
 * JD-Core Version:    0.7.0.1
 */