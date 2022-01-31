import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.SearchTroopListActivity;

public class dmx
  implements DialogInterface.OnCancelListener
{
  public dmx(SearchTroopListActivity paramSearchTroopListActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmx
 * JD-Core Version:    0.7.0.1
 */