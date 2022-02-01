import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class aotx
  implements DialogInterface.OnClickListener
{
  public aotx(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (String)this.this$0.BA.get(this.val$index);
    long l = Long.parseLong((String)this.this$0.BB.get(this.val$index));
    CardHandler localCardHandler = (CardHandler)this.this$0.app.getBusinessHandler(2);
    if (localCardHandler != null) {
      localCardHandler.h(this.this$0.app.getCurrentAccountUin(), paramDialogInterface, l);
    }
    if (!this.this$0.isFinishing()) {
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aotx
 * JD-Core Version:    0.7.0.1
 */