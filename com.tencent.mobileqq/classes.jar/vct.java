import android.app.Activity;
import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Collections;
import java.util.List;

class vct
  implements vjt
{
  vct(vcn paramvcn) {}
  
  public void a()
  {
    QLog.d("QCircleDataEditContentP", 1, "onClickSend()");
    if ((this.a.a().isFinishing()) || (vcn.a(this.a) == null))
    {
      QLog.d("QCircleDataEditContentP", 1, "onCommentSend(): mTroopAddInputPopupWindow null");
      return;
    }
    String str = vcn.a(this.a).a();
    if (TextUtils.isEmpty(str.trim())) {
      QQToast.a(this.a.a(), this.a.a().getString(2131697348), 0).a();
    }
    for (;;)
    {
      vtq.a(vcn.a(this.a).id.get(), 11, 25, 5, "", str, "", "", "", this.a.b());
      return;
      if (!NetworkUtils.isNetworkAvailable(this.a.a()))
      {
        QQToast.a(this.a.a(), 1, this.a.a().getString(2131693974), 0).a();
      }
      else if (vcn.a(this.a).contains(Long.valueOf(Long.parseLong(str))))
      {
        QQToast.a(this.a.a(), 1, this.a.a().getString(2131697350), 0).a();
      }
      else
      {
        vcn.a(this.a).g();
        vcn.a(this.a).c("");
        vcn.a(this.a, Collections.singletonList(Long.valueOf(Long.parseLong(str))));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vct
 * JD-Core Version:    0.7.0.1
 */