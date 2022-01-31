import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class cnn
  implements DialogInterface.OnClickListener
{
  public cnn(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.a.a()))
    {
      ReportController.b(this.a.b, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, "", "", "", "");
      DiscussionInfoCardActivity.a(this.a).d(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue());
      this.a.a(this.a.getString(2131562648));
      DiscussionInfoCardActivity.a(this.a).show();
      return;
    }
    this.a.a(1, this.a.getString(2131562488));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cnn
 * JD-Core Version:    0.7.0.1
 */