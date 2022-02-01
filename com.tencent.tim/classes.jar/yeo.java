import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopLowCreditLevelNotifyActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;

public class yeo
  implements DialogInterface.OnClickListener
{
  public yeo(TroopChatPie paramTroopChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.this$0.mContext, TroopLowCreditLevelNotifyActivity.class);
    paramDialogInterface.putExtra("troopUin", this.this$0.sessionInfo.aTl);
    this.this$0.mContext.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yeo
 * JD-Core Version:    0.7.0.1
 */