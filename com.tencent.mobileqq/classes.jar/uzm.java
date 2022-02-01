import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.qqcircle.comment.QCircleCommentItemView;
import feedcloud.FeedCloudMeta.StFeed;

class uzm
  extends RecyclerView.ViewHolder
{
  private uzm(uzl paramuzl, View paramView)
  {
    super(paramView);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, vat paramvat, aakb paramaakb)
  {
    if ((this.itemView instanceof QCircleCommentItemView))
    {
      ((QCircleCommentItemView)this.itemView).setFeed(paramStFeed);
      ((QCircleCommentItemView)this.itemView).setOnCommentElementClickListener(paramaakb);
      ((QCircleCommentItemView)this.itemView).a(paramvat, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzm
 * JD-Core Version:    0.7.0.1
 */