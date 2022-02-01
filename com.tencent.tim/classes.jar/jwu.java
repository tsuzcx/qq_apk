import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class jwu
  implements View.OnClickListener
{
  public jwu(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "action cancel");
    }
    anot.c(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.this$0).a.UD, "0X80090FD", "0X80090FD", 0, 0, PublicAccountAdvertisementActivity.a(this.this$0).a.hT, "", "", PublicAccountAdvertisementActivity.a(this.this$0).a.mNickName);
    if ((PublicAccountAdvertisementActivity.a(this.this$0) != null) && (PublicAccountAdvertisementActivity.a(this.this$0).isShowing())) {
      PublicAccountAdvertisementActivity.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwu
 * JD-Core Version:    0.7.0.1
 */