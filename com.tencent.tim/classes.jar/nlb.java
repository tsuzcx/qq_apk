import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout.a;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class nlb
  implements SwipePostTableLayout.a
{
  public nlb(FastWebActivity paramFastWebActivity) {}
  
  public void On()
  {
    FastWebActivity.b(this.this$0, true);
    QLog.d(FastWebActivity.a(this.this$0), 1, "onPageSwipeClose");
  }
  
  public void Oo()
  {
    if (FastWebActivity.a(this.this$0) == 0L)
    {
      FastWebActivity.a(this.this$0, NetConnInfoCenter.getServerTime());
      QLog.d(FastWebActivity.a(this.this$0), 1, "onPageSwipeNotClose time :" + FastWebActivity.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nlb
 * JD-Core Version:    0.7.0.1
 */