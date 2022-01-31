import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

class wjh
  implements View.OnTouchListener
{
  wjh(wjf paramwjf) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (wjf.a(this.a)) {
        break label105;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(wjf.a(this.a), wjf.a(this.a), this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, wjf.a(this.a).jdField_a_of_type_Boolean);
      wjf.a(this.a).jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      paramView = this.a;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      wjf.a(paramView, bool);
      return false;
    }
    label105:
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wjh
 * JD-Core Version:    0.7.0.1
 */