import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.3.1;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Timer;

public class agcp
  implements View.OnClickListener
{
  public agcp(MPFileVerifyPwdView paramMPFileVerifyPwdView) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext())) {
      ahao.JD(BaseApplicationImpl.getContext().getString(2131696270));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ahao.JD(BaseApplicationImpl.getContext().getString(2131696012));
      acde localacde = (acde)MPFileVerifyPwdView.a(this.this$0).getBusinessHandler(8);
      MPFileVerifyPwdView.a(this.this$0, localacde.a().f(3));
      MPFileVerifyPwdView.b(this.this$0).setEnabled(false);
      MPFileVerifyPwdView.b(this.this$0).setTextColor(-7829368);
      MPFileVerifyPwdView.a(this.this$0).schedule(new MPFileVerifyPwdView.3.1(this), 15000L);
      if (MPFileVerifyPwdView.a(this.this$0) != null) {
        MPFileVerifyPwdView.a(this.this$0).m(MPFileVerifyPwdView.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agcp
 * JD-Core Version:    0.7.0.1
 */