import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.widget.QQToast;

public class fln
  implements ConditionSearchManager.IConfigListener
{
  public fln(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean)) {
      this.a.d = true;
    }
    if ((this.a.h == 1) || (this.a.h == 2)) {
      if (!paramBoolean) {
        this.a.e();
      }
    }
    while ((!this.a.c) || (paramInt != 2) || (!paramBoolean))
    {
      QQToast.a(this.a, 2131562108, 0).b(this.a.d());
      do
      {
        return;
      } while (paramInt != 2);
      this.a.e();
      this.a.a(this.a.h);
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fln
 * JD-Core Version:    0.7.0.1
 */