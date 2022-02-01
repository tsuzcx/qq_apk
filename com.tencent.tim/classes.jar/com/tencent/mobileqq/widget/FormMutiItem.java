package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class FormMutiItem
  extends FormSimpleItem
{
  protected TextView abU;
  protected TextView abV;
  protected CharSequence as;
  protected CharSequence at;
  protected int efY = 0;
  protected int efZ = 2;
  protected int ega;
  protected int egb;
  protected LinearLayout lj;
  
  public FormMutiItem(Context paramContext)
  {
    super(paramContext);
    ehV();
  }
  
  /* Error */
  public FormMutiItem(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 35	com/tencent/mobileqq/widget/FormSimpleItem:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: iconst_0
    //   8: putfield 23	com/tencent/mobileqq/widget/FormMutiItem:efY	I
    //   11: aload_0
    //   12: iconst_2
    //   13: putfield 25	com/tencent/mobileqq/widget/FormMutiItem:efZ	I
    //   16: aconst_null
    //   17: astore_3
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic 41	atau$a:qB	[I
    //   23: invokevirtual 47	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_3
    //   29: aload_0
    //   30: aload_1
    //   31: iconst_5
    //   32: invokevirtual 53	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   35: putfield 55	com/tencent/mobileqq/widget/FormMutiItem:as	Ljava/lang/CharSequence;
    //   38: aload_1
    //   39: astore_3
    //   40: aload_0
    //   41: aload_1
    //   42: bipush 19
    //   44: invokevirtual 53	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   47: putfield 57	com/tencent/mobileqq/widget/FormMutiItem:at	Ljava/lang/CharSequence;
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 60	android/content/res/TypedArray:recycle	()V
    //   58: aload_0
    //   59: invokespecial 29	com/tencent/mobileqq/widget/FormMutiItem:ehV	()V
    //   62: return
    //   63: astore_1
    //   64: aload_3
    //   65: ifnull -7 -> 58
    //   68: aload_3
    //   69: invokevirtual 60	android/content/res/TypedArray:recycle	()V
    //   72: goto -14 -> 58
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull +7 -> 88
    //   84: aload_3
    //   85: invokevirtual 60	android/content/res/TypedArray:recycle	()V
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_1
    //   92: astore_3
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	FormMutiItem
    //   0	96	1	paramContext	Context
    //   0	96	2	paramAttributeSet	android.util.AttributeSet
    //   17	76	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   18	27	63	java/lang/Throwable
    //   29	38	63	java/lang/Throwable
    //   40	50	63	java/lang/Throwable
    //   18	27	75	finally
    //   29	38	90	finally
    //   40	50	90	finally
  }
  
  private void ehV()
  {
    this.lj = new LinearLayout(getContext());
    this.lj.setOrientation(1);
    this.abU = new TextView(getContext());
    this.abU.setSingleLine(true);
    this.abU.setTextColor(d(getResources(), this.efY));
    int i = getResources().getDimensionPixelSize(2131296925);
    this.abU.setTextSize(0, i);
    this.abU.setGravity(19);
    this.abU.setEllipsize(TextUtils.TruncateAt.END);
    this.abU.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.as)) {
      this.abU.setText(this.as);
    }
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    this.abV = new TextView(getContext());
    if (this.mNeedSetHeight)
    {
      this.abV.setSingleLine(true);
      this.abV.setEllipsize(TextUtils.TruncateAt.END);
      this.abV.setDuplicateParentStateEnabled(true);
    }
    for (;;)
    {
      i = getResources().getDimensionPixelSize(2131296934);
      this.abV.setTextColor(d(getResources(), this.efZ));
      this.abV.setTextSize(0, i);
      this.abV.setGravity(19);
      if (!TextUtils.isEmpty(this.at)) {
        this.abV.setText(this.at);
      }
      this.lj.addView(this.abU, (ViewGroup.LayoutParams)localObject);
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelOffset(2131296909);
      if (!this.mNeedSetHeight) {
        ((LinearLayout.LayoutParams)localObject).bottomMargin = getResources().getDimensionPixelOffset(2131296915);
      }
      this.lj.addView(this.abV, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131367515);
      ((RelativeLayout.LayoutParams)localObject).addRule(0, 2131367517);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      addView(this.lj, (ViewGroup.LayoutParams)localObject);
      setCustomHeight(getResources().getDimensionPixelSize(2131298726));
      return;
      this.abV.setSingleLine(false);
      ((LinearLayout.LayoutParams)localObject).topMargin = getResources().getDimensionPixelSize(2131296919);
    }
  }
  
  public void setFirstLineRightDrawalbe(Drawable paramDrawable)
  {
    this.abU.setCompoundDrawables(null, null, paramDrawable, null);
  }
  
  public void setFirstLineText(int paramInt)
  {
    this.as = getResources().getString(paramInt);
    this.abU.setText(this.as);
  }
  
  public void setFirstLineText(CharSequence paramCharSequence)
  {
    this.as = paramCharSequence;
    this.abU.setText(this.as);
  }
  
  public void setFirstLineTextColor(int paramInt)
  {
    this.efY = paramInt;
    this.abU.setTextColor(this.efY);
  }
  
  public void setFirstLineTextSize(int paramInt)
  {
    this.ega = paramInt;
    this.abU.setTextSize(this.ega);
  }
  
  public void setSecondLineText(int paramInt)
  {
    this.at = getResources().getString(paramInt);
    this.abV.setText(this.at);
  }
  
  public void setSecondLineText(CharSequence paramCharSequence)
  {
    this.at = paramCharSequence;
    this.abV.setText(this.at);
  }
  
  public void setSecondLineTextColor(int paramInt)
  {
    this.abV.setTextColor(this.efZ);
  }
  
  public void setSecondLineTextSize(int paramInt)
  {
    this.abV.setTextSize(this.egb);
  }
  
  public void setSecondLineTextViewPaddingRight(int paramInt)
  {
    this.abV.setPadding(this.abV.getPaddingLeft(), this.abV.getPaddingTop(), paramInt, this.abV.getPaddingBottom());
  }
  
  public void setSecondLineVisible(boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.abV.getVisibility() == 0)
    {
      boolean bool1 = true;
      if ((bool1 ^ paramBoolean))
      {
        TextView localTextView = this.abV;
        if (!paramBoolean) {
          break label63;
        }
        bool1 = bool2;
        label32:
        localTextView.setVisibility(bool1);
        if (!paramBoolean) {
          break label69;
        }
      }
    }
    label63:
    label69:
    for (int i = getResources().getDimensionPixelSize(2131298726);; i = getResources().getDimensionPixelSize(2131298643))
    {
      setCustomHeight(i);
      return;
      i = 0;
      break;
      i = 8;
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMutiItem
 * JD-Core Version:    0.7.0.1
 */