package com.tencent.mobileqq.activity.aio.rebuild;

import acff;
import akti;
import amey;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import ybb;

public class LimitChatPie$9
  implements Runnable
{
  public LimitChatPie$9(ybb paramybb, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.aPi)) {
      this.this$0.Cu.setText(ybb.a(this.this$0));
    }
    for (;;)
    {
      localObject = (amey)this.this$0.a(45);
      if (!((amey)localObject).apu()) {
        break;
      }
      return;
      this.this$0.Cu.setText(this.aPi);
    }
    boolean bool = true;
    if ((this.blf) || (((amey)localObject).avM()) || (!this.this$0.aTa)) {
      bool = false;
    }
    Object localObject = ((acff)this.this$0.app.getManager(51)).e(this.this$0.sessionInfo.aTl);
    akti.a().a((Friends)localObject, this.this$0.Cu, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9
 * JD-Core Version:    0.7.0.1
 */