import android.content.Context;
import com.tencent.mobileqq.activity.aio.doodle.DoodleLayout.DoodleLayoutListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

public class uou
  implements DoodleLayout.DoodleLayoutListener
{
  public uou(DoodlePanel paramDoodlePanel) {}
  
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
        uov localuov = new uov(this);
        DialogUtil.a(this.a.getContext(), 230, null, this.a.getContext().getString(2131439049), null, this.a.getContext().getString(2131439053), localuov, null).show();
      }
      return;
    }
    QQToast.a(this.a.getContext(), this.a.getContext().getString(2131439050), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uou
 * JD-Core Version:    0.7.0.1
 */