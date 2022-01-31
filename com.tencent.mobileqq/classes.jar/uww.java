import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout.DoodleLayoutListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class uww
  implements DoodleLayout.DoodleLayoutListener
{
  public uww(DoodlePanel paramDoodlePanel) {}
  
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
        uwx localuwx = new uwx(this);
        DialogUtil.a(this.a.getContext(), 230, null, this.a.getContext().getString(2131439104), null, this.a.getContext().getString(2131439108), localuwx, null).show();
      }
      return;
    }
    QQToast.a(this.a.getContext(), this.a.getContext().getString(2131439105), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uww
 * JD-Core Version:    0.7.0.1
 */