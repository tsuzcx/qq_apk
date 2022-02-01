import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.comment.QCircleMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

class uyg
  extends RecyclerView.ViewHolder
{
  private uyg(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(uzm paramuzm, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt1, int paramInt2, aaga paramaaga)
  {
    if ((this.itemView instanceof QCircleReplyItemView))
    {
      ((QCircleReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
      ((QCircleReplyItemView)this.itemView).setOnCommentElementClickListener(paramaaga);
      ((QCircleReplyItemView)this.itemView).a(paramuzm, paramInt2);
    }
    while (!(this.itemView instanceof QCircleMoreReplyItemView)) {
      return;
    }
    ((QCircleMoreReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
    ((QCircleMoreReplyItemView)this.itemView).setOnCommentElementClickListener(paramaaga);
    ((QCircleMoreReplyItemView)this.itemView).a(paramuzm, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyg
 * JD-Core Version:    0.7.0.1
 */