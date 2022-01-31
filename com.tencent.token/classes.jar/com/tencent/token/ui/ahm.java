package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;

final class ahm
  implements View.OnClickListener
{
  ahm(WtloginFinishNoMibaoActivity paramWtloginFinishNoMibaoActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, IndexActivity.class);
    paramView.putExtra("index_from", 16);
    ax.a().f(WtloginFinishNoMibaoActivity.access$000(this.a));
    ax.a().u();
    AccountPageActivity.mNeedRefreshEval = true;
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahm
 * JD-Core Version:    0.7.0.1
 */