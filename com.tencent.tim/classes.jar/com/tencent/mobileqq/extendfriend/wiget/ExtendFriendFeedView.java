package com.tencent.mobileqq.extendfriend.wiget;

import afxw;
import afyi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import wja;

public class ExtendFriendFeedView
  extends FrameLayout
  implements View.OnTouchListener
{
  public static ColorFilter d = new PorterDuffColorFilter(536870912, PorterDuff.Mode.SRC_ATOP);
  private static Bitmap fh;
  private static Map<String, WeakReference<Bitmap>> ks = new HashMap();
  private static final int[] li = { -13900833, -37464, -12331403, -5544982 };
  private Paint Q;
  private int cVl;
  private boolean cbL;
  private Bitmap dw;
  private GradientDrawable g;
  private RectF mBgRect;
  private int mLayoutHeight;
  private int mLayoutWidth;
  private float wm;
  
  public ExtendFriendFeedView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131561346, this, true);
    this.wm = wja.dp2px(4.0F, getResources());
  }
  
  private GradientDrawable b(int paramInt)
  {
    int i = li.length;
    paramInt = li[(paramInt % i)];
    if (this.g == null) {
      this.g = afyi.a(paramInt, 0.0F, 0.0F, this.wm, this.wm);
    }
    for (;;)
    {
      return this.g;
      this.g.setColor(paramInt);
    }
  }
  
  private void bnv()
  {
    if (this.Q == null)
    {
      this.Q = new Paint(1);
      this.Q.setStyle(Paint.Style.FILL);
      this.Q.setAntiAlias(true);
    }
    int i;
    float f2;
    float f3;
    float f1;
    if ((this.mLayoutWidth > 0) && (this.mLayoutHeight > 0))
    {
      if ((this.dw == null) || (this.dw.isRecycled()))
      {
        if (fh == null)
        {
          fh = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
          new Canvas(fh).drawColor(-1);
        }
        this.dw = fh;
      }
      i = this.dw.getWidth();
      int j = this.dw.getHeight();
      f2 = this.mLayoutWidth / i;
      f3 = this.mLayoutHeight / j;
      if (f2 <= f3) {
        break label315;
      }
      f1 = (j * f2 - this.mLayoutHeight) / 2.0F;
      f3 = f2;
      f2 = 0.0F;
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate(-f2, -f1);
      BitmapShader localBitmapShader = new BitmapShader(this.dw, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      localBitmapShader.setLocalMatrix(localMatrix);
      this.Q.setShader(localBitmapShader);
      if (this.mBgRect == null) {
        this.mBgRect = new RectF();
      }
      this.mBgRect.set(0.0F, this.cVl, this.mLayoutWidth, this.mLayoutHeight);
      if (this.g != null)
      {
        i = wja.dp2px(5.0F, getResources());
        this.g.setBounds(0, this.mLayoutHeight - i, this.mLayoutWidth, this.mLayoutHeight);
      }
      return;
      label315:
      f2 = (i * f3 - this.mLayoutWidth) / 2.0F;
      f1 = 0.0F;
    }
  }
  
  private Bitmap z(String paramString)
  {
    Object localObject1 = afxw.fd;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break label214;
          }
          i = paramString.lastIndexOf('=');
          if (i < 0) {
            break label214;
          }
          paramString = paramString.substring(i + 1);
          if (TextUtils.isEmpty(paramString)) {
            break label214;
          }
          i = paramString.toUpperCase().charAt(0) % localObject1.length;
          if (i == -1)
          {
            str = afxw.kL("expand_feed_bg_default.png");
            paramString = (WeakReference)ks.get(str);
            if (paramString == null) {
              break label209;
            }
            paramString = (Bitmap)paramString.get();
            if (paramString != null)
            {
              localObject2 = paramString;
              localObject1 = paramString;
            }
          }
        }
        catch (Exception paramString)
        {
          String str;
          Object localObject2;
          localObject1 = null;
          QLog.e("ExtendFriendFeedView", 1, "getRandomFeedBackground fail.", paramString);
          return localObject1;
        }
        try
        {
          if (paramString.isRecycled())
          {
            localObject1 = paramString;
            localObject2 = new BitmapFactory.Options();
            localObject1 = paramString;
            ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
            localObject1 = paramString;
            ((BitmapFactory.Options)localObject2).inSampleSize = 2;
            localObject1 = paramString;
            localObject2 = afxw.decodeFile(str, (BitmapFactory.Options)localObject2);
            localObject1 = localObject2;
            ks.put(str, new WeakReference(localObject2));
          }
          return localObject2;
        }
        catch (Exception paramString)
        {
          continue;
        }
        str = afxw.kL(localObject1[i]);
        continue;
        label209:
        paramString = null;
        continue;
        label214:
        int i = -1;
      }
    }
    return null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.mBgRect != null) && (this.Q != null)) {
      paramCanvas.drawRoundRect(this.mBgRect, this.wm, this.wm, this.Q);
    }
    if (this.g != null) {
      this.g.draw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.mLayoutWidth = paramInt1;
    this.mLayoutHeight = paramInt2;
    bnv();
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = false;
      if (this.cbL != bool)
      {
        this.cbL = bool;
        if (!bool) {
          break label82;
        }
        this.Q.setColorFilter(d);
      }
      break;
    }
    for (;;)
    {
      invalidate();
      return false;
      bool = true;
      break;
      bool = false;
      break;
      label82:
      this.Q.setColorFilter(null);
    }
  }
  
  public void setFeedBgParams(int paramInt1, String paramString, int paramInt2)
  {
    setFeedBgParams(paramInt1, paramString, paramInt2, true);
  }
  
  public void setFeedBgParams(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.cVl = paramInt2;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFeedView", 0, "setFeedBgParams feedPosition:" + paramInt1 + " itemPaddingTop:" + paramInt2 + "  getPaddingTop:" + getPaddingTop());
    }
    setPadding(getPaddingLeft(), paramInt2, getPaddingRight(), getPaddingBottom());
    this.dw = z(paramString);
    if (paramBoolean) {}
    for (this.g = b(paramInt1);; this.g = null)
    {
      bnv();
      invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView
 * JD-Core Version:    0.7.0.1
 */