package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Message;
import com.tencent.token.cw;
import com.tencent.token.global.f;

class yv
  extends cb
{
  yv(SettingSubmitCommentActivity paramSettingSubmitCommentActivity)
  {
    super(paramSettingSubmitCommentActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.isFinishing())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 != 0)
    {
      if (paramMessage.arg1 == 101)
      {
        SettingSubmitCommentActivity.access$200(this.a).b(0L, SettingSubmitCommentActivity.access$000(this.a), SettingSubmitCommentActivity.access$100(this.a));
        return;
      }
      this.a.dismissDialog();
      paramMessage = (f)paramMessage.obj;
      if ((paramMessage.c == null) || (paramMessage.c.length() == 0)) {
        f.a(this.a.getResources(), paramMessage);
      }
      this.a.showUserDialog(paramMessage.c);
      return;
    }
    this.a.dismissDialog();
    this.a.showOrangeToast(this.a.getResources().getString(2131231440), 2130838018);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.yv
 * JD-Core Version:    0.7.0.1
 */