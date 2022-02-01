import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

final class atxt
  implements View.OnClickListener
{
  atxt(auhk.e parame, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Auhk$e != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_b_of_type_Auhk$e.nT(localArrayList);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxt
 * JD-Core Version:    0.7.0.1
 */