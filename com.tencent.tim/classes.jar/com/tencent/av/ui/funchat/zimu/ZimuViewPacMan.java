package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import igd;
import ijn;
import imm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import jhc.a;
import jhd;
import jhg;
import jhg.a;

public class ZimuViewPacMan
  extends ZimuViewMotion
{
  static final jhc.a[] a = { new jhc.a(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 4) };
  WeakReference<ZimuView> bM;
  int[] cQ = { 48, 38, 34 };
  final int[] cR = { 70, 58, 52 };
  int[] cS = { 116, 102, 90 };
  Bitmap[] f = { null, null };
  List<a> fF = new ArrayList(4);
  Random mRandom = new Random();
  
  public ZimuViewPacMan(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    int i = 0;
    while (i < 4)
    {
      paramVideoAppInterface = new a(i, 0);
      this.fF.add(paramVideoAppInterface);
      i += 1;
    }
    this.bM = new WeakReference(this);
  }
  
  protected List<jhd> a(ijn paramijn, boolean paramBoolean)
  {
    anO();
    ArrayList localArrayList = new ArrayList();
    int k = this.mRandom.nextInt(40);
    int m = this.cR.length;
    int n = this.cS.length;
    int i = k % this.cQ.length;
    int j = mA();
    Object localObject = new jhg.a(this.f, this.cS[(k % n)], this.cR[(k % m)], j);
    localObject = new jhg(getContext(), this.bM, this.mScreenWidth, this.mScreenHeight, this.hY, (jhg.a)localObject);
    ((jhg)localObject).setRecycle(paramBoolean);
    ((jhg)localObject).a(this.mTypeface, this.cQ[i], a[0]);
    ((jhg)localObject).a(paramijn);
    m = this.azU;
    k = ((jhg)localObject).getHeight();
    j = L(m * j, k);
    ((jhg)localObject).setPosition(this.mScreenWidth, j);
    ((jhg)localObject).start(0L);
    localArrayList.add(localObject);
    igd.aJ("ZimuViewPacMan", "onCreateItemView:|" + j + "|" + k + "|" + this.azU + "|" + this.cQ[i]);
    return localArrayList;
  }
  
  protected void a(jhd paramjhd)
  {
    ny(((jhg)paramjhd).my());
  }
  
  protected void b(jhd paramjhd)
  {
    super.b(paramjhd);
    paramjhd.releaseBitmap();
    paramjhd = (jhg)paramjhd;
    int i = this.mRandom.nextInt(40);
    int j = this.cS.length;
    int k = this.cR.length;
    int m = this.cQ.length;
    int n = mA();
    paramjhd.a(new jhg.a(this.f, this.cS[(i % j)], this.cR[(i % k)], n));
    paramjhd.a(this.mTypeface, this.cQ[(i % m)], a[0]);
    i = L(this.azU * n, paramjhd.getHeight());
    paramjhd.setPosition(this.mScreenWidth, i);
    paramjhd.start(0L);
  }
  
  long bT()
  {
    long l = imm.getMaxCpuFreq();
    if (l > 1800000L) {
      this.py = 50L;
    }
    for (;;)
    {
      return this.py;
      if (l > 1400000L) {
        this.py = 62L;
      } else {
        this.py = 83L;
      }
    }
  }
  
  public String getID()
  {
    return "pacman";
  }
  
  public void init()
  {
    int j = 0;
    float f1 = this.hY * 0.48F;
    int k = this.cQ.length;
    int i = 0;
    int[] arrayOfInt;
    while (i < k)
    {
      arrayOfInt = this.cQ;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f1));
      i += 1;
    }
    k = this.cR.length;
    i = 0;
    while (i < k)
    {
      arrayOfInt = this.cR;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f1));
      i += 1;
    }
    k = this.cS.length;
    i = j;
    while (i < k)
    {
      arrayOfInt = this.cS;
      arrayOfInt[i] = ((int)(arrayOfInt[i] * f1));
      i += 1;
    }
    try
    {
      this.f[0] = BitmapFactory.decodeResource(getContext().getResources(), 2130843162);
      this.f[1] = BitmapFactory.decodeResource(getContext().getResources(), 2130843163);
      bT();
      super.init();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  int mA()
  {
    int i = this.fj.size();
    int j = this.fF.size();
    if (i < j)
    {
      i = j - i;
      if (i <= 1) {}
    }
    for (i = this.mRandom.nextInt(i * 10) % i;; i = 0)
    {
      a locala = (a)this.fF.get(i);
      locala.usercount += 1;
      this.fF.remove(i);
      this.fF.add(locala);
      return locala.index;
    }
  }
  
  void ny(int paramInt)
  {
    Iterator localIterator = this.fF.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.index == paramInt)
      {
        locala.usercount -= 1;
        if (locala.usercount == 0)
        {
          localIterator.remove();
          this.fF.add(0, locala);
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    int j = this.f.length;
    int i = 0;
    while (i < j)
    {
      if (this.f[i] != null)
      {
        this.f[i].recycle();
        this.f[i] = null;
      }
      i += 1;
    }
  }
  
  class a
  {
    int index;
    int usercount;
    
    public a(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.usercount = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewPacMan
 * JD-Core Version:    0.7.0.1
 */