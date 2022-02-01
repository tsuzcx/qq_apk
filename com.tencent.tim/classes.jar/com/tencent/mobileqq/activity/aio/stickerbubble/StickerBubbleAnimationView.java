package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import wja;
import yfu.a;
import yfu.b;
import yfv;
import yfx;
import yfy;
import yfy.a;
import yga;
import yga.a;

public class StickerBubbleAnimationView
  extends View
  implements View.OnAttachStateChangeListener, yga.a
{
  private static SparseArray<Float> bA = new SparseArray();
  private long JR;
  private long JS;
  private int LJ;
  private b a;
  private String aXB = "";
  private boolean bmq = true;
  private Map<String, List<yga>> bq;
  private Set<String> bu;
  private List<Long> dC;
  private Map<String, List<yga>> hV;
  private Map<String, BitmapDrawable[]> hW;
  private Map<String, Integer> hX;
  private Map<String, List<a>> hY;
  private Paint mPaint;
  private Paint mStrokePaint;
  
  public StickerBubbleAnimationView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void KN()
  {
    int j = 0;
    if ((this.bq.isEmpty()) && (this.hV.isEmpty())) {}
    label183:
    for (;;)
    {
      return;
      int k = 1;
      Iterator localIterator = this.bq.keySet().iterator();
      String str;
      do
      {
        i = k;
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((List)this.bq.get(str)).isEmpty());
      int i = 0;
      localIterator = this.hV.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!((List)this.hV.get(str)).isEmpty()) {
          i = j;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label183;
        }
        this.aXB = "";
        if (this.a == null) {
          break;
        }
        this.a.onAnimationEnd();
        return;
      }
    }
  }
  
  @Nullable
  private Bitmap a(@NonNull Bitmap paramBitmap, double paramDouble)
  {
    paramDouble = getResources().getDisplayMetrics().density * paramDouble / 2.75D;
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramDouble), (int)(paramDouble * paramBitmap.getHeight()), true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.e("StickerBubbleAnimationView", 1, "oom when scale bitmap");
    }
    return null;
  }
  
  private BitmapDrawable a(long paramLong1, long paramLong2, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    paramInt = (int)((paramLong1 - paramLong2) / paramInt % paramArrayOfBitmapDrawable.length);
    while (paramInt >= 0)
    {
      if (paramArrayOfBitmapDrawable[paramInt] != null) {
        return paramArrayOfBitmapDrawable[paramInt];
      }
      paramInt -= 1;
    }
    return paramArrayOfBitmapDrawable[0];
  }
  
  private yga a(a parama, long paramLong)
  {
    yfu.b localb = new yfu.b(a.a(parama));
    yfu.a locala = new yfu.a(a.a(parama));
    parama = new yga(((BitmapDrawable[])this.hW.get(a.a(parama)))[0], a.a(parama), localb, locala, 1.0D, paramLong, a.a(parama), a.a(parama));
    parama.a(this);
    return parama;
  }
  
  private void a(a parama, long paramLong)
  {
    List localList;
    Object localObject;
    if (a.a(parama))
    {
      localList = (List)this.hV.get(a.a(parama));
      localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        if (!a.a(parama)) {
          break label111;
        }
        this.hV.put(a.a(parama), localObject);
      }
      label66:
      if (!a.a(parama)) {
        break label130;
      }
    }
    label130:
    for (parama = b(parama, paramLong);; parama = a(parama, paramLong))
    {
      ((List)localObject).add(parama);
      return;
      localList = (List)this.bq.get(a.a(parama));
      break;
      label111:
      this.bq.put(a.a(parama), localObject);
      break label66;
    }
  }
  
  private void a(Set<String> paramSet, long paramLong, Canvas paramCanvas)
  {
    label392:
    label399:
    for (;;)
    {
      long l;
      int i;
      Object localObject2;
      Object localObject1;
      List localList;
      BitmapDrawable[] arrayOfBitmapDrawable;
      int k;
      Object localObject3;
      try
      {
        l = SystemClock.uptimeMillis();
        i = 0;
        paramSet = paramSet.iterator();
        if (paramSet.hasNext())
        {
          localObject2 = (String)paramSet.next();
          if (!this.hW.containsKey(localObject2)) {
            break label399;
          }
          localObject1 = (List)this.bq.get(localObject2);
          localList = (List)this.hV.get(localObject2);
          arrayOfBitmapDrawable = (BitmapDrawable[])this.hW.get(localObject2);
          k = ((Integer)this.hX.get(localObject2)).intValue();
          if (localObject1 == null) {
            break label392;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (yga)((Iterator)localObject2).next();
            BitmapDrawable localBitmapDrawable = a(paramLong, ((yga)localObject3).aB(), arrayOfBitmapDrawable, k);
            ((yga)localObject3).a(paramCanvas, this.mPaint, paramLong, localBitmapDrawable);
            continue;
          }
          j = ((List)localObject1).size() + i;
        }
      }
      catch (Exception paramSet)
      {
        QLog.e("StickerBubbleAnimationView", 1, "throw exception in doDraw: " + paramSet);
        return;
      }
      for (;;)
      {
        i = j;
        if (localList == null) {
          break label399;
        }
        localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (yga)((Iterator)localObject1).next();
          localObject3 = a(paramLong, ((yga)localObject2).aB(), arrayOfBitmapDrawable, k);
          ((yga)localObject2).a(paramCanvas, this.mPaint, paramLong, (Drawable)localObject3);
        }
        i = j + localList.size();
        break label399;
        if (this.bmq) {
          b(paramCanvas, paramLong);
        }
        paramLong = SystemClock.uptimeMillis();
        if ((!QLog.isColorLevel()) || (this.JS % 60L != 0L)) {
          break;
        }
        QLog.d("StickerBubbleAnimationViewCost", 2, "draw " + i + " items, take time " + (paramLong - l));
        return;
        int j = i;
      }
    }
  }
  
  private void a(yfv paramyfv, BitmapDrawable[] paramArrayOfBitmapDrawable, String paramString, int paramInt)
  {
    ThreadManager.post(new StickerBubbleAnimationView.2(this, paramArrayOfBitmapDrawable, paramyfv, paramString, paramInt), 8, null, true);
  }
  
  private yga b(a parama, long paramLong)
  {
    yfu.b localb = new yfu.b(a.a(parama));
    yfu.a locala = new yfu.a(a.a(parama));
    parama = new yga(((BitmapDrawable[])this.hW.get(a.a(parama)))[0], a.a(parama), localb, locala, paramLong, 1.7D, true, a.a(parama), a.a(parama));
    parama.a(this);
    return parama;
  }
  
  private void b(Canvas paramCanvas, long paramLong)
  {
    int i = this.LJ;
    String str;
    float f1;
    if (i > 1)
    {
      str = Integer.toString(i);
      if (i >= 10) {
        break label246;
      }
      f1 = wja.dp2px(i * 2.5F + 50.0F, getResources());
      if (f1 >= 0.0F) {
        break label392;
      }
      Float localFloat = (Float)bA.get(str.length());
      if (localFloat == null) {
        break label296;
      }
      f1 = localFloat.floatValue();
    }
    label392:
    for (;;)
    {
      this.mPaint.setTextSize(f1);
      this.mStrokePaint.setTextSize(f1);
      f1 = this.mPaint.measureText(str);
      i = (int)((paramCanvas.getWidth() - f1) / 2.0F);
      int j = paramCanvas.save();
      int k = (int)(paramCanvas.getHeight() / 8 - this.mPaint.getFontMetrics().ascent);
      float f2 = f(paramLong);
      float f3 = i;
      paramCanvas.rotate(f2, f1 / 2.0F + f3, k + this.mPaint.getFontMetrics().ascent / 2.0F);
      paramCanvas.drawText(str, i, k, this.mStrokePaint);
      paramCanvas.drawText(str, i, k, this.mPaint);
      paramCanvas.restoreToCount(j);
      if (this.JR == 0L) {
        this.JR = paramLong;
      }
      return;
      label246:
      if (i < 100)
      {
        f1 = wja.dp2px((i - 10) * 0.2777778F + 75.0F, getResources());
        break;
      }
      f1 = wja.dp2px(100.0F, getResources());
      break;
      label296:
      i = 200;
      for (;;)
      {
        if (i > 0)
        {
          f1 = wja.dp2px(i, getResources());
          this.mPaint.setTextSize(f1);
          if (this.mPaint.measureText(str) >= getResources().getDisplayMetrics().widthPixels - wja.dp2px(48.0F, getResources())) {}
        }
        else
        {
          bA.put(str.length(), Float.valueOf(f1));
          break;
        }
        i -= 10;
      }
    }
  }
  
  private float f(long paramLong)
  {
    if (this.JR == 0L) {
      return 0.0F;
    }
    double d = (paramLong - this.JR) % 400L / 400.0D * 20.0D;
    if (d < 10.0D) {}
    for (d -= 5.0D;; d = 10.0D - (d - 10.0D) - 5.0D) {
      return (float)d;
    }
  }
  
  private void g(Set<String> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!this.hW.containsKey(str))
      {
        yfy.a locala = yfy.a(str);
        if (locala != null)
        {
          this.hW.put(str, locala.a());
          this.hX.put(str, Integer.valueOf(locala.getFrameDelay()));
          if (QLog.isColorLevel()) {
            QLog.d("StickerBubbleAnimationView", 2, "get frames from cache");
          }
        }
        else if (!this.bu.contains(str))
        {
          this.bu.add(str);
          yC(str);
        }
      }
    }
  }
  
  private void init()
  {
    setBackgroundColor(0);
    this.mPaint = new Paint();
    this.mPaint.setColor(Color.parseColor("#FFDC4F"));
    this.mPaint.setAntiAlias(true);
    if (yfx.mTypeface == null) {
      yfx.chW();
    }
    this.mPaint.setTypeface(yfx.mTypeface);
    this.mStrokePaint = new Paint(this.mPaint);
    this.mStrokePaint.setTypeface(yfx.mTypeface);
    this.mStrokePaint.setStyle(Paint.Style.STROKE);
    this.mStrokePaint.setColor(Color.parseColor("#418DFF"));
    this.mStrokePaint.setStrokeWidth(30.0F);
    setFocusable(false);
    setClickable(false);
    this.bq = new HashMap();
    this.hV = new HashMap();
    this.hW = new HashMap();
    this.hX = new HashMap();
    this.hY = new HashMap();
    this.bu = new HashSet();
    this.dC = new ArrayList(70);
    addOnAttachStateChangeListener(this);
  }
  
  private void yC(String paramString)
  {
    ThreadManager.postImmediately(new StickerBubbleAnimationView.3(this, paramString), null, true);
  }
  
  public void KO()
  {
    this.aXB = "";
  }
  
  public void a(a parama)
  {
    if (!this.aXB.equals(a.a(parama)))
    {
      this.LJ = 0;
      this.aXB = a.a(parama);
    }
    this.LJ += 1;
    List localList = (List)this.hY.get(a.a(parama));
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.hY.put(a.a(parama), localObject);
    }
    ((List)localObject).add(parama);
  }
  
  public void a(yga paramyga)
  {
    post(new StickerBubbleAnimationView.1(this, paramyga));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.JS += 1L;
    SystemClock.uptimeMillis();
    Set localSet = this.hY.keySet();
    g(localSet);
    long l = SystemClock.uptimeMillis();
    Iterator localIterator1 = localSet.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      if (this.hW.containsKey(localObject))
      {
        localObject = (List)this.hY.get(localObject);
        if (localObject == null) {
          return;
        }
        Iterator localIterator2 = ((List)localObject).iterator();
        while (localIterator2.hasNext()) {
          a((a)localIterator2.next(), l);
        }
        ((List)localObject).clear();
      }
    }
    a(localSet, l, paramCanvas);
    KN();
    SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationView", 2, "onViewAttachedToWindow");
    }
    yfy.chX();
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationView", 2, "onViewDetachedFromWindow");
    }
    this.bq.clear();
    this.hV.clear();
    this.hW.clear();
    this.hX.clear();
    this.hY.clear();
    this.bu.clear();
    if (this.a != null) {
      this.a.onSurfaceDestroyed();
    }
  }
  
  public void setAnimationCallback(b paramb)
  {
    this.a = paramb;
  }
  
  public void setShowText(boolean paramBoolean)
  {
    this.bmq = paramBoolean;
  }
  
  public static class a
  {
    private int LL;
    private String aXD;
    private yfu.a jdField_b_of_type_Yfu$a;
    private yfu.b jdField_b_of_type_Yfu$b;
    private Point point;
    private boolean wm;
    
    public a(Point paramPoint, String paramString, boolean paramBoolean, yfu.b paramb, yfu.a parama, int paramInt)
    {
      this.point = paramPoint;
      this.aXD = paramString;
      this.wm = paramBoolean;
      this.jdField_b_of_type_Yfu$b = paramb;
      this.jdField_b_of_type_Yfu$a = parama;
      this.LL = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void onAnimationEnd();
    
    public abstract void onSurfaceDestroyed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView
 * JD-Core Version:    0.7.0.1
 */