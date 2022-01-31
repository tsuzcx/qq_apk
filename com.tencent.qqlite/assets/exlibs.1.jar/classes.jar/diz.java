import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class diz
  implements Runnable
{
  public diz(QfileCloudFileTabView paramQfileCloudFileTabView, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void run()
  {
    Object localObject = QfileTimeUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.b);
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.a.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo) == true) {
      return;
    }
    ((List)localObject).add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityCloudfileQfileCloudFileTabView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     diz
 * JD-Core Version:    0.7.0.1
 */