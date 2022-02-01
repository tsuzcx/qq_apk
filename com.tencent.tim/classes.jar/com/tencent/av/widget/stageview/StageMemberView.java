package com.tencent.av.widget.stageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import jmf;

public class StageMemberView
  extends ViewGroup
{
  private static final Paint av = new Paint(3);
  private static final Rect mBound = new Rect();
  private SimpleTextView a;
  private boolean aay;
  jmf b = null;
  private Bitmap bP;
  private Bitmap bQ;
  private Drawable cm = a();
  public ImageView ha;
  private int mColor = Color.parseColor("#FF6633");
  private ImageView mImageView;
  private int mPosition = 3;
  private String mText;
  private TextPaint mTextPaint;
  
  public StageMemberView(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramContext);
    this.bP = paramBitmap1;
    this.bQ = paramBitmap2;
    this.a = new SimpleTextView(getContext());
    this.a.setVisibility(0);
    this.mImageView = new ImageView(getContext());
    this.ha = new ImageView(getContext());
    this.ha.setImageDrawable(this.cm);
    addViewInLayout(this.ha, 0, generateDefaultLayoutParams(), false);
    addViewInLayout(this.mImageView, 1, generateDefaultLayoutParams(), false);
    addViewInLayout(this.a, 2, generateDefaultLayoutParams(), false);
    this.ha.setVisibility(0);
    setClipChildren(false);
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.setColor(2147483647);
    this.mTextPaint.density = getResources().getDisplayMetrics().density;
    float f = a(0, 15.0F);
    this.mTextPaint.setTextSize(f);
    super.setBackgroundColor(this.mColor);
  }
  
  private ShapeDrawable a()
  {
    int i = (int)TypedValue.applyDimension(1, 18.0F, getResources().getDisplayMetrics());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    if (this.mColor == -1) {
      this.mColor = Color.parseColor("#FF6633");
    }
    localShapeDrawable.getPaint().setColor(this.mColor);
    return localShapeDrawable;
  }
  
  private void aya()
  {
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.ha.measure(i, j);
    i = this.ha.getMeasuredWidth();
    j = this.ha.getMeasuredHeight();
    if (this.mPosition == 3)
    {
      float f = q(1.0F);
      this.ha.layout(54, (int)(108.0F - j * 1.4F / f - 2), (int)(i * 1.4F / f + 54.0F), 106);
      this.ha.setPadding(0, 0, 0, 0);
      return;
    }
    this.ha.setVisibility(8);
  }
  
  private float q(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  float a(int paramInt, float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources()) {
      return TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
    }
  }
  
  void ac(String paramString, boolean paramBoolean)
  {
    if (((this.mText == null) && (paramString == null)) || ((this.mText != null) && (this.mText.equals(paramString)))) {
      return;
    }
    float f2 = super.getResources().getDimensionPixelSize(2131299163);
    String str2 = paramString;
    if (f2 > 0.0F)
    {
      float f1 = this.mTextPaint.measureText(paramString);
      str2 = paramString;
      if (f1 > f2)
      {
        float f3 = f2 - this.mTextPaint.measureText(".");
        String str1 = paramString;
        while ((f3 > 0.0F) && (f1 > f3) && (str1.length() > 0))
        {
          str2 = str1.substring(0, str1.length() - 1);
          f2 = this.mTextPaint.measureText(str2);
          str1 = str2;
          f1 = f2;
          if (f2 == 0.0F)
          {
            str1 = str2;
            f1 = f2;
            if (str2.length() > 0)
            {
              f1 = 1.0F + f3;
              str1 = str2;
            }
          }
        }
        str2 = paramString;
        if (f3 > 0.0F)
        {
          str2 = paramString;
          if (str1.length() > 0) {
            str2 = str1 + ".";
          }
        }
      }
    }
    if ((this.b != null) && (!TextUtils.isEmpty(this.b.format))) {
      if ((TextUtils.isEmpty(str2)) && (this.b.format.contains("%s "))) {
        this.mText = this.b.format.replace("%s ", "");
      }
    }
    for (;;)
    {
      axZ();
      this.a.invalidate();
      this.ha.invalidate();
      setContentDescription(this.mText);
      return;
      this.mText = String.format(this.b.format, new Object[] { str2 });
      continue;
      this.mText = str2;
    }
  }
  
  void axZ()
  {
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    if (this.mText == null) {}
    for (int i = 0;; i = (int)Layout.getDesiredWidth(this.mText, this.mTextPaint))
    {
      int j = (int)(localFontMetrics.descent - localFontMetrics.ascent);
      getWidth();
      this.a.layout((getWidth() - i) / 2 + 5, this.mImageView.getHeight(), (i + getWidth()) / 2 + 5, j + this.mImageView.getHeight());
      aya();
      return;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.mImageView.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).draw(paramCanvas);
    }
    if (this.aay) {}
    for (localObject = this.bQ;; localObject = this.bP)
    {
      paramCanvas.drawBitmap((Bitmap)localObject, null, mBound, av);
      dispatchDraw(paramCanvas);
      return;
    }
  }
  
  public void lo(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.ha.isShown()) {
        this.ha.setVisibility(0);
      }
    }
    for (;;)
    {
      this.a.invalidate();
      this.ha.invalidate();
      this.mImageView.invalidate();
      return;
      this.ha.setVisibility(8);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    mBound.set(0, 0, paramInt1, paramInt2);
    paramInt1 = (int)9.5F;
    this.mImageView.setPadding(paramInt1, paramInt1, paramInt1, paramInt1);
    this.mImageView.layout(0, 0, 114, 114);
    axZ();
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      if (!this.aay) {
        break label79;
      }
    }
    label79:
    for (Object localObject = this.bQ;; localObject = this.bP)
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      this.mImageView.setImageDrawable(paramDrawable);
      this.mImageView.setBackgroundDrawable((Drawable)localObject);
      int i = (int)9.5F;
      this.mImageView.setPadding(i, i, i, i);
      this.mImageView.layout(0, 0, 114, 114);
      super.invalidate();
      axZ();
      return;
    }
  }
  
  public void setIconBadge(int paramInt, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.mPosition = paramInt;
      this.cm = paramDrawable;
      if (this.cm != null)
      {
        this.ha.setImageDrawable(this.cm);
        aya();
        this.ha.setVisibility(0);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.ha.setImageDrawable(a());
      break;
      this.ha.setVisibility(8);
    }
  }
  
  class SimpleTextView
    extends View
  {
    public SimpleTextView(Context paramContext)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas)
    {
      float f;
      if (StageMemberView.a(StageMemberView.this) != null)
      {
        f = -StageMemberView.a(StageMemberView.this).getFontMetrics().ascent;
        if (StageMemberView.this.b == null) {
          break label76;
        }
        StageMemberView.a(StageMemberView.this).setColor(StageMemberView.this.b.color);
      }
      for (;;)
      {
        paramCanvas.drawText(StageMemberView.a(StageMemberView.this), 0.0F, f, StageMemberView.a(StageMemberView.this));
        return;
        label76:
        StageMemberView.a(StageMemberView.this).setColor(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageMemberView
 * JD-Core Version:    0.7.0.1
 */