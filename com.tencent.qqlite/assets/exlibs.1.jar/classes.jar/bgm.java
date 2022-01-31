import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.RegisterActivity;

public class bgm
  implements DialogInterface.OnClickListener
{
  public bgm(RegisterActivity paramRegisterActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a = 0;
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bgm
 * JD-Core Version:    0.7.0.1
 */