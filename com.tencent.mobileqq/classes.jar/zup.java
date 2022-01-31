import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;

public class zup
  implements DialogInterface.OnClickListener
{
  public zup(TestAppFragment paramTestAppFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zup
 * JD-Core Version:    0.7.0.1
 */