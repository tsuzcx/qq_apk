import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

class dlm
  implements Runnable
{
  dlm(dll paramdll) {}
  
  public void run()
  {
    if (this.a.a.b != null)
    {
      Iterator localIterator = this.a.a.b.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (((List)this.a.a.b.get(str)).size() == 0) {
          localIterator.remove();
        }
      }
    }
    this.a.a.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(this.a.a.b);
    this.a.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.c(0);
    this.a.a.i();
    this.a.a.setSelect(0);
    this.a.a.b.clear();
    this.a.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dlm
 * JD-Core Version:    0.7.0.1
 */