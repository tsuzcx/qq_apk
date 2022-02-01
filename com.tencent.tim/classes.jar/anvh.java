import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

class anvh
  implements DialogInterface.OnClickListener
{
  anvh(anvg paramanvg, Context paramContext, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anvf.a(this.a.this$0, this.I, this.val$view);
    if ((this.I instanceof BaseActivity)) {
      anot.a(((BaseActivity)this.I).app, "CliOper", "", "", "0X8005BA3", "0X8005BA3", 0, 0, "", "", "", "");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvh
 * JD-Core Version:    0.7.0.1
 */