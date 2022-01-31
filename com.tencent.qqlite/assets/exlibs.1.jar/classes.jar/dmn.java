import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class dmn
  implements Runnable
{
  public dmn(QfileRecentMediaFileTabView paramQfileRecentMediaFileTabView) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      String str = QfileRecentMediaFileTabView.a(this.a, localFileManagerEntity.fileName);
      if (str != null)
      {
        if (!this.a.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
          this.a.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, new ArrayList());
        }
        ((List)this.a.jdField_a_of_type_JavaUtilLinkedHashMap.get(str)).add(localFileManagerEntity);
      }
    }
    this.a.i();
    this.a.setSelect(0);
    this.a.a(true);
    this.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmn
 * JD-Core Version:    0.7.0.1
 */