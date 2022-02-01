import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailyFragment;

public class ldu
  extends BroadcastReceiver
{
  public ldu(ReadInJoyDailyFragment paramReadInJoyDailyFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.this$0.getActivity() != null)
    {
      if (ReadInJoyDailyFragment.a(this.this$0) != null) {
        ReadInJoyDailyFragment.a(this.this$0).aCD();
      }
      ReadInJoyDailyFragment.a(this.this$0, true);
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ldu
 * JD-Core Version:    0.7.0.1
 */