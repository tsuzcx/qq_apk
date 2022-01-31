import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.List;

public class bzb
  extends EnterpriseQQObserver
{
  public bzb(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.b = EnterpriseQQManager.a(BusinessCmrTmpChatPie.e(this.a)).a(BusinessCmrTmpChatPie.d(this.a), this.a.a());
      if ((1024 == BusinessCmrTmpChatPie.h(this.a).jdField_a_of_type_Int) && (!CrmUtils.a(BusinessCmrTmpChatPie.f(this.a), BusinessCmrTmpChatPie.i(this.a).jdField_a_of_type_JavaLangString))) {
        this.a.b = null;
      }
      BusinessCmrTmpChatPie.a(this.a, this.a.b);
      if ((this.a.b != null) && (!this.a.b.isEmpty())) {
        BusinessCmrTmpChatPie.a(this.a, false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bzb
 * JD-Core Version:    0.7.0.1
 */