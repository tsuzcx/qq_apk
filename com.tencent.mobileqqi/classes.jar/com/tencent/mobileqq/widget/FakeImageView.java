package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

public class FakeImageView
  extends ImageView
{
  private ActionBarActivity a;
  
  public FakeImageView(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof ActionBarActivity)) {
      this.a = ((ActionBarActivity)paramContext);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.a != null) {
      this.a.supportInvalidateOptionsMenu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FakeImageView
 * JD-Core Version:    0.7.0.1
 */