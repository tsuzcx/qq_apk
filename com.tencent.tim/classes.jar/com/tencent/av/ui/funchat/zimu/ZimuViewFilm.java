package com.tencent.av.ui.funchat.zimu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.av.app.VideoAppInterface;
import ijn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import jhc.a;
import jhd;
import jhe;

public class ZimuViewFilm
  extends ZimuView
{
  jhc.a[] a = { new jhc.a(Color.parseColor("#ffffff"), Color.parseColor("#000000"), 5), new jhc.a(Color.parseColor("#fdeabd"), Color.parseColor("#000000"), 4) };
  WeakReference<ZimuView> bM = new WeakReference(this);
  final int[] cQ = { 44, 30 };
  
  public ZimuViewFilm(long paramLong, VideoAppInterface paramVideoAppInterface, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramLong, paramVideoAppInterface, paramContext, paramAttributeSet);
    float f = this.hY * 0.48F;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.cQ.length) {
        break;
      }
      paramVideoAppInterface = this.cQ;
      paramVideoAppInterface[i] = ((int)(paramVideoAppInterface[i] * f));
      i += 1;
    }
    while (j < this.a.length)
    {
      paramVideoAppInterface = this.a[j];
      paramVideoAppInterface.hX *= f;
      j += 1;
    }
  }
  
  protected List<jhd> a(ijn paramijn, boolean paramBoolean)
  {
    removeAllView();
    jhe localjhe = new jhe(getContext(), this.bM, this.mScreenWidth, 0, this.hY);
    localjhe.setRecycle(paramBoolean);
    localjhe.setPosition(0, 0);
    localjhe.a(this.mTypeface, this.cQ[0], this.a[0]);
    localjhe.b(this.mTypeface, this.cQ[1], this.a[1]);
    localjhe.a(paramijn);
    localjhe.start(0L);
    paramijn = new ArrayList();
    paramijn.add(localjhe);
    return paramijn;
  }
  
  void awr()
  {
    jhe localjhe = (jhe)this.fj.get(0);
    if ((localjhe != null) && (localjhe.xo())) {
      requestRender();
    }
  }
  
  public String getID()
  {
    return "film";
  }
  
  public int getViewHeight()
  {
    return (int)getContext().getResources().getDimension(2131298135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuViewFilm
 * JD-Core Version:    0.7.0.1
 */