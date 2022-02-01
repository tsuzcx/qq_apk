import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;

public class aaom
  implements DialogInterface.OnClickListener
{
  public aaom(TimLoginQQView paramTimLoginQQView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.this$0.a.getText().toString();
    if (!TextUtils.isEmpty(paramDialogInterface)) {
      this.this$0.Ay(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaom
 * JD-Core Version:    0.7.0.1
 */