import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.comment.QCircleMoreReplyItemView;
import com.tencent.biz.qqcircle.comment.QCircleReplyItemView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;

class uzp
  extends RecyclerView.ViewHolder
{
  private uzp(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public void a(vbc paramvbc, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt1, int paramInt2, aakb paramaakb)
  {
    if ((this.itemView instanceof QCircleReplyItemView))
    {
      ((QCircleReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
      ((QCircleReplyItemView)this.itemView).setOnCommentElementClickListener(paramaakb);
      ((QCircleReplyItemView)this.itemView).a(paramvbc, paramInt2);
    }
    while (!(this.itemView instanceof QCircleMoreReplyItemView)) {
      return;
    }
    ((QCircleMoreReplyItemView)this.itemView).setPreData(paramStFeed, paramStComment, paramInt1);
    ((QCircleMoreReplyItemView)this.itemView).setOnCommentElementClickListener(paramaakb);
    ((QCircleMoreReplyItemView)this.itemView).a(paramvbc, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzp
 * JD-Core Version:    0.7.0.1
 */