import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

class udn
  implements View.OnTouchListener
{
  udn(udl paramudl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (udl.a(this.a)) {
        break label105;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(udl.a(this.a), udl.a(this.a), this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, udl.a(this.a).jdField_a_of_type_Boolean);
      udl.a(this.a).jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      paramView = this.a;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      udl.a(paramView, bool);
      return false;
    }
    label105:
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     udn
 * JD-Core Version:    0.7.0.1
 */