package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import igd;
import ijn;
import imm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jhc.a;
import jhd;
import jhh;

public class ZimuViewRibon
  extends ZimuViewMotion
{
  jhc.a[] a = { new jhc.a(Color.parseColor("#cc8de1"), Color.parseColor("#ffffff"), 7), new jhc.a(Color.parseColor("#57d4d9"), Color.parseColor("#ffffff"), 7), new jhc.a(Color.parseColor("#ffc903"), Color.parseColor("#ffffff"), 7) };
  private int azW = this.mRandom.nextInt() & 0x1;
  WeakReference<ZimuView> bM = new WeakReference(this);
  int[] cQ = { 86, 60, 56, 44, 32 };
  private int mIndex;
  Random mRandom = new Random();
  
  public ZimuViewRibon(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
  }
  
  @NonNull
  private jhh a(ijn paramijn, int paramInt1, int paramInt2, boolean paramBoolean, jhh paramjhh)
  {
    int j = this.cQ.length;
    int i = this.a.length;
    j = paramInt1 % j;
    paramjhh.setRecycle(paramBoolean);
    paramjhh.a(this.mTypeface, this.cQ[j], this.a[(paramInt1 % i)]);
    paramjhh.a(paramijn);
    i = L(this.azU * (paramInt1 % 4), paramjhh.getHeight());
    paramjhh.setPosition(this.mScreenWidth, i);
    igd.aJ("ZimuViewRibon", "onCreateItemView:" + paramInt1 + "|" + paramInt2 + "|" + i + "|" + this.azU + "|" + this.cQ[j]);
    paramjhh.start(paramInt2);
    return paramjhh;
  }
  
  protected List<jhd> a(ijn paramijn, boolean paramBoolean)
  {
    anO();
    ArrayList localArrayList = new ArrayList();
    jhh localjhh;
    int k;
    if (this.mIndex % 3 == 0)
    {
      i = this.mRandom.nextInt(3000);
      if ((i & 0x1) == 1)
      {
        j = 1;
        localjhh = new jhh(getContext(), this.bM, this.mScreenWidth, this.mScreenHeight, this.hY);
        int m = this.azW;
        if (j == 0) {
          break label243;
        }
        k = i;
        label86:
        localArrayList.add(a(paramijn, m, k, paramBoolean, localjhh));
        this.azW += 1;
        localjhh = new jhh(getContext(), this.bM, this.mScreenWidth, this.mScreenHeight, this.hY);
        k = this.azW;
        if (j != 0) {
          break label249;
        }
      }
      for (;;)
      {
        localArrayList.add(a(paramijn, k, i, paramBoolean, localjhh));
        igd.aJ("ZimuViewRibon", "onCreateItemView random 00 :" + this.azW + "||" + paramijn.l);
        this.azW += 1;
        this.mIndex += 1;
        return localArrayList;
        j = 0;
        break;
        label243:
        k = 0;
        break label86;
        label249:
        i = 0;
      }
    }
    int j = this.mRandom.nextInt(3000);
    if ((j & 0x1) == 1)
    {
      i = 1;
      label276:
      localjhh = new jhh(getContext(), this.bM, this.mScreenWidth, this.mScreenHeight, this.hY);
      k = this.azW;
      if (i == 0) {
        break label384;
      }
    }
    label384:
    for (int i = j;; i = 0)
    {
      localArrayList.add(a(paramijn, k, i, paramBoolean, localjhh));
      igd.aJ("ZimuViewRibon", "onCreateItemView random zz :" + this.azW + "|" + paramijn.l);
      break;
      i = 0;
      break label276;
    }
  }
  
  protected void b(jhd paramjhd)
  {
    super.b(paramjhd);
    paramjhd.releaseBitmap();
    ijn localijn = paramjhd.a;
    paramjhd = (jhh)paramjhd;
    a(localijn, this.azW, 0, true, paramjhd);
    this.azW += 1;
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
    return "ribbon";
  }
  
  public void init()
  {
    int j = 0;
    float f = this.hY * 0.48F;
    int k = this.cQ.length;
    int i = 0;
    while (i < k)
    {
      this.cQ[i] = ((int)(this.cQ[i] * f));
      i += 1;
    }
    k = this.a.length;
    i = j;
    while (i < k)
    {
      this.a[i].hX *= f;
      i += 1;
    }
    bT();
    super.init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewRibon
 * JD-Core Version:    0.7.0.1
 */