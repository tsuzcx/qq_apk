import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class abgq
  implements DialogInterface.OnClickListener
{
  abgq(abgo paramabgo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(abgo.a(this.a), 4, "right button is clicked! ");
    }
    abgo.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgq
 * JD-Core Version:    0.7.0.1
 */