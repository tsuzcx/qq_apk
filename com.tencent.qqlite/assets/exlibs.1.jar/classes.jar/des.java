import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class des
  implements Runnable
{
  des(der paramder, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType != 3)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label242;
      }
      if (this.jdField_a_of_type_Der.a.c != null)
      {
        int j = this.jdField_a_of_type_Der.a.c.size();
        i = 0;
        if (i < j)
        {
          localObject = (EmoticonViewBinder)this.jdField_a_of_type_Der.a.c.get(i);
          if ((localObject == null) || (!(localObject instanceof BigEmoticonViewBinder))) {
            break label235;
          }
          localObject = (BigEmoticonViewBinder)localObject;
          if ((((BigEmoticonViewBinder)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (!((BigEmoticonViewBinder)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
            break label235;
          }
          ((BigEmoticonViewBinder)localObject).a(100);
          if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.isRecommendation) {
            ReportController.b(this.jdField_a_of_type_Der.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_endoffer_download", 0, 0, "", "", "", "");
          }
        }
      }
      this.jdField_a_of_type_Der.a.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Der.a.b = false;
      if ((this.jdField_a_of_type_Der.a.getVisibility() == 0) && (EmoticonMainPanel.g == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "Emoticon pkg downloaded in panel, refresh");
        }
        this.jdField_a_of_type_Der.a.a(2, 0);
      }
    }
    label235:
    label242:
    do
    {
      return;
      i += 1;
      break;
      if ((EmoticonMainPanel.g == 2) && (this.jdField_a_of_type_Der.a.c != null) && (EmoticonMainPanel.i < this.jdField_a_of_type_Der.a.c.size()))
      {
        localObject = (EmoticonViewBinder)this.jdField_a_of_type_Der.a.c.get(EmoticonMainPanel.i);
        if ((localObject != null) && ((localObject instanceof BigEmoticonViewBinder)))
        {
          localObject = (BigEmoticonViewBinder)localObject;
          if ((((BigEmoticonViewBinder)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) && (((BigEmoticonViewBinder)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
            ((BigEmoticonViewBinder)localObject).b();
          }
        }
      }
      if (this.jdField_a_of_type_Int == 11000)
      {
        QQToast.a(this.jdField_a_of_type_Der.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Der.a.jdField_a_of_type_AndroidContentContext.getString(2131364107), 1).b(this.jdField_a_of_type_Der.a.j);
        return;
      }
    } while (this.jdField_a_of_type_Int != 11001);
    QQToast.a(this.jdField_a_of_type_Der.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Der.a.jdField_a_of_type_AndroidContentContext.getString(2131364106), 1).b(this.jdField_a_of_type_Der.a.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     des
 * JD-Core Version:    0.7.0.1
 */