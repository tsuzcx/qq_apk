import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.common.config.AppSetting;
import com.tencent.widget.ListView;

public class apwi
  implements Handler.Callback
{
  private byte A;
  private int Fx;
  private int Fy;
  private int Fz;
  private Handler V;
  private apwi.a jdField_a_of_type_Apwi$a;
  private apwi.c jdField_a_of_type_Apwi$c;
  private ListView b;
  private boolean cSP;
  private View cW;
  private View cX;
  private View cY;
  private final int ckO;
  private int mMinFlingVelocity;
  private Scroller mScroller;
  private int mStartX;
  private int mStartY;
  private VelocityTracker mVelocityTracker;
  private boolean qf = true;
  private boolean qg;
  
  public apwi(Context paramContext, ListView paramListView, apwi.c paramc)
  {
    this.b = paramListView;
    this.jdField_a_of_type_Apwi$c = paramc;
    this.mScroller = new Scroller(paramContext, new apwi.b());
    paramContext = ViewConfiguration.get(paramContext);
    this.ckO = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = (paramContext.getScaledMinimumFlingVelocity() * 4);
    this.mStartX = -1;
    this.Fx = -1;
    this.mStartY = -1;
    this.Fy = -1;
    this.V = new Handler(Looper.getMainLooper(), this);
  }
  
  private void AN()
  {
    int i = fz();
    int j = this.cX.getScrollX();
    if (i > this.mMinFlingVelocity)
    {
      aA(this.cX);
      return;
    }
    if (i < -this.mMinFlingVelocity)
    {
      aB(this.cX);
      return;
    }
    if ((i > 0) && (j < this.Fz * 0.7F))
    {
      aA(this.cX);
      return;
    }
    if ((i < 0) && (j > this.Fz * 0.3F))
    {
      aB(this.cX);
      return;
    }
    if ((this.qg) && (j < this.Fz * 0.7F))
    {
      aA(this.cX);
      return;
    }
    if (j > this.Fz * 0.3F)
    {
      aB(this.cX);
      return;
    }
    aA(this.cX);
  }
  
  private void AO()
  {
    this.V.removeMessages(1);
    this.V.removeMessages(0);
    this.cY = null;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3)
  {
    paramInt2 = this.Fx;
    paramInt1 = paramView.getScrollX() - (paramInt1 - paramInt2);
    if (paramInt1 > paramInt3) {}
    for (;;)
    {
      if (!this.cSP)
      {
        if (this.jdField_a_of_type_Apwi$a != null) {
          this.jdField_a_of_type_Apwi$a.al(true);
        }
        this.cSP = true;
      }
      paramView.scrollTo(paramInt3, 0);
      return;
      if (paramInt1 < 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = paramInt1;
      }
    }
  }
  
  private void aA(View paramView)
  {
    if (paramView != null) {}
    for (int i = paramView.getScrollX();; i = 0)
    {
      if (i != 0) {
        if (!(paramView.getTag(-3) instanceof Integer)) {
          break label104;
        }
      }
      label104:
      for (int j = ((Integer)paramView.getTag(-3)).intValue();; j = 0)
      {
        if ((this.cY != paramView) && (this.cY != null)) {
          this.cY.scrollTo(0, 0);
        }
        AO();
        this.cY = paramView;
        int k = -i;
        this.mScroller.startScroll(i, 0, k, 0, x(j, k));
        this.V.sendEmptyMessage(1);
        return;
      }
    }
  }
  
  private void aB(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int j = paramView.getScrollX();
    int i = this.Fz;
    if ((i == 0) && ((paramView.getTag(-3) instanceof Integer))) {
      i = ((Integer)paramView.getTag(-3)).intValue();
    }
    for (;;)
    {
      if (j != i)
      {
        if ((this.cY != paramView) && (this.cY != null)) {
          this.cY.scrollTo(0, 0);
        }
        AO();
        this.cY = paramView;
        int k = i - j;
        this.mScroller.startScroll(j, 0, k, 0, x(i, k));
        this.V.sendEmptyMessage(0);
      }
      if (this.jdField_a_of_type_Apwi$a != null) {
        this.jdField_a_of_type_Apwi$a.hW(paramView);
      }
      if ((!AppSetting.enableTalkBack) || (!(paramView instanceof LinearLayout))) {
        break;
      }
      paramView = (LinearLayout)paramView;
      paramView = paramView.getChildAt(paramView.getChildCount() - 1);
      if (paramView == null) {
        break;
      }
      paramView.sendAccessibilityEvent(8);
      return;
    }
  }
  
  private boolean b(float paramFloat)
  {
    return paramFloat < this.b.getWidth() - this.Fz;
  }
  
  private int fz()
  {
    this.mVelocityTracker.computeCurrentVelocity(1000);
    return (int)this.mVelocityTracker.getXVelocity();
  }
  
  private boolean n(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > this.ckO) || (paramFloat2 > this.ckO))
    {
      if ((paramFloat1 > this.ckO) && (paramFloat2 / paramFloat1 < 0.6F))
      {
        this.A = 1;
        return true;
      }
      this.A = 2;
      return true;
    }
    return false;
  }
  
  private void o(MotionEvent paramMotionEvent)
  {
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
  }
  
  private boolean r(View paramView)
  {
    return (paramView != null) && (paramView.getScrollX() >= this.ckO);
  }
  
  private void recycleVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private int x(int paramInt1, int paramInt2)
  {
    int i = 300;
    if (paramInt1 > 0) {
      i = (int)(Math.abs(paramInt2) / paramInt1 * 300.0F) + 50;
    }
    return i;
  }
  
  public void AP()
  {
    int i;
    int j;
    if (!r(this.cX))
    {
      i = this.b.getFirstVisiblePosition() - this.b.getHeaderViewsCount();
      j = this.b.getLastVisiblePosition();
    }
    for (;;)
    {
      if (i <= j)
      {
        View localView = this.b.getChildAt(i);
        if (r(localView)) {
          this.cX = localView;
        }
      }
      else
      {
        aA(this.cX);
        return;
      }
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    case 2: 
      return bool;
    case 0: 
      bool = this.mScroller.computeScrollOffset();
      f = this.mScroller.getCurrX();
      if (this.cY != null)
      {
        this.cY.scrollTo((int)f, 0);
        if (this.b != null) {
          this.b.invalidate();
        }
      }
      if (bool)
      {
        this.V.sendEmptyMessage(0);
        return true;
      }
      this.cY = null;
      return true;
    }
    bool = this.mScroller.computeScrollOffset();
    float f = this.mScroller.getCurrX();
    if (this.cY != null)
    {
      this.cY.scrollTo((int)f, 0);
      if (this.b != null) {
        this.b.invalidate();
      }
    }
    if (bool)
    {
      this.V.sendEmptyMessage(1);
      return true;
    }
    this.cY = null;
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.qf)
    {
      bool2 = this.jdField_a_of_type_Apwi$c.aq(paramMotionEvent);
      return bool2;
    }
    int j = (int)(paramMotionEvent.getX() + 0.5F);
    int i = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    label80:
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
      label83:
      if ((k == 0) && (this.qg))
      {
        if (this.jdField_a_of_type_Apwi$a != null) {
          this.jdField_a_of_type_Apwi$a.al(true);
        }
        AO();
      }
      break;
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return this.jdField_a_of_type_Apwi$c.aq(paramMotionEvent);
      this.A = 0;
      this.mStartX = j;
      this.Fx = j;
      this.mStartY = i;
      this.Fy = i;
      this.cW = this.cX;
      this.qg = r(this.cW);
      int m;
      int n;
      if (!this.qg)
      {
        m = this.b.getFirstVisiblePosition();
        n = this.b.getHeaderViewsCount();
        i = this.b.getLastVisiblePosition();
      }
      for (;;)
      {
        if (i >= m - n)
        {
          View localView = this.b.getChildAt(i);
          this.qg = r(localView);
          if (this.qg) {
            this.cW = localView;
          }
        }
        else
        {
          this.Fz = 0;
          this.cX = null;
          i = this.mStartY;
          if (this.b.isOverscrollHeadVisiable()) {
            i = this.mStartY + this.b.getScrollY();
          }
          i = this.b.pointToPosition(this.mStartX, i);
          if (i >= 0)
          {
            this.cX = this.b.getChildAt(i - this.b.getFirstVisiblePosition());
            if ((this.cX != null) && ((this.cX.getTag(-3) instanceof Integer))) {
              this.Fz = ((Integer)this.cX.getTag(-3)).intValue();
            }
          }
          if ((!this.qg) || ((this.cX == this.cW) && (!b(j)))) {
            break label412;
          }
          bool1 = true;
          break;
        }
        i -= 1;
      }
      label412:
      bool1 = false;
      break label83;
      if ((this.Fz > 0) && (this.A == 0)) {
        n(Math.abs(j - this.mStartX), Math.abs(i - this.mStartY));
      }
      if (this.A != 1) {
        break label80;
      }
      if (j < this.mStartX)
      {
        bool1 = true;
        break label83;
      }
      bool1 = false;
      break label83;
      if (this.qg) {
        aA(this.cW);
      }
      this.mStartX = -1;
      this.Fx = -1;
      this.mStartY = -1;
      this.Fy = -1;
      break label80;
      if (((k == 1) || (k == 3)) && (this.jdField_a_of_type_Apwi$a != null)) {
        this.jdField_a_of_type_Apwi$a.al(false);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2;
    if (!this.qf)
    {
      bool2 = this.jdField_a_of_type_Apwi$c.ar(paramMotionEvent);
      return bool2;
    }
    o(paramMotionEvent);
    int i = (int)(paramMotionEvent.getX() + 0.5F);
    int j = (int)(paramMotionEvent.getY() + 0.5F);
    int k = paramMotionEvent.getAction();
    boolean bool1;
    switch (k)
    {
    default: 
      bool1 = false;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((k == 0) && (this.qg))
        {
          if (this.jdField_a_of_type_Apwi$a != null) {
            this.jdField_a_of_type_Apwi$a.al(true);
          }
          label116:
          bool2 = bool1;
          if (bool1) {
            break;
          }
          return this.jdField_a_of_type_Apwi$c.ar(paramMotionEvent);
          if ((this.qg) && ((this.cX != this.cW) || (b(i)))) {}
          for (bool2 = true;; bool2 = false)
          {
            bool1 = bool2;
            if (!this.qg) {
              break;
            }
            bool1 = bool2;
            if (this.cW == this.cX) {
              break;
            }
            aA(this.cW);
            bool1 = bool2;
            break;
          }
          if (this.qg) {
            if ((this.cX != this.cW) || (b(i)))
            {
              bool2 = true;
              label243:
              bool1 = bool2;
              if (this.cX == this.cW)
              {
                if (this.A == 0)
                {
                  bool1 = bool2;
                  if (!n(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))) {
                    continue;
                  }
                }
                bool1 = bool2;
                if (this.A == 1)
                {
                  a(i, j, this.cX, this.Fz);
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.Fx = i;
      this.Fy = j;
      break;
      bool2 = false;
      break label243;
      if (this.Fz == 0)
      {
        bool1 = false;
      }
      else
      {
        if ((this.A == 0) && (!n(Math.abs(i - this.mStartX), Math.abs(j - this.mStartY))))
        {
          bool1 = false;
          break;
        }
        if (this.A == 1)
        {
          a(i, j, this.cX, this.Fz);
          bool1 = true;
          continue;
          if (this.qg) {
            if ((this.cX != this.cW) || (b(i)))
            {
              bool2 = true;
              label455:
              bool1 = bool2;
              if (this.cX == this.cW)
              {
                if (this.A != 1) {
                  break label518;
                }
                AN();
                bool1 = true;
              }
            }
          }
          for (;;)
          {
            recycleVelocityTracker();
            this.mStartX = -1;
            this.Fx = -1;
            this.mStartY = -1;
            this.Fy = -1;
            break;
            bool2 = false;
            break label455;
            label518:
            aA(this.cX);
            bool1 = bool2;
            continue;
            if (this.Fz == 0)
            {
              bool1 = false;
            }
            else
            {
              if (this.A == 1)
              {
                AN();
                bool1 = true;
                continue;
                if (((k != 1) && (k != 3)) || (this.jdField_a_of_type_Apwi$a == null)) {
                  break label116;
                }
                this.jdField_a_of_type_Apwi$a.al(false);
                this.cSP = false;
                break label116;
              }
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = false;
        }
      }
    }
  }
  
  public void release()
  {
    this.b = null;
    this.jdField_a_of_type_Apwi$a = null;
  }
  
  public void setSlidingListener(apwi.a parama)
  {
    this.jdField_a_of_type_Apwi$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void al(boolean paramBoolean);
    
    public abstract void hW(View paramView);
  }
  
  public static class b
    implements Interpolator
  {
    public float getInterpolation(float paramFloat)
    {
      return (float)(Math.pow(paramFloat - 1.0D, 5.0D) + 1.0D);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean aq(MotionEvent paramMotionEvent);
    
    public abstract boolean ar(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwi
 * JD-Core Version:    0.7.0.1
 */