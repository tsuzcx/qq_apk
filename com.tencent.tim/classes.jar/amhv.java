import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amhv
  implements View.OnClickListener
{
  public amhv(CommentsView paramCommentsView, amhs paramamhs, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Amhs.avQ()) && (CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView) != null)) {
      CommentsView.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView).j(this.val$position, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amhv
 * JD-Core Version:    0.7.0.1
 */