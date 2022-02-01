import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class mjo
  implements oud
{
  public mjo(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void a(URL paramURL, int paramInt) {}
  
  public void a(URL paramURL, Throwable paramThrowable) {}
  
  public void a(URL paramURL, nov paramnov)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment cover download success");
    }
    ReadInJoyDeliverVideoActivity.c(this.this$0, ShortVideoPreviewActivity.f(paramnov.Q()));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverVideoActivity", 2, "king moment local cover is " + ReadInJoyDeliverVideoActivity.a(this.this$0));
    }
    this.this$0.setRightViewTextDisable(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mjo
 * JD-Core Version:    0.7.0.1
 */