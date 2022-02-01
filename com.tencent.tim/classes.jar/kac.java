import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager.f;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.widget.FadeIconImageView;

public class kac
  implements RIJRedPacketManager.f
{
  public kac(PublicAccountBrowser paramPublicAccountBrowser, String paramString) {}
  
  public void lJ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ViewStub localViewStub = (ViewStub)this.this$0.findViewById(2131376770);
      if (localViewStub != null)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.findViewById(2131377503);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
        int i = riw.dip2px(this.this$0, 116.0F);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = i;
        localRelativeLayout.setLayoutParams(localLayoutParams);
        PublicAccountBrowser.a(this.this$0, (RIJRedPacketProgressView)localViewStub.inflate());
        PublicAccountBrowser.a(this.this$0).setVisibility(0);
        PublicAccountBrowser.a(this.this$0).setOnClickListener(new kad(this));
      }
      if (PublicAccountBrowser.a(this.this$0) != null)
      {
        PublicAccountBrowser.a(this.this$0).refresh();
        PublicAccountBrowser.b(this.this$0, this.Vw);
        PublicAccountBrowser.a(this.this$0);
        if (!this.this$0.adb) {
          break label284;
        }
        if ((PublicAccountBrowser.a(this.this$0) != null) && (PublicAccountBrowser.a(this.this$0).getVisibility() == 0)) {
          break label247;
        }
        PublicAccountBrowser.a(this.this$0).setImageResource(2130850290);
        PublicAccountBrowser.a(this.this$0).setVisibility(0);
        PublicAccountBrowser.a(this.this$0).setVisibility(8);
      }
    }
    for (;;)
    {
      PublicAccountBrowser.a(this.this$0).a(2, PublicAccountBrowser.a(this.this$0), this.Vw);
      return;
      label247:
      PublicAccountBrowser.a(this.this$0).setImageResource(2130850363);
      PublicAccountBrowser.a(this.this$0).setVisibility(0);
      PublicAccountBrowser.a(this.this$0).setVisibility(0);
      continue;
      label284:
      PublicAccountBrowser.a(this.this$0).setVisibility(8);
      PublicAccountBrowser.a(this.this$0).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kac
 * JD-Core Version:    0.7.0.1
 */