import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import java.io.File;

class bdq
  implements Runnable
{
  bdq(bdo parambdo) {}
  
  public void run()
  {
    this.a.a.r = null;
    this.a.a.p = true;
    this.a.a.a.a(this.a.a.getString(2131362615));
    if (new File(QQMapConstants.i).exists()) {
      UniformDownloadUtil.a(QQMapConstants.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdq
 * JD-Core Version:    0.7.0.1
 */