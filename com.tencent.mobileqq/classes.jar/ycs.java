import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

class ycs
  implements View.OnTouchListener
{
  ycs(ycq paramycq) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (ycq.a(this.a)) {
        break label105;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(ycq.a(this.a), ycq.a(this.a), this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, ycq.a(this.a).jdField_a_of_type_Boolean);
      ycq.a(this.a).jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      paramView = this.a;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      ycq.a(paramView, bool);
      return false;
    }
    label105:
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycs
 * JD-Core Version:    0.7.0.1
 */