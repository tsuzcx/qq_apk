package com.dataline.activities;

import acqp;
import ao;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import db;

public class LiteActivity$27$6
  implements Runnable
{
  public LiteActivity$27$6(ao paramao, int paramInt) {}
  
  public void run()
  {
    this.a.this$0.jdField_a_of_type_Db.notifyDataSetChanged();
    LiteActivity.a(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.a.this$0.mListView);
    LiteActivity.a(this.a.this$0.mListView);
    this.a.this$0.app.b().a(this.cQ).cNX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.27.6
 * JD-Core Version:    0.7.0.1
 */