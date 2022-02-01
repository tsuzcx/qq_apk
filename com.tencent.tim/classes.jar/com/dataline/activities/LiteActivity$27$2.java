package com.dataline.activities;

import acqp;
import acxt;
import ao;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qphone.base.util.QLog;
import db;

public class LiteActivity$27$2
  implements Runnable
{
  public LiteActivity$27$2(ao paramao, boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    if (!this.aW) {
      this.a.this$0.d(1048576L);
    }
    DataLineMsgRecord localDataLineMsgRecord = this.a.this$0.app.b().a(this.cQ).a(this.ad);
    DataLineMsgSet localDataLineMsgSet = this.a.this$0.app.a(this.cQ).b(this.ad);
    if ((localDataLineMsgSet != null) && (!localDataLineMsgSet.isSingle())) {
      if (!this.a.this$0.jdField_a_of_type_Db.a(this.ad, this.a.this$0.mListView)) {
        this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      this.a.this$0.app.b().a(this.cQ).cNX();
      if (QLog.isColorLevel()) {
        QLog.d(LiteActivity.TAG, 2, "LiteActivity.onRecvFile, msgId[" + this.ad + "], sPath = " + this.val$path + "], set[" + localDataLineMsgSet + "], msgItem[" + localDataLineMsgRecord);
      }
      return;
      this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
      if ((localDataLineMsgRecord != null) && (!localDataLineMsgRecord.bIsResendOrRecvFile))
      {
        LiteActivity.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.a.this$0.mListView);
        LiteActivity.a(this.a.this$0.mListView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.2
 * JD-Core Version:    0.7.0.1
 */