package com.dataline.activities;

import acbn;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anre;
import aofk;
import aqgv;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;

class LiteActivity$36
  implements Runnable
{
  LiteActivity$36(LiteActivity paramLiteActivity, QQMessageFacade.Message paramMessage, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (((this.a.senderuin == null) || (!this.a.senderuin.equalsIgnoreCase(this.this$0.app.getCurrentAccountUin()))) && (!this.this$0.aM))
    {
      if (this.this$0.A == null)
      {
        this.this$0.A = new TextView(this.this$0);
        this.this$0.A.setId(2131372043);
        this.this$0.A.setSingleLine();
        this.this$0.A.setBackgroundDrawable(this.this$0.getResources().getDrawable(2130839290));
        this.this$0.A.setGravity(17);
        this.this$0.A.setTextSize(2, 14.0F);
        this.this$0.A.setBackgroundResource(2130839290);
        this.this$0.A.setTextColor(this.this$0.getResources().getColorStateList(2131167375));
        this.this$0.A.setPadding((int)(LiteActivity.a(this.this$0) * 10.0F), this.this$0.A.getPaddingTop(), (int)(LiteActivity.b(this.this$0) * 10.0F), this.this$0.A.getPaddingBottom());
        localObject = new RelativeLayout.LayoutParams(-1, (int)this.this$0.getResources().getDimension(2131297318));
        this.this$0.f.addView(this.this$0.A, (ViewGroup.LayoutParams)localObject);
        this.this$0.A.setOnClickListener(this.this$0);
      }
      this.this$0.A.setVisibility(0);
      if (this.a.msgtype != -2016) {
        break label510;
      }
      localObject = this.a.msg.split("\\|");
      if ((localObject == null) || (localObject.length <= 0)) {
        break label504;
      }
      localObject = localObject[0].trim();
      localStringBuilder = new StringBuilder();
      if (this.a.nickName == null) {
        break label568;
      }
      localStringBuilder.append(this.val$intent.getStringExtra("uinname"));
      localStringBuilder.append("-");
      localStringBuilder.append(this.a.nickName);
      label388:
      localStringBuilder.append(":");
      if (!(localObject instanceof aofk)) {
        break label906;
      }
    }
    for (;;)
    {
      try
      {
        this.this$0.A.setText(((aofk)localObject).a(localStringBuilder.toString(), true, new int[] { 1, 16 }));
        this.this$0.A.requestLayout();
        this.this$0.A.setTag(this.val$intent);
        localObject = this.this$0.A.getHandler();
        if (localObject != null)
        {
          ((Handler)localObject).removeCallbacks(this.this$0.g);
          ((Handler)localObject).postDelayed(this.this$0.g, 10000L);
        }
        return;
        label504:
        localObject = "";
        break;
        label510:
        if (this.a.msgtype == -2011)
        {
          localObject = anre.a(this.a.msgData);
          if (localObject != null)
          {
            localObject = ((AbsStructMsg)localObject).mMsgBrief;
            break;
          }
          localObject = this.a.msg;
          break;
        }
        localObject = this.a.getMessageText();
        break;
        label568:
        String str3 = this.val$intent.getStringExtra("uinname");
        if ((str3 == null) || (str3.length() == 0))
        {
          localStringBuilder.append(this.a.frienduin);
          break label388;
        }
        String str2;
        String str1;
        if (7000 == this.a.istroop)
        {
          str2 = this.val$intent.getStringExtra("subAccountLatestNick");
          if (str2 != null)
          {
            str1 = str2;
            if (str2.length() != 0) {}
          }
          else
          {
            str1 = this.a.senderuin;
          }
          localStringBuilder.append(str3);
          localStringBuilder.append("-");
          localStringBuilder.append(str1);
          break label388;
        }
        if ((1010 == this.a.istroop) || (1001 == this.a.istroop) || (10002 == this.a.istroop))
        {
          if (String.valueOf(acbn.bkE).equals(this.a.frienduin))
          {
            str2 = aqgv.G(this.this$0.app, this.a.senderuin);
            str1 = str2;
            if (TextUtils.isEmpty(str2)) {
              str1 = this.a.senderuin;
            }
            localStringBuilder.append(str3);
            localStringBuilder.append("-");
            localStringBuilder.append(str1);
            if (this.a.msgtype != -1024) {
              break label388;
            }
            localObject = String.format(this.this$0.getResources().getString(2131700986), new Object[] { str1 });
            break label388;
          }
          str2 = aqgv.G(this.this$0.app, this.a.frienduin);
          str1 = str2;
          if (!TextUtils.isEmpty(str2)) {
            continue;
          }
          str1 = this.a.frienduin;
          continue;
        }
        localStringBuilder.append(str3);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(LiteActivity.TAG, 2, localException.toString());
        continue;
      }
      label906:
      localStringBuilder.append(localException);
      this.this$0.A.setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.36
 * JD-Core Version:    0.7.0.1
 */