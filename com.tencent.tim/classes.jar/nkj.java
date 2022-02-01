import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.b;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class nkj
  implements RIJRedPacketManager.b
{
  public nkj(FastWebActivity paramFastWebActivity) {}
  
  public void p(boolean paramBoolean, String paramString)
  {
    FastWebActivity.e(this.this$0, paramBoolean);
    if (paramBoolean)
    {
      FastWebActivity.c(this.this$0, paramString);
      if (FastWebActivity.a(this.this$0).getVisibility() == 0) {
        break label55;
      }
      FastWebActivity.a(this.this$0).setImageResource(2130850290);
    }
    for (;;)
    {
      FastWebActivity.h(this.this$0);
      return;
      label55:
      FastWebActivity.a(this.this$0).setImageResource(2130850362);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkj
 * JD-Core Version:    0.7.0.1
 */