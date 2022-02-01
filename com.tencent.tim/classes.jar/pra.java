import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;

public class pra
  implements View.OnTouchListener
{
  public pra(StoryInputBarView paramStoryInputBarView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      StoryInputBarView.a(this.this$0);
      if (this.this$0.aBk) {
        break label94;
      }
      this.this$0.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(this.this$0.mContext, this.this$0.mRootView, this.this$0.b, this.this$0.jdField_a_of_type_Qrj.aET);
      paramView = this.this$0;
      if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      paramView.aBk = bool;
      return false;
    }
    label94:
    this.this$0.bmx();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pra
 * JD-Core Version:    0.7.0.1
 */