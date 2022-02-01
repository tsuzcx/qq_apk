import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

final class ner
  implements DialogInterface.OnClickListener
{
  ner(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      awit.acy(1);
      awit.bP(true);
      kgw.M(this.val$context, 9);
    }
    for (;;)
    {
      if ((this.val$context instanceof Activity)) {
        ((Activity)this.val$context).finish();
      }
      return;
      paramDialogInterface = new Intent(this.val$context, SplashActivity.class);
      paramDialogInterface.putExtra("fragment_id", 1);
      paramDialogInterface.putExtra("open_kandian_tab_fragment", true);
      paramDialogInterface.putExtra("arg_channel_cover_id", 0);
      paramDialogInterface.setFlags(335544320);
      this.val$context.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ner
 * JD-Core Version:    0.7.0.1
 */