import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import java.util.List;

public class voa
  extends EnterpriseQQObserver
{
  public voa(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.b = EnterpriseQQManager.a(this.a.a).a(this.a.a, this.a.a());
      this.a.b(this.a.b);
      if ((this.a.b != null) && (!this.a.b.isEmpty())) {
        this.a.o(false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     voa
 * JD-Core Version:    0.7.0.1
 */