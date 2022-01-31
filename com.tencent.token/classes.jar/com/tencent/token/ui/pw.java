package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class pw
  implements View.OnTouchListener
{
  private boolean b;
  private boolean c;
  
  public pw(ps paramps, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131558539);
    TextView localTextView2 = (TextView)paramView.findViewById(2131558540);
    TextView localTextView3 = (TextView)paramView.findViewById(2131558541);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131558538);
    int i = ps.a(this.a).getResources().getColor(2131492933);
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
        localRelativeLayout.setBackgroundResource(2130837803);
        continue;
        if (!paramView.isPressed()) {
          break;
        }
        localTextView1.setTextColor(i);
        localTextView2.setTextColor(i);
        localTextView3.setTextColor(i);
        localRelativeLayout.setBackgroundResource(2130837803);
      }
    }
    if (this.b) {
      if (this.c)
      {
        localRelativeLayout.setBackgroundResource(2130837802);
        localTextView1.setTextAppearance(ps.a(this.a), 2131362164);
        localTextView2.setTextAppearance(ps.a(this.a), 2131362163);
      }
    }
    for (;;)
    {
      localTextView3.setTextAppearance(ps.a(this.a), 2131362175);
      break;
      localRelativeLayout.setBackgroundResource(2130837801);
      localTextView1.setTextAppearance(ps.a(this.a), 2131362160);
      localTextView2.setTextAppearance(ps.a(this.a), 2131362159);
      continue;
      localRelativeLayout.setBackgroundResource(2130837802);
      localTextView1.setTextAppearance(ps.a(this.a), 2131362164);
      localTextView2.setTextAppearance(ps.a(this.a), 2131362163);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.pw
 * JD-Core Version:    0.7.0.1
 */