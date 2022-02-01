import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ixg
  implements View.OnClickListener
{
  public ixg(AVActivity paramAVActivity, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    iwu.a(this.this$0.mApp, 1044);
    this.this$0.G(2, false);
    ijw.iP(this.this$0.a.getChatRoomId(this.this$0.a.b().peerUin) + "");
    if (AudioHelper.aCz()) {
      QLog.w(this.this$0.TAG, 1, "qav_double_screen_notify, click[" + this.val$id + "], seq[" + this.kQ + "]");
    }
    if (!TextUtils.isEmpty(this.val$id)) {
      new iya.e(this.kQ, this.val$id, false, 4).n(this.this$0.mApp);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixg
 * JD-Core Version:    0.7.0.1
 */