import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class aaez
  implements DialogInterface.OnClickListener
{
  public aaez(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DrawRedpacketPannelPreviewFragment.a(this.this$0, false);
    DrawRedpacketPannelPreviewFragment.a(this.this$0).ba(false, false);
    DrawRedpacketPannelPreviewFragment.a(this.this$0);
    DrawRedpacketPannelPreviewFragment.c(this.this$0).setTextColor(Color.parseColor("#878B99"));
    DrawRedpacketPannelPreviewFragment.c(this.this$0).setText("......");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaez
 * JD-Core Version:    0.7.0.1
 */