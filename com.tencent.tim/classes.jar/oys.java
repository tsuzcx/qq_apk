import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.comment.ItemReplyContainer;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView.a;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StComment;

public class oys
  implements View.OnClickListener
{
  public oys(QCircleCommentItemView paramQCircleCommentItemView) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleCommentItemView.a(this.a) != null) && (QCircleCommentItemView.a(this.a).vecReply.size() > 0))
    {
      QCircleCommentItemView.a(this.a).a(paramView, 10, QCircleCommentItemView.a(this.a), QCircleCommentItemView.a(this.a));
      this.a.a.ex.setVisibility(8);
      this.a.a.lt.setVisibility(8);
      QCircleCommentItemView.a(this.a).setVisibility(0);
      QCircleCommentItemView.a(this.a).setVisibility(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oys
 * JD-Core Version:    0.7.0.1
 */