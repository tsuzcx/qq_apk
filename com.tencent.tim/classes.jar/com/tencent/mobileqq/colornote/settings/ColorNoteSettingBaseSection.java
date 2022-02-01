package com.tencent.mobileqq.colornote.settings;

import aecz;
import aede;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingBaseSection
  extends LinearLayout
{
  private FormSimpleItem au;
  private aecz b;
  private LinearLayout iy;
  
  public ColorNoteSettingBaseSection(Context paramContext)
  {
    super(paramContext);
    cVM();
  }
  
  public ColorNoteSettingBaseSection(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cVM();
  }
  
  public ColorNoteSettingBaseSection(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cVM();
  }
  
  private void cVM()
  {
    inflate(getContext(), 2131559019, this);
    this.au = ((FormSimpleItem)findViewById(2131377910));
    this.iy = ((LinearLayout)findViewById(2131363330));
  }
  
  public void refreshData()
  {
    this.iy.removeAllViews();
    Iterator localIterator = this.b.l(getContext()).iterator();
    while (localIterator.hasNext())
    {
      HistoryFormItem localHistoryFormItem = (HistoryFormItem)localIterator.next();
      this.iy.addView(localHistoryFormItem);
    }
  }
  
  public void setAdapter(aecz paramaecz)
  {
    this.b = paramaecz;
    this.b.a(new aede(this));
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.au.setContentDescription(paramCharSequence);
  }
  
  public void setHeaderOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.au.setOnClickListener(paramOnClickListener);
  }
  
  public void setHeaderTitle(CharSequence paramCharSequence)
  {
    this.au.setLeftText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingBaseSection
 * JD-Core Version:    0.7.0.1
 */