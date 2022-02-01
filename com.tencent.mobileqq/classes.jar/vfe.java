import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionCommentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vfe
  implements View.OnClickListener
{
  public vfe(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void onClick(View paramView)
  {
    PublicAccountImageCollectionCommentActivity.a(this.a);
    PublicAccountImageCollectionCommentActivity.a(this.a, -1);
    PublicAccountImageCollectionCommentActivity.b(this.a, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfe
 * JD-Core Version:    0.7.0.1
 */