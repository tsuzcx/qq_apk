import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

public class uts
  implements View.OnFocusChangeListener
{
  public uts(StoryInputBarView paramStoryInputBarView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.a();
    }
    while (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.a.jdField_a_of_type_Whs.jdField_a_of_type_Boolean);
    this.a.jdField_a_of_type_Whs.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    paramView = this.a;
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramView.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uts
 * JD-Core Version:    0.7.0.1
 */