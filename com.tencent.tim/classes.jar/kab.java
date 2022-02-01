import android.widget.ImageView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.b;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.widget.FadeIconImageView;

public class kab
  implements RIJRedPacketManager.b
{
  public kab(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void p(boolean paramBoolean, String paramString)
  {
    this.this$0.adb = paramBoolean;
    PublicAccountBrowser.a(this.this$0);
    if (paramBoolean)
    {
      this.this$0.Vs = paramString;
      if ((PublicAccountBrowser.a(this.this$0) == null) || (PublicAccountBrowser.a(this.this$0).getVisibility() != 0))
      {
        PublicAccountBrowser.a(this.this$0).setImageResource(2130850290);
        PublicAccountBrowser.a(this.this$0).setVisibility(0);
        PublicAccountBrowser.a(this.this$0).setVisibility(8);
      }
      for (;;)
      {
        PublicAccountBrowser.b(this.this$0);
        return;
        PublicAccountBrowser.a(this.this$0).setImageResource(2130850363);
        PublicAccountBrowser.a(this.this$0).setVisibility(0);
        PublicAccountBrowser.a(this.this$0).setVisibility(0);
      }
    }
    PublicAccountBrowser.a(this.this$0).setVisibility(8);
    PublicAccountBrowser.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kab
 * JD-Core Version:    0.7.0.1
 */