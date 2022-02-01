package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import ankt;
import aqgs;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class TroopActiveLayout
  extends View
  implements Handler.Callback
{
  private static final int[] oP = { 2130843375, 2130843376, 2130843376, 2130843377, 2130843378, 2130843379 };
  private volatile ArrayList<Bitmap> Cy;
  private ArrayList<Bitmap> Cz;
  private SizeableBitmapCache a;
  private boolean cSH;
  private int dXq = 0;
  private int dXr = 10;
  private int dXs;
  private volatile int dXt = 0;
  private final Object fq = new Object();
  private Context mContext;
  private RectF mDstRect;
  private Handler mMainHandler;
  private Paint mPaint;
  private Rect mSrcRect;
  private Handler mSubHandler;
  
  public TroopActiveLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopActiveLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TroopActiveLayout(Context arg1, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(???, paramAttributeSet, paramInt);
    Sizeable localSizeable = aqgs.a("TroopActiveLayout_cache");
    paramAttributeSet = localSizeable;
    if (!(localSizeable instanceof SizeableBitmapCache))
    {
      paramAttributeSet = new SizeableBitmapCache(41702);
      aqgs.a("TroopActiveLayout_cache", paramAttributeSet);
    }
    this.a = ((SizeableBitmapCache)paramAttributeSet);
    this.mContext = ???;
    this.mMainHandler = new Handler(this);
    synchronized (this.fq)
    {
      this.Cy = new ArrayList(this.dXr / 2 + 1);
      this.dXs = ankt.dip2px(3.0F);
      this.Cz = new ArrayList(this.dXr / 2 + 1);
      this.mSubHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mSrcRect = new Rect();
      this.mDstRect = new RectF();
      setHotLevel(this.dXt);
      this.cSH = "1103".equals(ThemeUtil.getCurrentThemeId());
      return;
    }
  }
  
  private void Xe(int paramInt)
  {
    int i = 0;
    Bitmap[] arrayOfBitmap = a(paramInt);
    if (arrayOfBitmap == null)
    {
      this.mSubHandler.sendMessage(Message.obtain(this.mSubHandler, 102, paramInt, 0));
      return;
    }
    for (;;)
    {
      synchronized (this.fq)
      {
        this.Cy.clear();
        int j = arrayOfBitmap.length;
        paramInt = i;
        if (paramInt < j)
        {
          Bitmap localBitmap = arrayOfBitmap[paramInt];
          if (localBitmap != null) {
            this.Cy.add(localBitmap);
          }
        }
        else
        {
          requestLayout();
          invalidate();
          return;
        }
      }
      paramInt += 1;
    }
  }
  
  private void Xf(int paramInt)
  {
    int n = 1;
    int j;
    int i;
    if ((Looper.myLooper() != Looper.getMainLooper()) || (paramInt % 2 == 1))
    {
      j = 1;
      if (j == 0) {
        break label290;
      }
      i = paramInt - 1;
      label29:
      if (i != 0) {
        break label420;
      }
    }
    label134:
    label290:
    label420:
    for (int k = 2;; k = i)
    {
      int m;
      label43:
      Bitmap localBitmap1;
      label89:
      int i1;
      Bitmap localBitmap2;
      if (j != 0)
      {
        m = paramInt;
        if (this.a.containsKey(Integer.valueOf(0))) {
          break label308;
        }
        localBitmap1 = q(oP[0]);
        if (localBitmap1 == null) {
          break label303;
        }
        this.a.put(Integer.valueOf(0), localBitmap1);
        i = 0;
        if ((k < this.dXq) || (k > this.dXr)) {
          break label414;
        }
        if (this.a.containsKey(Integer.valueOf(k))) {
          break label356;
        }
        i1 = paramInt / 2;
        if (i1 > 0) {
          break label329;
        }
        j = 1;
        localBitmap2 = q(oP[j]);
        if (localBitmap2 == null) {
          break label351;
        }
        this.a.put(Integer.valueOf(k), localBitmap2);
      }
      for (;;)
      {
        label165:
        Bitmap localBitmap3;
        if ((localBitmap1 != null) && (localBitmap2 != null) && (m >= this.dXq) && (m <= this.dXr)) {
          if (!this.a.containsKey(Integer.valueOf(m)))
          {
            localBitmap3 = f(localBitmap2, localBitmap1);
            if (localBitmap3 != null) {
              this.a.put(Integer.valueOf(m), localBitmap3);
            }
          }
        }
        for (;;)
        {
          label238:
          if ((localBitmap1 == null) && (localBitmap2 == null))
          {
            j = 1;
            label250:
            if ((i != 0) || (j != 0)) {
              break label406;
            }
          }
          for (i = n;; i = 0)
          {
            if (i != 0) {
              this.mMainHandler.sendMessage(Message.obtain(this.mMainHandler, 101, paramInt, 0));
            }
            return;
            j = 0;
            break;
            i = paramInt;
            break label29;
            m = paramInt + 1;
            break label43;
            label303:
            i = 1;
            break label89;
            label308:
            localBitmap1 = (Bitmap)this.a.get(Integer.valueOf(0));
            i = 0;
            break label89;
            label329:
            j = i1;
            if (i1 < oP.length) {
              break label134;
            }
            j = oP.length - 1;
            break label134;
            label351:
            i = 1;
            break label165;
            label356:
            localBitmap2 = (Bitmap)this.a.get(Integer.valueOf(k));
            break label165;
            i = 1;
            break label238;
            localBitmap3 = (Bitmap)this.a.get(Integer.valueOf(m));
            break label238;
            j = 0;
            break label250;
          }
        }
        localBitmap2 = null;
      }
    }
  }
  
  private Bitmap[] a(int paramInt)
  {
    int i = 1;
    int k = 0;
    int j = 0;
    int m = getIconSize();
    Bitmap localBitmap1 = (Bitmap)this.a.get(Integer.valueOf(0));
    if (paramInt % 2 == 1) {}
    Object localObject;
    while (i != 0)
    {
      localBitmap2 = (Bitmap)this.a.get(Integer.valueOf(paramInt));
      localObject = (Bitmap)this.a.get(Integer.valueOf(paramInt - 1));
      if ((localBitmap2 == null) || (localObject == null)) {
        break label229;
      }
      i = paramInt / 2;
      Bitmap[] arrayOfBitmap = new Bitmap[m];
      paramInt = j;
      for (;;)
      {
        if (paramInt < i)
        {
          arrayOfBitmap[paramInt] = localObject;
          paramInt += 1;
          continue;
          i = 0;
          break;
        }
      }
      arrayOfBitmap[i] = localBitmap2;
      paramInt = i + 1;
      while (paramInt < m)
      {
        arrayOfBitmap[paramInt] = localBitmap1;
        paramInt += 1;
      }
      return arrayOfBitmap;
    }
    Bitmap localBitmap2 = (Bitmap)this.a.get(Integer.valueOf(paramInt));
    if (localBitmap2 != null)
    {
      i = paramInt / 2;
      localObject = new Bitmap[m];
      paramInt = k;
      while (paramInt < i)
      {
        localObject[paramInt] = localBitmap2;
        paramInt += 1;
      }
      paramInt = i;
      while (paramInt < m)
      {
        localObject[paramInt] = localBitmap1;
        paramInt += 1;
      }
      return localObject;
    }
    label229:
    return null;
  }
  
  /* Error */
  private Bitmap f(@android.support.annotation.NonNull Bitmap paramBitmap1, @android.support.annotation.NonNull Bitmap paramBitmap2)
  {
    // Byte code:
    //   0: new 124	android/graphics/Paint
    //   3: dup
    //   4: invokespecial 125	android/graphics/Paint:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: iconst_1
    //   12: invokevirtual 131	android/graphics/Paint:setAntiAlias	(Z)V
    //   15: aload_1
    //   16: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   19: aload_1
    //   20: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   23: getstatic 241	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: invokestatic 245	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   29: astore_3
    //   30: new 247	android/graphics/Canvas
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 250	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   38: astore 5
    //   40: aload 5
    //   42: aload_1
    //   43: new 133	android/graphics/Rect
    //   46: dup
    //   47: iconst_0
    //   48: iconst_0
    //   49: aload_1
    //   50: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   53: iconst_2
    //   54: idiv
    //   55: aload_1
    //   56: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   59: invokespecial 253	android/graphics/Rect:<init>	(IIII)V
    //   62: new 133	android/graphics/Rect
    //   65: dup
    //   66: iconst_0
    //   67: iconst_0
    //   68: aload_1
    //   69: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   72: iconst_2
    //   73: idiv
    //   74: aload_1
    //   75: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   78: invokespecial 253	android/graphics/Rect:<init>	(IIII)V
    //   81: aload 4
    //   83: invokevirtual 257	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   86: aload 5
    //   88: aload_2
    //   89: new 133	android/graphics/Rect
    //   92: dup
    //   93: aload_2
    //   94: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   97: iconst_2
    //   98: idiv
    //   99: iconst_0
    //   100: aload_2
    //   101: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   104: aload_2
    //   105: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   108: invokespecial 253	android/graphics/Rect:<init>	(IIII)V
    //   111: new 133	android/graphics/Rect
    //   114: dup
    //   115: aload_1
    //   116: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   119: iconst_2
    //   120: idiv
    //   121: iconst_0
    //   122: aload_1
    //   123: invokevirtual 232	android/graphics/Bitmap:getWidth	()I
    //   126: aload_1
    //   127: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   130: invokespecial 253	android/graphics/Rect:<init>	(IIII)V
    //   133: aload 4
    //   135: invokevirtual 257	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   138: aload_3
    //   139: areturn
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_3
    //   143: ldc_w 259
    //   146: iconst_1
    //   147: aload_1
    //   148: iconst_0
    //   149: anewarray 60	java/lang/Object
    //   152: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: areturn
    //   157: astore_1
    //   158: goto -15 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	TroopActiveLayout
    //   0	161	1	paramBitmap1	Bitmap
    //   0	161	2	paramBitmap2	Bitmap
    //   29	127	3	localBitmap	Bitmap
    //   7	127	4	localPaint	Paint
    //   38	49	5	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   0	30	140	java/lang/Throwable
    //   30	138	157	java/lang/Throwable
  }
  
  private Bitmap q(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt, null);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("TroopActiveLayout", 1, localOutOfMemoryError, new Object[0]);
    }
    return null;
  }
  
  private int r(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3) {
      throw new IllegalArgumentException(String.format("getValueWithLimit min value %s is greater than max value %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private int r(int paramInt, boolean paramBoolean)
  {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    switch (i)
    {
    default: 
      return 0;
    case 0: 
    case -2147483648: 
      this.Cz.clear();
      synchronized (this.fq)
      {
        this.Cz.addAll(this.Cy);
        if (!paramBoolean) {
          break label164;
        }
        i = this.Cz.size();
        if (i <= 0) {
          return paramInt;
        }
      }
      ??? = this.Cz.iterator();
      for (paramInt = 0; ((Iterator)???).hasNext(); paramInt = ((Bitmap)((Iterator)???).next()).getWidth() + paramInt) {}
      return (i - 1) * this.dXs + paramInt + (getPaddingLeft() + getPaddingRight());
      label164:
      ??? = this.Cz.iterator();
      for (paramInt = 0; ((Iterator)???).hasNext(); paramInt = Math.max(paramInt, ((Bitmap)((Iterator)???).next()).getHeight())) {}
      return getPaddingTop() + getPaddingBottom() + paramInt;
    }
    return paramInt;
  }
  
  public int getIconSize()
  {
    return (this.dXr + 1) / 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Xe(paramMessage.arg1);
      continue;
      Xf(paramMessage.arg1);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = getWidth();
    int i = getHeight();
    int k = getPaddingLeft();
    int i1 = getPaddingRight();
    int m = getPaddingTop();
    int j = getPaddingBottom();
    k = r(k, 0, n);
    n = r(n - i1, 0, n);
    m = r(m, 0, i);
    i = r(i - j, 0, i);
    k = n - k;
    j = i - m;
    if ((k <= 0) || (j <= 0)) {
      return;
    }
    this.Cz.clear();
    label496:
    for (;;)
    {
      synchronized (this.fq)
      {
        this.Cz.addAll(this.Cy);
        i = this.Cz.size();
        if (i <= 0) {
          break;
        }
        k = (k - this.dXs * (i - 1)) / i;
        if (k <= 0) {
          break;
        }
        float f1 = j / k;
        if (this.cSH) {
          this.mPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
        }
        ??? = this.Cz.iterator();
        i = 0;
        if (!((Iterator)???).hasNext()) {
          break;
        }
        Bitmap localBitmap = (Bitmap)((Iterator)???).next();
        if (localBitmap == null) {
          break label496;
        }
        m = localBitmap.getHeight();
        n = localBitmap.getWidth();
        f3 = m / n;
        this.mSrcRect.left = 0;
        this.mSrcRect.top = 0;
        this.mSrcRect.right = localBitmap.getWidth();
        this.mSrcRect.bottom = localBitmap.getHeight();
        if (f1 > f3)
        {
          f2 = f3 * k;
          f3 = k;
          this.mDstRect.left = i;
          this.mDstRect.top = ((j - f2) / 2.0F);
          this.mDstRect.right = (f3 + i);
          this.mDstRect.bottom = (j - (j - f2) / 2.0F);
          paramCanvas.drawBitmap(localBitmap, this.mSrcRect, this.mDstRect, this.mPaint);
          i = this.dXs + k + i;
        }
      }
      float f2 = j;
      float f3 = j / f3;
      this.mDstRect.left = (i + (k - f3) / 2.0F);
      this.mDstRect.top = 0.0F;
      this.mDstRect.right = (i + k - (k - f3) / 2.0F);
      this.mDstRect.bottom = f2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(r(paramInt1, true), r(paramInt2, false));
  }
  
  public void setHotLevel(int paramInt)
  {
    if ((paramInt < this.dXq) || (paramInt > this.dXr)) {
      throw new IllegalArgumentException(String.format("setHotLevel error, level[%s] is out of range", new Object[] { Integer.valueOf(paramInt) }));
    }
    this.dXt = paramInt;
    this.mMainHandler.sendMessage(Message.obtain(this.mMainHandler, 101, paramInt, 0));
  }
  
  static class SizeableBitmapCache
    extends ConcurrentHashMap<Integer, Bitmap>
    implements Sizeable
  {
    private int mFixSize;
    
    SizeableBitmapCache(int paramInt)
    {
      this.mFixSize = paramInt;
    }
    
    public int getByteSize()
    {
      return this.mFixSize;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopActiveLayout
 * JD-Core Version:    0.7.0.1
 */