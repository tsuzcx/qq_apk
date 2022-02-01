import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.activity.MediaPreviewInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class apva
  implements View.OnClickListener
{
  apva(apuz paramapuz, apuz.a parama, MediaPreviewInfo paramMediaPreviewInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Apuz$a.EM.setVisibility(8);
    this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityMediaPreviewInfo, this.jdField_a_of_type_Apuz$a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apva
 * JD-Core Version:    0.7.0.1
 */