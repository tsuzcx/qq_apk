import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;

public class bdl
  implements PopupWindow.OnDismissListener
{
  public bdl(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss()
  {
    if (this.a.r != null)
    {
      OfflineDownloader.d(this.a.r);
      this.a.a.a(this.a.getString(2131362609));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdl
 * JD-Core Version:    0.7.0.1
 */