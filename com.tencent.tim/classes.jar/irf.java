import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.random.RandomController;

public class irf
  implements DialogInterface.OnClickListener
{
  public irf(RandomController paramRandomController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (RandomController.a(this.this$0) == 1) {
      anot.a(null, "CliOper", "", "", "0X80053B4", "0X80053B4", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.this$0.stop();
      RandomController.d(this.this$0, false);
      return;
      if (RandomController.a(this.this$0) == 2) {
        anot.a(null, "CliOper", "", "", "0X80053C0", "0X80053C0", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     irf
 * JD-Core Version:    0.7.0.1
 */