package com.tencent.mobileqq.doutu;

import acff;
import afdw;
import afeb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$3
  implements Runnable
{
  public DoutuManager$3(afdw paramafdw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetDoutuList : run begin .");
    }
    afdw.a(this.this$0, 1);
    NewIntent localNewIntent = new NewIntent(afdw.a(this.this$0).getApp(), afeb.class);
    long l = Long.valueOf(afdw.a(this.this$0).getCurrentAccountUin()).longValue();
    localNewIntent.putExtra("KEY_SRC_UIN", l);
    localNewIntent.putExtra("KEY_CMD", 1);
    Object localObject = (acff)afdw.a(this.this$0).getManager(51);
    int i;
    if (localObject != null)
    {
      localObject = ((acff)localObject).b(afdw.a(this.this$0).getCurrentAccountUin());
      if (localObject != null)
      {
        i = ((Card)localObject).age;
        localNewIntent.putExtra("KEY_AGE", ((Card)localObject).age);
        localNewIntent.putExtra("key_gender", ((Card)localObject).shGender);
        afdw.a(this.this$0, (Card)localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuManager", 2, "postGetDoutuList : curUin = " + l + ", age = " + i);
      }
      afdw.a(this.this$0).startServlet(localNewIntent);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.3
 * JD-Core Version:    0.7.0.1
 */