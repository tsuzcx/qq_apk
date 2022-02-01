package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ausb;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

class BaseChatPie$41
  implements Runnable
{
  BaseChatPie$41(BaseChatPie paramBaseChatPie, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    if ((!this.this$0.sessionInfo.aTl.equals(this.a.frienduin)) && ((this.a.senderuin == null) || (!this.a.senderuin.equalsIgnoreCase(this.this$0.app.getCurrentAccountUin()))) && (!this.this$0.aM))
    {
      if (this.this$0.A == null)
      {
        BaseChatPie.a(this.this$0, new View(this.this$0.mContext));
        BaseChatPie.a(this.this$0).setId(2131372046);
        BaseChatPie.a(this.this$0).setBackgroundColor(this.this$0.mContext.getResources().getColor(2131166713));
        localObject = new RelativeLayout.LayoutParams(-1, 1);
        this.this$0.f.addView(BaseChatPie.a(this.this$0), (ViewGroup.LayoutParams)localObject);
        this.this$0.A = new TextView(this.this$0.mContext);
        this.this$0.A.setId(2131372043);
        this.this$0.A.setSingleLine();
        this.this$0.A.setBackgroundDrawable(this.this$0.mContext.getResources().getDrawable(2130839290));
        this.this$0.A.setGravity(17);
        this.this$0.A.setTextSize(2, 14.0F);
        this.this$0.A.setBackgroundResource(2130839290);
        this.this$0.A.setTextColor(this.this$0.mContext.getResources().getColorStateList(2131167375));
        this.this$0.A.setPadding((int)(this.this$0.mDensity * 10.0F), this.this$0.A.getPaddingTop(), (int)(this.this$0.mDensity * 10.0F), this.this$0.A.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.mContext.getResources().getDimension(2131297318));
        ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131372046);
        this.this$0.f.addView(this.this$0.A, (ViewGroup.LayoutParams)localObject);
        this.this$0.A.setOnClickListener(this.this$0);
      }
      if ((!ChatActivityUtils.fY(this.this$0.sessionInfo.cZ)) && (!ChatActivityUtils.e(this.this$0.app, this.this$0.sessionInfo))) {
        break label577;
      }
      BaseChatPie.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      this.this$0.A.setVisibility(0);
      ThreadManager.postImmediately(new BaseChatPie.41.1(this), null, true);
      this.this$0.A.requestLayout();
      this.this$0.A.setTag(this.val$intent);
      localObject = this.this$0.A.getHandler();
      if (localObject != null)
      {
        ((Handler)localObject).removeCallbacks(this.this$0.g);
        ((Handler)localObject).postDelayed(this.this$0.g, 10000L);
      }
      ausb.a(this.this$0.app).a(this.a, this.this$0.A);
      this.this$0.bIE();
      return;
      label577:
      BaseChatPie.a(this.this$0).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.41
 * JD-Core Version:    0.7.0.1
 */