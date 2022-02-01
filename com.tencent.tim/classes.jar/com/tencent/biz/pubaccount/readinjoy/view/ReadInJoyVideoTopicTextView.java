package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import aqcx;

public class ReadInJoyVideoTopicTextView
  extends TextView
{
  private final int aVN = 14;
  private final int aYH = 8;
  private String alo;
  private Context mContext;
  
  public ReadInJoyVideoTopicTextView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public ReadInJoyVideoTopicTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public ReadInJoyVideoTopicTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void init(int paramInt)
  {
    SpannableString localSpannableString = new SpannableString(this.alo);
    Object localObject = new ForegroundColorSpan(Color.parseColor("#737373"));
    int j = aqcx.dip2px(this.mContext, 5.5F);
    int i;
    if (paramInt == 1)
    {
      localObject = getResources().getDrawable(2130843998);
      paramInt = aqcx.dip2px(this.mContext, 12.0F);
      ((Drawable)localObject).setBounds(0, 0, paramInt, paramInt);
      setCompoundDrawablePadding(aqcx.dip2px(this.mContext, 3.0F));
      setCompoundDrawables((Drawable)localObject, null, null, null);
      i = aqcx.dip2px(this.mContext, 4.5F);
      setTextSize(2, 12.0F);
    }
    for (;;)
    {
      setTextColor(Color.parseColor("#737373"));
      setText(localSpannableString);
      setIncludeFontPadding(false);
      setPadding(aqcx.dip2px(this.mContext, 8.0F), i, aqcx.dip2px(this.mContext, 8.0F), i);
      setClickable(true);
      setFocusable(true);
      setBackgroundResource(2130843995);
      setSingleLine(true);
      setGravity(17);
      return;
      i = j;
      if (paramInt == 2)
      {
        localSpannableString.setSpan(localObject, 0, this.alo.length(), 34);
        setHeight(aqcx.dip2px(this.mContext, 27.0F));
        setTextSize(2, 14.0F);
        i = j;
      }
    }
  }
  
  public int getViewWidth()
  {
    Rect localRect = new Rect();
    getPaint().getTextBounds(this.alo, 0, this.alo.length(), localRect);
    return localRect.width() + aqcx.dip2px(this.mContext, 8.0F) * 2;
  }
  
  public void setSubChannelText(String paramString)
  {
    this.alo = paramString;
    init(2);
  }
  
  public void setTopicText(String paramString)
  {
    this.alo = paramString;
    init(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyVideoTopicTextView
 * JD-Core Version:    0.7.0.1
 */