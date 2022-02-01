package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class ReadInJoyFeedsActivity$3
  implements Runnable
{
  ReadInJoyFeedsActivity$3(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity) {}
  
  public void run()
  {
    QQMessageFacade localQQMessageFacade = this.this$0.app.b();
    if (localQQMessageFacade != null)
    {
      int i = localQQMessageFacade.bl();
      this.this$0.oP(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.3
 * JD-Core Version:    0.7.0.1
 */