import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.widget.AbsListView.RecyclerListener;

public class bya
  implements AbsListView.RecyclerListener
{
  public bya(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    Object localObject;
    StructingMsgItemBuilder.ViewCache localViewCache;
    do
    {
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
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) || (!(this.a.a instanceof ChatActivity)));
      localViewCache = ((ChatActivity)this.a.a).a().a();
    } while (localViewCache == null);
    localViewCache.a(((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).getLayoutStr(), (ViewGroup)paramView.findViewById(2131296305));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bya
 * JD-Core Version:    0.7.0.1
 */