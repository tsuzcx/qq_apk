import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.qphone.base.util.QLog;

public class ajzf
  implements View.OnLayoutChangeListener
{
  public ajzf(StuffContainerView paramStuffContainerView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    long l1 = System.currentTimeMillis();
    long l2 = StuffContainerView.a(this.c);
    if ((StuffContainerView.a(this.c) > 0L) && (l1 - l2 < 500L)) {}
    do
    {
      return;
      StuffContainerView.a(this.c, l1);
      if (QLog.isColorLevel()) {
        QLog.d("StuffContainerView", 2, "VideoInfoListenerImpl onLayoutChange");
      }
    } while (this.c.a == null);
    this.c.a.dzM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzf
 * JD-Core Version:    0.7.0.1
 */