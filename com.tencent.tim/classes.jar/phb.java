import android.os.Handler;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView;
import com.tencent.biz.qqcircle.widgets.QCircleRockeyPopupView.1.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.QQAnimationDrawable.b;
import com.tencent.qphone.base.util.QLog;

public class phb
  implements QQAnimationDrawable.b
{
  public phb(QCircleRockeyPopupView paramQCircleRockeyPopupView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onStart() {}
  
  public void onStop()
  {
    QLog.i("QQAnimationDrawable", 2, "dismiss count" + this.val$count);
  }
  
  public void vz(int paramInt)
  {
    if (paramInt == this.biN)
    {
      QLog.i("QCircleRecommend_", 1, "onPlay" + paramInt + " showRecommendCountAnimation");
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRockeyPopupView.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phb
 * JD-Core Version:    0.7.0.1
 */