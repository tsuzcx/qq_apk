package com.tencent.mobileqq.surfaceviewaction.nv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import anxu;
import anxz;
import anyz;
import java.util.ArrayList;
import java.util.Iterator;

public class SpriteNativeView
  extends FrameLayout
  implements anxz<anyz>, Runnable
{
  private Handler dv = new Handler(Looper.getMainLooper());
  private ArrayList<anyz> mNodes = new ArrayList(10);
  
  public SpriteNativeView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SpriteNativeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int Kz()
  {
    return 0;
  }
  
  public void a(int paramInt, anyz paramanyz)
  {
    if (!this.mNodes.contains(paramanyz))
    {
      this.mNodes.add(paramInt, paramanyz);
      paramanyz.onAdded();
    }
  }
  
  public void b(anyz paramanyz)
  {
    a(this.mNodes.size(), paramanyz);
  }
  
  public void dTW()
  {
    Iterator localIterator = this.mNodes.iterator();
    for (boolean bool = false; localIterator.hasNext(); bool = ((anyz)localIterator.next()).azq() | bool) {}
    if (bool) {
      this.dv.postDelayed(this, 16L);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mNodes.iterator();
    while (localIterator.hasNext()) {
      ((anxu)localIterator.next()).release();
    }
    this.mNodes.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    dTW();
  }
  
  public void onPause()
  {
    Iterator localIterator = this.mNodes.iterator();
    while (localIterator.hasNext()) {
      ((anxu)localIterator.next()).pause();
    }
  }
  
  public void onResume()
  {
    Iterator localIterator = this.mNodes.iterator();
    while (localIterator.hasNext()) {
      ((anxu)localIterator.next()).resume();
    }
  }
  
  public void run()
  {
    dTW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView
 * JD-Core Version:    0.7.0.1
 */