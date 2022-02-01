import android.app.Activity;
import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Collections;
import java.util.List;

class vbd
  implements vhp
{
  vbd(vax paramvax) {}
  
  public void a()
  {
    QLog.d("QCircleDataEditContentP", 1, "onClickSend()");
    if ((this.a.a().isFinishing()) || (vax.a(this.a) == null))
    {
      QLog.d("QCircleDataEditContentP", 1, "onCommentSend(): mTroopAddInputPopupWindow null");
      return;
    }
    String str = vax.a(this.a).a();
    if (TextUtils.isEmpty(str.trim())) {
      QQToast.a(this.a.a(), this.a.a().getString(2131697270), 0).a();
    }
    for (;;)
    {
      vrf.a(vax.a(this.a).id.get(), 11, 25, 5, "", str, "", "", "", this.a.b());
      return;
      if (!NetworkUtils.isNetworkAvailable(this.a.a()))
      {
        QQToast.a(this.a.a(), 1, this.a.a().getString(2131693957), 0).a();
      }
      else if (vax.a(this.a).contains(Long.valueOf(Long.parseLong(str))))
      {
        QQToast.a(this.a.a(), 1, this.a.a().getString(2131697272), 0).a();
      }
      else
      {
        vax.a(this.a).g();
        vax.a(this.a).c("");
        vax.a(this.a, Collections.singletonList(Long.valueOf(Long.parseLong(str))));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbd
 * JD-Core Version:    0.7.0.1
 */