package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.do;

class aeq
  implements View.OnClickListener
{
  aeq(UtilsTokenLabActivity paramUtilsTokenLabActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = do.a().e();
    if (paramView == null) {
      return;
    }
    this.a.getSKey("" + paramView.mRealUin, 523005419L, UtilsTokenLabActivity.access$500(this.a), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aeq
 * JD-Core Version:    0.7.0.1
 */