import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;

public class mjf
  implements DialogInterface.OnDismissListener
{
  public mjf(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ReadInJoyDeliverUGCActivity.c(this.this$0))
    {
      ReadInJoyDeliverUGCActivity.c(this.this$0, false);
      ReadInJoyDeliverUGCActivity.e(this.this$0);
      if ((ReadInJoyDeliverUGCActivity.g(this.this$0)) || (ReadInJoyDeliverUGCActivity.a(this.this$0) != null)) {
        ReadInJoyDeliverUGCActivity.a(this.this$0).removeCallbacksAndMessages(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjf
 * JD-Core Version:    0.7.0.1
 */