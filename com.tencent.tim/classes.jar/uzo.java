import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;

class uzo
  implements DialogInterface.OnClickListener
{
  uzo(uzn paramuzn) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.this$0.bOF();
    anot.a(this.a.this$0.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.eP(this.a.this$0.a.e.bJa), 0, Integer.toString(ProfileActivity.a(this.a.this$0.a.e)), Integer.toString(this.a.this$0.a.e.bJd), "", "");
    if (this.a.this$0.a.cwc) {
      new anov(this.a.this$0.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.a.this$0.a.troopUin }).report();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uzo
 * JD-Core Version:    0.7.0.1
 */