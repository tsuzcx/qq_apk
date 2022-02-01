package com.tencent.mobileqq.apollo.view;

import abzy;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$20
  implements Runnable
{
  ApolloPanel$20(ApolloPanel paramApolloPanel, ApolloLinearLayout.a parama) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.d == null) || (this.this$0.mBaseChatPie == null) || (this.this$0.mBaseChatPie.mContext == null) || (this.a.sk == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "holder.apolloInfo == null");
      }
      return;
    }
    this.a.sk.setBackgroundDrawable(this.a.d.a(this.this$0.mBaseChatPie.mContext, this.this$0.mBaseChatPie.mContext.getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.20
 * JD-Core Version:    0.7.0.1
 */