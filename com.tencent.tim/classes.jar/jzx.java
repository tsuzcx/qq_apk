import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.PublicAccountBrowser.13.1;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.qphone.base.util.QLog;

public class jzx
  extends lce
{
  public jzx(PublicAccountBrowser paramPublicAccountBrowser) {}
  
  public void o(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (PublicAccountBrowser.a(this.this$0) != null))
    {
      Object localObject = new int[2];
      PublicAccountBrowser.a(this.this$0).getLocationInWindow((int[])localObject);
      if (PublicAccountBrowser.b(this.this$0) == null)
      {
        PublicAccountBrowser.b(this.this$0, new RIJRedPacketPopupView(this.this$0));
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout)this.this$0.findViewById(2131363728)).addView(PublicAccountBrowser.b(this.this$0), (ViewGroup.LayoutParams)localObject);
      }
      PublicAccountBrowser.b(this.this$0).nO(false);
      PublicAccountBrowser.b(this.this$0).nP(false);
      PublicAccountBrowser.b(this.this$0).setText(paramString);
      PublicAccountBrowser.b(this.this$0).setVisibility(4);
      PublicAccountBrowser.b(this.this$0).post(new PublicAccountBrowser.13.1(this, paramString));
      PublicAccountBrowser.b(this.this$0, true);
      return;
    }
    QLog.i("PublicAccountBrowser", 1, " red packet task do not get Tips!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzx
 * JD-Core Version:    0.7.0.1
 */