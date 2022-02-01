import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController.ViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;

public class tkr
  extends Handler
{
  public tkr(ReadInJoyDiandianHeaderController paramReadInJoyDiandianHeaderController, Looper paramLooper)
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
    paramMessage.jdField_a_of_type_Int += 1;
    this.a.jdField_a_of_type_Int %= ReadInJoyDiandianHeaderController.a(this.a).getCount();
    ReadInJoyDiandianHeaderController.a(this.a).setCurrentItem(this.a.jdField_a_of_type_Int, true);
    olh.a(null, "", "0X8009827", "0X8009827", 0, 0, "", "", "", "", false);
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tkr
 * JD-Core Version:    0.7.0.1
 */