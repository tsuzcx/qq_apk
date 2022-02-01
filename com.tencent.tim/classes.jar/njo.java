import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;

public class njo
  implements RIJRedPacketManager.f
{
  public njo(FastWebActivity paramFastWebActivity) {}
  
  public void lJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)FastWebActivity.a(this.this$0).getLayoutParams();
      int i = riw.dip2px(this.this$0, 144.0F);
      localLayoutParams.rightMargin = i;
      localLayoutParams.leftMargin = i;
      FastWebActivity.a(this.this$0).setLayoutParams(localLayoutParams);
      FastWebActivity.a(this.this$0).setVisibility(0);
      FastWebActivity.a(this.this$0).setOnClickListener(new njp(this));
      FastWebActivity.a(this.this$0);
      if (FastWebActivity.b(this.this$0)) {
        FastWebActivity.a(this.this$0).setImageResource(2130850362);
      }
      FastWebActivity.a(this.this$0).a(2, FastWebActivity.a(this.this$0), FastWebActivity.a(this.this$0).innerUniqueID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njo
 * JD-Core Version:    0.7.0.1
 */