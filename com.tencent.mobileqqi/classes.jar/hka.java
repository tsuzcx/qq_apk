import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.open.appcenter.QZoneAppCenterActivity;
import com.tencent.open.base.LogUtility;

public class hka
  implements View.OnLongClickListener
{
  public hka(QZoneAppCenterActivity paramQZoneAppCenterActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    LogUtility.c(QZoneAppCenterActivity.c, "webView onLongClick");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hka
 * JD-Core Version:    0.7.0.1
 */