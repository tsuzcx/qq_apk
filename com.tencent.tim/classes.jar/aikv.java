import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class aikv
  implements DialogInterface.OnClickListener
{
  public aikv(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if (!TextUtils.isEmpty(this.val$callback)) {
        this.this$0.callJs(this.val$callback + "({button: 1})");
      }
    }
    while (paramInt != 1)
    {
      return;
      this.this$0.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 1})");
      return;
    }
    if (!TextUtils.isEmpty(this.val$callback))
    {
      this.this$0.callJs(this.val$callback + "({button: 0})");
      return;
    }
    this.this$0.callJs4OpenApiIfNeeded("showDialog", 0, "({button: 0})");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikv
 * JD-Core Version:    0.7.0.1
 */