package com.tencent.mobileqq.troop.utils;

import ahav;
import android.text.TextUtils;
import aocq;
import apbr;
import apsq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;

public class TroopFileTransferManager$6$1
  implements Runnable
{
  public TroopFileTransferManager$6$1(apsq paramapsq, String paramString, apbr paramapbr) {}
  
  public void run()
  {
    String str = this.coE;
    if (!TextUtils.isEmpty(this.e.mFileId)) {
      str = this.e.mFileId;
    }
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)this.a.this$0.mApp.b().a(String.valueOf(this.a.this$0.mTroopUin), 1, str);
    QQAppInterface localQQAppInterface = this.a.this$0.mApp;
    if (localMessageForTroopFile != null)
    {
      str = localMessageForTroopFile.fileName;
      long l = ahav.d(localQQAppInterface, str);
      if ((localMessageForTroopFile == null) || (localMessageForTroopFile.fileSize > l)) {
        break label138;
      }
      ((aocq)this.a.this$0.mApp.getManager(272)).aE(localMessageForTroopFile);
    }
    label138:
    while (!QLog.isColorLevel())
    {
      return;
      str = "";
      break;
    }
    QLog.e("AIOMessageSpreadManager", 1, "can't find troopFile Msg, troop[" + this.a.this$0.mTroopUin + "], id:" + this.e.mFileId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.6.1
 * JD-Core Version:    0.7.0.1
 */