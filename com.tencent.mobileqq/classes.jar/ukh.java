import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;

public class ukh
  implements TroopManager.ITroopMemberInfoCallBack
{
  public int a;
  public BaseChatItemLayout a;
  public TroopInfo a;
  public boolean a;
  
  private ukh(BaseBubbleBuilder paramBaseBubbleBuilder) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Object localObject1 = (BaseBubbleBuilder.ViewHolder)this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
    TroopRankConfig.TroopRankItem localTroopRankItem;
    Object localObject2;
    int i;
    int j;
    label81:
    boolean bool1;
    if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.ViewHolder)localObject1).a.senderuin, paramTroopMemberInfo.memberuin)))
    {
      localTroopRankItem = null;
      localObject2 = null;
      localObject1 = null;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop())) {
        break label225;
      }
      i = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop())) {
        break label230;
      }
      j = 1;
      if (i == 0) {
        break label241;
      }
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.Administrator.contains(paramTroopMemberInfo.memberuin))) {
        break label235;
      }
      bool1 = true;
      label128:
      localTroopRankItem = TroopRankConfig.a().a(bool2, bool1);
      if (localTroopRankItem == null) {
        break label367;
      }
      paramTroopMemberInfo = localTroopRankItem.a;
      i = localTroopRankItem.b;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramTroopMemberInfo))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a, true, paramTroopMemberInfo, false, i, this.jdField_a_of_type_Int);
        BaseBubbleBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setTag(Integer.valueOf(2131361867));
      }
      return;
      label225:
      i = 0;
      break;
      label230:
      j = 0;
      break label81;
      label235:
      bool1 = false;
      break label128;
      label241:
      if (j != 0)
      {
        localObject1 = TroopRankConfig.a().a(paramTroopMemberInfo.level, false, false, false);
        if ((localObject1 == null) || (!HWTroopUtils.a(paramTroopMemberInfo))) {
          break label359;
        }
        paramTroopMemberInfo = ((TroopRankConfig.TroopRankItem)localObject1).a;
        i = ((TroopRankConfig.TroopRankItem)localObject1).b;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Boolean) {
          i = TroopRankConfig.a().jdField_a_of_type_Int;
        }
        break;
        localObject1 = TroopRankConfig.a().a(paramTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
        if (localObject1 != null)
        {
          paramTroopMemberInfo = ((TroopRankConfig.TroopRankItem)localObject1).a;
          i = ((TroopRankConfig.TroopRankItem)localObject1).b;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            i = TroopRankConfig.a().jdField_a_of_type_Int;
            break;
          }
          break;
          i = 0;
          paramTroopMemberInfo = localObject2;
        }
        label359:
        i = 0;
        paramTroopMemberInfo = localTroopRankItem;
      }
      label367:
      i = 0;
      paramTroopMemberInfo = (TroopMemberInfo)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ukh
 * JD-Core Version:    0.7.0.1
 */