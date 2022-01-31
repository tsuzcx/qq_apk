import android.os.Process;
import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EPJsonTask;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.qphone.base.util.QLog;

public class fbw
  implements Runnable
{
  public fbw(EmoticonManagerImp paramEmoticonManagerImp, String paramString, int paramInt) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.b(this.jdField_a_of_type_JavaLangString);
    if (localEmoticonPackage == null) {
      return;
    }
    localEmoticonPackage.jsonVersion = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp.a(localEmoticonPackage);
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManagerImp", 2, this.jdField_a_of_type_Int + "==========KeywordJsonupdate============" + this.jdField_a_of_type_JavaLangString);
    }
    EmoticonController.a(EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp)).a(localEmoticonPackage.epId, EPJsonTask.b, false);
    EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp, this.jdField_a_of_type_JavaLangString);
    EmoticonManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonManagerImp, true, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fbw
 * JD-Core Version:    0.7.0.1
 */