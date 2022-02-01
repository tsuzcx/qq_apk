package com.tencent.token;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ActionBarContainer;

public final class ic
  extends ib
{
  public ic(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public final void getOutline(Outline paramOutline)
  {
    if (this.a.d)
    {
      if (this.a.c != null) {
        this.a.c.getOutline(paramOutline);
      }
    }
    else if (this.a.a != null) {
      this.a.a.getOutline(paramOutline);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ic
 * JD-Core Version:    0.7.0.1
 */