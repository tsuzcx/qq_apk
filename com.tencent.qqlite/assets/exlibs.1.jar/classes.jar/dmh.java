import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class dmh
  implements Runnable
{
  public dmh(QfileLocalFilePicTabView paramQfileLocalFilePicTabView, Context paramContext) {}
  
  public void run()
  {
    HashMap localHashMap = (HashMap)FileCategoryUtil.a(this.jdField_a_of_type_AndroidContentContext);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      FileCategoryUtil.a(AppConstants.ay, ".jpg|.bmp|.jpeg|.gif|.png|.ico|", "", localHashMap, null);
      FileCategoryUtil.a(localHashMap);
      if (localHashMap != null)
      {
        Iterator localIterator = localHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if (((String)localObject).equalsIgnoreCase("QQfile_recv") != true)
          {
            localObject = (List)localHashMap.get(localObject);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView.a.addAll((Collection)localObject);
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmh
 * JD-Core Version:    0.7.0.1
 */