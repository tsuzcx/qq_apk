import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileCategoryBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class dkq
  extends AsyncTask
{
  public dkq(QfileLocalFileCategoryBrowserActivity paramQfileLocalFileCategoryBrowserActivity) {}
  
  protected List a(Void... paramVarArgs)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    switch (this.a.c)
    {
    case 0: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      return null;
    case 10: 
      paramVarArgs = FileCategoryUtil.a(this.a.getApplicationContext());
      localArrayList = new ArrayList();
      localIterator = paramVarArgs.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)paramVarArgs.get((String)localIterator.next()));
      }
      return localArrayList;
    case 1: 
      paramVarArgs = FileCategoryUtil.c(this.a.getApplicationContext());
      localArrayList = new ArrayList();
      localIterator = paramVarArgs.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)paramVarArgs.get((String)localIterator.next()));
      }
      return localArrayList;
    case 2: 
      paramVarArgs = FileCategoryUtil.b(this.a.getApplicationContext());
      localArrayList = new ArrayList();
      localIterator = paramVarArgs.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)paramVarArgs.get((String)localIterator.next()));
      }
      return localArrayList;
    case 4: 
      return FileCategoryUtil.a(this.a.getApplicationContext(), null);
    }
    return FileManagerUtil.a(false, 0);
  }
  
  protected void a(List paramList)
  {
    if (paramList == null)
    {
      QfileLocalFileCategoryBrowserActivity.a(this.a);
      QfileLocalFileCategoryBrowserActivity.b(this.a);
      FileManagerUtil.a(QfileLocalFileCategoryBrowserActivity.a(this.a));
      return;
    }
    this.a.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put("本地文件分组", this.a.jdField_a_of_type_JavaUtilArrayList);
    QfileLocalFileCategoryBrowserActivity.a(this.a);
    QfileLocalFileCategoryBrowserActivity.c(this.a);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    QfileLocalFileCategoryBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkq
 * JD-Core Version:    0.7.0.1
 */