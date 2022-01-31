import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileDocTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class dkv
  implements Runnable
{
  public dkv(QfileLocalFileDocTabView paramQfileLocalFileDocTabView, FileInfo paramFileInfo) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.e());
    if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject, new ArrayList());
    }
    localObject = (List)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
    if (((List)localObject).contains(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo) == true) {}
    do
    {
      return;
      ((List)localObject).add(0, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.i();
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.jdField_a_of_type_JavaUtilArrayList.size() != 1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFileDocTabView.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dkv
 * JD-Core Version:    0.7.0.1
 */