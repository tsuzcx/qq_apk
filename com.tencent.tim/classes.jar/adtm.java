import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adtm
  implements View.OnClickListener
{
  adtm(adta.a parama, int paramInt, ArkViewImplement.ArkViewInterface paramArkViewInterface) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (this.val$menuType == 2) {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(5);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(4);
      }
      else if (i == 2)
      {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(3);
        continue;
        if (this.val$menuType == 1)
        {
          if (i == 0) {
            this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(1);
          } else if (i == 1) {
            this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(2);
          } else if (i == 2) {
            this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(3);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adtm
 * JD-Core Version:    0.7.0.1
 */