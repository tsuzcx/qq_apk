import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;

public class wyb
  implements Runnable
{
  public wyb(RedPacketRecordFragment paramRedPacketRecordFragment) {}
  
  public void run()
  {
    if (!this.a.e()) {
      this.a.getActivity().runOnUiThread(new wyc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyb
 * JD-Core Version:    0.7.0.1
 */