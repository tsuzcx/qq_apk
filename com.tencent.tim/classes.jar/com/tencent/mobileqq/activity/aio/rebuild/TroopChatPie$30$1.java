package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import yex;

public class TroopChatPie$30$1
  implements Runnable
{
  public TroopChatPie$30$1(yex paramyex, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      QQToast.a(this.jdField_a_of_type_Yex.this$0.app.getApp(), 2131693097, 0).show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Yex.this$0.app.getApp(), 2131720463, 0).show();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Yex.this$0.app.getCurrentUin(), "Stick", "Send", "2", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.30.1
 * JD-Core Version:    0.7.0.1
 */