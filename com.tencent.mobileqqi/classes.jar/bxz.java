import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;

public class bxz
  extends BizTroopObserver
{
  public bxz(ChatActivity paramChatActivity) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo != null) && (this.a.a.jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString))) {
      ChatActivity.a(this.a, paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo, true);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (ChatActivity.a(this.a) != null) {
      ChatActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    long l = ((Long)paramObject).longValue();
    if ((this.a.a.jdField_a_of_type_Int == 1) && (this.a.a.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
      ChatActivity.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bxz
 * JD-Core Version:    0.7.0.1
 */