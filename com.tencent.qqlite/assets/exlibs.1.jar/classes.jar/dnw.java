import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentMediaFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class dnw
  implements Runnable
{
  public dnw(QfileRecentMediaFileTabView paramQfileRecentMediaFileTabView, String paramString, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentMediaFileTabView.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentMediaFileTabView.a.put(this.jdField_a_of_type_JavaLangString, new ArrayList());
    }
    List localList = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentMediaFileTabView.a.get(this.jdField_a_of_type_JavaLangString);
    if (localList.contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) == true) {
      return;
    }
    localList.add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentMediaFileTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dnw
 * JD-Core Version:    0.7.0.1
 */