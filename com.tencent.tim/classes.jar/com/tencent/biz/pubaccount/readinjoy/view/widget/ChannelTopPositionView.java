package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import nrb;

public class ChannelTopPositionView
  extends RelativeLayout
{
  private RelativeLayout ft;
  private Context mContext;
  private View.OnClickListener mListener = new nrb(this);
  
  public ChannelTopPositionView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public ChannelTopPositionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  private void aAz()
  {
    this.ft.setOnClickListener(this.mListener);
  }
  
  private void init()
  {
    LayoutInflater.from(this.mContext).inflate(2131560175, this, true);
    initUI();
    aAz();
  }
  
  private void initUI()
  {
    this.ft = ((RelativeLayout)findViewById(2131373523));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView
 * JD-Core Version:    0.7.0.1
 */