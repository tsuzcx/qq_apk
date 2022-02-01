import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.lang.ref.WeakReference;

public class adpr
  implements adpq.c
{
  public adpr(ArkAiDictUpdateMgr.1 param1, aeje.m paramm, adpq.e parame, aeje.a parama) {}
  
  public void GG(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.r("ArkApp.Dict.Update", String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { adpq.b(this.jdField_a_of_type_Aeje$m) }));
      this.jdField_a_of_type_Adpq$e.success = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Adpq$e)
      {
        adpq.e locale2 = this.jdField_a_of_type_Adpq$e;
        int i = locale2.taskCount - 1;
        locale2.taskCount = i;
        if (i != 0) {
          return;
        }
        if (this.jdField_a_of_type_Adpq$e.success)
        {
          ArkAppCenter.r("ArkApp.Dict.Update", "updateWordDict, all success");
          adpq.c(this.jdField_a_of_type_Aeje$a);
          adpq.d(this.jdField_a_of_type_Aeje$a);
          adpo.o((AppInterface)adpq.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0).get());
          try
          {
            adpq.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
            if (adpq.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0))
            {
              adpq.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
              ArkAppCenter.r("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
              ArkAppCenter.a().postToMainThreadDelayed(new ArkAiDictUpdateMgr.1.1.1(this), 5000L);
            }
            return;
          }
          finally {}
        }
      }
      ArkAppCenter.r("ArkApp.Dict.Update", "updateWordDict, one or more tasks failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpr
 * JD-Core Version:    0.7.0.1
 */