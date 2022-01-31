import android.view.View;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public final class yim
  implements HandshakeCompletedListener
{
  public yim(View paramView, long paramLong) {}
  
  public void handshakeCompleted(HandshakeCompletedEvent paramHandshakeCompletedEvent)
  {
    ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).queueEvent(new yin(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yim
 * JD-Core Version:    0.7.0.1
 */