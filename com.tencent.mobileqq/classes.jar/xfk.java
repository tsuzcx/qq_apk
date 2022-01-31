import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.LoginManagerActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class xfk
  implements View.OnClickListener
{
  public xfk(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131365401: 
    case 2131365402: 
    default: 
    case 2131365399: 
      do
      {
        return;
        paramView = new Intent(BannerManager.a(this.a), LoginManagerActivity.class);
        paramView.putExtra("loginInfo", this.a.jdField_b_of_type_JavaLangString);
        paramView.putExtra("appType", this.a.jdField_b_of_type_Int);
        paramView.putExtra("subappid", this.a.a);
        paramView.putExtra("clientType", this.a.jdField_b_of_type_Long);
        BannerManager.a(this.a).startActivity(paramView);
      } while (this.a.jdField_b_of_type_Long != 77313L);
      ReportController.b(BannerManager.a(this.a).app, "dc00898", "", "", "0X8008880", "0X8008880", 0, 0, "", "", "", "");
      return;
    }
    if (this.a.jdField_b_of_type_Long == 77313L) {
      this.a.jdField_b_of_type_Boolean = true;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfk
 * JD-Core Version:    0.7.0.1
 */