import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class fok
  implements Runnable
{
  fok(foj paramfoj, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    int i;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType != 3)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label244;
      }
      if (EmoticonMainPanel.b(this.jdField_a_of_type_Foj.a) != null)
      {
        int j = EmoticonMainPanel.b(this.jdField_a_of_type_Foj.a).size();
        i = 0;
        if (i < j)
        {
          localObject = (EmoticonViewBinder)EmoticonMainPanel.b(this.jdField_a_of_type_Foj.a).get(i);
          if ((localObject == null) || (!(localObject instanceof BigEmoticonViewBinder))) {
            break label237;
          }
          localObject = (BigEmoticonViewBinder)localObject;
          if ((((BigEmoticonViewBinder)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (!((BigEmoticonViewBinder)localObject).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
            break label237;
          }
          ((BigEmoticonViewBinder)localObject).a(100);
          if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.isRecommendation) {
            ReportController.b(EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a), "CliOper", "", "", "ep_mall", "Ep_endoffer_download", 0, 0, "", "", "", "");
          }
        }
      }
      EmoticonMainPanel.b(this.jdField_a_of_type_Foj.a, true);
      EmoticonMainPanel.c(this.jdField_a_of_type_Foj.a, false);
      if ((this.jdField_a_of_type_Foj.a.getVisibility() == 0) && (EmoticonMainPanel.b() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "Emoticon pkg downloaded in panel, refresh");
        }
        EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a, 1, 0);
      }
    }
    label237:
    label244:
    do
    {
      return;
      i += 1;
      break;
      if ((EmoticonMainPanel.b() == 2) && (EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a) != null) && (EmoticonMainPanel.c() < EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a).size()))
      {
        localObject = (EmoticonViewBinder)EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a).get(EmoticonMainPanel.c());
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
        QQToast.a(EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a), EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a).getString(2131562498), 1).b(this.jdField_a_of_type_Foj.a.c);
        return;
      }
    } while (this.jdField_a_of_type_Int != 11001);
    QQToast.a(EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a), EmoticonMainPanel.a(this.jdField_a_of_type_Foj.a).getString(2131562822), 1).b(this.jdField_a_of_type_Foj.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fok
 * JD-Core Version:    0.7.0.1
 */