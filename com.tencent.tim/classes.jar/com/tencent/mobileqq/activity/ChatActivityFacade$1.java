package com.tencent.mobileqq.activity;

import akxb;
import aooi;
import aool;
import aool.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

public final class ChatActivityFacade$1
  implements Runnable
{
  public ChatActivityFacade$1(MessageForPtt paramMessageForPtt, QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, akxb paramakxb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop + " itemType " + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.itemType + " uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq);
    }
    aool localaool = new aool();
    localaool.mSelfUin = this.val$app.getAccount();
    localaool.mPeerUin = this.Mu;
    localaool.mUinType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.istroop;
    localaool.mFileType = 2;
    localaool.mUniseq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.uniseq;
    localaool.cNy = false;
    localaool.cmo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.urlAtServer;
    localaool.clR = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getLocalFilePath();
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSendFromOtherTerminal()) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.isSend()))
    {
      bool = true;
      localaool.cNz = bool;
      localaool.mMd5 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.md5;
      localaool.apQ = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileID;
      localaool.clM = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.groupFileKeyStr;
      localaool.dQF = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.subVersion;
      localaool.F = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
      if (!this.aTm) {
        break label286;
      }
    }
    for (;;)
    {
      localaool.dpB = i;
      localaool.b = this.jdField_a_of_type_Akxb;
      localaool.en = new aool.e(this.lM, this.bER);
      this.val$app.a().a(localaool);
      return;
      bool = false;
      break;
      label286:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.1
 * JD-Core Version:    0.7.0.1
 */