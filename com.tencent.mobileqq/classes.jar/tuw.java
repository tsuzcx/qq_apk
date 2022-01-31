import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.comment.ItemReplyContainer;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StComment;

public class tuw
  implements View.OnClickListener
{
  public tuw(QCircleCommentItemView paramQCircleCommentItemView) {}
  
  public void onClick(View paramView)
  {
    if ((QCircleCommentItemView.a(this.a) != null) && (QCircleCommentItemView.a(this.a).vecReply.size() > 0))
    {
      QCircleCommentItemView.a(this.a).a(paramView, 10, QCircleCommentItemView.a(this.a), QCircleCommentItemView.a(this.a));
      this.a.a.b.setVisibility(8);
      this.a.a.a.setVisibility(8);
      QCircleCommentItemView.a(this.a).setVisibility(0);
      QCircleCommentItemView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuw
 * JD-Core Version:    0.7.0.1
 */