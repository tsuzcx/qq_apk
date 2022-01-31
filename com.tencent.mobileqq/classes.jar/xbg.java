import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;

public class xbg
  implements Runnable
{
  public xbg(RedPacketRecordFragment paramRedPacketRecordFragment) {}
  
  public void run()
  {
    if (!this.a.e()) {
      this.a.getActivity().runOnUiThread(new xbh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbg
 * JD-Core Version:    0.7.0.1
 */