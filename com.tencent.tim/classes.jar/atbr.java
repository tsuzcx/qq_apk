import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.activity.profile.friend.FriendProfileFragment;

public class atbr
  implements DialogInterface.OnClickListener
{
  public atbr(FriendProfileFragment paramFriendProfileFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.bOF();
    if (FriendProfileFragment.e(this.a).cwc) {
      new anov(FriendProfileFragment.f(this.a)).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { FriendProfileFragment.f(this.a).troopUin }).report();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbr
 * JD-Core Version:    0.7.0.1
 */