import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView;
import com.tencent.mobileqq.gamecenter.view.QQGameStatusView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahuq
  implements View.OnClickListener
{
  public ahuq(QQGameStatusView paramQQGameStatusView) {}
  
  public void onClick(View paramView)
  {
    if ((QQGameStatusView.a(this.b) == null) || (QQGameStatusView.a(this.b))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QQGameStatusView.a(this.b) == 1) {
        QQGameStatusView.a(this.b).KD(QQGameStatusView.a(this.b));
      } else if (QQGameStatusView.a(this.b) == 2) {
        QQGameStatusView.a(this.b).KC(QQGameStatusView.a(this.b));
      } else if (QQGameStatusView.a(this.b) == 3) {
        QQGameStatusView.a(this.b).KE(QQGameStatusView.a(this.b));
      } else if (QQGameStatusView.a(this.b) == 5) {
        QQGameStatusView.a(this.b).KF(QQGameStatusView.a(this.b));
      } else if (QQGameStatusView.a(this.b) == 6) {
        if (!TextUtils.isEmpty(QQGameStatusView.b(this.b))) {
          QQGameStatusView.a(this.b).gj(QQGameStatusView.a(this.b), QQGameStatusView.b(this.b));
        } else if (QLog.isColorLevel()) {
          QLog.d("QQGameStatusView", 1, "downloadFilePath is null,install faile");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuq
 * JD-Core Version:    0.7.0.1
 */