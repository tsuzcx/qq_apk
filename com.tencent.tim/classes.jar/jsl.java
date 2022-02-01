import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.lebasearch.Utils;

public final class jsl
  implements DialogInterface.OnClickListener
{
  public jsl(int paramInt, acci paramacci, Context paramContext, skj paramskj, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (this.val$type == 1)
      {
        this.c.onUpdate(17, false, null);
        paramDialogInterface.dismiss();
        return;
      }
      Utils.sendPluginSetMessage(this.val$context, this.b, this.c, this.qA, false);
      return;
    }
    if (this.val$type == 1)
    {
      Utils.sendPluginSetMessage(this.val$context, this.b, this.c, this.qA, true);
      return;
    }
    this.c.onUpdate(17, false, null);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsl
 * JD-Core Version:    0.7.0.1
 */