import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.TroopManager.c;

public final class aqnn
  implements DialogInterface.OnClickListener
{
  public aqnn(boolean paramBoolean, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.cUH)
    {
      paramDialogInterface = new Intent(this.val$context, QQBrowserActivity.class);
      paramDialogInterface.putExtra("url", String.format(yhy.aYa, new Object[] { this.Uf, "group_aio_popup" }));
      paramDialogInterface.putExtra("hide_operation_bar", true);
      this.val$context.startActivity(paramDialogInterface);
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "qq_vip", this.cun, this.ead, 0, "", "", "", "");
      return;
      TroopManager.c.y(this.val$context, this.Uf, "group_aio_popup");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnn
 * JD-Core Version:    0.7.0.1
 */