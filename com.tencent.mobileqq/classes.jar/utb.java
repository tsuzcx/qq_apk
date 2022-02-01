import android.view.View;
import com.tencent.superplayer.view.ISPlayerVideoView;

public class utb
  implements usr
{
  private ISPlayerVideoView a;
  
  public utb(ISPlayerVideoView paramISPlayerVideoView)
  {
    this.a = paramISPlayerVideoView;
  }
  
  public View a()
  {
    if ((this.a instanceof View)) {
      return (View)this.a;
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.setFixedSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utb
 * JD-Core Version:    0.7.0.1
 */