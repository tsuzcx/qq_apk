package com.tencent.mobileqq.mini.widget;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AuthDialog$6
  implements View.OnClickListener
{
  AuthDialog$6(AuthDialog paramAuthDialog, List paramList) {}
  
  public void onClick(View paramView)
  {
    AuthDialog.access$600(this.this$0, (INTERFACE.StSubscribeMessage)this.val$subMsgNoMaintainAuth.get(2));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog.6
 * JD-Core Version:    0.7.0.1
 */