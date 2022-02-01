import android.text.TextUtils;
import com.tencent.mobileqq.activity.RewardNoticeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class vsj
  extends acbw
{
  public vsj(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void B(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.aPF)) {
        QQToast.a(this.a.app.getApp(), 2, this.a.aPF, 0).show();
      }
      if (this.a.mType == 13) {
        this.a.bVg();
      }
      this.a.finish();
      return;
    }
    QQToast.a(this.a.app.getApp(), 1, acfp.m(2131713933), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vsj
 * JD-Core Version:    0.7.0.1
 */