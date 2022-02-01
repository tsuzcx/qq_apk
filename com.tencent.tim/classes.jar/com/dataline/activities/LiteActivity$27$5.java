package com.dataline.activities;

import acqp;
import acxt;
import ao;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import db;

public class LiteActivity$27$5
  implements Runnable
{
  public LiteActivity$27$5(ao paramao, int paramInt, long paramLong) {}
  
  public void run()
  {
    DataLineMsgRecord localDataLineMsgRecord = this.a.this$0.app.b().a(this.cQ).a(this.ah);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!localDataLineMsgRecord.isSendFromLocal());
        this.a.this$0.app.b().a(this.cQ).cNX();
        DataLineMsgSet localDataLineMsgSet = this.a.this$0.app.a(this.cQ).b(this.ah);
        if ((localDataLineMsgSet == null) || (localDataLineMsgSet.isSingle())) {
          break;
        }
      } while (this.a.this$0.jdField_a_of_type_Db.a(this.ah, this.a.this$0.mListView));
      this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
      return;
      this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
    } while (localDataLineMsgRecord.bIsResendOrRecvFile);
    LiteActivity.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.a.this$0.mListView);
    LiteActivity.a(this.a.this$0.mListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.5
 * JD-Core Version:    0.7.0.1
 */