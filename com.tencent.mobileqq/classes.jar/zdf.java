import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;

public class zdf
  implements QQTabHost.OnTabSelectionListener
{
  public zdf(FrameFragment paramFrameFragment) {}
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost)
  {
    if (paramInt1 == paramInt2)
    {
      paramQQTabHost = this.a.b();
      if (paramQQTabHost != null) {
        paramQQTabHost.e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zdf
 * JD-Core Version:    0.7.0.1
 */