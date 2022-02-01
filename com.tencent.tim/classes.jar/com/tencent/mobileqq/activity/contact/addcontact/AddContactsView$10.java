package com.tencent.mobileqq.activity.contact.addcontact;

import accv;
import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class AddContactsView$10
  implements Runnable
{
  AddContactsView$10(AddContactsView paramAddContactsView, StringBuilder paramStringBuilder) {}
  
  public void run()
  {
    int i = this.this$0.c.Am();
    if (i != 0) {
      this.val$sb.append(accv.dR[i]).append("、");
    }
    Object localObject = this.this$0.c.N();
    localObject = this.this$0.c.B(localObject[0], localObject[1]);
    if (!accv.dS[0].equals(localObject)) {
      this.val$sb.append((String)localObject).append("、");
    }
    i = this.this$0.c.Ak();
    if ((i != 0) && (i != accv.dU.length - 1)) {
      this.val$sb.append(accv.dV[i]).append("、");
    }
    if (this.this$0.bnH) {
      if ((this.this$0.cR != null) && (this.this$0.bnI)) {
        if ("-1".equals(this.this$0.cR[0]))
        {
          localObject = ((acff)this.this$0.app.getManager(51)).b(this.this$0.app.getCurrentAccountUin());
          if (localObject == null) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        this.this$0.cR = ((Card)localObject).strLocationCodes.split("-");
        if (QLog.isColorLevel()) {
          QLog.d("AddContactsView", 2, "card.strLocationCodes = " + ((Card)localObject).strLocationCodes);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          this.this$0.cR[3] = "0";
          localObject = this.this$0.c.e(this.this$0.cR);
          this.this$0.c.H(this.this$0.cR);
          this.this$0.c.bZ(0, (String)localObject);
          if (!"0".equals(this.this$0.cR[0])) {
            this.val$sb.append(this.this$0.c.jd((String)localObject)).append("、");
          }
          localObject = this.this$0.c.dw(1);
          if (!((String)localObject).startsWith("不限")) {
            this.val$sb.append(this.this$0.c.jd((String)localObject)).append("、");
          }
          i = this.this$0.c.Al();
          if (i != 0) {
            this.val$sb.append(accv.dT[i]).append("、");
          }
          this.this$0.c.cHZ();
          this.this$0.app.runOnUiThread(new AddContactsView.10.1(this));
          return;
          localException1 = localException1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AddContactsView", 2, "spliteLocationString | exception: ", localException1);
          continue;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AddContactsView", 2, "parseLocationDesc", localException2);
          continue;
        }
      }
      String str = this.this$0.c.dw(0);
      if (!str.startsWith("不限")) {
        this.val$sb.append(this.this$0.c.jd(str)).append("、");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.10
 * JD-Core Version:    0.7.0.1
 */