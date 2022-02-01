package com.tencent.imcore.message;

import achq;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QQMessageFacade$2
  implements Runnable
{
  QQMessageFacade$2(QQMessageFacade paramQQMessageFacade, MessageRecord paramMessageRecord, achq paramachq, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this.this$0.c(this.e, this.f, this.aQe);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.e("Q.msg.QQMessageFacade", 1, "smr error :", localRuntimeException);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.2
 * JD-Core Version:    0.7.0.1
 */