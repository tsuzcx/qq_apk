import android.support.v7.widget.StaggeredGridLayoutManager.ExceptionListener;
import android.view.View;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.qphone.base.util.QLog;

public class ahzf
  implements StaggeredGridLayoutManager.ExceptionListener
{
  public ahzf(HotPicPageView paramHotPicPageView) {}
  
  public void onGetPositionErr(View paramView, boolean paramBoolean, int paramInt, Exception paramException)
  {
    QLog.e("HotPicManagerHotPicPageView", 1, "onGetPositionErr 1  final p:" + paramInt + " rescue:" + paramBoolean + " v:" + paramView + " error: " + paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzf
 * JD-Core Version:    0.7.0.1
 */