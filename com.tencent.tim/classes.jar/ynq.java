import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;

public class ynq
  implements DialogInterface.OnClickListener
{
  public ynq(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      ThreadManager.post(new ClassificationSearchActivity.15.1(this), 10, null, true);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ynq
 * JD-Core Version:    0.7.0.1
 */