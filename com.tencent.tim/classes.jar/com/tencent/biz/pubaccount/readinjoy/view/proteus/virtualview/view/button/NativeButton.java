package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.drawable.RoundedDrawable;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;

public class NativeButton
  extends ButtonBase
{
  private static final String DRAWABLE_LEFT = "l";
  private static final String TAG = "NativeButton";
  private CharSequence mBtnText;
  private NativeButtonImp mNative;
  
  NativeButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new NativeButtonImp(paramVafContext.getContext());
  }
  
  private Drawable radius(Drawable paramDrawable)
  {
    paramDrawable = RoundedDrawable.fromDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      paramDrawable.setCornerRadius(this.mBorderRadius);
      paramDrawable.setScaleType(ImageView.ScaleType.FIT_XY);
    }
    return paramDrawable;
  }
  
  private void setBackGroundForState(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    Drawable localDrawable3 = paramDrawable1;
    Drawable localDrawable2 = paramDrawable2;
    Drawable localDrawable1 = paramDrawable3;
    if (this.mBorderRadius > 0)
    {
      localDrawable3 = radius(paramDrawable1);
      localDrawable2 = radius(paramDrawable2);
      localDrawable1 = radius(paramDrawable3);
    }
    paramDrawable1 = DrawableUtil.getSelector(localDrawable3, localDrawable2, localDrawable1);
    this.mNative.setBackgroundDrawable(paramDrawable1);
  }
  
  private void setRealText(CharSequence paramCharSequence)
  {
    if (this.mNative.getLayoutParams() == null)
    {
      Object localObject = getComLayoutParams();
      localObject = new ViewGroup.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
      this.mNative.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.mNative.setText(paramCharSequence);
  }
  
  public int getComMeasuredHeight()
  {
    return this.mNative.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mNative.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mNative;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mNative.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mNative.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    int i = 1;
    super.onParseValueFinished();
    this.mNative.setClickable(true);
    this.mNative.setIncludeFontPadding(false);
    this.mNative.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.mNative.setTextSize(0, this.mTextSize);
    this.mNative.setLineSpacing(0.0F, 1.0F);
    this.mNative.setBorderColor(this.mBorderColor);
    this.mNative.setBorderWidth(this.mBorderWidth);
    this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
    this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
    this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
    this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
    this.mNative.setBackgroundColor(this.mBackground);
    if (this.mTypeface != null) {
      this.mNative.setTypeface(this.mTypeface);
    }
    if ((this.mTextStyle & 0x1) != 0) {
      i = 33;
    }
    int j = i;
    if ((this.mTextStyle & 0x8) != 0) {
      j = i | 0x10;
    }
    this.mNative.setPaintFlags(j);
    if ((this.mTextStyle & 0x2) != 0) {
      this.mNative.setTypeface(null, 3);
    }
    if (this.mMaxWidth > 0) {
      this.mNative.setMaxWidth(this.mMaxWidth);
    }
    if (!TextUtils.isEmpty(this.mBtnText)) {
      setRealText(this.mBtnText);
    }
    for (;;)
    {
      refresh();
      return;
      if (!TextUtils.isEmpty(this.mText)) {
        setRealText(this.mText);
      } else {
        setRealText("");
      }
    }
  }
  
  public void reset()
  {
    super.reset();
    this.mSupportHtmlStyle = false;
    this.mText = null;
  }
  
  protected void setBackgroundColorForStates()
  {
    setBackGroundForState(DrawableUtil.getDrawable(getStatus(0).backgroundColor), DrawableUtil.getDrawable(getStatus(1).backgroundColor), DrawableUtil.getDrawable(getStatus(4).backgroundColor));
  }
  
  protected void setBackgroundForStates()
  {
    Context localContext = this.mNative.getContext();
    setBackGroundForState(DrawableUtil.getDrawable(localContext, getStatus(0).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable(localContext, getStatus(1).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable(localContext, getStatus(4).background, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
  }
  
  protected void setCompoundDrawableForStates()
  {
    Object localObject = this.mNative.getContext();
    if ((this.drawableLeftPath != null) && (getStatus(0).img != this.drawableLeftPath)) {
      getStatus(0).img = this.drawableLeftPath;
    }
    localObject = DrawableUtil.getSelector(DrawableUtil.getDrawable((Context)localObject, getStatus(0).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(1).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER), DrawableUtil.getDrawable((Context)localObject, getStatus(4).img, this.TRANSPARENT_PLACE_HOLDER, this.GRAY_PLACEHOLDER));
    SpannableString localSpannableString = new SpannableString("l" + this.mText);
    localSpannableString.setSpan(new CenterImageSpan((Drawable)localObject), 0, 1, 33);
    this.mBtnText = localSpannableString;
    setText(localSpannableString);
  }
  
  public void setDrawableLeft(String paramString)
  {
    this.drawableLeftPath = paramString;
    setCompoundDrawableForStates();
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    this.mNative.setSelected(paramBoolean);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.mBtnText))
    {
      this.mBtnText = paramCharSequence;
      setRealText(this.mBtnText);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.mTextColor != paramInt)
    {
      this.mTextColor = paramInt;
      this.mNative.setTextColor(this.mTextColor);
    }
  }
  
  protected void setTextColorForStates()
  {
    ColorStateList localColorStateList = ColorUtil.getColorStateList(getStatus(0).textColor, getStatus(1).textColor, getStatus(4).textColor);
    this.mNative.setTextColor(localColorStateList);
  }
  
  public static class Builder
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new NativeButton(paramVafContext);
    }
  }
  
  class CenterImageSpan
    extends ImageSpan
  {
    public CenterImageSpan(@NonNull Drawable paramDrawable)
    {
      super();
      if (TextUtils.isEmpty(NativeButton.this.mText))
      {
        paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, getDrawableHeight());
        return;
      }
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, NativeButton.this.mTextSize);
    }
    
    private int getDrawableHeight()
    {
      if (NativeButton.this.mMeasuredHeight > 0) {
        return NativeButton.this.mMeasuredHeight;
      }
      if (NativeButton.this.mNative.getComMeasuredHeight() > 0) {
        return NativeButton.this.mNative.getComMeasuredHeight();
      }
      if ((NativeButton.this.mParams != null) && (NativeButton.this.mParams.mLayoutHeight > 0)) {
        return NativeButton.this.mParams.mLayoutHeight;
      }
      return NativeButton.this.mTextSize;
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = getDrawable();
      paramPaint = paramPaint.getFontMetricsInt();
      int j;
      int i;
      if (TextUtils.isEmpty(NativeButton.this.mText))
      {
        paramCanvas.save();
        j = (NativeButton.this.mNative.getMeasuredHeight() - paramCharSequence.getIntrinsicHeight()) / 2;
        Rect localRect = paramCharSequence.getBounds();
        i = j;
        if (localRect.bottom != getDrawableHeight()) {
          i = j - (getDrawableHeight() - localRect.bottom) / 2;
        }
        paramCanvas.translate(paramFloat, i);
        paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth(), paramCharSequence.getIntrinsicHeight());
        paramCharSequence.draw(paramCanvas);
        paramCanvas.restore();
        paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, getDrawableHeight());
      }
      for (;;)
      {
        if (LogUtils.shouldLog()) {
          LogUtils.d("NativeButton", NativeButton.this.mName + " : draw:  start:" + paramInt1 + " end:" + paramInt2 + " x:" + paramFloat + " top:" + paramInt3 + " y:" + paramInt4 + " bottom:" + paramInt5 + " fm:" + paramPaint + " drawable getIntrinsicHeight :" + paramCharSequence.getIntrinsicHeight() + " mTextSize :" + NativeButton.this.mTextSize + "measureHeight: " + NativeButton.this.mNative.getMeasuredHeight() + "transY: " + i);
        }
        return;
        j = NativeButton.this.mTextSize;
        i = j;
        if (NativeButton.this.mNative.getMeasuredHeight() > 0)
        {
          i = j;
          if (j > NativeButton.this.mNative.getMeasuredHeight()) {
            i = NativeButton.this.mNative.getMeasuredHeight();
          }
        }
        j = (paramPaint.descent + paramInt4 + paramInt4 + paramPaint.ascent) / 2;
        int k = paramCharSequence.getBounds().bottom / 2;
        i = (i - paramCharSequence.getIntrinsicHeight()) / 2 + (j - k);
        paramCanvas.save();
        paramCanvas.translate(paramFloat, i);
        paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth(), paramCharSequence.getIntrinsicHeight());
        paramCharSequence.draw(paramCanvas);
        paramCanvas.restore();
        paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding, NativeButton.this.mTextSize);
      }
    }
    
    public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
    {
      super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
      return getDrawable().getIntrinsicWidth() + NativeButton.this.mCompoundDrawablePadding;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton
 * JD-Core Version:    0.7.0.1
 */