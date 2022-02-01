import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender.15.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public final class abhz
  implements HandshakeCompletedListener
{
  public abhz(View paramView, long paramLong) {}
  
  public void handshakeCompleted(HandshakeCompletedEvent paramHandshakeCompletedEvent)
  {
    ((ApolloSurfaceView)this.val$view).runRenderTask(new ApolloRender.15.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhz
 * JD-Core Version:    0.7.0.1
 */