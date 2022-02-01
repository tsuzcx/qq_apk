import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ivi
  implements DialogInterface.OnDismissListener
{
  ivi(ivc.b paramb, long paramLong) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    QLog.w("ShareChat", 1, "ActionSheet.onDismiss, mChoosedLinkType[" + this.this$0.atV + "], mIHandle[" + this.this$0.a + "], seq[" + this.kQ + "]");
    if ((this.this$0.atV == -1) && (this.this$0.a != null)) {
      this.this$0.C(this.this$0.atU, this.this$0.atV, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivi
 * JD-Core Version:    0.7.0.1
 */