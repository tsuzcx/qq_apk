import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import com.tencent.tim.teamwork.TeamWorkAuthorizeSettingActivity;

class aukg
  implements DialogInterface.OnClickListener
{
  aukg(aukf paramaukf, TimDocSSOMsg.UinRightInfo paramUinRightInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aukf.a.ceP = true;
    this.jdField_a_of_type_Aukf.a.a.RH(String.valueOf(this.jdField_a_of_type_ComTencentTimSsoCmdTimDocSSOMsg$UinRightInfo.uint64_uin.get()));
    this.jdField_a_of_type_Aukf.a.a.notifyDataSetChanged();
    if (this.jdField_a_of_type_Aukf.a.dNL == 1) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukg
 * JD-Core Version:    0.7.0.1
 */