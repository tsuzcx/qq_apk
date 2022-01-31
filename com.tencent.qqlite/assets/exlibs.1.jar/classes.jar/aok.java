import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;

public class aok
  implements DialogInterface.OnClickListener
{
  public aok(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.b == 1) {
      VipUtils.a(this.a, 1, ProfileCardUtil.a(3));
    }
    for (;;)
    {
      this.a.p();
      return;
      if (this.a.b == 2) {
        VipUtils.b(this.a, 1, ProfileCardUtil.a(6));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aok
 * JD-Core Version:    0.7.0.1
 */