import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

final class ajtq
  implements DialogInterface.OnClickListener
{
  ajtq(Activity paramActivity, String paramString, int paramInt, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.val$activity, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.bSo);
    paramDialogInterface.putExtra("roomNum", this.val$num);
    if (this.Hg > 0L)
    {
      paramDialogInterface.putExtra("gc", this.Hg);
      paramDialogInterface.putExtra("isInviteTroop", false);
    }
    this.val$activity.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtq
 * JD-Core Version:    0.7.0.1
 */