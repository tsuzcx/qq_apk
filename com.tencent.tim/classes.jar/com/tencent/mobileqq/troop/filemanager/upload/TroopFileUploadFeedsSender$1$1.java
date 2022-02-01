package com.tencent.mobileqq.troop.filemanager.upload;

import android.text.TextUtils;
import aocq;
import apbr;
import apef;
import apef.b;
import apfu;
import apfv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;

public class TroopFileUploadFeedsSender$1$1
  implements Runnable
{
  public TroopFileUploadFeedsSender$1$1(apfv paramapfv, String paramString, apbr paramapbr) {}
  
  public void run()
  {
    Object localObject = this.coE;
    if (!TextUtils.isEmpty(this.e.mFileId)) {
      localObject = this.e.mFileId;
    }
    QQAppInterface localQQAppInterface = apef.getApp();
    if (localQQAppInterface == null)
    {
      apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.a.coy + "] addToSendCache app=null");
      return;
    }
    localObject = (MessageForTroopFile)localQQAppInterface.b().a(String.valueOf(this.a.a.mTroopUin), 1, (String)localObject);
    if (localObject != null)
    {
      ((aocq)localQQAppInterface.getManager(272)).aE((MessageRecord)localObject);
      return;
    }
    apef.b.e("TroopFileUploadFeedsSender", apef.b.USR, "[" + this.a.a.coy + "] addToSendCache can't find troopFile Msg, troop[" + this.a.a.mTroopUin + "], id:" + this.e.mFileId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
 * JD-Core Version:    0.7.0.1
 */