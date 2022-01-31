import android.content.Context;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dkw
  implements Runnable
{
  public dkw(QfileLocalFileMediaTabView paramQfileLocalFileMediaTabView, Context paramContext) {}
  
  public void run()
  {
    Map localMap = FileCategoryUtil.c(this.jdField_a_of_type_AndroidContentContext);
    Iterator localIterator;
    Object localObject;
    if (localMap != null)
    {
      localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (((String)localObject).equalsIgnoreCase("QQfile_recv") != true)
        {
          localObject = (List)localMap.get(localObject);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.addAll((Collection)localObject);
        }
      }
    }
    localMap = FileCategoryUtil.b(this.jdField_a_of_type_AndroidContentContext);
    if (localMap != null)
    {
      localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (((String)localObject).equalsIgnoreCase("QQfile_recv") != true)
        {
          localObject = (List)localMap.get(localObject);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileMediaTabView.a.addAll((Collection)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkw
 * JD-Core Version:    0.7.0.1
 */