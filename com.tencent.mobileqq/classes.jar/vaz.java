import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleProfile.SetProfileRsp;

class vaz
  implements Observer<vup<QQCircleProfile.SetProfileRsp>>
{
  vaz(vax paramvax) {}
  
  public void a(@Nullable vup<QQCircleProfile.SetProfileRsp> paramvup)
  {
    if ((paramvup != null) && (paramvup.a() == 3) && (vax.a(this.a) != null))
    {
      paramvup = new Intent();
      paramvup.setAction("action_reload_get_main_page");
      paramvup.putExtra("uin", vax.a(this.a).id.get());
      if (this.a.a() != null)
      {
        this.a.a().sendBroadcast(paramvup);
        this.a.a().finish();
      }
    }
    while ((paramvup == null) || (paramvup.a() != 4)) {
      return;
    }
    if (paramvup.a() == null) {}
    for (String str = anni.a(2131718323);; str = paramvup.a())
    {
      QLog.e("QCircleDataEditContentP", 1, "onChanged() return error！errMsg:" + str);
      vtt.a(paramvup.a(), BaseApplicationImpl.getContext(), 1, str, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaz
 * JD-Core Version:    0.7.0.1
 */