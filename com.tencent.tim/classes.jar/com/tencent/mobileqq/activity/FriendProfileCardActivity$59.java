package com.tencent.mobileqq.activity;

import akjp;
import alcn;
import anot;
import aqep;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Locale;

class FriendProfileCardActivity$59
  implements Runnable
{
  FriendProfileCardActivity$59(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    akjp localakjp;
    Object localObject1;
    if (this.this$0.a.e.pa == 0)
    {
      localakjp = (akjp)this.this$0.app.getManager(160);
      i = localakjp.GR();
      localObject1 = null;
    }
    Object localObject2;
    switch (i)
    {
    default: 
      localObject2 = null;
      if (localObject1 != null)
      {
        anot.a(this.this$0.app, "dc00898", "", "", (String)localObject1, (String)localObject1, 0, 0, "", "", "", "");
        anot.a(this.this$0.app, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
      }
      localakjp.MP(true);
      if (aqep.aBZ())
      {
        localObject2 = Locale.getDefault().getCountry();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = this.this$0.app;
        if (this.this$0.a.e.pa != 0) {
          break label235;
        }
      }
      break;
    }
    label235:
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject2, "dc00898", "", "", "0X8008CA2", "0X8008CA2", i, 0, "", "", (String)localObject1, "");
      return;
      localObject1 = "0X8007394";
      localObject2 = "0X8007393";
      break;
      localObject1 = "0X8007399";
      localObject2 = "0X8007398";
      break;
      localObject1 = "0X80073B9";
      localObject2 = "0X80073BA";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.59
 * JD-Core Version:    0.7.0.1
 */