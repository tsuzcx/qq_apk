package com.tencent.token.ui;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.token.global.e;

final class rp
  implements View.OnTouchListener
{
  rp(NetActiveVryOtherListActivity paramNetActiveVryOtherListActivity) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    e.a("view id： " + paramView.getId() + "mobile: " + 2131296871 + "token: " + 2131296874 + "ques: " + 2131296877);
    e.a("action: " + paramMotionEvent.getAction());
    switch (paramView.getId())
    {
    default: 
      return false;
    case 2131296871: 
      paramView = (TextView)this.a.findViewById(2131296873);
    }
    int i;
    for (;;)
    {
      i = this.a.getResources().getColor(2131165192);
      int j = this.a.getResources().getColor(2131165194);
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return false;
      case 0: 
        e.a("down");
        paramView.setTextColor(j);
        return false;
        paramView = (TextView)this.a.findViewById(2131296876);
        continue;
        paramView = (TextView)this.a.findViewById(2131296879);
      }
    }
    e.a("up");
    paramView.setTextColor(i);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rp
 * JD-Core Version:    0.7.0.1
 */