import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;
import com.tencent.tim.filemanager.core.WpsFileEditManager;

public class atpk
  implements DialogInterface.OnClickListener
{
  public atpk(WpsFileEditSaveDlgActivity paramWpsFileEditSaveDlgActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.eqI == 1) {
      WpsFileEditManager.a().b(WpsFileEditSaveDlgActivity.a(this.a), null);
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
      WpsFileEditManager.a().c(WpsFileEditSaveDlgActivity.a(this.a), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpk
 * JD-Core Version:    0.7.0.1
 */