import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HornListActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.HornDetail;
import com.tencent.mobileqq.statistics.ReportController;

class cwp
  implements View.OnClickListener
{
  cwp(cwo paramcwo, HornDetail paramHornDetail) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.jdField_a_of_type_Cwo.a.b, "P_CliOper", "Svip", "", "Vip_nearby", "Vip_nearby_enterProfileCard", 0, 0, "", "", "", "");
    paramView = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.uin, 41);
    paramView.g = this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.nickName;
    paramView.a = this.jdField_a_of_type_ComTencentMobileqqDataHornDetail.seg;
    paramView.e = 4;
    paramView.f = 5;
    ProfileActivity.a(this.jdField_a_of_type_Cwo.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cwp
 * JD-Core Version:    0.7.0.1
 */