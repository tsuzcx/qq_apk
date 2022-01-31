import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class wpi
  implements DialogInterface.OnClickListener
{
  public wpi(SystemMsgListView paramSystemMsgListView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent(this.a.getContext(), BindNumberActivity.class);
      paramDialogInterface.putExtra("kSrouce", 17);
      this.a.a(paramDialogInterface, 230);
      ReportController.b(this.a.a, "dc00898", "", "", "0X80077C9", "0X80077C9", 0, 0, "", "", "", "");
    }
    while (paramInt != 0) {
      return;
    }
    ReportController.b(this.a.a, "dc00898", "", "", "0X80077CA", "0X80077CA", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wpi
 * JD-Core Version:    0.7.0.1
 */