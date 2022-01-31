import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.HashMap;

public class dkn
  implements Runnable
{
  public dkn(QfileLocalFileDocTabView paramQfileLocalFileDocTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    FileCategoryUtil.a(AppConstants.ay, ".doc|.docx|.wps|.pages|.ppt|.pptx.|.dps|.keynote|.xls|.xlsx|.et|.numbers|.pdf|", "", localHashMap, this.a);
    FileCategoryUtil.a(localHashMap);
    QfileLocalFileDocTabView.a(this.a, new dko(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkn
 * JD-Core Version:    0.7.0.1
 */