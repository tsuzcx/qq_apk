import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleProfile.SetProfileRsp;

class vcp
  implements Observer<vxq<QQCircleProfile.SetProfileRsp>>
{
  vcp(vcn paramvcn) {}
  
  public void a(@Nullable vxq<QQCircleProfile.SetProfileRsp> paramvxq)
  {
    if ((paramvxq != null) && (paramvxq.a() == 3) && (vcn.a(this.a) != null))
    {
      paramvxq = new Intent();
      paramvxq.setAction("action_reload_get_main_page");
      paramvxq.putExtra("uin", vcn.a(this.a).id.get());
      if (this.a.a() != null)
      {
        this.a.a().sendBroadcast(paramvxq);
        this.a.a().finish();
      }
    }
    while ((paramvxq == null) || (paramvxq.a() != 4)) {
      return;
    }
    if (paramvxq.a() == null) {}
    for (String str = anzj.a(2131718459);; str = paramvxq.a())
    {
      QLog.e("QCircleDataEditContentP", 1, "onChanged() return error！errMsg:" + str);
      vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, str, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcp
 * JD-Core Version:    0.7.0.1
 */