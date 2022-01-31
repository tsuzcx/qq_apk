import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;

public class ymw
  implements Runnable
{
  public ymw(ApolloTextureView paramApolloTextureView) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.a.getRender();
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null))
    {
      double d = 0.0D;
      if (localApolloRender.mIsFrameMode) {
        d = localApolloRender.mDuration;
      }
      localApolloRender.getSavaWrapper().a(d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ymw
 * JD-Core Version:    0.7.0.1
 */