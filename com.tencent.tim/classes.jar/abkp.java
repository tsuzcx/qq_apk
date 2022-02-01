import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.debug.CmGameDebugView;

public class abkp
  implements abkj.a
{
  public abkp(CmGameDebugView paramCmGameDebugView) {}
  
  public void Ho(int paramInt)
  {
    if (CmGameDebugView.a(this.a).getVisibility() != 0)
    {
      CmGameDebugView.b(this.a, true);
      return;
    }
    CmGameDebugView.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkp
 * JD-Core Version:    0.7.0.1
 */