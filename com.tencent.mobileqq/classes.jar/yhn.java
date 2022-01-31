import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class yhn
  implements Runnable
{
  public yhn(ApolloPanelManager paramApolloPanelManager) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i = this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((ApolloPanelManager)localObject).a(i, bool, ApolloPanelManager.a(this.a));
      if ((this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0) && (!ApolloPanelManager.a(this.a)) && (this.a.a() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null))
      {
        localObject = SpriteUtil.a(this.a.a()).a();
        if (localObject != null) {
          ((SpriteActionMessage)localObject).a(this.a.b);
        }
      }
      if (((ApolloPanelManager.a(this.a)) || (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0)) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo != null)) {
        ApolloPanelManager.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhn
 * JD-Core Version:    0.7.0.1
 */