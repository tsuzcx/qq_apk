import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;

public class vzc
  implements DialogInterface.OnClickListener
{
  public vzc(TroopInfoActivity paramTroopInfoActivity, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TroopInfoActivity.a(this.this$0, true);
    this.this$0.finish();
    if ((this.M != null) && (this.M.isShowing())) {
      this.M.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzc
 * JD-Core Version:    0.7.0.1
 */