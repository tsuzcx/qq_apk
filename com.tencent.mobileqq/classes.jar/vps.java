import android.content.Context;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragCallBack;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pic.Logger;
import java.util.ArrayList;

public class vps
  extends vpw
{
  int jdField_a_of_type_Int;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  int[] jdField_a_of_type_ArrayOfInt;
  RelativeLayout.LayoutParams b;
  
  public vps(PhotoListPanel.SwipeUpAndDragListener paramSwipeUpAndDragListener, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramSwipeUpAndDragListener, paramContext, paramViewGroup);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("松手发送");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837705);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(6.0F * paramSwipeUpAndDragListener.e));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  AnimationSet a()
  {
    float f = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_AndroidWidgetRelativeLayout.getWidth(), this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight());
    Logger.a("PhotoListPanel", "createDragReleaseSendAnim", "d scale = " + f);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[0] - (int)(65.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getWidth() * f + 0.5F) - this.jdField_a_of_type_ArrayOfInt[0];
    int k = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getHeight() - (int)(10.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight() * f + 0.5F) - this.jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(this.jdField_b_of_type_Int) == 1) {
      i = j + (int)(9.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F);
    }
    Logger.a("PhotoListPanel", "createDragReleaseSendAnim", " deltY = " + k + ", flyStartLocation[1] = " + this.jdField_a_of_type_ArrayOfInt[1] + ",inputBarRightTopCorner[1] = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ArrayOfInt[1] + ",top = " + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTop());
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(1.0F, f, 1.0F, f);
    ((ScaleAnimation)localObject).setStartOffset(0L);
    ((ScaleAnimation)localObject).setDuration(500L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AnimationSet(false);
    ((AnimationSet)localObject).setStartOffset(0L);
    ((AnimationSet)localObject).setDuration(500L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, i, 0.0F, 0.0F);
    localTranslateAnimation.setInterpolator(new LinearInterpolator());
    ((AnimationSet)localObject).addAnimation(localTranslateAnimation);
    localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, k);
    localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
    ((AnimationSet)localObject).addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setStartOffset(500L - 200L / 2L);
    ((AlphaAnimation)localObject).setDuration(200L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillAfter(false);
    return localAnimationSet;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    float f2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.d;
    paramMotionEvent = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramMotionEvent.topMargin = ((int)(f1 - f2 + paramMotionEvent.topMargin));
    this.jdField_a_of_type_Int = (this.jdField_b_of_type_ArrayOfInt[1] + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Int + paramMotionEvent.topMargin);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramMotionEvent);
    Logger.a("PhotoListPanel", "DragHandler", "drag hanldeMove, contentParent = " + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getParent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.d = f1;
    if (-(int)(f1 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float) > (int)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.g)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    return true;
  }
  
  boolean a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    paramInt = paramView.getWidth() - (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e * 2.0F + 0.5F);
    int i = paramView.getHeight() - (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e * 2.0F + 0.5F) * 2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.jdField_c_of_type_ArrayOfInt[0] + (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e * 2.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e * 2.0F + 0.5F));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.g = (i * 3 / 5);
    paramView = (ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent();
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      paramView.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, new RelativeLayout.LayoutParams(paramInt, i));
    this.d = new RelativeLayout.LayoutParams(paramInt, i);
    this.d.leftMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin;
    this.d.topMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getParent() != null) {
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    Logger.a("PhotoListPanel", "DragHandler", "drag prepare, contentParent = " + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getParent());
    return true;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    Logger.a("PhotoListPanel", "handleUp", "handler = " + this);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 4)
    {
      if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Long < 200L) && (Math.abs(f2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Int) && (Math.abs(f1 - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_Float) < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_b_of_type_Int))
      {
        a();
        return false;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_AndroidViewView.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
      paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, (int)(2.0F * this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.e + 0.5F) + this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ArrayOfInt[1]);
      paramMotionEvent.setFillAfter(true);
      paramMotionEvent.setDuration(200L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMotionEvent);
      paramMotionEvent.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      return true;
    }
    Logger.a("PhotoListPanel", "DragHandler", "@#handleUp, createFlyAnimation ");
    paramMotionEvent = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
    Logger.a("PhotoListPanel", "DragHandler", "@#handleUp, startFlyAnimation ");
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMotionEvent);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(this.jdField_b_of_type_Int);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(this.jdField_b_of_type_Int).path);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragCallBack;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.a(this.jdField_b_of_type_Int).path;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.f == 2) {
        bool = true;
      }
      ((PhotoListPanel.SwipeUpAndDragCallBack)localObject).a(str, bool);
    }
    for (;;)
    {
      paramMotionEvent.setAnimationListener(new vpt(this, f2));
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$SwipeUpAndDragListener.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(i, (ArrayList)localObject, false, true, "0X8005E0D", "0", i + "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vps
 * JD-Core Version:    0.7.0.1
 */