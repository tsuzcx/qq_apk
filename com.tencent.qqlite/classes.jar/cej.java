import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class cej
  extends GestureDetector.SimpleOnGestureListener
{
  private static final int jdField_a_of_type_Int = 100;
  private float jdField_a_of_type_Float;
  
  public cej(TopGestureLayout paramTopGestureLayout, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, 0);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((TopGestureLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout)) || (TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout))) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if ((TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, 1)) && (f1 < 0.0F) && (f2 < 0.5F) && (TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout) != null))
    {
      TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, -1);
      TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout).flingLToR();
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout)) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = Math.abs((paramMotionEvent1.getY() - paramMotionEvent2.getY()) / f1);
    if (TopGestureLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout))
    {
      if ((Math.abs(f1) > this.jdField_a_of_type_Float) && (paramFloat1 < 0.0F) && (f2 < 0.5F))
      {
        TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, 1);
        return true;
      }
    }
    else if ((TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, 1)) && ((paramFloat1 > 0.0F) || (f2 >= 0.5F))) {
      TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, -1);
    }
    return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    TopGestureLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout, -1);
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cej
 * JD-Core Version:    0.7.0.1
 */