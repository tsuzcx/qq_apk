import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
import java.lang.ref.WeakReference;

public class yxa
  implements Runnable
{
  public yxa(ApolloDrawerInfoViewListener paramApolloDrawerInfoViewListener) {}
  
  public void run()
  {
    if (ApolloDrawerInfoViewListener.a(this.a).get() != null) {
      ((SpriteDrawerInfoManager)ApolloDrawerInfoViewListener.a(this.a).get()).a(ApolloDrawerInfoViewListener.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yxa
 * JD-Core Version:    0.7.0.1
 */