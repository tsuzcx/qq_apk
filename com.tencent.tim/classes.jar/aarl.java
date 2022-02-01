import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class aarl
  implements View.OnTouchListener
{
  public aarl(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    long l2 = 0L;
    if (!this.this$0.bwW) {
      return false;
    }
    if ((!this.this$0.bwP) && (!this.this$0.bxR)) {
      return false;
    }
    if (this.this$0.bxP)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch mIsShootingPhoto= " + this.this$0.bxP);
      }
      return false;
    }
    NewFlowCameraActivity.f(this.this$0);
    this.this$0.mVelocityTracker.addMovement(paramMotionEvent);
    if (((paramMotionEvent.getAction() & 0xFF) == 5) && (!this.this$0.byA))
    {
      int[] arrayOfInt = new int[2];
      this.this$0.wr.getLocationOnScreen(arrayOfInt);
      int i = paramMotionEvent.getActionIndex();
      this.this$0.a(paramMotionEvent, i, arrayOfInt[0], arrayOfInt[1]);
    }
    if (paramView.getId() == 2131367247)
    {
      NewFlowCameraActivity.a(this.this$0).onTouchEvent(paramMotionEvent, true);
      GLGestureProxy.getInstance().onTouchEvent(paramMotionEvent, true, this.this$0.wr, this.this$0.a.a);
      if ((this.this$0.c.aL.get() == 4) || (NewFlowCameraActivity.a(this.this$0) == null) || (!NewFlowCameraActivity.a(this.this$0).isShown())) {}
    }
    try
    {
      if (GLGestureProxy.getInstance().checkSecendFinger(paramMotionEvent))
      {
        paramView = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
        NewFlowCameraActivity.a(this.this$0).onTouchEvent(paramView);
        paramView.recycle();
      }
      switch (paramMotionEvent.getAction())
      {
      case 2: 
      default: 
        return true;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        continue;
        if (NewFlowCameraActivity.a(this.this$0) != null) {
          NewFlowCameraActivity.a(this.this$0).cxV();
        }
        acbs.go(this.this$0.xf);
        if ((NewFlowCameraActivity.f(this.this$0)) && (NewFlowCameraActivity.g(this.this$0)))
        {
          this.this$0.ca.set(false);
          label395:
          if (NewFlowCameraActivity.h(this.this$0)) {
            break label545;
          }
          if (this.this$0.ciS != 10017) {
            break label535;
          }
          if (anij.a().axv()) {
            this.this$0.cwN();
          }
        }
        for (;;)
        {
          this.this$0.byy = false;
          this.this$0.isCapturing = true;
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_DOWN, event = " + paramMotionEvent);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "ACTION_DOWN isTemplateMode " + this.this$0.bxw);
          break;
          this.this$0.ca.set(true);
          break label395;
          label535:
          this.this$0.cwN();
          continue;
          label545:
          if (this.this$0.bwT) {
            this.this$0.cwM();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "[@]onTouch ACTION_UP, event = " + paramMotionEvent + " , recordFinish---startEdit");
        }
        if (NewFlowCameraActivity.h(this.this$0)) {
          if (this.this$0.ca.get())
          {
            if (this.this$0.bxz) {
              this.this$0.h("612", "3", "0", true);
            }
            long l3 = System.currentTimeMillis();
            long l1 = l2;
            if (NewFlowCameraActivity.b(this.this$0) > 0L)
            {
              l1 = l2;
              if (l3 - NewFlowCameraActivity.b(this.this$0) > 0L) {
                l1 = l3 - NewFlowCameraActivity.b(this.this$0);
              }
            }
            NewFlowCameraActivity.a(this.this$0).put("captureDuration", String.valueOf(l1));
            NewFlowCameraActivity.g(this.this$0);
            if (this.this$0.ciS == 10004) {
              rar.a("plus_shoot", "clk_shoot", 0, 0, new String[] { "2", "", "", "" });
            }
          }
          else
          {
            this.this$0.cwN();
            if (this.this$0.ciS == 10002) {
              rar.a("video_shoot", "clk_shoot", 0, 0, new String[] { "2" });
            } else if (this.this$0.ciS == 10004) {
              rar.a("plus_shoot", "clk_shoot", 0, 0, new String[] { "1", "", "", "" });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarl
 * JD-Core Version:    0.7.0.1
 */