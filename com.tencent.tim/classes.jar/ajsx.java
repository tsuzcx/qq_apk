import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

public class ajsx
  implements DialogInterface.OnClickListener
{
  public ajsx(GameRoomInviteActivity paramGameRoomInviteActivity, boolean paramBoolean, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.ni = this.cqe;
    paramDialogInterface = this.this$0;
    String str = this.bSo;
    paramDialogInterface.OG = str;
    GameRoomInviteActivity.bSp = str;
    this.this$0.init(false);
    this.this$0.mGameRoomAVController.dyZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajsx
 * JD-Core Version:    0.7.0.1
 */