package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import axqg;
import ayjn;
import ayjn.b;
import ayjt;
import ayjt.a;
import ayjv;
import ayjw;
import ayjw.c;
import aykb;
import aykb.b;
import aylp;
import aylq;
import aylr;
import ayls;
import ayoo.a;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import ram;

public class DoodleEditView
  extends DoodleView
  implements DoodleLayout.h
{
  public ayjv a;
  private a a;
  private boolean aHK;
  Runnable dv = new DoodleEditView.5(this);
  private boolean dzL;
  private axqg e;
  private int mFrom;
  private float translateX;
  private float translateY;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public void ZC(boolean paramBoolean)
  {
    this.dzL = paramBoolean;
  }
  
  public void Zv(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(4);
      return;
    }
    postDelayed(this.dv, ayjw.bqY);
  }
  
  public axqg a()
  {
    return this.e;
  }
  
  public ayjv a()
  {
    return this.jdField_a_of_type_Ayjv;
  }
  
  public boolean aQN()
  {
    return this.dzL;
  }
  
  public void b(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void bue()
  {
    tK(false);
  }
  
  public void e(ayoo.a parama)
  {
    if (parama == null) {}
    while ((parama.aX == null) || (!parama.aX.isRunning())) {
      return;
    }
    ram.d("DoodleEditView", "cancelNailAnimator");
    parama.aX.cancel();
  }
  
  public void eSc()
  {
    if ((getFrom() == 1) && (this.jdField_a_of_type_Ayjv.Lp()))
    {
      ayoo.a locala = this.jdField_a_of_type_Ayjv.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(locala, 0);
      postInvalidate();
    }
  }
  
  public void eSy()
  {
    ayoo.a locala = this.jdField_a_of_type_Ayjv.a();
    if (locala != null) {
      locala.eSc();
    }
    if (this.jdField_a_of_type_Ayjv.c != null)
    {
      this.jdField_a_of_type_Ayjv.c.eSc();
      this.jdField_a_of_type_Ayjv.c = null;
    }
  }
  
  public void ei(int paramInt1, int paramInt2)
  {
    int j = getContext().getResources().getDisplayMetrics().widthPixels;
    int i = getContext().getResources().getDisplayMetrics().heightPixels;
    if (EditPicRawImage.bpD != 0) {
      i = EditPicRawImage.bpD;
    }
    if (j > paramInt1) {
      this.translateX = ((j - paramInt1) / 2.0F);
    }
    if (i > paramInt2) {
      this.translateY = ((i - paramInt2) / 2.0F);
    }
  }
  
  public int getFrom()
  {
    return this.mFrom;
  }
  
  protected void init()
  {
    this.jdField_a_of_type_Ayjv = new ayjv(this);
    this.e = new aylp(this);
  }
  
  public void j(ayoo.a parama)
  {
    if (parama == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parama.aX;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new aylr(this, parama));
        localValueAnimator1.addListener(new ayls(this, parama));
        parama.aX = localValueAnimator1;
      }
    } while ((parama.aX.isStarted()) || (parama.aX.isRunning()));
    ram.d("DoodleEditView", "breathScale start ");
    localValueAnimator1.start();
  }
  
  public void onDestroy()
  {
    e(this.jdField_a_of_type_Ayjv.a());
    super.onDestroy();
    this.jdField_a_of_type_Ayjv.onDestroy();
    this.translateX = 0.0F;
    this.translateY = 0.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.isEnable) {
      return;
    }
    paramCanvas.save();
    if ((this.translateX > 0.0F) || (this.translateY > 0.0F)) {
      paramCanvas.translate(this.translateX, this.translateY);
    }
    this.jdField_a_of_type_Ayjv.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f4 = 0.0F;
    Object localObject;
    int i;
    if ((this.translateX > 0.0F) || (this.translateY > 0.0F))
    {
      localObject = MotionEvent.obtain(paramMotionEvent);
      ((MotionEvent)localObject).setLocation(paramMotionEvent.getX() - this.translateX, paramMotionEvent.getY() - this.translateY);
      i = 1;
      paramMotionEvent = (MotionEvent)localObject;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Ayjv.I(paramMotionEvent))) {
        this.aHK = true;
      }
      boolean bool;
      if (this.aHK)
      {
        bool = this.jdField_a_of_type_Ayjv.L(paramMotionEvent);
        invalidate();
        if (paramMotionEvent.getAction() == 1) {
          this.aHK = false;
        }
        if (i != 0) {
          paramMotionEvent.recycle();
        }
        return bool;
      }
      float f5;
      float f6;
      float f1;
      float f2;
      float f3;
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.KQ()) && (this.jdField_a_of_type_Ayjv.Lp()))
      {
        localObject = this.jdField_a_of_type_Ayjv.a();
        if (((ayoo.a)localObject).eKr == 1)
        {
          this.jdField_a_of_type_Ayjv.c = ((ayoo.a)localObject);
          if (((ayoo.a)localObject).eKr == 1)
          {
            e((ayoo.a)localObject);
            f5 = ((ayoo.a)localObject).centerP.x + ((ayoo.a)localObject).translateXValue - ((ayoo.a)localObject).width * ((ayoo.a)localObject).scaleValue / 2.0F;
            f6 = ((ayoo.a)localObject).centerP.y + ((ayoo.a)localObject).translateYValue - ((ayoo.a)localObject).height * ((ayoo.a)localObject).scaleValue / 2.0F;
            if ((!((ayoo.a)localObject).isAnchor) || (!((ayoo.a)localObject).dzH)) {
              break label392;
            }
            f1 = ((ayoo.a)localObject).FJ + ((ayoo.a)localObject).FH - ((ayoo.a)localObject).width / 2.0F;
            f2 = ((ayoo.a)localObject).FK + ((ayoo.a)localObject).FI - ((ayoo.a)localObject).height / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((ayoo.a)localObject).FM = ((ayoo.a)localObject).scaleValue;
        ((ayoo.a)localObject).eKr = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((ayoo.a)localObject).width;
        f6 = ((ayoo.a)localObject).scaleValue;
        float f7 = ((ayoo.a)localObject).height;
        localDoodleLayout.f(f1, f2, f5 * f6, ((ayoo.a)localObject).scaleValue * f7, f3, f4);
        bue();
        bool = false;
        break;
        label392:
        f3 = 0.0F;
        f2 = f6;
        f1 = f5;
      }
      i = 0;
    }
  }
  
  public void setDoodleEditViewListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$a = parama;
  }
  
  public void setFrom(int paramInt)
  {
    this.mFrom = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Ayjv.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$k);
    this.jdField_a_of_type_Ayjv.a(new aylq(this));
  }
  
  public void tK(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.dv);
    }
    ayoo.a locala;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Ayjv.Lp())
      {
        locala = this.jdField_a_of_type_Ayjv.a();
        locala.aIp = false;
        if (!(locala instanceof ayjn.b)) {
          break label221;
        }
        localObject2 = (ayjn)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(ayjn.TAG);
        ayjn.b localb = (ayjn.b)locala;
        if (((ayjn.b)locala).eGY != 1)
        {
          localObject1 = localObject2;
          if (((ayjn.b)locala).eGY != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Lb()) {}
        }
        else
        {
          localObject1 = (ayjn)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((ayjn.b)locala).drawable.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((ayjn)localObject1).oJ.add(localb);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Ayjv.btS();
      setVisibility(8);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$a != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$a.eNB();
      }
      return;
      label221:
      if ((locala instanceof ayjw.c))
      {
        if (((ayjw.c)locala).c != null) {
          ((ayjw.c)locala).c.cz(-1, false);
        }
        localObject1 = (ayjw)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(ayjw.TAG);
        if (localObject1 != null)
        {
          localObject2 = ((ayjw.c)locala).c;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).aPQ()) && (((DynamicTextItem)localObject2).aPP())) {
              ((DynamicTextItem)localObject2).YZ(true);
            }
            if (!((DynamicTextItem)localObject2).isEmpty()) {
              ((ayjw)localObject1).mItems.add((ayjw.c)locala);
            }
          }
        }
      }
      else if ((locala instanceof ayjt.a))
      {
        localObject1 = (ayjt)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((ayjt)localObject1).a = ((aykb.b)locala);
          ((ayjt)localObject1).eSn();
        }
      }
      else if ((locala instanceof aykb.b))
      {
        localObject1 = (aykb)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c.a("VoteLayer");
        if (localObject1 != null)
        {
          ((aykb)localObject1).a = ((aykb.b)locala);
          ((aykb)localObject1).eSn();
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ayoo.a parama);
    
    public abstract void eNB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */