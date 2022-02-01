import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.ViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;

public class nnz
  extends Handler
{
  public nnz(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (ReadInJoyDiandianHeaderController.a(this.a)) {}
    while (ReadInJoyDiandianHeaderController.a(this.a).getCount() <= 1) {
      return;
    }
    paramMessage = this.a;
    paramMessage.baC += 1;
    this.a.baC %= ReadInJoyDiandianHeaderController.a(this.a).getCount();
    ReadInJoyDiandianHeaderController.a(this.a).setCurrentItem(this.a.baC, true);
    kbp.a(null, "", "0X8009827", "0X8009827", 0, 0, "", "", "", "", false);
    this.a.mHandler.sendMessageDelayed(this.a.mHandler.obtainMessage(), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnz
 * JD-Core Version:    0.7.0.1
 */