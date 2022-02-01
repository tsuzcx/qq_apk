import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout.a;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.qphone.base.util.QLog;

public class aaex
  implements DoodleLayout.a
{
  public aaex(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void CF(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(DrawRedpacketPannelPreviewFragment.TAG, 2, "---onLineFinish---");
    }
    DrawRedpacketPannelPreviewFragment.c(this.this$0);
  }
  
  public void ctQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d(DrawRedpacketPannelPreviewFragment.TAG, 2, "---onLineBegin---");
    }
    DrawRedpacketPannelPreviewFragment.a(this.this$0, false);
    DrawRedpacketPannelPreviewFragment.a(this.this$0);
    DrawRedpacketPannelPreviewFragment.c(this.this$0).setTextColor(Color.parseColor("#878B99"));
    DrawRedpacketPannelPreviewFragment.c(this.this$0).setText(acfp.m(2131705316));
  }
  
  public void ft(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaex
 * JD-Core Version:    0.7.0.1
 */