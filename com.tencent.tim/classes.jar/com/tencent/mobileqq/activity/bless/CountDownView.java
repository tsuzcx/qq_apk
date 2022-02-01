package com.tencent.mobileqq.activity.bless;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import aqge;

public class CountDownView
  extends ImageView
{
  private static final int[] iM = { 2130838914, 2130838913, 2130838912 };
  private a a;
  private int bZQ;
  private boolean bnx;
  private Runnable eH = new CountDownView.1(this);
  
  public CountDownView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cjF()
  {
    aqge.bVz();
    aqge.a(2131230759, 1, null, null);
  }
  
  public void cjE()
  {
    setImageResource(iM[0]);
    this.bnx = false;
    Handler localHandler = getHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(this.eH);
    }
    this.bZQ = 0;
    setVisibility(4);
  }
  
  public void setListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cjG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView
 * JD-Core Version:    0.7.0.1
 */