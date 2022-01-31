import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;

public class ahw
  implements ConditionSearchManager.IConfigListener
{
  public ahw(DetailProfileActivity paramDetailProfileActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.a.s == 1) || (this.a.s == 2))
    {
      if (paramBoolean) {
        break label55;
      }
      this.a.a();
      QQToast.a(this.a, 2131364394, 0).b(this.a.getTitleBarHeight());
    }
    label55:
    while (paramInt != 2) {
      return;
    }
    this.a.a();
    this.a.b(this.a.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ahw
 * JD-Core Version:    0.7.0.1
 */