import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.HashMap;

public class dkd
  implements Runnable
{
  public dkd(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    FileCategoryUtil.a(this.a.a, this.a);
    HashMap localHashMap = new HashMap();
    FileCategoryUtil.a(AppConstants.ay, ".apk", "", localHashMap, this.a);
    FileCategoryUtil.a(localHashMap);
    QfileLocalFileAppTabView.a(this.a, new dke(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkd
 * JD-Core Version:    0.7.0.1
 */