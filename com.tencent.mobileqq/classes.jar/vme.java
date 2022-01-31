import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.statistics.ReportController;

public class vme
  implements DialogInterface.OnClickListener
{
  public vme(PhotoListPanel paramPhotoListPanel) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(this.a.a, "CliOper", "", "", "0X80061FC", "0X80061FC", 0, 0, "0", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */