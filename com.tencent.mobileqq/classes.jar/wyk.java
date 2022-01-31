import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasH5PayUtil;

public class wyk
  implements View.OnClickListener
{
  public wyk(AvatarPendantActivity paramAvatarPendantActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    VasH5PayUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity, "mvip.gxh.android.faceaddon_nati_dft", this.jdField_a_of_type_Int, "1450000515", this.jdField_a_of_type_JavaLangString, this.b, "");
    paramView = "0";
    if (!TextUtils.isEmpty(this.b)) {
      if (!"QQ会员".equals(this.b)) {
        break label84;
      }
    }
    label84:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityPendantAvatarPendantActivity.app, "CliOper", "", "", "0X8005FD2", "0X8005FD2", 0, 0, paramView, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyk
 * JD-Core Version:    0.7.0.1
 */