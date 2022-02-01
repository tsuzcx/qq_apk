import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterChooseLoginActivity;

public class vrn
  implements DialogInterface.OnClickListener
{
  public vrn(RegisterChooseLoginActivity paramRegisterChooseLoginActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RegisterChooseLoginActivity.a(this.a, false);
    RegisterChooseLoginActivity.a(this.a, false);
    anot.c(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 0, 0, "", "", "", "");
    anot.c(this.a.app, "dc00898", "", "", "0X8007CC9", "0X8007CC9", 2, 0, "", "", "", "");
    anot.a(this.a.app, "new_reg", "next_ask", "no_clk", "", 1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vrn
 * JD-Core Version:    0.7.0.1
 */