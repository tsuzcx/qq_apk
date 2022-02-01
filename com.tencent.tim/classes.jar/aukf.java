import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import com.tencent.tim.teamwork.TeamWorkAuthorizeSettingActivity;

public class aukf
  implements ausj.a
{
  public aukf(TeamWorkAuthorizeSettingActivity paramTeamWorkAuthorizeSettingActivity, aukn.a parama, SparseArray paramSparseArray, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TimDocSSOMsg.UinRightInfo localUinRightInfo = this.jdField_a_of_type_Aukn$a.b;
    if (this.dt.get(paramInt) == null) {
      paramInt = -1;
    }
    switch (paramInt)
    {
    default: 
    case 2131720872: 
    case 2131720873: 
      for (;;)
      {
        TeamWorkAuthorizeSettingActivity.a(this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity);
        this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity.a.notifyDataSetChanged();
        if (this.val$sheet.isShowing()) {
          this.val$sheet.dismiss();
        }
        return;
        paramInt = ((Integer)this.dt.get(paramInt)).intValue();
        break;
        localUinRightInfo.uint32_right.set(1);
        continue;
        localUinRightInfo.uint32_right.set(2);
      }
    }
    if ((localUinRightInfo.uint32_right.get() == 1) && (this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity.dNL == 1)) {}
    for (paramView = this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity.getString(2131720869);; paramView = this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity.getString(2131720868))
    {
      aqha.a(this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity, 230, "提示", paramView, 2131721058, 2131692505, new aukg(this, localUinRightInfo), new aukh(this)).show();
      if (this.jdField_a_of_type_ComTencentTimTeamworkTeamWorkAuthorizeSettingActivity.dNL != 1) {
        break;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukf
 * JD-Core Version:    0.7.0.1
 */