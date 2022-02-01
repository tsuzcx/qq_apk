import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ylw
  implements DialogInterface.OnClickListener
{
  public ylw(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!aqiw.isNetworkAvailable(this.this$0.getApplicationContext())) {
      QQToast.a(this.this$0, 2131696743, 1).show();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      this.this$0.cjz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylw
 * JD-Core Version:    0.7.0.1
 */