import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.widget.AbsListView.RecyclerListener;

public class efx
  implements AbsListView.RecyclerListener
{
  public efx(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = AIOUtils.a(paramView);
        } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject));
        localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;
      } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject)) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)));
      localObject = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)));
    Object localObject = ((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).getLayoutStr();
    StructingMsgItemBuilder.a().a((String)localObject, (ViewGroup)paramView.findViewById(2131230779));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     efx
 * JD-Core Version:    0.7.0.1
 */