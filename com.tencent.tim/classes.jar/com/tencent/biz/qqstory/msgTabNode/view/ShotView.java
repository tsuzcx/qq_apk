package com.tencent.biz.qqstory.msgTabNode.view;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@Deprecated
public class ShotView
  extends LinearLayout
{
  public ShotView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2131561904, this);
    ((TextView)findViewById(2131379769)).setText(acfp.m(2131714530));
    ((ImageView)findViewById(2131368383)).setImageResource(2130847509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.ShotView
 * JD-Core Version:    0.7.0.1
 */