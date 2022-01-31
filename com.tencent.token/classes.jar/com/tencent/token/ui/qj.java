package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

final class qj
  implements View.OnTouchListener
{
  private boolean b;
  private boolean c;
  
  public qj(qf paramqf, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131296280);
    TextView localTextView2 = (TextView)paramView.findViewById(2131296281);
    TextView localTextView3 = (TextView)paramView.findViewById(2131296282);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131296279);
    int i = qf.a(this.a).getResources().getColor(2131165194);
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return false;
        localTextView1.setTextColor(i);
        localTextView2.setTextColor(i);
        localTextView3.setTextColor(i);
        localRelativeLayout.setBackgroundResource(2130837728);
        continue;
        if (!paramView.isPressed()) {
          break;
        }
        localTextView1.setTextColor(i);
        localTextView2.setTextColor(i);
        localTextView3.setTextColor(i);
        localRelativeLayout.setBackgroundResource(2130837728);
      }
    }
    if ((this.b) && (!this.c))
    {
      localRelativeLayout.setBackgroundResource(2130837726);
      localTextView1.setTextAppearance(qf.a(this.a), 2131427426);
      localTextView2.setTextAppearance(qf.a(this.a), 2131427427);
    }
    for (;;)
    {
      localTextView3.setTextAppearance(qf.a(this.a), 2131427436);
      break;
      localRelativeLayout.setBackgroundResource(2130837727);
      localTextView1.setTextAppearance(qf.a(this.a), 2131427424);
      localTextView2.setTextAppearance(qf.a(this.a), 2131427425);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qj
 * JD-Core Version:    0.7.0.1
 */