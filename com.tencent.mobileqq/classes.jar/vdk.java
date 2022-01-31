import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryCommentItemBuilder;

class vdk
  extends GestureDetector.SimpleOnGestureListener
{
  vdk(vdj paramvdj) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (QQStoryCommentItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder)) {
      return false;
    }
    com.tencent.mobileqq.activity.aio.AIOUtils.m = true;
    ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidViewView, (FragmentActivity)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryCommentItemBuilder.jdField_a_of_type_AndroidContentContext);
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener.onLongClick(this.a.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdk
 * JD-Core Version:    0.7.0.1
 */