import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;

public class ubk
  implements DialogInterface.OnClickListener
{
  public ubk(TestAppFragment paramTestAppFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubk
 * JD-Core Version:    0.7.0.1
 */