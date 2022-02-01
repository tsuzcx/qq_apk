package com.tencent.mobileqq.mutualmark.view;

import ajns;
import ajoh;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MutualMarkIconItemView
  extends ImageView
{
  ajns jdField_a_of_type_Ajns;
  ajoh jdField_a_of_type_Ajoh;
  
  public MutualMarkIconItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MutualMarkIconItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MutualMarkIconItemView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int Gy()
  {
    if (this.jdField_a_of_type_Ajns != null) {
      return this.jdField_a_of_type_Ajns.getIntrinsicWidth();
    }
    return getMeasuredWidth();
  }
  
  public void ME(String paramString)
  {
    if (this.jdField_a_of_type_Ajns != null) {
      this.jdField_a_of_type_Ajns.ME(paramString);
    }
  }
  
  public void dyz()
  {
    if (this.jdField_a_of_type_Ajns != null) {
      this.jdField_a_of_type_Ajns.dyz();
    }
  }
  
  public long gr()
  {
    if (this.jdField_a_of_type_Ajoh != null) {
      return this.jdField_a_of_type_Ajoh.type;
    }
    return 0L;
  }
  
  public void setIconAlpha(float paramFloat)
  {
    dyz();
    setAlpha(paramFloat);
  }
  
  public void setIconResource(ajoh paramajoh)
  {
    if (this.jdField_a_of_type_Ajoh == paramajoh) {}
    do
    {
      return;
      this.jdField_a_of_type_Ajoh = paramajoh;
      if (!TextUtils.isEmpty(paramajoh.icon_static_url))
      {
        this.jdField_a_of_type_Ajns = new ajns(getContext(), paramajoh.icon_static_url);
        setImageDrawable(this.jdField_a_of_type_Ajns);
        return;
      }
    } while (paramajoh.iconResId == 0);
    this.jdField_a_of_type_Ajns = new ajns(getContext(), paramajoh.iconResId);
    setImageDrawable(this.jdField_a_of_type_Ajns);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.view.MutualMarkIconItemView
 * JD-Core Version:    0.7.0.1
 */