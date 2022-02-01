package com.tencent.mobileqq.activity.qwallet;

import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;
import zyr;

public class RedPacketEmojiFragment$4$1
  implements Runnable
{
  public RedPacketEmojiFragment$4$1(zyr paramzyr, int paramInt, PreloadManager.PathResult paramPathResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RedPacketEmojiFragment", 2, "face config doLoading result:" + this.val$resCode + ",pathres=" + this.val$pathRes);
    }
    if (this.val$resCode == 0)
    {
      this.a.a.bbo = this.val$pathRes.filePath;
      this.a.a.csy();
      return;
    }
    this.a.a.csz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.4.1
 * JD-Core Version:    0.7.0.1
 */