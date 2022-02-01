package com.tencent.mobileqq.doutu;

import acff;
import afdv;
import afdw;
import afeb;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class DoutuManager$4
  implements Runnable
{
  public DoutuManager$4(afdw paramafdw, afdv paramafdv, long paramLong, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("DoutuManager", 2, "postGetRecommendPicList item:" + this.b.toString() + ", timeKey:" + this.Xr + ", sessionType:" + this.a.cZ + ", friendUin:" + this.a.aTl);
    }
    NewIntent localNewIntent = new NewIntent(afdw.a(this.this$0).getApp(), afeb.class);
    if (this.a.cZ == 0)
    {
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(afdw.a(this.this$0).getCurrentAccountUin()).longValue());
      if (this.a.cZ != 0) {
        break label351;
      }
    }
    for (;;)
    {
      localNewIntent.putExtra("KEY_SESSION_TYPE", i);
      localNewIntent.putExtra("KEY_TO_UIN", Long.valueOf(this.b.bDe));
      localNewIntent.putExtra("KEY_MD5", this.b.md5);
      localNewIntent.putExtra("key_url", this.b.url);
      localNewIntent.putExtra("KEY_CMD", 6);
      localNewIntent.putExtra("key_sequence", this.Xr);
      if (afdw.a(this.this$0) == null)
      {
        Object localObject = (acff)afdw.a(this.this$0).getManager(51);
        if (localObject != null)
        {
          localObject = ((acff)localObject).b(afdw.a(this.this$0).getCurrentAccountUin());
          if (localObject != null) {
            afdw.a(this.this$0, (Card)localObject);
          }
        }
      }
      if (afdw.a(this.this$0) != null)
      {
        localNewIntent.putExtra("key_gender", afdw.a(this.this$0).shGender);
        localNewIntent.putExtra("KEY_AGE", afdw.a(this.this$0).age);
      }
      afdw.a(this.this$0).startServlet(localNewIntent);
      return;
      localNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(this.a.aTl));
      break;
      label351:
      if ((this.a.cZ == 1) || (this.a.cZ == 3000)) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.4
 * JD-Core Version:    0.7.0.1
 */