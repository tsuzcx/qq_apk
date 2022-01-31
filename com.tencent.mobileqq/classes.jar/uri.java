import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

public class uri
  implements ArkViewImplement.LoadCallback
{
  public uri(ArkAppItemBubbleBuilder paramArkAppItemBubbleBuilder, ArkAppItemBubbleBuilder.Holder paramHolder, MessageForArkApp paramMessageForArkApp) {}
  
  @TargetApi(14)
  public void onLoadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "attachArkView onLoadFinish MessageForArkApp state=" + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder$Holder.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uri
 * JD-Core Version:    0.7.0.1
 */