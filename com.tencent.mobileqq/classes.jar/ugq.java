import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;

public class ugq
  implements View.OnClickListener
{
  public ugq(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.e, "超级会员");
    paramView.putString(VasH5PayUtil.f, "CJCLUBT");
    paramView.putString(VasH5PayUtil.d, "1450000516");
    paramView.putInt(VasH5PayUtil.b, 3);
    paramView.putString(VasH5PayUtil.i, "http://imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&_fv=0&aid=" + "mvip.pt.vipsite.tqtips_chengyuan");
    paramView.putString(VasH5PayUtil.g, "svip");
    paramView.putString(VasH5PayUtil.a, this.a.app.getCurrentAccountUin());
    VasH5PayUtil.a(this.a.app, this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ugq
 * JD-Core Version:    0.7.0.1
 */