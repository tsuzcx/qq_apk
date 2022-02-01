import UserGrowth.stSimpleMetaComment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentView;
import com.tencent.biz.pubaccount.weishi_new.comment.WsReplyContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class umr
  implements View.OnClickListener
{
  public umr(WsCommentView paramWsCommentView) {}
  
  public void onClick(View paramView)
  {
    if ((WsCommentView.a(this.a) != null) && (WsCommentView.a(this.a).replyList.size() > 0))
    {
      WsCommentView.a(this.a).a(paramView, 10, WsCommentView.a(this.a), WsCommentView.a(this.a));
      this.a.jdField_a_of_type_Ums.b.setVisibility(8);
      this.a.jdField_a_of_type_Ums.a.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsReplyContainer.setVisibility(0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umr
 * JD-Core Version:    0.7.0.1
 */