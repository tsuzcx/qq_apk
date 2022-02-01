import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.a;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;

public class kae
  implements RIJRedPacketManager.a
{
  public kae(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void e(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.findViewById(2131363728);
      if (PublicAccountBrowser.a(this.this$0) == null)
      {
        PublicAccountBrowser.a(this.this$0, new RIJRedPacketPopupView(this.this$0));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localRelativeLayout.addView(PublicAccountBrowser.a(this.this$0), localLayoutParams);
      }
      int i = riw.dip2px(this.this$0, 16.0F);
      int j = localRelativeLayout.getHeight();
      int k = riw.dip2px(this.this$0, 78.0F);
      PublicAccountBrowser.a(this.this$0, PublicAccountBrowser.a(this.this$0), i, j - k - i, false, false, paramString, 2147483647);
      PublicAccountBrowser.a(this.this$0, true);
      PublicAccountBrowser.a(this.this$0, paramInt);
      PublicAccountBrowser.a(this.this$0).setOnClickListener(new kaf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kae
 * JD-Core Version:    0.7.0.1
 */