import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter.IPtvTemplateItemCallback;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class xpr
  implements PtvTemplateAdapter.IPtvTemplateItemCallback
{
  public xpr(PtvTemplateAdapter paramPtvTemplateAdapter) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PtvTemplateManager", 2, "PtvTemplateAdapter onItemClicked position: " + paramInt);
    }
    if ((paramInt < 0) || (paramInt >= this.a.jdField_a_of_type_JavaUtilArrayList.size())) {}
    PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo;
    do
    {
      do
      {
        return;
        localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      } while (localPtvTemplateInfo == null);
      this.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.b(paramInt, (int)(-this.a.jdField_a_of_type_Int * (0.75F + this.a.c - 1.0F)), 400);
    } while (localPtvTemplateInfo.usable);
    FlowCameraMqqAction.b("", "0X8006A1A");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpr
 * JD-Core Version:    0.7.0.1
 */