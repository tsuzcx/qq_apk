import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout.a;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.widget.QQToast;

public class wri
  implements DoodleLayout.a
{
  public wri(DoodlePanel paramDoodlePanel) {}
  
  public void CF(int paramInt)
  {
    DoodlePanel.a(this.b);
  }
  
  public void ft(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (!DoodlePanel.a(this.b))
      {
        DoodlePanel.a(this.b, true);
        wrj localwrj = new wrj(this);
        aqha.a(this.b.getContext(), 230, null, this.b.getContext().getString(2131690123), null, this.b.getContext().getString(2131690112), localwrj, null).show();
      }
      return;
    }
    QQToast.a(this.b.getContext(), this.b.getContext().getString(2131690115), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wri
 * JD-Core Version:    0.7.0.1
 */