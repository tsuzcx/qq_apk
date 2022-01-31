import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentAllFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class dmj
  implements Runnable
{
  public dmj(QfileRecentAllFileTabView paramQfileRecentAllFileTabView, FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    Object localObject = QfileTimeUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentAllFileTabView.a.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentAllFileTabView.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentAllFileTabView.a.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) == true) {
      return;
    }
    ((List)localObject).add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityRecentfileQfileRecentAllFileTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dmj
 * JD-Core Version:    0.7.0.1
 */