import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout.DoodleLayoutListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class urw
  implements DoodleLayout.DoodleLayoutListener
{
  public urw(DoodlePanel paramDoodlePanel) {}
  
  public void a(int paramInt)
  {
    DoodlePanel.a(this.a);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      if (!DoodlePanel.a(this.a))
      {
        DoodlePanel.a(this.a, true);
        urx localurx = new urx(this);
        DialogUtil.a(this.a.getContext(), 230, null, this.a.getContext().getString(2131439077), null, this.a.getContext().getString(2131439081), localurx, null).show();
      }
      return;
    }
    QQToast.a(this.a.getContext(), this.a.getContext().getString(2131439078), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     urw
 * JD-Core Version:    0.7.0.1
 */