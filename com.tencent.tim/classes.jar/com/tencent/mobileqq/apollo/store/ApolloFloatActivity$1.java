package com.tencent.mobileqq.apollo.store;

import android.content.res.Resources;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import wja;

class ApolloFloatActivity$1
  implements Runnable
{
  ApolloFloatActivity$1(ApolloFloatActivity paramApolloFloatActivity, Resources paramResources, RelativeLayout paramRelativeLayout) {}
  
  public void run()
  {
    this.this$0.er = new TextView(this.this$0);
    this.this$0.er.setBackgroundResource(2130851767);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(50.0F, this.val$resources), wja.dp2px(52.0F, this.val$resources));
    if (ApolloFloatActivity.a(this.this$0) == 1)
    {
      this.this$0.er.setTextColor(-16777216);
      this.this$0.er.setVisibility(8);
    }
    for (;;)
    {
      this.this$0.er.setGravity(17);
      this.this$0.er.setTextSize(17.0F);
      this.this$0.er.setText(2131721059);
      this.this$0.er.setOnClickListener(this.this$0);
      this.ig.addView(this.this$0.er, localLayoutParams);
      return;
      localLayoutParams.addRule(10, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.rightMargin = wja.dp2px(5.0F, this.val$resources);
      this.this$0.er.setTextColor(this.val$resources.getColor(2131167298));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloFloatActivity.1
 * JD-Core Version:    0.7.0.1
 */