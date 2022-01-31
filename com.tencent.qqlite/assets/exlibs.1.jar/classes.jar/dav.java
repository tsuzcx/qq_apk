import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class dav
  implements ConditionSearchManager.IConfigListener
{
  public dav(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean)) {
      this.a.d = true;
    }
    if ((this.a.h == 1) || (this.a.h == 2)) {
      if (!paramBoolean) {
        this.a.d();
      }
    }
    while ((!this.a.c) || (paramInt != 2) || (!paramBoolean))
    {
      QQToast.a(this.a, 2131364412, 0).b(this.a.getTitleBarHeight());
      do
      {
        return;
      } while (paramInt != 2);
      this.a.d();
      this.a.a(this.a.h);
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dav
 * JD-Core Version:    0.7.0.1
 */