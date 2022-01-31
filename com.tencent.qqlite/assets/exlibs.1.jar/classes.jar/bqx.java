import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;

public class bqx
  implements DialogInterface.OnClickListener
{
  public bqx(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeActivity.a(this.a);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bqx
 * JD-Core Version:    0.7.0.1
 */