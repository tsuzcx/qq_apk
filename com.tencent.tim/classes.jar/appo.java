import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment.17;
import com.tencent.qphone.base.util.QLog;

public class appo
  implements DialogInterface.OnClickListener
{
  public appo(VisitorTroopCardFragment.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.x.cancel();
      return;
    }
    try
    {
      ahkr.a(this.a.this$0.getActivity(), true, "action_game_join_group", Long.valueOf(this.a.this$0.getActivity().getIntent().getStringExtra("appid")).longValue(), -1, this.a.val$message);
      this.a.this$0.x.cancel();
      this.a.this$0.getActivity().finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("VisitorTroopCardFragment.Activity", 1, "showAlertDlg error = " + paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appo
 * JD-Core Version:    0.7.0.1
 */