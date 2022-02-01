package com.tencent.av.redpacket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.redpacket.AVRedPacketManager;
import isl;
import isp;
import isu;
import itc;

public class RedPacketGameSmallScreenView
  extends View
{
  public isu a;
  public isl[] a;
  public isp[] a;
  public itc[] e;
  public boolean mIsSend;
  public Paint mPaint = new Paint();
  public Vibrator mVibrator;
  
  public RedPacketGameSmallScreenView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public RedPacketGameSmallScreenView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public RedPacketGameSmallScreenView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  public void a(Canvas paramCanvas, long paramLong)
  {
    int k = 0;
    if (this.mIsSend)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ArrayOfIsp.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfIsp[i].draw(paramCanvas, this.mPaint);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfIsl.length)
      {
        this.jdField_a_of_type_ArrayOfIsl[j].draw(paramCanvas, this.mPaint);
        j += 1;
      }
    }
    this.jdField_a_of_type_Isu.draw(paramCanvas, this.mPaint);
  }
  
  public void init(Context paramContext)
  {
    setId(2131374189);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    update(l);
    a(paramCanvas, l);
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = 0;
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mIsSend)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ArrayOfIsl.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfIsl[i].onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfIsp.length)
      {
        this.jdField_a_of_type_ArrayOfIsp[j].onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        j += 1;
      }
    }
    this.jdField_a_of_type_Isu.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void recycle()
  {
    int j = 0;
    int i;
    if (this.jdField_a_of_type_ArrayOfIsl != null)
    {
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfIsl.length)
      {
        if (this.jdField_a_of_type_ArrayOfIsl[i] != null) {
          this.jdField_a_of_type_ArrayOfIsl[i].recycle();
        }
        this.jdField_a_of_type_ArrayOfIsl[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfIsl = null;
    if (this.jdField_a_of_type_Isu != null) {
      this.jdField_a_of_type_Isu.recycle();
    }
    this.jdField_a_of_type_Isu = null;
    if (this.e != null)
    {
      i = 0;
      while (i < this.e.length)
      {
        if (this.e[i] != null) {
          this.e[i].recycle();
        }
        this.e[i] = null;
        i += 1;
      }
    }
    this.e = null;
    if (this.jdField_a_of_type_ArrayOfIsp != null)
    {
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfIsp.length)
      {
        if (this.jdField_a_of_type_ArrayOfIsp[i] != null) {
          this.jdField_a_of_type_ArrayOfIsp[i].recycle();
        }
        this.jdField_a_of_type_ArrayOfIsp[i] = null;
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfIsp = null;
    if (this.mVibrator != null) {
      this.mVibrator.cancel();
    }
    this.mVibrator = null;
    this.mPaint = null;
  }
  
  public void setAVRedPacketManager(AVRedPacketManager paramAVRedPacketManager, boolean paramBoolean)
  {
    int j = 0;
    long l = System.currentTimeMillis();
    this.mIsSend = paramBoolean;
    if (this.mIsSend)
    {
      this.jdField_a_of_type_ArrayOfIsl = new isl[2];
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfIsl.length)
      {
        this.jdField_a_of_type_ArrayOfIsl[i] = new isl();
        this.jdField_a_of_type_ArrayOfIsl[i].lG(i);
        this.jdField_a_of_type_ArrayOfIsl[i].mStartTime = (i * 2000 + l);
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfIsl[0].b = new itc(paramAVRedPacketManager.o("qav_redpacket_emoji_6.png"));
      this.jdField_a_of_type_ArrayOfIsl[1].b = new itc(paramAVRedPacketManager.o("qav_redpacket_emoji_9.png"));
      this.e = new itc[6];
      i = 0;
      while (i < this.e.length)
      {
        this.e[i] = new itc(paramAVRedPacketManager.o("qav_redpacket_focus_" + i * 6 + ".png"));
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfIsp = new isp[2];
      i = j;
      while (i < this.jdField_a_of_type_ArrayOfIsp.length)
      {
        this.jdField_a_of_type_ArrayOfIsp[i] = new isp(this.jdField_a_of_type_ArrayOfIsl[i]);
        this.jdField_a_of_type_ArrayOfIsp[i].c = this.e;
        i += 1;
      }
    }
    this.jdField_a_of_type_Isu = new isu();
    this.jdField_a_of_type_Isu.b = new itc(paramAVRedPacketManager.o("qav_redpacket_hb_smallscreen.png"));
    this.jdField_a_of_type_Isu.setAlpha(255);
    this.mVibrator = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jdField_a_of_type_Isu.mStartTime = l;
    this.mVibrator.vibrate(200L);
    invalidate();
  }
  
  public void update(long paramLong)
  {
    int k = 0;
    if (this.mIsSend)
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.jdField_a_of_type_ArrayOfIsl.length) {
          break;
        }
        this.jdField_a_of_type_ArrayOfIsl[i].update(paramLong);
        i += 1;
      }
      while (j < this.jdField_a_of_type_ArrayOfIsp.length)
      {
        this.jdField_a_of_type_ArrayOfIsp[j].update(paramLong);
        j += 1;
      }
    }
    this.jdField_a_of_type_Isu.update(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketGameSmallScreenView
 * JD-Core Version:    0.7.0.1
 */