import com.tencent.mobileqq.activity.richmedia.PtvTemplateAdapter;
import com.tencent.mobileqq.activity.richmedia.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

class xpu
  implements Runnable
{
  xpu(xps paramxps, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Xps.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Xps.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLastVisiblePosition();
    int i = j;
    Object localObject;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Xps.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateManager", 2, "onProgressUpdate index: " + i + " progress: " + this.jdField_a_of_type_Int);
      }
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
      localObject = this.jdField_a_of_type_Xps.a.jdField_a_of_type_ComTencentWidgetHorizontalListView.getChildAt(i - j);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.jdField_a_of_type_Int != 100) {
          break label189;
        }
      }
    }
    label189:
    for (i = 99;; i = this.jdField_a_of_type_Int)
    {
      ((PtvTemplateItemView)localObject).b(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpu
 * JD-Core Version:    0.7.0.1
 */