import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class atxs
  implements View.OnClickListener
{
  atxs(auhk.e parame, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Auhk$e != null) {
      this.jdField_b_of_type_Auhk$e.bG(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxs
 * JD-Core Version:    0.7.0.1
 */