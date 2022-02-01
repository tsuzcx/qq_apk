import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

public class prb
  implements View.OnFocusChangeListener
{
  public prb(StoryInputBarView paramStoryInputBarView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.this$0.bmx();
    }
    while (this.this$0.aBk) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(this.this$0.mContext, this.this$0.mRootView, this.this$0.b, this.this$0.jdField_a_of_type_Qrj.aET);
    this.this$0.jdField_a_of_type_Qrj.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.this$0.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
    paramView = this.this$0;
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramView.aBk = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prb
 * JD-Core Version:    0.7.0.1
 */