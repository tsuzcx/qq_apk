package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class zk
  implements View.OnClickListener
{
  zk(zj paramzj) {}
  
  public void onClick(View paramView)
  {
    if (SmsContentTipActivity.access$500(this.a.a) == 3)
    {
      paramView = new Intent(this.a.a, MyMbSubPageActivity.class);
      paramView.addFlags(67108864);
      this.a.a.startActivity(paramView);
    }
    for (;;)
    {
      this.a.a.finish();
      return;
      if (SmsContentTipActivity.access$2800(this.a.a) == 10)
      {
        paramView = new Intent(this.a.a, IndexActivity.class);
        paramView.putExtra("index_from", 16);
        this.a.a.startActivity(paramView);
      }
      else if (SmsContentTipActivity.access$2800(this.a.a) == 14)
      {
        paramView = new Intent(this.a.a, MyMbSubPageActivity.class);
        paramView.putExtra("page_id", SmsContentTipActivity.access$2800(this.a.a));
        paramView.addFlags(67108864);
        this.a.a.startActivity(paramView);
      }
      else if (SmsContentTipActivity.access$2800(this.a.a) == 17)
      {
        paramView = new Intent(this.a.a, MyMbSubPageActivity.class);
        paramView.putExtra("page_id", SmsContentTipActivity.access$2800(this.a.a));
        paramView.addFlags(67108864);
        this.a.a.startActivity(paramView);
      }
      else
      {
        paramView = new Intent(this.a.a, IndexActivity.class);
        this.a.a.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zk
 * JD-Core Version:    0.7.0.1
 */