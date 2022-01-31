import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class txr
  implements TroopInfoActivityHelper.ISetSameCityCheckTypeInfo
{
  public txr(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = 4;
    }
    ReportController.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "local_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.b, "", "");
    TroopInfoActivity.a(this.a, true, 0L, "", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
  }
  
  public void a(String paramString)
  {
    this.a.j();
    TroopInfoActivity.a(this.a, false, 0L, paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     txr
 * JD-Core Version:    0.7.0.1
 */