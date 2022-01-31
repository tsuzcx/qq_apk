import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class cby
  implements Runnable
{
  public cby(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void run()
  {
    if (!TroopAssistantManager.a().e(TroopAssistTipsBar.a(this.a))) {
      if (QLog.isColorLevel()) {
        QLog.d(TroopAssistTipsBar.a(), 2, "getTroopAssistTipInRange false, return ");
      }
    }
    for (;;)
    {
      return;
      if (TroopAssistTipsBar.a(this.a).getIntent() != null)
      {
        FriendManager localFriendManager = (FriendManager)TroopAssistTipsBar.a(this.a).getManager(8);
        int i = TroopAssistTipsBar.a(this.a).a().a(TroopAssistTipsBar.a(this.a).jdField_a_of_type_JavaLangString, TroopAssistTipsBar.a(this.a).jdField_a_of_type_Int);
        if ((i > 99) && (!TroopAssistantManager.a().b(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).jdField_a_of_type_JavaLangString)) && (TroopAssistTipsBar.a(this.a).b(TroopAssistTipsBar.a(this.a).jdField_a_of_type_JavaLangString) == 1) && (!localFriendManager.f(TroopAssistTipsBar.a(this.a).jdField_a_of_type_JavaLangString))) {
          if (i <= 200) {}
        }
        for (i = 1; (i != 0) && (TroopAssistTipsBar.a(this.a).a(this.a, new Object[0])); i = 0)
        {
          TroopAssistantManager.a().i(TroopAssistTipsBar.a(this.a));
          ReportController.b(TroopAssistTipsBar.a(this.a), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
          return;
          TroopAssistTipsBar.a(this.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cby
 * JD-Core Version:    0.7.0.1
 */