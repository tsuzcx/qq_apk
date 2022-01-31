import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.LinkedList;

public class axf
  implements View.OnClickListener
{
  public axf(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, 2131363515, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (NearbyPeopleProfileActivity.a(this.a).size() <= 1)
    {
      paramView = DialogUtil.a(this.a, "交友相册需要至少一张照片\n仅陌生人可见，秀出精彩的自己！", 0, 0, null, null);
      paramView.setNegativeButton(2131362790, new axg(this, paramView));
      paramView.setPositiveButton("立即上传", new axh(this, paramView));
      paramView.show();
      return;
    }
    paramView = NearbyPeopleProfileActivity.a(this.a).getText().toString();
    if ((!StringUtil.b(paramView)) && (StringUtil.e(paramView).length() == 0))
    {
      QQToast.a(this.a, "交友昵称不允许全为空格", 0).b(this.a.getTitleBarHeight());
      return;
    }
    NearbyPeopleProfileActivity.c(this.a);
    if (NearbyPeopleProfileActivity.a(this.a).size() > 0)
    {
      NearbyPeopleProfileActivity.f(this.a);
      return;
    }
    NearbyPeopleProfileActivity.g(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     axf
 * JD-Core Version:    0.7.0.1
 */