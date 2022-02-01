import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ivh
  implements DialogInterface.OnDismissListener
{
  ivh(ivc.b paramb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.w("ShareChat", 1, "ShareActionSheetBuilder.onDismiss, mChoosedChannel[" + this.this$0.atU + "], mIHandle[" + this.this$0.a + "]");
    }
    if ((this.this$0.atU == -1) && (this.this$0.a != null)) {
      this.this$0.C(this.this$0.atU, this.this$0.atV, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivh
 * JD-Core Version:    0.7.0.1
 */