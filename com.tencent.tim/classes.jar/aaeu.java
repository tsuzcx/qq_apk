import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class aaeu
  implements View.OnLongClickListener
{
  public aaeu(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((DrawRedpacketPannelPreviewFragment.a(this.this$0) != null) && (DrawRedpacketPannelPreviewFragment.a(this.this$0).e(false, false) > 0) && (DrawRedpacketPannelPreviewFragment.a(this.this$0) != null)) {
      DrawRedpacketPannelPreviewFragment.a(this.this$0).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaeu
 * JD-Core Version:    0.7.0.1
 */