import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;

class aocm
  implements DialogInterface.OnClickListener
{
  aocm(aocl paramaocl, TimDocSSOMsg.UinRightInfo paramUinRightInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.ceP = true;
    this.a.a.a.RH(String.valueOf(this.c.uint64_uin.get()));
    this.a.a.a.notifyDataSetChanged();
    if (this.a.a.dNL == 1) {
      anot.a(TeamWorkAuthorizeSettingFragment.a(this.a.a), "dc00898", "", "", "0x8007CFD", "0x8007CFD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocm
 * JD-Core Version:    0.7.0.1
 */