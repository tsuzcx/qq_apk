import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import cooperation.qzone.panorama.controller.TouchController.1;
import java.util.Timer;
import java.util.TimerTask;

public class avws
  implements View.OnTouchListener
{
  private float Dm;
  private float Dn;
  private float Do;
  private float Dp;
  private ScaleGestureDetector.OnScaleGestureListener jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener = new avwt(this);
  private avwp jdField_a_of_type_Avwp;
  private ScaleGestureDetector c;
  private Context context;
  private float downX;
  private float downY;
  private View eT;
  private boolean isTouchMove;
  private float kW = 1.0F;
  private VelocityTracker mVelocityTracker;
  private int modeType;
  private int panoramaType;
  private float rotateX;
  private float rotateY;
  private int showType;
  private Timer timer;
  private TimerTask timerTask;
  private float yP;
  private float yQ;
  
  public avws(View paramView, Context paramContext, avwp paramavwp, avxa.a parama)
  {
    this.jdField_a_of_type_Avwp = paramavwp;
    this.context = paramContext;
    this.modeType = parama.PQ();
    this.showType = parama.getShowType();
    this.panoramaType = parama.PR();
    this.eT = paramView;
    this.c = new ScaleGestureDetector(paramContext, this.jdField_a_of_type_AndroidViewScaleGestureDetector$OnScaleGestureListener);
    if (this.modeType == 0)
    {
      this.Dm = 0.35F;
      this.Dn = 0.057F;
      this.Do = (this.Dm / this.Dn);
      this.Dp = 0.162F;
    }
    while (this.showType == 1) {
      if (this.modeType == 0)
      {
        this.kW = 0.4142652F;
        return;
        this.Dm = 0.122F;
        this.Dn = 0.01F;
        this.Do = (this.Dm / this.Dn);
        this.Dp = 0.08F;
      }
      else
      {
        this.kW = 0.5228754F;
        return;
      }
    }
    this.kW = 1.0F;
  }
  
  private void r(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Avwp != null) {
      this.jdField_a_of_type_Avwp.r(paramFloat1, paramFloat2);
    }
    this.rotateX += paramFloat1;
    this.rotateY += paramFloat2;
    if (this.rotateX > 90.0F) {
      this.rotateX = 90.0F;
    }
    while (this.rotateX >= -90.0F) {
      return;
    }
    this.rotateX = -90.0F;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 40;
    int j = 1;
    if (this.eT != null) {
      this.eT.getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    boolean bool = this.c.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getActionMasked() == 6) {
      this.isTouchMove = true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if ((!this.c.isInProgress()) && (paramMotionEvent.getPointerCount() == 1) && (!this.isTouchMove))
    {
      if (paramMotionEvent.getAction() != 0) {
        break label341;
      }
      this.downX = f1;
      this.downY = f2;
      if (this.timer != null) {
        this.timer.cancel();
      }
      if (this.timerTask != null) {
        this.timerTask.cancel();
      }
    }
    int k;
    label278:
    label283:
    label341:
    while (paramMotionEvent.getAction() != 2)
    {
      this.yQ = f2;
      this.yP = f1;
      if (paramMotionEvent.getAction() == 1)
      {
        this.isTouchMove = false;
        i = ViewConfiguration.get(this.context).getScaledTouchSlop();
        if ((Math.abs(f1 - this.downX) <= i) && (Math.abs(f2 - this.downY) <= i) && (this.jdField_a_of_type_Avwp != null)) {
          this.jdField_a_of_type_Avwp.eBZ();
        }
        this.mVelocityTracker.computeCurrentVelocity(10);
        k = (int)this.mVelocityTracker.getXVelocity();
        int m = (int)this.mVelocityTracker.getYVelocity();
        if (k <= 0) {
          break;
        }
        i = 1;
        if (m <= 0) {
          break label499;
        }
        this.timer = new Timer();
        this.timerTask = new TouchController.1(this, i, new int[] { k, m }, j);
        this.timer.schedule(this.timerTask, 0L, 15L);
      }
      return bool;
    }
    float f3 = this.yP;
    float f4 = this.yQ;
    float f5;
    float f6;
    if (this.panoramaType != 4)
    {
      f5 = f2 - this.downY;
      f6 = f1 - this.downX;
      k = ViewConfiguration.get(this.context).getScaledTouchSlop() * 2;
      if (k >= 40) {
        break label505;
      }
    }
    for (;;)
    {
      if (((f5 / f6 >= 1.0F) || (f5 / f6 <= -1.0F)) && (Math.abs(f5) <= i) && (Math.abs(f6) <= i))
      {
        this.eT.getParent().requestDisallowInterceptTouchEvent(false);
        return true;
      }
      r(this.Dp * (f2 - f4), this.Dp * (f1 - f3));
      break;
      i = 0;
      break label278;
      label499:
      j = 0;
      break label283;
      label505:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avws
 * JD-Core Version:    0.7.0.1
 */