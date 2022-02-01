import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class armq
  implements DialogInterface.OnClickListener
{
  armq(int paramInt, Activity paramActivity, armm.a parama) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 2;
    if (this.val$scene == 1)
    {
      armm.aU(this.val$activity, 398668);
      armm.iF("0X80094F5");
      paramInt = 1;
    }
    for (;;)
    {
      armm.aV(this.val$activity, paramInt);
      this.a.callback(1);
      paramDialogInterface.dismiss();
      return;
      if ((this.val$scene == 2) || (this.val$scene == 5))
      {
        armm.aU(this.val$activity, 398668);
        armm.iF("0X80094F4");
        paramInt = 1;
      }
      else if (this.val$scene == 3)
      {
        armm.aU(this.val$activity, 398671);
        armm.iF("0X80094F6");
      }
      else
      {
        if (this.val$scene == 4)
        {
          armm.aU(this.val$activity, 398690);
          armm.iF("0X80094F4");
        }
        paramInt = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     armq
 * JD-Core Version:    0.7.0.1
 */