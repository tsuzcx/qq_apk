import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.statistics.LocalCrashCollector;
import com.tencent.mobileqq.statistics.LocalCrashCollector.3;
import com.tencent.widget.XEditTextEx;

public class anok
  implements DialogInterface.OnClickListener
{
  public anok(LocalCrashCollector.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      LocalCrashCollector.a(this.a.this$0).a.setText("");
      LocalCrashCollector.a(this.a.this$0).delete(0, LocalCrashCollector.a(this.a.this$0).length());
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anok
 * JD-Core Version:    0.7.0.1
 */