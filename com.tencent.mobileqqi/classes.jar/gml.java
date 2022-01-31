import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;

class gml
  implements DialogInterface.OnClickListener
{
  gml(gmk paramgmk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ShareAppLogActivity.a(this.a.a).a(false);
    ShareAppLogActivity.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gml
 * JD-Core Version:    0.7.0.1
 */