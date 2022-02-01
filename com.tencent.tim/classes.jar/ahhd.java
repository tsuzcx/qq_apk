import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;

class ahhd
  implements DialogInterface.OnClickListener
{
  ahhd(ahhc paramahhc, int paramInt, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.p != null)
    {
      paramDialogInterface = this.a.a(this.val$type, this.bg);
      this.a.p.send(0, paramDialogInterface);
    }
    if (this.a.mActivity != null)
    {
      this.a.mActivity.setResult(1);
      this.a.mActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahhd
 * JD-Core Version:    0.7.0.1
 */