package com.tencent.mobileqq.widget;

import acfp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aofk;
import aqnm;
import arfq;
import atau.a;
import com.tencent.qphone.base.util.QLog;

public class FolderTextView
  extends RelativeLayout
{
  private TextView abS;
  private TextView abT;
  private String cAm;
  private boolean dae;
  private int efN;
  private int efO;
  private int efP;
  private View.OnClickListener ge = new arfq(this);
  private CharSequence mText;
  private int mTextColor;
  private int mTextSize;
  
  public FolderTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FolderTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qA);
    try
    {
      this.mText = paramAttributeSet.getString(2);
      this.mTextColor = a(paramAttributeSet.getColorStateList(1));
      this.mTextSize = paramAttributeSet.getDimensionPixelSize(0, aqnm.dip2px(12.0F));
      this.mTextSize = aqnm.pxTosp(this.mTextSize);
      this.efN = paramAttributeSet.getInt(5, 2);
      this.cAm = paramAttributeSet.getString(4);
      this.efO = paramAttributeSet.getColor(3, paramContext.getResources().getColor(2131166558));
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("FolderTextView", 1, "Exception:", paramContext);
        paramAttributeSet.recycle();
      }
    }
    finally
    {
      paramAttributeSet.recycle();
    }
    if (TextUtils.isEmpty(this.cAm)) {
      this.cAm = acfp.m(2131706380);
    }
    if (TextUtils.isEmpty(this.mText)) {
      this.mText = "";
    }
    this.efP = 0;
    init();
  }
  
  private float a(CharSequence paramCharSequence, TextPaint paramTextPaint)
  {
    return paramTextPaint.measureText(paramCharSequence.toString());
  }
  
  private int a(ColorStateList paramColorStateList)
  {
    int i = -16777216;
    if (paramColorStateList != null) {
      i = paramColorStateList.getColorForState(getDrawableState(), -16777216);
    }
    return i;
  }
  
  private int a(CharSequence paramCharSequence, TextPaint paramTextPaint, float paramFloat)
  {
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramFloat <= 0.0F)) {}
    int i;
    label199:
    for (;;)
    {
      return 0;
      float f = paramTextPaint.measureText("...");
      i = paramCharSequence.length();
      if (a(paramCharSequence, paramTextPaint) <= paramFloat - f) {
        break;
      }
      i = paramCharSequence.length() - 1;
      if ((paramCharSequence instanceof Spanned))
      {
        Spanned localSpanned = (Spanned)paramCharSequence;
        Object[] arrayOfObject = localSpanned.getSpans(0, paramCharSequence.length(), Object.class);
        int j = 0;
        while (j < arrayOfObject.length)
        {
          int m = localSpanned.getSpanStart(Integer.valueOf(j));
          int n = localSpanned.getSpanEnd(Integer.valueOf(j));
          int k = i;
          if (m != -1)
          {
            k = i;
            if (n != -1) {
              if (i < m)
              {
                k = i;
                if (i > n) {}
              }
              else
              {
                k = m;
              }
            }
          }
          j += 1;
          i = k;
        }
      }
      for (;;)
      {
        if (i <= 0) {
          break label199;
        }
        paramCharSequence = paramCharSequence.subSequence(0, i);
        break;
      }
    }
    return i;
  }
  
  private Layout a(int paramInt, CharSequence paramCharSequence)
  {
    if (aGv()) {
      return new DynamicLayout(paramCharSequence, this.abS.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    }
    return new StaticLayout(paramCharSequence, this.abS.getPaint(), paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private boolean aGv()
  {
    boolean bool1 = this.mText instanceof Spannable;
    boolean bool2 = this.abS.isTextSelectable();
    return (bool1) || (bool2);
  }
  
  private void ehT()
  {
    int j = this.abS.getMeasuredWidth() - this.abS.getPaddingLeft() - this.abS.getPaddingRight();
    if (j <= 0)
    {
      this.efP = 1;
      QLog.d("FolderTextView", 1, "updateFoldStatus, layoutWidth <= 0");
    }
    Object localObject1;
    Object localObject2;
    label296:
    int k;
    if (this.efP == 0)
    {
      if (this.abS.getLayout() != null) {
        i = this.abS.getLayout().getWidth();
      }
      Layout localLayout;
      for (;;)
      {
        localLayout = a(i, this.mText);
        if (localLayout.getLineCount() > this.efN) {
          break;
        }
        this.abS.setText(this.mText);
        this.abT.setVisibility(4);
        return;
        i = j;
        if (QLog.isDebugVersion())
        {
          QLog.d("FolderTextView", 4, "getLayout == null");
          i = j;
        }
      }
      j = localLayout.getLineStart(this.efN - 1);
      i = localLayout.getLineEnd(this.efN - 1);
      if ((this.mText instanceof aofk))
      {
        localObject1 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject1).append(this.mText, j, i);
        if (QLog.isDebugVersion()) {
          QLog.d("FolderTextView", 4, String.format("mText: %s, lineCount: %s, lastLineText: %s", new Object[] { this.mText.toString(), Integer.valueOf(localLayout.getLineCount()), localObject1 }));
        }
        localObject2 = localObject1;
        if (((CharSequence)localObject1).length() > 0)
        {
          localObject2 = localObject1;
          if (((CharSequence)localObject1).toString().charAt(((CharSequence)localObject1).length() - 1) == '\n')
          {
            if (((CharSequence)localObject1).length() != 1) {
              break label410;
            }
            localObject2 = "";
          }
        }
        i = localLayout.getWidth();
        k = this.abT.getMeasuredWidth();
        k = a((CharSequence)localObject2, this.abS.getPaint(), i - k);
        if (k == ((CharSequence)localObject2).length()) {
          break label452;
        }
      }
    }
    label410:
    label452:
    for (int i = 1;; i = 0)
    {
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(this.mText, 0, k + j);
      if (i != 0) {
        ((SpannableStringBuilder)localObject1).append("...");
      }
      this.abS.setText((CharSequence)localObject1);
      this.abT.setVisibility(0);
      return;
      localObject1 = this.mText.subSequence(j, i);
      break;
      localObject2 = ((CharSequence)localObject1).subSequence(0, ((CharSequence)localObject1).length() - 1);
      break label296;
      this.abS.setText(this.mText);
      this.abT.setVisibility(4);
      return;
    }
  }
  
  private void init()
  {
    this.abS = new TextView(getContext());
    this.abS.setId(2131380714);
    this.abS.setTextColor(this.mTextColor);
    this.abS.setTextSize(this.mTextSize);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.abS, localLayoutParams);
    this.abT = new TextView(getContext());
    this.abT.setTextSize(this.mTextSize);
    this.abT.setOnClickListener(this.ge);
    this.abT.setText(this.cAm);
    this.abT.setTextColor(this.efO);
    this.abT.setVisibility(4);
    int i = aqnm.dip2px(10.0F);
    this.abT.setPadding(i, 0, i, 0);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 2131380714);
    localLayoutParams.addRule(7, 2131380714);
    addView(this.abT, localLayoutParams);
    if (!TextUtils.isEmpty(this.mText)) {
      post(new FolderTextView.1(this));
    }
  }
  
  public CharSequence getText()
  {
    return this.abS.getText();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.dae)
    {
      this.dae = true;
      ehT();
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    this.efP = 0;
    if (this.dae) {
      ehT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FolderTextView
 * JD-Core Version:    0.7.0.1
 */