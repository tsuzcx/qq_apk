import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.subscribe.comment.CommentView;
import com.tencent.biz.subscribe.comment.ReplyContainer;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public class waq
  implements View.OnClickListener
{
  public waq(CommentView paramCommentView) {}
  
  public void onClick(View paramView)
  {
    if ((CommentView.a(this.a) != null) && (CommentView.a(this.a).vecReply.size() > 0))
    {
      CommentView.a(this.a).a(paramView, 10, CommentView.a(this.a), CommentView.a(this.a));
      this.a.jdField_a_of_type_War.b.setVisibility(8);
      this.a.jdField_a_of_type_War.a.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizSubscribeCommentReplyContainer.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */