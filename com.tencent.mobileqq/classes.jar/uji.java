import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnDismissListener;

public final class uji
  implements ActionSheet.OnDismissListener
{
  public uji(QQAppInterface paramQQAppInterface) {}
  
  public void onDismiss()
  {
    ReportController.b(this.a, "CliOper", "", "", "0X8004864", "0X8004864", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uji
 * JD-Core Version:    0.7.0.1
 */