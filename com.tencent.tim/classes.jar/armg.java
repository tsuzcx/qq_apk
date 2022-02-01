import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class armg
  implements DialogInterface.OnShowListener
{
  public armg(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.a(this.this$0, false);
    if (ShareActionSheetV2.a(this.this$0) != null) {
      ShareActionSheetV2.a(this.this$0).onShow(paramDialogInterface);
    }
    ShareActionSheetV2.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armg
 * JD-Core Version:    0.7.0.1
 */