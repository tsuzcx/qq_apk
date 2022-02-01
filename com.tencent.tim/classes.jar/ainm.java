import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import java.util.Map;

public class ainm
  implements DialogInterface.OnClickListener
{
  public ainm(ListenTogetherManager paramListenTogetherManager, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.this$0.dta();
      paramDialogInterface.dismiss();
    }
    while (paramInt != 0) {
      return;
    }
    this.this$0.dtb();
    paramDialogInterface.dismiss();
    ListenTogetherManager.a(this.this$0, (ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(aiob.H(this.val$type, this.val$uin)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainm
 * JD-Core Version:    0.7.0.1
 */