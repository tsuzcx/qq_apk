import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

class uha
  implements View.OnClickListener
{
  uha(ugz paramugz) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!TextUtils.isEmpty(this.a.a.operation.opUser.id.get())))
    {
      if (paramView.getId() != 2131368706) {
        break label94;
      }
      tzv.a(this.a.a.operation.opUser.id.get(), 17, 8L);
    }
    for (;;)
    {
      tqs.a(this.a.a.operation.opUser.id.get());
      return;
      label94:
      if (paramView.getId() == 2131378900) {
        tzv.a(this.a.a.operation.opUser.id.get(), 17, 9L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uha
 * JD-Core Version:    0.7.0.1
 */