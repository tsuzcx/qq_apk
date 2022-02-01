import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;

public class ayjv
  extends aykd
  implements Drawable.Callback
{
  public static final String TAG = ayjv.class.getSimpleName();
  public ayjv.a a;
  public ayoo a;
  public boolean aHA;
  public ayoo.a b;
  public ayoo.a c;
  public int mStartY;
  
  public ayjv(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Ayoo = new ayoo();
    this.jdField_a_of_type_Ayoo.tP(true);
    this.jdField_a_of_type_Ayoo.setMaxScale(6.0F);
    this.jdField_a_of_type_Ayoo.setMinScale(0.2F);
  }
  
  private void O(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Ayoo.a(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
      if (this.jdField_a_of_type_Ayjv$a != null)
      {
        if (!(this.jdField_b_of_type_Ayoo$a instanceof ayjw.c)) {
          break label77;
        }
        paramMotionEvent = ((ayjw.c)this.jdField_b_of_type_Ayoo$a).c;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_Ayjv$a.a(this.jdField_b_of_type_Ayoo$a, paramMotionEvent.Rw(), 2);
        }
      }
    }
    label77:
    DynamicTextItem localDynamicTextItem;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_Ayjv$a.a(this.jdField_b_of_type_Ayoo$a, 0, 0);
              return;
              if (!this.jdField_a_of_type_Ayoo.e(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_Ayjv$a == null);
            this.jdField_a_of_type_Ayjv$a.h(this.jdField_b_of_type_Ayoo$a);
            return;
            if (!this.jdField_a_of_type_Ayoo.b(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_Ayjv$a == null);
          this.jdField_a_of_type_Ayjv$a.i(this.jdField_b_of_type_Ayoo$a);
          return;
          if (!this.jdField_a_of_type_Ayoo.c(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
            break;
          }
          if (!this.jdField_b_of_type_Ayoo$a.isAnchor) {
            this.jdField_b_of_type_Ayoo$a.isAnchor = true;
          }
        } while (this.jdField_a_of_type_Ayjv$a == null);
        this.jdField_a_of_type_Ayjv$a.b(this.jdField_b_of_type_Ayoo$a, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_Ayoo.a(this.jdField_b_of_type_Ayoo$a, f1, f2, true)) || (this.jdField_a_of_type_Ayjv$a == null) || (this.jdField_b_of_type_Ayoo$a == null));
      if (!(this.jdField_b_of_type_Ayoo$a instanceof ayjw.c)) {
        break;
      }
      localDynamicTextItem = ((ayjw.c)this.jdField_b_of_type_Ayoo$a).c;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.aPK()) && (localDynamicTextItem.aPR()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, getWidth(), getHeight(), (ayjw.c)this.jdField_b_of_type_Ayoo$a, this.jdField_a_of_type_Ayoo);
      localDynamicTextItem.aeK(i);
      this.jdField_a_of_type_Ayjv$a.a(this.jdField_b_of_type_Ayoo$a, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_Ayjv$a.a(this.jdField_b_of_type_Ayoo$a, localDynamicTextItem.Rw(), 0, f1, f2);
    return;
    ram.d(TAG, "click the item:" + this.jdField_b_of_type_Ayoo$a);
    this.jdField_a_of_type_Ayjv$a.a(this.jdField_b_of_type_Ayoo$a, 0, 0, f1, f2);
  }
  
  private void a(aykb.b paramb)
  {
    if (paramb == null) {
      return;
    }
    boolean bool1 = this.jdField_a_of_type_Ayoo.a(paramb, StoryGuideLineView.bqQ, true);
    boolean bool2 = this.jdField_a_of_type_Ayoo.a(paramb, StoryGuideLineView.bqR, false);
    boolean bool3 = this.jdField_a_of_type_Ayoo.b(paramb, StoryGuideLineView.bqT, false);
    if ((!bool1) && (!bool2) && (!bool3))
    {
      paramb.FG = paramb.nJ;
      paramb.an = paramb.centerP;
      paramb.FC = paramb.scaleValue;
      paramb.FD = paramb.nI;
      paramb.FE = paramb.translateXValue;
      paramb.FF = paramb.translateYValue;
    }
    for (;;)
    {
      this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramb.aIq, paramb.nI, paramb.translateXValue, paramb.translateYValue, paramb.centerP, paramb.aHC, 0);
      if (this.jdField_a_of_type_Ayjv$a == null) {
        break;
      }
      this.jdField_a_of_type_Ayjv$a.b(bool1, bool2, false, bool3, paramb.aIq);
      return;
      paramb.nJ = paramb.FG;
      paramb.centerP = paramb.an;
      paramb.scaleValue = paramb.FC;
      paramb.nI = paramb.FD;
      if (bool3)
      {
        paramb.translateYValue = paramb.FF;
        if ((!bool1) && (!bool2)) {
          paramb.FE = paramb.translateXValue;
        }
      }
      if ((bool1) || (bool2))
      {
        paramb.translateXValue = paramb.FE;
        if (!bool3) {
          paramb.FF = paramb.translateYValue;
        }
      }
    }
  }
  
  private boolean a(ayoo.a parama, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {}
    float f1;
    float f2;
    do
    {
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (((!(parama instanceof ayjt.a)) && (!(parama instanceof aykb.b))) || (!((aykb.b)this.jdField_b_of_type_Ayoo$a).dzD));
    boolean bool1;
    if (!this.jdField_a_of_type_Ayoo.a(this.jdField_b_of_type_Ayoo$a, f1, f2))
    {
      bool1 = true;
      label68:
      bool2 = bool1;
      if (bool1) {
        if (this.jdField_a_of_type_Ayoo.e(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
          break label127;
        }
      }
    }
    label127:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (!bool2) {
        break label133;
      }
      if (!this.jdField_a_of_type_Ayoo.b(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
        break;
      }
      return false;
      bool1 = false;
      break label68;
    }
    label133:
    return bool2;
  }
  
  private void al(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Ayoo.a(this.jdField_b_of_type_Ayoo$a, f1, f2)) {
      this.jdField_b_of_type_Ayoo$a.ajB = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Ayoo.e(this.jdField_b_of_type_Ayoo$a, f1, f2))
      {
        this.jdField_b_of_type_Ayoo$a.ajB = 1;
        return;
      }
    } while (!this.jdField_a_of_type_Ayoo.b(this.jdField_b_of_type_Ayoo$a, f1, f2));
    this.jdField_b_of_type_Ayoo$a.ajB = 2;
  }
  
  private void c(ayoo.a parama)
  {
    boolean bool1 = this.jdField_a_of_type_Ayoo.a(parama, StoryGuideLineView.bqQ, true);
    boolean bool2 = this.jdField_a_of_type_Ayoo.a(parama, StoryGuideLineView.bqR, false);
    boolean bool3 = this.jdField_a_of_type_Ayoo.b(parama, StoryGuideLineView.bqT, false);
    if (this.jdField_a_of_type_Ayjv$a != null) {
      this.jdField_a_of_type_Ayjv$a.b(bool1, bool2, false, bool3, parama.aIq);
    }
    if (parama != null)
    {
      if (parama.aIp) {
        this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parama.aIq, parama.nI, parama.translateXValue, parama.translateYValue, parama.centerP, parama.aHC, 2);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(parama.aIq, parama.nI, parama.translateXValue, parama.translateYValue, parama.centerP, parama.aHC, 1);
  }
  
  private void eSb()
  {
    this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void g(ayoo.a parama)
  {
    if ((parama == null) || (parama.ajB != 2)) {}
    do
    {
      return;
      if ((parama instanceof ayjt.a))
      {
        rar.a("video_shoot_new", "qa_zoom", 2, 0, new String[0]);
        return;
      }
    } while (!(parama instanceof aykb.b));
    rar.a("video_shoot_new", "qa_zoom", 1, 0, new String[0]);
  }
  
  private boolean z(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_Ayoo.a(this.jdField_b_of_type_Ayoo$a, paramFloat1, paramFloat2, true);
  }
  
  protected boolean H(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean I(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_Ayoo.a(this.jdField_b_of_type_Ayoo$a, f1, f2, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public boolean L(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if ((this.jdField_a_of_type_Aykd$a != null) && (a(this.jdField_b_of_type_Ayoo$a, paramMotionEvent))) {
      this.jdField_a_of_type_Aykd$a.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.mStartY);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label86:
      this.jdField_a_of_type_Ayoo.a(paramMotionEvent, true);
      if (i == 0) {
        eSb();
      }
      break;
    }
    do
    {
      return true;
      this.mStartY = j;
      this.aHA = false;
      z(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_b_of_type_Ayoo$a != null) {
        this.jdField_a_of_type_Ayoo.l(this.jdField_b_of_type_Ayoo$a);
      }
      if (this.jdField_b_of_type_Ayoo$a != null) {
        al(paramMotionEvent);
      }
      if ((this.jdField_b_of_type_Ayoo$a == null) || (this.jdField_b_of_type_Ayoo$a.dzF != true) || (!this.jdField_b_of_type_Ayoo$a.isAnchor) || (this.jdField_b_of_type_Ayoo$a.aX == null) || (!this.jdField_b_of_type_Ayoo$a.aX.isRunning())) {
        break;
      }
      ram.d(TAG, "cancelNailAnimator");
      this.jdField_b_of_type_Ayoo$a.aX.cancel();
      i = 1;
      break label86;
      if (k > 10) {
        this.aHA = true;
      }
      i = 1;
      break label86;
      if (!this.aHA) {
        O(paramMotionEvent);
      }
      if ((this.aHA) && (this.jdField_b_of_type_Ayoo$a != null)) {
        g(this.jdField_b_of_type_Ayoo$a);
      }
      if (this.jdField_b_of_type_Ayoo$a != null) {
        this.jdField_b_of_type_Ayoo$a.ajB = -1;
      }
      if (this.jdField_b_of_type_Ayoo$a != null) {
        this.jdField_b_of_type_Ayoo$a.dzF = false;
      }
      this.jdField_a_of_type_Ayoo.reset();
      break label86;
      if (((this.jdField_b_of_type_Ayoo$a instanceof ayjn.b)) || ((this.jdField_b_of_type_Ayoo$a instanceof ayjw.c)))
      {
        c(this.jdField_b_of_type_Ayoo$a);
        return true;
      }
    } while (!(this.jdField_b_of_type_Ayoo$a instanceof aykb.b));
    a((aykb.b)this.jdField_b_of_type_Ayoo$a);
    return true;
  }
  
  public boolean Lp()
  {
    return this.jdField_b_of_type_Ayoo$a != null;
  }
  
  public ayoo.a a()
  {
    return this.jdField_b_of_type_Ayoo$a;
  }
  
  public void a(ayjv.a parama)
  {
    this.jdField_a_of_type_Ayjv$a = parama;
  }
  
  public boolean aN(long paramLong)
  {
    return true;
  }
  
  protected void an(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Ayoo$a == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_b_of_type_Ayoo$a.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void ao(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void b(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void btS()
  {
    e(this.jdField_b_of_type_Ayoo$a);
    this.jdField_b_of_type_Ayoo$a = null;
    ayjw.Zw(false);
    notifyChange();
  }
  
  public void clear()
  {
    e(this.jdField_b_of_type_Ayoo$a);
    this.jdField_b_of_type_Ayoo$a = null;
    this.jdField_a_of_type_Ayoo.reset();
  }
  
  public void d(ayoo.a parama)
  {
    this.jdField_b_of_type_Ayoo$a = parama;
    if (this.jdField_b_of_type_Ayoo$a == null) {}
    do
    {
      return;
      ayjw.Zw(true);
      if ((this.jdField_b_of_type_Ayoo$a instanceof ayjw.c))
      {
        this.jdField_a_of_type_Ayoo.setMaxScale(6.0F);
        this.jdField_a_of_type_Ayoo.setMinScale(0.2F);
        return;
      }
      if (((this.jdField_b_of_type_Ayoo$a instanceof ayjn.b)) || ((this.jdField_b_of_type_Ayoo$a instanceof ayjn.a)))
      {
        this.jdField_a_of_type_Ayoo.setMaxScale(18.0F);
        this.jdField_a_of_type_Ayoo.setMinScale(0.2F);
        return;
      }
    } while (!(this.jdField_b_of_type_Ayoo$a instanceof aykb.b));
    this.jdField_a_of_type_Ayoo.setMaxScale(18.0F);
    this.jdField_a_of_type_Ayoo.setMinScale(0.5F);
    ((aykb.b)this.jdField_b_of_type_Ayoo$a).a.a((aykb.b)this.jdField_b_of_type_Ayoo$a, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView, false, 3000, 500, null);
  }
  
  public void e(ayoo.a parama)
  {
    if (parama == null) {}
    while ((parama.aX == null) || (!parama.aX.isRunning())) {
      return;
    }
    ram.d(TAG, "cancelNailAnimator");
    parama.aX.cancel();
  }
  
  public void f(ayoo.a parama)
  {
    if (parama == null) {
      return;
    }
    parama.aIp = true;
    if (this.jdField_b_of_type_Ayoo$a != null) {
      parama.mSegmentKeeper.lockData(this.jdField_b_of_type_Ayoo$a.mSegmentKeeper.isDataLocked());
    }
    if (((parama instanceof ayjn.b)) && ((((ayjn.b)parama).eGY == 1) || (((ayjn.b)parama).eGY == 3))) {
      ((ayjn.b)parama).drawable.setCallback(this);
    }
    this.jdField_b_of_type_Ayoo$a = parama;
  }
  
  public String getTag()
  {
    return TAG;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    notifyChange();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
  
  public static abstract interface a
  {
    public abstract void a(ayoo.a parama, int paramInt1, int paramInt2);
    
    public abstract void a(ayoo.a parama, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
    
    public abstract void b(ayoo.a parama, int paramInt1, int paramInt2);
    
    public abstract void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
    
    public abstract void h(ayoo.a parama);
    
    public abstract void i(ayoo.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayjv
 * JD-Core Version:    0.7.0.1
 */