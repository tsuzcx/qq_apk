package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;

final class ai
  implements View.OnClickListener
{
  ai(AccountPageActivity paramAccountPageActivity, EvalAccountResult.RecommendItem paramRecommendItem) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.b, MyProtecSubPageActivity.class);
    paramView.putExtra("detailItems", this.a.mDetails);
    this.b.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ai
 * JD-Core Version:    0.7.0.1
 */