import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowUserItemView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class vyp
  implements DialogInterface.OnClickListener
{
  public vyp(QCircleSpecialFollowUserItemView paramQCircleSpecialFollowUserItemView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new FeedCloudMeta.StUser();
    paramDialogInterface.id.set(QCircleSpecialFollowUserItemView.a(this.a));
    vol.a().a(paramDialogInterface, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyp
 * JD-Core Version:    0.7.0.1
 */