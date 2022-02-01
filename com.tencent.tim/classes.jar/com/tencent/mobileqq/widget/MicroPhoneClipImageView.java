package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MicroPhoneClipImageView
  extends ImageView
{
  public static final int[] pm = { 3658, 4390, 5182, 6036, 6829, 7621, 8536, 9207 };
  private ClipDrawable c;
  private boolean dan;
  private int[] pn;
  
  public MicroPhoneClipImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MicroPhoneClipImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MicroPhoneClipImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.c = ((ClipDrawable)getDrawable());
  }
  
  private int kz(int paramInt)
  {
    int j = pm.length - 2;
    if (this.pn == null)
    {
      this.pn = new int[pm.length];
      i = 0;
      while (i < j)
      {
        this.pn[(i + 1)] = (8000 - (j - i) * 7900 / j);
        i += 1;
      }
      this.pn[0] = 0;
      this.pn[(this.pn.length - 1)] = 8000;
    }
    int i = this.pn.length - 1;
    if (i >= 0) {
      if (paramInt < this.pn[i]) {}
    }
    for (;;)
    {
      if (i == -1)
      {
        return 0;
        i -= 1;
        break;
      }
      return i;
      i = -1;
    }
  }
  
  public void setRecordState(boolean paramBoolean)
  {
    this.dan = paramBoolean;
  }
  
  public void setSoundWave(int paramInt)
  {
    if (this.dan)
    {
      paramInt = kz(paramInt);
      this.c.setLevel(pm[paramInt]);
      return;
    }
    this.c.setLevel(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MicroPhoneClipImageView
 * JD-Core Version:    0.7.0.1
 */