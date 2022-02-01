import android.view.View;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;

class mdr
  implements AbsListView.e
{
  int aQB = 0;
  View kU = null;
  View lastView = null;
  int lastY = 0;
  
  mdr(mdq parammdq, AbsListView paramAbsListView, ChatMessage paramChatMessage) {}
  
  private void aOK()
  {
    int i;
    int j;
    label84:
    PressEffectImageView localPressEffectImageView;
    if ((this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0) != null) && ("RIJRedPacketStruttingMsgItemBuilder".equals(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0).getTag(2131370590))))
    {
      i = 1;
      if ((this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1) == null) || (!"RIJRedPacketStruttingMsgItemBuilder".equals(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).getTag(2131370590)))) {
        break label260;
      }
      j = 1;
      if (((this.kU != null) && ((this.kU == this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0)) || (this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0) == null) || (this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0).getTop() >= this.aQB))) || (i == 0)) {
        break label265;
      }
      QLog.d("RIJRedPacketStruttingMsgItemBuilder", 1, "qqqqqqqqqqqqqqqqqqqqqqqqqqq 1");
      localPressEffectImageView = (PressEffectImageView)this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0).findViewById(2131376670);
      mdq.a(this.a, localPressEffectImageView);
      mdq.a(this.a, (MessageForStructing)this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
    }
    for (;;)
    {
      this.kU = this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(0);
      this.lastView = this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1);
      if (this.kU != null) {
        this.aQB = this.kU.getTop();
      }
      if (this.lastView != null) {
        this.lastY = this.lastView.getTop();
      }
      return;
      i = 0;
      break;
      label260:
      j = 0;
      break label84;
      label265:
      if (((this.lastView == null) || ((this.lastView != this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1)) && (this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1) != null) && (this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).getTop() > this.lastY))) && (j != 0))
      {
        QLog.d("RIJRedPacketStruttingMsgItemBuilder", 1, "qqqqqqqqqqqqqqqqqqqqqqqqqqq 2");
        localPressEffectImageView = (PressEffectImageView)this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_b_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).findViewById(2131376670);
        mdq.a(this.a, localPressEffectImageView);
        mdq.a(this.a, (MessageForStructing)this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    aOK();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdr
 * JD-Core Version:    0.7.0.1
 */