import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;

public class vrh
  implements DialogInterface.OnClickListener
{
  public vrh(GameRoomChatPie paramGameRoomChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.V = true;
    GameRoomChatPie.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrh
 * JD-Core Version:    0.7.0.1
 */