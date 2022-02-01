import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aesl
  implements DialogInterface.OnClickListener
{
  aesl(aesh paramaesh, Runnable paramRunnable, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.val$callback.run();
    String str2;
    if (this.bWf)
    {
      paramDialogInterface = "0X800AE6B";
      str2 = this.bAQ;
      if (!this.bWg) {
        break label55;
      }
    }
    label55:
    for (String str1 = "size";; str1 = "full")
    {
      aesh.aD(paramDialogInterface, str2, str1);
      return;
      paramDialogInterface = "0X800AE65";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesl
 * JD-Core Version:    0.7.0.1
 */