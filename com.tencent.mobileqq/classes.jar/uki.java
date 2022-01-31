import android.content.res.ColorStateList;
import android.text.TextUtils;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopMemberInfo;

public class uki
  implements TroopManager.ITroopMemberInfoCallBack
{
  public int a;
  public ColorStateList a;
  public BaseBubbleBuilder.ViewHolder a;
  public BaseChatItemLayout a;
  public ChatMessage a;
  public CharSequence a;
  public String a;
  public boolean a;
  public ColorStateList b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  private uki(BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, paramTroopMemberInfo.memberuin)))
    {
      if ((((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin)) || (TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue()))
      {
        this.jdField_a_of_type_JavaLangCharSequence = TroopMemberLbsHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_AndroidContentContext);
        if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label316;
        }
        this.jdField_b_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(AnonymousChatHelper.d);
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
          break label336;
        }
        bool1 = true;
        label180:
        this.c = bool1;
      }
      paramTroopMemberInfo = ((TroopManager)localObject1).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      if ((paramTroopMemberInfo == null) && (!this.jdField_a_of_type_Boolean)) {
        break label341;
      }
    }
    label316:
    label336:
    label341:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentResColorStateList;
      if (((this.jdField_a_of_type_Boolean) && (AnonymousChatHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())) {
        bool2 = true;
      }
      ((BaseChatItemLayout)localObject1).a(bool1, paramTroopMemberInfo, (ColorStateList)localObject2, bool2, this.jdField_b_of_type_Boolean, this.d, this.c, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_AndroidContentResColorStateList, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int == 1) {
        BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder);
      }
      return;
      this.jdField_b_of_type_AndroidContentResColorStateList = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList;
      break;
      bool1 = false;
      break label180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uki
 * JD-Core Version:    0.7.0.1
 */