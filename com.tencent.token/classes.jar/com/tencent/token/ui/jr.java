package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;
import com.tencent.token.utils.w;

class jr
  implements View.OnClickListener
{
  jr(FreezeStatusActivity paramFreezeStatusActivity) {}
  
  public void onClick(View paramView)
  {
    String str = this.a.getString(2131231047);
    QQUser localQQUser = do.a().e();
    paramView = str;
    if (localQQUser != null) {
      paramView = String.format(str, new Object[] { Long.valueOf(localQQUser.b()) });
    }
    w.a(this.a, paramView, this.a.getString(2131231051));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.jr
 * JD-Core Version:    0.7.0.1
 */