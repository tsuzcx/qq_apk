package com.tencent.token.utils.bugscanuitl;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class f
  implements View.OnClickListener
{
  public abstract void a(int paramInt);
  
  public void onClick(View paramView)
  {
    a(((Integer)paramView.getTag()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.bugscanuitl.f
 * JD-Core Version:    0.7.0.1
 */