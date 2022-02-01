package com.tencent.tim.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class NoFileRelativeLayout
  extends RelativeLayout
{
  TextView afq;
  Context context;
  RelativeLayout ff = null;
  int mHeight = 0;
  int mWidth = 0;
  LinearLayout md = null;
  LinearLayout me = null;
  
  public NoFileRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NoFileRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131563199, this);
    this.ff = ((RelativeLayout)findViewById(2131372417));
    this.md = ((LinearLayout)findViewById(2131366417));
    this.me = ((LinearLayout)findViewById(2131370805));
    this.afq = ((TextView)findViewById(2131366412));
    this.context = paramContext;
  }
  
  public void aaF(int paramInt)
  {
    this.ff.setVisibility(0);
    this.md.setVisibility(0);
    this.me.setVisibility(4);
    if (paramInt != 0)
    {
      this.afq.setText(paramInt);
      return;
    }
    this.afq.setText(2131691621);
  }
  
  public void setGone()
  {
    this.ff.setVisibility(8);
    this.md.setVisibility(8);
    this.me.setVisibility(8);
  }
  
  public void setLayoutParams(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while ((this.mWidth == paramInt1) && (this.mHeight == paramInt2)) {
      return;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
    this.ff.setLayoutParams(localLayoutParams);
    this.ff.invalidate();
  }
  
  public void showLoadingView()
  {
    this.ff.setVisibility(0);
    this.md.setVisibility(4);
    this.me.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.NoFileRelativeLayout
 * JD-Core Version:    0.7.0.1
 */