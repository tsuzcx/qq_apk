import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EnterpriseQQObserver;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;

public class cbd
  extends EnterpriseQQObserver
{
  public cbd(ChatForEnterpriseActivity paramChatForEnterpriseActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = EnterpriseQQManager.a(this.a.b).a(this.a.b, this.a.c());
      if (!CrmUtils.a(this.a.b, this.a.a.a)) {
        paramObject = null;
      }
      ChatForEnterpriseActivity.a(this.a, paramObject);
      if (paramObject != null) {
        ChatForEnterpriseActivity.a(this.a, false);
      }
    }
  }
  
  protected void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cbd
 * JD-Core Version:    0.7.0.1
 */