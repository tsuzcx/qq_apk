package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import aqhu;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import xdw;

public class HeartBreakCombolEffectView
  extends View
  implements Runnable
{
  static boolean mIsAnimating;
  DecodeRunnable a;
  int bTe = 0;
  Handler by;
  Bitmap ea;
  int mCurIndex = 0;
  Paint mPaint = new Paint(6);
  Handler mUiHandler;
  private Vector<Bitmap> p = new Vector();
  public ArrayList<Bitmap> qB = new ArrayList();
  ArrayList<a> qC = new ArrayList();
  
  public HeartBreakCombolEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HeartBreakCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeartBreakCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void cdM()
  {
    String str = PokeBigResHandler.brt + "/xinsui_caidan/xinsui_caidan_";
    int i = 0;
    if (i < 55)
    {
      if (i + 1 < 10) {
        cB(str + "0" + (i + 1) + ".png", 30);
      }
      for (;;)
      {
        i += 1;
        break;
        cB(str + (i + 1) + ".png", 30);
      }
    }
  }
  
  private void init()
  {
    setOnTouchListener(new xdw(this));
    this.mUiHandler = new Handler(Looper.getMainLooper());
    cdM();
    HandlerThread localHandlerThread = new HandlerThread("decode");
    localHandlerThread.start();
    this.by = new Handler(localHandlerThread.getLooper());
  }
  
  public Bitmap al()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.qB != null)
    {
      localObject1 = localObject2;
      if (this.qB.size() > 0) {
        localObject1 = (Bitmap)this.qB.remove(0);
      }
    }
    return localObject1;
  }
  
  public void cB(String paramString, int paramInt)
  {
    a locala = new a();
    locala.path = paramString;
    locala.aCm = paramInt;
    this.qC.add(locala);
  }
  
  public void clear()
  {
    if ((this.ea != null) && (!this.ea.isRecycled()))
    {
      this.ea.recycle();
      this.ea = null;
    }
    Iterator localIterator;
    if (this.qB.size() > 0)
    {
      localIterator = this.qB.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.qB.clear();
    }
    if (this.p.size() > 0)
    {
      localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.p.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.ea != null)
    {
      int i = this.ea.getWidth();
      int j = this.ea.getHeight();
      int k = getWidth();
      int m = getHeight();
      float f = k * 1.0F / i;
      paramCanvas.translate(0.0F, (int)(m / 2 - j * f / 2.0F) + 50);
      Rect localRect1 = new Rect(0, 0, i, j);
      Rect localRect2 = new Rect(0, 0, k, (int)(j * f));
      paramCanvas.drawBitmap(this.ea, localRect1, localRect2, this.mPaint);
    }
  }
  
  public void end()
  {
    this.mCurIndex = 0;
    this.bTe = 0;
    mIsAnimating = false;
    this.mUiHandler.removeCallbacks(this);
    this.by.post(this.a);
    this.a = null;
    setVisibility(8);
  }
  
  public void run()
  {
    int i = this.mCurIndex + 1;
    if (i < 55)
    {
      if (this.a == null) {
        this.a = new DecodeRunnable(this.qB);
      }
      a locala = (a)this.qC.get(i);
      this.by.removeCallbacks(this.a);
      this.by.post(this.a);
      this.mCurIndex += 1;
      Bitmap localBitmap;
      if ((this.ea != null) && (!this.ea.isRecycled()))
      {
        localBitmap = this.ea;
        if (this.p.size() > 2) {
          break label150;
        }
        this.p.add(localBitmap);
      }
      for (;;)
      {
        this.ea = al();
        invalidate();
        this.mUiHandler.postDelayed(this, locala.aCm);
        return;
        label150:
        localBitmap.recycle();
      }
    }
    end();
  }
  
  public void start()
  {
    if (mIsAnimating == true) {
      return;
    }
    setVisibility(0);
    this.mUiHandler.removeCallbacks(this);
    this.mUiHandler.post(this);
    this.ea = aqhu.d(((a)this.qC.get(this.mCurIndex)).path, null);
    mIsAnimating = true;
  }
  
  public class DecodeRunnable
    implements Runnable
  {
    BitmapFactory.Options d = new BitmapFactory.Options();
    ArrayList<Bitmap> qD;
    
    public DecodeRunnable()
    {
      Object localObject;
      this.qD = localObject;
    }
    
    public void run()
    {
      Object localObject3;
      while ((this.qD.size() < 2) && (HeartBreakCombolEffectView.this.bTe < HeartBreakCombolEffectView.this.qC.size()) && (HeartBreakCombolEffectView.mIsAnimating))
      {
        localObject1 = HeartBreakCombolEffectView.this.qC;
        localObject3 = HeartBreakCombolEffectView.this;
        int i = ((HeartBreakCombolEffectView)localObject3).bTe;
        ((HeartBreakCombolEffectView)localObject3).bTe = (i + 1);
        localObject3 = (HeartBreakCombolEffectView.a)((ArrayList)localObject1).get(i);
        if (localObject3 != null)
        {
          this.d.inSampleSize = 1;
          this.d.inPreferredConfig = Bitmap.Config.ARGB_4444;
          this.d.inMutable = true;
          if (HeartBreakCombolEffectView.a(HeartBreakCombolEffectView.this).size() <= 0) {
            break label218;
          }
        }
      }
      Object localObject2;
      label218:
      for (Object localObject1 = (Bitmap)HeartBreakCombolEffectView.a(HeartBreakCombolEffectView.this).remove(0);; localObject2 = null)
      {
        for (;;)
        {
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.Sx())) {
            this.d.inBitmap = ((Bitmap)localObject1);
          }
          try
          {
            localObject1 = aqhu.d(((HeartBreakCombolEffectView.a)localObject3).path, this.d);
            if (localObject1 == null) {
              break;
            }
            this.qD.add(localObject1);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("HeartBreak", 2, localOutOfMemoryError.toString());
              }
              localObject2 = null;
            }
          }
        }
        if (!HeartBreakCombolEffectView.mIsAnimating) {
          HeartBreakCombolEffectView.this.clear();
        }
        return;
      }
    }
  }
  
  public class a
  {
    int aCm;
    String path;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView
 * JD-Core Version:    0.7.0.1
 */