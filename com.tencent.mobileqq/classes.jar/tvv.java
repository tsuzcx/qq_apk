import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class tvv
  implements DialogInterface.OnClickListener
{
  public tvv(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    TroopInfoActivity.b(this.a);
    switch (TroopInfoActivity.a(this.a))
    {
    default: 
      return;
    }
    this.a.overridePendingTransition(0, 2131034122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tvv
 * JD-Core Version:    0.7.0.1
 */