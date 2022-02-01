import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.2.1;

public class aaet
  implements aaeh.a
{
  public aaet(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void onInit(boolean paramBoolean)
  {
    if ((this.this$0.getActivity() == null) || (this.this$0.getActivity().isFinishing())) {
      return;
    }
    DrawRedpacketPannelPreviewFragment.a(this.this$0).post(new DrawRedpacketPannelPreviewFragment.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaet
 * JD-Core Version:    0.7.0.1
 */