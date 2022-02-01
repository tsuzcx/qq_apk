package com.dataline.util.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.TextView;

public class WaitTextView
  extends TextView
{
  private Handler D;
  private a a;
  private String bO;
  private int dR;
  private Runnable m = new WaitTextView.1(this);
  
  public WaitTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaitTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WaitTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void cm()
  {
    switch (this.dR)
    {
    default: 
      setText(this.bO + "...");
      this.dR = 0;
      return;
    case 0: 
      setText(this.bO + "   ");
      this.dR += 1;
      return;
    case 1: 
      setText(this.bO + ".  ");
      this.dR += 1;
      return;
    }
    setText(this.bO + ".. ");
    this.dR += 1;
  }
  
  public void cn()
  {
    if (this.D == null)
    {
      this.D = new Handler(Looper.getMainLooper());
      this.D.postDelayed(this.m, 500L);
    }
  }
  
  public void co()
  {
    if (this.D != null)
    {
      this.D.removeCallbacks(this.m);
      this.D = null;
    }
  }
  
  public void setRefreshListener(a parama)
  {
    this.a = parama;
  }
  
  public void setWaitText(String paramString)
  {
    this.bO = paramString;
    this.dR = 0;
    setText(this.bO + "   ");
  }
  
  public static abstract interface a
  {
    public abstract void bV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.util.widget.WaitTextView
 * JD-Core Version:    0.7.0.1
 */