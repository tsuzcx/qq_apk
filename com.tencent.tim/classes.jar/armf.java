import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;

public class armf
  implements DialogInterface.OnDismissListener
{
  public armf(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onDismiss() called with: dialog = [" + paramDialogInterface + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    ShareActionSheetV2.b(this.this$0);
    if (ShareActionSheetV2.a(this.this$0) != null) {
      ShareActionSheetV2.a(this.this$0).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armf
 * JD-Core Version:    0.7.0.1
 */