import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragCallBack;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pic.Logger;
import java.util.ArrayList;

public class vms
  extends vmu
{
  public vms(PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramSwipeUpAndDragListener, paramContext, paramViewGroup);
  }
  
  private boolean a(int paramInt)
  {
    Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_AndroidViewView.getWidth() - (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F), this.jdField_a_of_type_AndroidViewView.getHeight() - (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F) * 2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = (this.jdField_c_of_type_ArrayOfInt[0] + (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F));
    this.jdField_a_of_type_AndroidViewViewGroup.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Int + (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F));
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    float f = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.a(paramInt, this.jdField_a_of_type_AndroidViewView.getWidth() - (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e), this.jdField_a_of_type_AndroidViewView.getHeight() - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e));
    Logger.a("PhotoListPanel", "startFlingAnim", "f scale = " + f);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[0] - (int)(65.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F + this.jdField_a_of_type_AndroidViewView.getWidth() * f + 0.5F) - this.jdField_c_of_type_ArrayOfInt[0];
    paramInt = i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(this.jdField_b_of_type_Int) == 1) {
      paramInt = i + (int)(9.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F);
    }
    i = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1];
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getHeight();
    int m = (int)(10.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F + this.jdField_a_of_type_AndroidViewView.getHeight() * f + 0.5F);
    int n = this.jdField_c_of_type_ArrayOfInt[1];
    int i1 = ((RelativeLayout.LayoutParams)localObject1).topMargin - (int)(30.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e);
    localObject1 = new AnimationSet(false);
    Object localObject2 = new ScaleAnimation(1.0F, f, 1.0F, f);
    ((ScaleAnimation)localObject2).setStartOffset(200L);
    ((ScaleAnimation)localObject2).setDuration(300L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject2).setStartOffset(0L);
    ((TranslateAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AnimationSet(false);
    ((AnimationSet)localObject2).setStartOffset(200L);
    ((AnimationSet)localObject2).setDuration(300L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, paramInt, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i + j - k - m - n + i1);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    localObject2 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject2).setStartOffset(200L + 300L - 200L / 2L);
    ((AlphaAnimation)localObject2).setDuration(200L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject1);
    ((AnimationSet)localObject1).setAnimationListener(new vmt(this));
    return true;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    return true;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    Logger.a("PhotoListPanel", "handleUp", "handler = " + this);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float;
    int i = paramMotionEvent.getPointerId(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
    Logger.a("PhotoListPanel", "FlingHandler", "@@handleUp,x = " + f1 + ",y = " + f2 + ",delY = " + f3 + ",velocityY = " + f4 + ",SWIPE_THRESHOLD = " + PhotoListPanel.SwipeUpAndDragListener.a());
    if ((-f3 > PhotoListPanel.SwipeUpAndDragListener.a()) && (Math.abs(f4) > 100.0F) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Long < 500L) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k == 4097)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a.size() == 0) {
        Logger.a("PhotoListPanel", "handleUp", "handler = " + this + "mInfos is null!!!!!! targetPosition=" + this.jdField_b_of_type_Int);
      }
    }
    do
    {
      return false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
      if (!a(this.jdField_b_of_type_Int))
      {
        Logger.a("PhotoListPanel", "handleUp", "handler  animLayout already hasparent= ");
        return false;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(this.jdField_b_of_type_Int);
      paramMotionEvent = new ArrayList();
      paramMotionEvent.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(this.jdField_b_of_type_Int).path);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack != null)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
        String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(this.jdField_b_of_type_Int).path;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.f == 2) {
          bool = true;
        }
        paramMotionEvent.a(str, bool);
      }
      for (;;)
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(i, paramMotionEvent, false, true, "0X8005E0D", "1", i + "");
      }
      Logger.a("PhotoListPanel", "FlingHandler", "@handleUp,return false. velocityY = " + f4 + ",dely = " + (f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float));
    } while ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Long < 200L) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Int) && (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Int));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vms
 * JD-Core Version:    0.7.0.1
 */