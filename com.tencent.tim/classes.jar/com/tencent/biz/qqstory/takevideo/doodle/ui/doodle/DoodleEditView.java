package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.List;
import rft;
import rft.b;
import rga;
import rgb;
import rgb.b;
import rhm;
import riy.a;

public class DoodleEditView
  extends DoodleView
  implements DoodleLayout.h
{
  private a jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$a;
  private b jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$b;
  public rga a;
  private boolean aHK;
  private DoodleView b;
  Runnable dv = new DoodleEditView.2(this);
  private float translateX;
  private float translateY;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public void b(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void bue()
  {
    tK(false);
  }
  
  public void ei(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  protected void init()
  {
    this.jdField_a_of_type_Rga = new rga(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Rga.onDestroy();
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
    this.jdField_a_of_type_Rga.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.translateX > 0.0F) || (this.translateY > 0.0F))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setLocation(paramMotionEvent.getX() - this.translateX, paramMotionEvent.getY() - this.translateY);
      paramMotionEvent = localMotionEvent;
    }
    for (int i = 1;; i = 0)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Rga.I(paramMotionEvent))) {
        this.aHK = true;
      }
      boolean bool;
      if (this.aHK)
      {
        bool = this.jdField_a_of_type_Rga.L(paramMotionEvent);
        invalidate();
      }
      for (;;)
      {
        if (paramMotionEvent.getAction() == 1) {
          this.aHK = false;
        }
        if (i != 0) {
          paramMotionEvent.recycle();
        }
        return bool;
        bue();
        bool = false;
      }
    }
  }
  
  public void setDoodleEditViewListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$a = parama;
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    super.setDoodleLayout(paramDoodleLayout);
    this.b = paramDoodleLayout.c;
  }
  
  public void setDoodleView(DoodleView paramDoodleView)
  {
    this.b = paramDoodleView;
  }
  
  public void setEditListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$b = paramb;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Rga.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a);
    setOnTextEditListener();
  }
  
  public void setOnTextEditListener()
  {
    this.jdField_a_of_type_Rga.a(new rhm(this));
  }
  
  public void tK(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.dv);
    }
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Rga.Lp())
      {
        localObject2 = this.jdField_a_of_type_Rga.a();
        ((riy.a)localObject2).aIp = false;
        if (!(localObject2 instanceof rft.b)) {
          break label112;
        }
        localObject1 = (rft)this.b.a("FaceLayer");
        localObject2 = (rft.b)localObject2;
        if (localObject1 != null) {
          ((rft)localObject1).oJ.add(localObject2);
        }
      }
    }
    for (;;)
    {
      this.b.invalidate();
      this.jdField_a_of_type_Rga.btS();
      setVisibility(8);
      return;
      label112:
      if ((localObject2 instanceof rgb.b))
      {
        localObject1 = (rgb)this.b.a("TextLayer");
        if (localObject1 != null) {
          ((rgb)localObject1).btV();
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(riy.a parama);
  }
  
  public static abstract interface b
  {
    public abstract void b(boolean paramBoolean1, float paramFloat, int paramInt1, int paramInt2, PointF paramPointF, boolean paramBoolean2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */