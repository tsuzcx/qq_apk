import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

class uqg
  implements View.OnTouchListener
{
  uqg(uqe paramuqe) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (uqe.a(this.a)) {
        break label105;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(uqe.a(this.a), uqe.a(this.a), this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, uqe.a(this.a).jdField_a_of_type_Boolean);
      uqe.a(this.a).jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      paramView = this.a;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      uqe.a(paramView, bool);
      return false;
    }
    label105:
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqg
 * JD-Core Version:    0.7.0.1
 */