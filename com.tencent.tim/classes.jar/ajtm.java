import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

final class ajtm
  implements DialogInterface.OnClickListener
{
  ajtm(Context paramContext, String paramString, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.val$context, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.bSo);
    paramDialogInterface.putExtra("roomNum", this.val$num);
    this.val$context.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajtm
 * JD-Core Version:    0.7.0.1
 */