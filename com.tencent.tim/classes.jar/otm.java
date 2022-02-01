import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class otm
  implements View.OnClickListener
{
  public otm(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void onClick(View paramView)
  {
    PublicAccountImageCollectionCommentActivity.a(this.a);
    PublicAccountImageCollectionCommentActivity.a(this.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     otm
 * JD-Core Version:    0.7.0.1
 */