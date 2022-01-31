import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;

class bvb
  implements DialogInterface.OnClickListener
{
  bvb(buz parambuz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.b != null) && (this.a.b.length() > 0))
    {
      paramDialogInterface = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.a.b));
      GrayTipsItemBuilder.i(this.a.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvb
 * JD-Core Version:    0.7.0.1
 */