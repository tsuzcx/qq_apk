import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;

public class aouh
  implements DialogInterface.OnClickListener
{
  public aouh(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, Bundle paramBundle, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    long l1 = this.val$extras.getLong("label_id", 0L);
    long l2 = Long.valueOf((String)this.this$0.BA.get(this.val$index)).longValue();
    ((albz)this.this$0.app.getBusinessHandler(112)).m(this.this$0.app.getCurrentAccountUin(), l1, l2);
    TroopAvatarWallPreviewActivity.a(this.this$0, this.this$0.getResources().getString(2131692539));
    this.this$0.addObserver(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aouh
 * JD-Core Version:    0.7.0.1
 */