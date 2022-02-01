package com.tencent.mobileqq.app;

import accv;
import acff;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchManager$4$1
  implements Runnable
{
  ConditionSearchManager$4$1(ConditionSearchManager.4 param4) {}
  
  public void run()
  {
    try
    {
      if (this.a.this$0.e != null)
      {
        Card localCard = this.a.this$0.e;
        Object localObject;
        String str;
        if (localCard.strLocationCodes != null)
        {
          localObject = localCard.strLocationCodes.split("-");
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "parse location codes: " + localCard.strLocationCodes);
          }
          str = this.a.this$0.d((String[])localObject);
          localObject = str;
          if (str.equals("不限")) {
            localObject = "";
          }
          localCard.strLocationDesc = ((String)localObject);
        }
        if (localCard.strHometownCodes != null)
        {
          localObject = localCard.strHometownCodes.split("-");
          if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.Manager", 2, "parse hometown codes: " + localCard.strHometownCodes);
          }
          str = this.a.this$0.d((String[])localObject);
          localObject = str;
          if (str.equals("不限")) {
            localObject = "";
          }
          localCard.strHometownDesc = ((String)localObject);
        }
        ((acff)accv.a(this.a.this$0).getManager(51)).a(localCard);
        ((CardHandler)accv.a(this.a.this$0).getBusinessHandler(2)).notifyUI(43, true, localCard);
      }
      this.a.this$0.bHc = false;
      this.a.this$0.e = null;
      this.a.this$0.aW(this.a.this$0.cn);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConditionSearch.Manager", 1, "pendCardParseRequest fail!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.4.1
 * JD-Core Version:    0.7.0.1
 */