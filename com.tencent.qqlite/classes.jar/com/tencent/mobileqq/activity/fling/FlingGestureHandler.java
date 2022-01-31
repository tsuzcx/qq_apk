package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.lang.ref.WeakReference;

public class FlingGestureHandler
  extends FlingHandler
  implements TopGestureLayout.OnGestureListener
{
  private View jdField_a_of_type_AndroidViewView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  
  public FlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private ViewGroup a(Activity paramActivity)
  {
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = localViewGroup.getChildAt(0);
    paramActivity = localViewGroup;
    if (localView != null)
    {
      paramActivity = localViewGroup;
      if ((localView instanceof DragFrameLayout)) {
        paramActivity = (ViewGroup)localView;
      }
    }
    return paramActivity;
  }
  
  protected void a()
  {
    if (!b()) {}
    ViewGroup localViewGroup;
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localViewGroup = a((Activity)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
      {
        this.jdField_a_of_type_AndroidViewView = localViewGroup.getChildAt(0);
        View localView = this.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = new TopGestureLayout((Context)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
        ((TopGestureLayout)localObject).setOnFlingGesture(this);
        localViewGroup.addView((View)localObject);
        localViewGroup.removeView(localView);
        ((TopGestureLayout)localObject).addView(localView);
        return;
      }
    } while (a());
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    localViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent() != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getParent() == this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
  }
  
  protected void b()
  {
    Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        localObject = a((Activity)localObject);
      } while ((!a()) || (!this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.getParent().equals(localObject)));
      ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    } while (!this.jdField_a_of_type_AndroidViewView.getParent().equals(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout));
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.removeView(this.jdField_a_of_type_AndroidViewView);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void flingLToR()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null) {
      localActivity.onBackPressed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */