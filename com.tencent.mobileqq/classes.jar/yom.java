import com.tencent.mobileqq.apollo.ai.ApolloAIPresenter;
import com.tencent.mobileqq.apollo.ai.IApolloAIView;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;

public class yom
  extends VasExtensionObserver
{
  public yom(ApolloAIPresenter paramApolloAIPresenter) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) && (ApolloAIPresenter.a(this.a) != null))
    {
      ApolloAIPresenter.a(this.a).i();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloAIPresenter", 2, "send msg to ai fail");
      }
    }
  }
  
  protected void h(boolean paramBoolean, Object paramObject)
  {
    if (ApolloAIPresenter.a(this.a) != null) {
      ApolloAIPresenter.a(this.a).b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yom
 * JD-Core Version:    0.7.0.1
 */