import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aksj
  implements DialogInterface.OnClickListener
{
  aksj(akrv paramakrv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((akrv.a(this.this$0) != null) && (akrv.a(this.this$0).isShowing()))
      {
        akrv.a(this.this$0).dismiss();
        akrv.a(this.this$0, null);
      }
      label42:
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanel", 2, "switch status cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksj
 * JD-Core Version:    0.7.0.1
 */