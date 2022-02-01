import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

class jir
  extends ClickableSpan
{
  jir(jim paramjim, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    QLog.w(this.this$0.TAG, 1, "closeUI showNoNameDialog, realName[" + this.ZA + "]");
    this.this$0.cH(this.Su);
    paramView = this.this$0.getAVActivity();
    if (paramView == null) {
      return;
    }
    paramView.finish();
    if (this.ZA)
    {
      jhy.d(this.this$0.mApp, this.Sv);
      return;
    }
    paramView = wja.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    paramView.putExtra("uin", this.this$0.mApp.b().b().peerUin);
    paramView.putExtra("uintype", 0);
    paramView.putExtra("uinname", this.this$0.mApp.b().b().MO);
    paramView.putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jir
 * JD-Core Version:    0.7.0.1
 */