import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder;

public class vil
  implements View.OnTouchListener
{
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new vim(this));
  View jdField_a_of_type_AndroidViewView = null;
  final OnLongClickAndTouchListener jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener;
  
  public vil(QQStoryCommentItemBuilder paramQQStoryCommentItemBuilder, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener = paramOnLongClickAndTouchListener;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onTouch(paramView, paramMotionEvent);
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      return true;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vil
 * JD-Core Version:    0.7.0.1
 */