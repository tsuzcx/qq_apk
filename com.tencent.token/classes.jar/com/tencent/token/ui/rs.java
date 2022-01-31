package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.token.utils.w;

class rs
  implements View.OnClickListener
{
  rs(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public void onClick(View paramView)
  {
    String str = ((Button)paramView).getText().toString();
    paramView = (String)paramView.getTag();
    if (paramView != null) {
      w.a(this.a, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rs
 * JD-Core Version:    0.7.0.1
 */