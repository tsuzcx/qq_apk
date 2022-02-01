package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import anyb;
import anyc;
import anyf;
import anyg;
import anyj;
import anyq;
import anyq.a;
import anyt;
import anyu;
import anyv;
import aqcx;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;
import woq;
import wos;
import wot;
import woy;
import woz;

public class FriendShipWaveView
  extends SpriteGLView
{
  public int JO;
  public Context N;
  public String TAG = "FriendShipWaveView";
  public anyq a;
  public anyq.a b;
  public anyu b;
  private anyv b;
  public anyu c;
  private anyv c;
  public anyu d;
  private anyv d;
  Bitmap dQ;
  public anyu e;
  private anyv e;
  public anyu f;
  private anyv f;
  public anyu g;
  private anyv g;
  public anyu h;
  private anyv h;
  public anyu i;
  private anyv i;
  public anyu j;
  private anyv j;
  public anyu k;
  private anyv k;
  public anyu l;
  private anyv l;
  public anyu m;
  public int mViewHeight;
  private List<anyu> rE = new LinkedList();
  private List<anyu> rF = new LinkedList();
  private List<anyu> rG = new LinkedList();
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, anyq.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.N = paramContext;
    this.jdField_b_of_type_Anyq$a = parama;
    this.JO = paramInt1;
    this.mViewHeight = paramInt2;
    this.dQ = paramBitmap4;
    this.jdField_b_of_type_Anyv = new anyv(this, paramBitmap9);
    this.jdField_c_of_type_Anyv = new anyv(this, paramBitmap10);
    this.jdField_d_of_type_Anyv = new anyv(this, paramBitmap11);
    this.jdField_e_of_type_Anyv = new anyv(this, paramBitmap1);
    this.k = new anyv(this, paramBitmap2);
    this.j = new anyv(this, paramBitmap3);
    this.f = new anyv(this, paramBitmap5);
    this.g = new anyv(this, paramBitmap6);
    this.h = new anyv(this, paramBitmap7);
    this.jdField_i_of_type_Anyv = new anyv(this, paramBitmap8);
    this.l = new anyv(this, paramBitmap12);
  }
  
  public void bZU()
  {
    int i2 = 0;
    int n = 0;
    anyu localanyu;
    while (n < 5)
    {
      localanyu = new anyu();
      localanyu.a(this.jdField_b_of_type_Anyv);
      localanyu.setPosition(-localanyu.width / 2.0F + (localanyu.width - 1.0F) * n, this.mViewHeight + localanyu.height / 4.0F);
      b(localanyu);
      this.rE.add(localanyu);
      n += 1;
    }
    bZX();
    n = 0;
    int i1;
    for (;;)
    {
      i1 = i2;
      if (n >= 5) {
        break;
      }
      localanyu = new anyu();
      localanyu.a(this.jdField_c_of_type_Anyv);
      localanyu.setPosition(-localanyu.width / 2.0F + (localanyu.width - 1.0F) * n, this.mViewHeight + localanyu.height / 4.0F);
      b(localanyu);
      this.rF.add(localanyu);
      n += 1;
    }
    while (i1 < 5)
    {
      localanyu = new anyu();
      localanyu.a(this.jdField_d_of_type_Anyv);
      localanyu.setPosition(-localanyu.width / 2.0F + (localanyu.width - 1.0F) * i1, this.mViewHeight + localanyu.height / 4.0F);
      b(localanyu);
      this.rG.add(localanyu);
      i1 += 1;
    }
    ak(new FriendShipWaveView.1(this));
    bZV();
    bZY();
    bZZ();
    caa();
    cab();
  }
  
  public void bZV()
  {
    int n = 0;
    anyu localanyu;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    while (n < this.rE.size())
    {
      localanyu = (anyu)this.rE.get(n);
      i1 = (int)(this.mViewHeight + localanyu.height / 2.0F);
      i2 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 85.0F));
      i3 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 250.0F));
      i4 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 220.0F));
      i5 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 230.0F));
      localanyu.a(new anyb[] { new anyj(new anyb[] { new anyf(1000, i1, i2), new anyf(700, i2, i3), new anyf(300, i3, i4), new anyf(100, i4, i5) }) });
      n += 1;
    }
    n = 0;
    while (n < this.rF.size())
    {
      localanyu = (anyu)this.rF.get(n);
      i1 = (int)(this.mViewHeight + localanyu.height / 2.0F);
      i2 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 70.0F));
      i3 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 235.0F));
      i4 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 205.0F));
      i5 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 215.0F));
      localanyu.a(new anyb[] { new anyj(new anyb[] { new anyf(1000, i1, i2), new anyf(700, i2, i3), new anyf(300, i3, i4), new anyf(100, i4, i5) }) });
      n += 1;
    }
    n = 0;
    while (n < this.rG.size())
    {
      localanyu = (anyu)this.rG.get(n);
      i1 = (int)(this.mViewHeight + localanyu.height / 2.0F);
      i2 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 50.0F));
      i3 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 215.0F));
      i4 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 185.0F));
      i5 = (int)(this.mViewHeight + localanyu.height / 2.0F - aqcx.dip2px(this.N, 195.0F));
      localanyu.a(new anyb[] { new anyj(new anyb[] { new anyf(1000, i1, i2), new anyf(700, i2, i3), new anyf(300, i3, i4), new anyf(100, i4, i5) }) });
      n += 1;
    }
  }
  
  public void bZW()
  {
    int n = 0;
    anyu localanyu;
    if (n < this.rE.size())
    {
      localanyu = (anyu)this.rE.get(n);
      localanyu.x += aqcx.dip2px(this.N, 2.0F);
      if ((n == this.rE.size() - 1) && (localanyu.x > this.JO + localanyu.width / 2.0F))
      {
        localanyu.x = (((anyu)this.rE.get(0)).x - localanyu.width + 1.0F);
        this.rE.add(0, this.rE.remove(n));
      }
    }
    else
    {
      n = 0;
      label131:
      if (n < this.rF.size())
      {
        localanyu = (anyu)this.rF.get(n);
        localanyu.x += aqcx.dip2px(this.N, 3.0F);
        if ((n != this.rF.size() - 1) || (localanyu.x <= this.JO + localanyu.width / 2.0F)) {
          break label397;
        }
        localanyu.x = (((anyu)this.rF.get(0)).x - localanyu.width + 1.0F);
        this.rF.add(0, this.rF.remove(n));
      }
      n = 0;
    }
    for (;;)
    {
      if (n < this.rG.size())
      {
        localanyu = (anyu)this.rG.get(n);
        localanyu.x += aqcx.dip2px(this.N, 4.0F);
        if ((n == this.rG.size() - 1) && (localanyu.x > this.JO + localanyu.width / 2.0F))
        {
          localanyu.x = (((anyu)this.rG.get(0)).x - localanyu.width + 1.0F);
          this.rG.add(0, this.rG.remove(n));
        }
      }
      else
      {
        return;
        n += 1;
        break;
        label397:
        n += 1;
        break label131;
      }
      n += 1;
    }
  }
  
  public void bZX()
  {
    this.jdField_b_of_type_Anyu = new anyu();
    this.jdField_b_of_type_Anyu.a(this.jdField_e_of_type_Anyv);
    this.jdField_b_of_type_Anyu.setPosition(this.JO / 2, -this.jdField_b_of_type_Anyu.height / 2.0F);
    b(this.jdField_b_of_type_Anyu);
    anyc localanyc = new anyc(1100);
    localanyc.a(new woq(this));
    this.jdField_b_of_type_Anyu.a(new anyb[] { localanyc });
  }
  
  public void bZY()
  {
    this.jdField_d_of_type_Anyu = new anyu();
    this.jdField_d_of_type_Anyu.scale = 0.0F;
    this.jdField_d_of_type_Anyu.a(this.k);
    this.jdField_d_of_type_Anyu.setPosition(this.JO / 2, aqcx.dip2px(this.N, 165.0F) + this.jdField_d_of_type_Anyu.height / 2.0F);
    this.jdField_c_of_type_Anyu = new anyu();
    this.jdField_c_of_type_Anyu.scale = 0.0F;
    this.jdField_c_of_type_Anyu.a(this.l);
    this.jdField_c_of_type_Anyu.setPosition(this.JO / 2, aqcx.dip2px(this.N, 130.0F) + this.jdField_c_of_type_Anyu.height / 2.0F);
    anyc localanyc = new anyc(1200);
    localanyc.a(new wos(this));
    b(this.jdField_d_of_type_Anyu);
    b(this.jdField_c_of_type_Anyu);
    this.jdField_d_of_type_Anyu.a(new anyb[] { localanyc });
  }
  
  public void bZZ()
  {
    this.jdField_e_of_type_Anyu = new anyu();
    this.jdField_e_of_type_Anyu.a(this.f);
    this.jdField_e_of_type_Anyu.opacity = 0;
    this.jdField_e_of_type_Anyu.setPosition(this.JO / 2 - aqcx.dip2px(this.N, 110.0F), this.jdField_c_of_type_Anyu.y + 20.0F);
    anyc localanyc = new anyc(1200);
    localanyc.a(new wot(this));
    b(this.jdField_e_of_type_Anyu);
    this.jdField_e_of_type_Anyu.a(new anyb[] { localanyc });
  }
  
  public void caa()
  {
    this.jdField_i_of_type_Anyu = new anyu();
    this.jdField_i_of_type_Anyu.a(this.j);
    this.jdField_i_of_type_Anyu.setPosition(this.jdField_e_of_type_Anyu.x - this.jdField_e_of_type_Anyu.width / 2.0F - 3.0F, this.jdField_e_of_type_Anyu.y - this.jdField_e_of_type_Anyu.height / 2.0F);
    this.jdField_i_of_type_Anyu.opacity = 0;
    anyc localanyc = new anyc(1700);
    localanyc.a(new woy(this));
    b(this.jdField_i_of_type_Anyu);
    this.jdField_i_of_type_Anyu.a(new anyb[] { localanyc });
  }
  
  public void cab()
  {
    anyc localanyc = new anyc(1000);
    for (;;)
    {
      try
      {
        this.a = new anyq(this, this.dQ, true);
        this.a.opacity = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        n = ImmersiveUtils.getStatusBarHeight(this.N);
        anyq localanyq = this.a;
        float f1 = this.JO - aqcx.dip2px(this.N, 20.0F);
        float f2 = this.a.width / 2.0F;
        float f3 = aqcx.dip2px(this.N, 5.0F);
        float f4 = this.a.height / 2.0F;
        localanyq.setPosition(f1 - f2, n + (f3 + f4));
        b(this.a);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.TAG, 2, "decode init mCloseButton failed");
        continue;
      }
      localanyc.a(new woz(this));
      this.a.a(new anyb[] { localanyc });
      return;
      n = 0;
    }
  }
  
  public void cac()
  {
    List localList = getNodeList();
    int n = 0;
    while (n < localList.size())
    {
      ((anyt)localList.get(n)).a(new anyb[] { new anyg(300, 255, 0) });
      n += 1;
    }
  }
  
  public void cad()
  {
    dTT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView
 * JD-Core Version:    0.7.0.1
 */