package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.EvalAccountResult.RecommendItem;
import com.tmsdk.TMSDKContext;

class am
  implements View.OnClickListener
{
  am(AccountPageActivity paramAccountPageActivity, EvalAccountResult.RecommendItem paramRecommendItem) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b, MyMbSubPageActivity.class);
    paramView.putExtra("detailItems", this.a.mDetails);
    this.b.startActivity(paramView);
    TMSDKContext.saveActionData(1150060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.am
 * JD-Core Version:    0.7.0.1
 */