package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import nas;

public class MultiVideoLoadingFooter
  extends FrameLayout
{
  ProgressBar C;
  ViewGroup bl;
  TextView rI;
  
  public MultiVideoLoadingFooter(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131560519, this);
    addOnLayoutChangeListener(new nas(this));
    this.bl = ((ViewGroup)findViewById(2131370805));
    this.rI = ((TextView)findViewById(2131370816));
    this.C = ((ProgressBar)findViewById(2131370811));
    te(1);
  }
  
  private String bB(int paramInt)
  {
    if (paramInt == 1) {}
    while (paramInt != 2) {
      return null;
    }
    return null;
  }
  
  public void te(int paramInt)
  {
    if (paramInt == 1)
    {
      this.C.setVisibility(0);
      this.rI.setVisibility(0);
      this.rI.setText(bB(1));
    }
    while (paramInt != 2) {
      return;
    }
    this.C.setVisibility(8);
    this.rI.setVisibility(0);
    this.rI.setText(bB(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoLoadingFooter
 * JD-Core Version:    0.7.0.1
 */