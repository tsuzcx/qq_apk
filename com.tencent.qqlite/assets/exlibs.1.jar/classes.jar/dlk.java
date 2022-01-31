import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class dlk
  implements Runnable
{
  public dlk(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB thread start");
    }
    List localList = QfileBaseRecentFileTabView.a(this.a).a().a();
    if (localList != null) {
      this.a.jdField_a_of_type_JavaUtilList.addAll(localList);
    }
    if (QLog.isColorLevel()) {
      QLog.i(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "queryFileEntitiesFromDB end size[" + this.a.jdField_a_of_type_JavaUtilList.size() + "]");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dlk
 * JD-Core Version:    0.7.0.1
 */