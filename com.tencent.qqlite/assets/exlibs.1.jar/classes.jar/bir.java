import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.SearchTroopListActivity;

public class bir
  implements DialogInterface.OnCancelListener
{
  public bir(SearchTroopListActivity paramSearchTroopListActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
    if (!this.a.isFinishing()) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bir
 * JD-Core Version:    0.7.0.1
 */