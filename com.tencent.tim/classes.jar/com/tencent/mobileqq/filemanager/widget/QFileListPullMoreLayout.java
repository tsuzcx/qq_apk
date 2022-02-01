package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QFileListPullMoreLayout
  extends RelativeLayout
{
  Context context;
  RelativeLayout layout = null;
  Drawable mLeftDrawable;
  TextView textView;
  
  public QFileListPullMoreLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QFileListPullMoreLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QFileListPullMoreLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560799, this);
    this.layout = ((RelativeLayout)findViewById(2131374460));
    this.textView = ((TextView)findViewById(2131374461));
    this.context = paramContext;
  }
  
  public void dmA()
  {
    if (this.mLeftDrawable == null) {
      return;
    }
    ((Animatable)this.mLeftDrawable).stop();
    this.mLeftDrawable = null;
    this.textView.setCompoundDrawables(null, null, null, null);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.layout.setBackgroundResource(paramInt);
  }
  
  public void setGone()
  {
    this.layout.setVisibility(8);
    this.textView.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.layout.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(int paramInt)
  {
    this.textView.setText(paramInt);
  }
  
  public void setTextColor(int paramInt)
  {
    this.textView.setTextColor(paramInt);
  }
  
  public void setTextLeftDrawable(int paramInt)
  {
    this.mLeftDrawable = this.context.getResources().getDrawable(paramInt);
    this.mLeftDrawable.setBounds(0, 0, this.mLeftDrawable.getMinimumWidth(), this.mLeftDrawable.getMinimumHeight());
    this.textView.setCompoundDrawables(this.mLeftDrawable, null, null, null);
    ((Animatable)this.mLeftDrawable).start();
  }
  
  public void setVisible()
  {
    this.layout.setVisibility(0);
    this.textView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout
 * JD-Core Version:    0.7.0.1
 */