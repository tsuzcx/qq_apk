import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;
import com.tencent.tim.filemanager.core.WpsFileEditManager;

public class atpl
  implements DialogInterface.OnClickListener
{
  public atpl(WpsFileEditSaveDlgActivity paramWpsFileEditSaveDlgActivity, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.eqI == 1) {
      WpsFileEditManager.a().d(WpsFileEditSaveDlgActivity.a(this.a), null);
    }
    for (;;)
    {
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
      paramDialogInterface = new Bundle();
      paramDialogInterface.putBoolean("bOnlyOverWriteFile", true);
      WpsFileEditManager.a().c(WpsFileEditSaveDlgActivity.a(this.a), paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpl
 * JD-Core Version:    0.7.0.1
 */