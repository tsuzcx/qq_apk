import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class dmo
  implements Runnable
{
  public dmo(QfileRecentDocFileTabView paramQfileRecentDocFileTabView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("WORD", new ArrayList());
    localLinkedHashMap.put("PPT", new ArrayList());
    localLinkedHashMap.put("PDF", new ArrayList());
    localLinkedHashMap.put("EXCEL", new ArrayList());
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      String str = QfileRecentDocFileTabView.a(this.a, localFileManagerEntity.fileName);
      if (str != null) {
        ((List)localLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    localIterator = localLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (((List)localLinkedHashMap.get((String)localIterator.next())).size() == 0) {
        localIterator.remove();
      }
    }
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
    this.a.i();
    this.a.setSelect(0);
    this.a.a(true);
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmo
 * JD-Core Version:    0.7.0.1
 */