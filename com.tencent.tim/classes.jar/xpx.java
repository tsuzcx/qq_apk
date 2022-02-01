import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.UUID;

class xpx
  implements DialogInterface.OnClickListener
{
  xpx(xpw paramxpw, long paramLong, UUID paramUUID, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TroopFileTransferManager.a(this.this$0.app, this.Hg).c(this.b);
      return;
    }
    new apca(this.Hg, this.this$0.app, this.val$activity).b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xpx
 * JD-Core Version:    0.7.0.1
 */