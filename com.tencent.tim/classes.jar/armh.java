import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class armh
  implements DialogInterface.OnCancelListener
{
  public armh(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.b(this.this$0);
    if (ShareActionSheetV2.a(this.this$0) != null) {
      ShareActionSheetV2.a(this.this$0).onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armh
 * JD-Core Version:    0.7.0.1
 */