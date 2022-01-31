package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.fn;

final class sk
  implements View.OnClickListener
{
  sk(OpMsgDisplayActivity paramOpMsgDisplayActivity) {}
  
  public final void onClick(View paramView)
  {
    fn.a().b();
    paramView = new Intent(this.a, UtilsGameLockActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sk
 * JD-Core Version:    0.7.0.1
 */