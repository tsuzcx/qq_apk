import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import java.util.ArrayList;
import java.util.Iterator;

public final class ulk
  implements FMDialogUtil.FMDialogInterface
{
  public ulk(ArrayList paramArrayList, Context paramContext, int paramInt, QQAppInterface paramQQAppInterface, String paramString1, String paramString2) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Uri)localIterator.next();
      localObject = ForwardFileBaseOption.a(this.jdField_a_of_type_AndroidContentContext, (Uri)localObject);
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.jdField_a_of_type_JavaLangString);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulk
 * JD-Core Version:    0.7.0.1
 */