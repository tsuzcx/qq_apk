import android.view.View;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;

public class vhu
  implements vhc
{
  private IVideoViewBase a;
  
  public vhu(IVideoViewBase paramIVideoViewBase)
  {
    this.a = paramIVideoViewBase;
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
 * Qualified Name:     vhu
 * JD-Core Version:    0.7.0.1
 */