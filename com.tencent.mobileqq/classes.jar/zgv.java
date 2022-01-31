import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class zgv
  implements Runnable
{
  public zgv(PublicAccountHandler paramPublicAccountHandler) {}
  
  public void run()
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)this.a.b.getManager(87);
    if (localEcShopAssistantManager != null) {
      localEcShopAssistantManager.a(null, "FollowList");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zgv
 * JD-Core Version:    0.7.0.1
 */