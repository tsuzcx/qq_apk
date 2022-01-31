import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView.FlingGestureListener;

public class eqi
  extends GestureDetector.SimpleOnGestureListener
{
  private static final int b = 0;
  private static final int c = -1;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 4;
  private static final int g = 8;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  public eqi(TroopAioFeedsCenterView paramTroopAioFeedsCenterView, Context paramContext)
  {
    this.jdField_a_of_type_Float = (ViewConfiguration.get(paramContext).getScaledTouchSlop() * 2);
  }
  
  private void a(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -1))
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int & (paramInt ^ 0xFFFFFFFF) | paramInt);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  private boolean a(int paramInt)
  {
    return (!b()) && ((this.jdField_a_of_type_Int & paramInt) == paramInt);
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int == -1;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    a(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a = false;
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((a()) || (b())) {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
    float f3 = Math.abs(f2 / f1);
    if (a(1)) {
      if ((f1 < 0.0F) && (f3 < 0.5F))
      {
        a(-1);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener.b();
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a = true;
        }
      }
    }
    for (;;)
    {
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      if (a(2))
      {
        if ((f1 > 0.0F) && (f3 < 0.5F))
        {
          a(-1);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener.c();
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a = true;
          }
        }
      }
      else if (a(4))
      {
        if ((f2 < 0.0F) && (f3 >= 0.5F))
        {
          a(-1);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener.d();
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a = true;
          }
        }
      }
      else if ((a(8)) && (f2 > 0.0F) && (f3 >= 0.5F))
      {
        a(-1);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView$FlingGestureListener.a();
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a = true;
        }
      }
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (b()) {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    float f1 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
    float f2 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
    float f3 = Math.abs(f2 / f1);
    if (a()) {
      if ((Math.abs(f1) > this.jdField_a_of_type_Float) && (f3 < 0.5F)) {
        if (paramFloat1 < 0.0F) {
          a(1);
        }
      }
    }
    for (;;)
    {
      return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      a(2);
      continue;
      if ((Math.abs(f2) > this.jdField_a_of_type_Float) && (f3 >= 0.5F)) {
        if (paramFloat2 < 0.0F)
        {
          a(4);
        }
        else
        {
          a(8);
          continue;
          if (a(1))
          {
            if ((paramFloat1 > 0.0F) || (f3 >= 0.5F)) {
              a(-1);
            }
          }
          else if (a(2))
          {
            if ((paramFloat1 < 0.0F) || (f3 >= 0.5F)) {
              a(-1);
            }
          }
          else if (a(4))
          {
            if ((paramFloat2 > 0.0F) || (f3 < 0.5F)) {
              a(-1);
            }
          }
          else if ((a(8)) && ((paramFloat2 < 0.0F) || (f3 < 0.5F))) {
            a(-1);
          }
        }
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(-1);
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eqi
 * JD-Core Version:    0.7.0.1
 */