import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class vlr
  implements ausj.a
{
  public vlr(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, String paramString1, String paramString2, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      anot.a(this.a.app, "dc00898", "", "", "0X8009EC8", "0X8009EC8", 0, 0, "", "", "", "");
      if (!aqiw.isNetSupport(this.a))
      {
        QQToast.a(this.a, this.a.getString(2131693404), 0).show(this.a.getTitleBarHeight());
        return;
      }
      paramView = (acll)this.a.app.getBusinessHandler(34);
      if (paramView != null) {
        paramView.G(3, this.aOB, this.aOC);
      }
      PhoneUnityBindInfoActivity.a(this.a);
      PhoneUnityBindInfoActivity.a(this.a, 2131719519, 1000L, true);
      this.a.aYX = false;
      return;
    case 1: 
      if (!aqiw.isNetSupport(paramView))
      {
        PhoneUnityBindInfoActivity.b(this.a, 2131696348);
        return;
      }
      paramView = new Intent(paramView, BindNumberActivity.class);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("kUnityOther", true);
      paramView.putExtra("kSrouce", this.a.mSource);
      this.a.startActivityForResult(paramView, 1004);
      anot.a(this.a.app, "dc00898", "", "", "0X8009EC9", "0X8009EC9", 0, 0, "", "", "", "");
      this.c.dismiss();
      this.a.aYX = false;
      return;
    }
    anot.a(this.a.app, "dc00898", "", "", "0X8009ECA", "0X8009ECA", 0, 0, "", "", "", "");
    this.a.aYX = true;
    this.c.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlr
 * JD-Core Version:    0.7.0.1
 */