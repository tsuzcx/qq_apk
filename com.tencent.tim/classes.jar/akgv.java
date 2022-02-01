import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;

class akgv
  implements DialogInterface.OnClickListener
{
  akgv(akgs paramakgs, aqju paramaqju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.L.dismiss();
    this.a.this$0.dBm();
    paramDialogInterface = new Intent("tribe_profile_edit_finish");
    BaseApplicationImpl.getApplication().sendBroadcast(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgv
 * JD-Core Version:    0.7.0.1
 */