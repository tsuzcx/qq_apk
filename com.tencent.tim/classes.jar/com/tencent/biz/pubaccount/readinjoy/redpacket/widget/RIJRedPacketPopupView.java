package com.tencent.biz.pubaccount.readinjoy.redpacket.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RIJRedPacketPopupView
  extends RelativeLayout
{
  private ImageView closeIcon;
  private ImageView jv;
  private TextView textView;
  
  public RIJRedPacketPopupView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public RIJRedPacketPopupView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public RIJRedPacketPopupView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131562925, this);
    this.jv = ((ImageView)findViewById(2131370601));
    this.textView = ((TextView)findViewById(2131377014));
    this.closeIcon = ((ImageView)findViewById(2131377007));
  }
  
  public void nO(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.closeIcon.setVisibility(0);
      return;
    }
    this.closeIcon.setVisibility(8);
  }
  
  public void nP(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jv.setVisibility(0);
      return;
    }
    this.jv.setVisibility(8);
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.closeIcon.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTipsClickListener(View.OnClickListener paramOnClickListener)
  {
    this.textView.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.textView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView
 * JD-Core Version:    0.7.0.1
 */