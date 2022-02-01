import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;

public class nsl
  extends Handler
{
  public nsl(ChannelTopBanner paramChannelTopBanner, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((ChannelTopBanner.a(this.b)) || (!ChannelTopBanner.b(this.b))) {}
    while (this.b.b.getCount() <= 1) {
      return;
    }
    paramMessage = this.b;
    paramMessage.baC += 1;
    this.b.baC %= this.b.b.getCount();
    this.b.a.setCurrentItem(this.b.baC, true);
    this.b.mHandler.sendMessageDelayed(this.b.mHandler.obtainMessage(), 4000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsl
 * JD-Core Version:    0.7.0.1
 */