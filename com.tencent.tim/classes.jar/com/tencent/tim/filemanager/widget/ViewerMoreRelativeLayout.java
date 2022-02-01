package com.tencent.tim.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewerMoreRelativeLayout
  extends RelativeLayout
{
  Context context;
  RelativeLayout layout = null;
  TextView textView;
  
  public ViewerMoreRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewerMoreRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewerMoreRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131561025, this);
    this.layout = ((RelativeLayout)findViewById(2131381895));
    this.textView = ((TextView)findViewById(2131381971));
    this.context = paramContext;
  }
  
  public void setGone()
  {
    this.layout.setVisibility(8);
    this.textView.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.layout.setOnClickListener(paramOnClickListener);
    this.textView.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(int paramInt)
  {
    this.textView.setText(paramInt);
  }
  
  public void setVisible()
  {
    this.layout.setVisibility(0);
    this.textView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.widget.ViewerMoreRelativeLayout
 * JD-Core Version:    0.7.0.1
 */