import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import feedcloud.FeedCloudMeta.StFeed;

class uyd
  extends RecyclerView.ViewHolder
{
  private uyd(uyc paramuyc, View paramView)
  {
    super(paramView);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, uzd paramuzd, aaga paramaaga)
  {
    if ((this.itemView instanceof QCircleCommentItemView))
    {
      ((QCircleCommentItemView)this.itemView).setFeed(paramStFeed);
      ((QCircleCommentItemView)this.itemView).setOnCommentElementClickListener(paramaaga);
      ((QCircleCommentItemView)this.itemView).a(paramuzd, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyd
 * JD-Core Version:    0.7.0.1
 */