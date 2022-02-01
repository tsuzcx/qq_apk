import com.tencent.biz.qqstory.settings.QQStoryBasicSettingsActivity;
import com.tencent.mobileqq.widget.QQToast;

public class qon
  extends pmd
{
  public qon(QQStoryBasicSettingsActivity paramQQStoryBasicSettingsActivity) {}
  
  public void rR(boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    if (paramBoolean)
    {
      this.a.c.vK(this.a.dW(this.a.bno));
      this.a.c.vL(this.a.dW(this.a.bno));
      if (this.a.bno == 2) {
        rar.a("browse_friend_settings", "close", 0, 0, new String[] { "", "", "", "" });
      }
      do
      {
        return;
        if (this.a.bno == 0)
        {
          rar.a("browse_friend_settings", "choose_all", 0, 0, new String[] { "", "", "", "" });
          return;
        }
      } while (this.a.bno != 1);
      rar.a("browse_friend_settings", "choose_wifi", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    QQToast.a(this.a, 2131696746, 0).show(this.a.getTitleBarHeight());
    this.a.bV(this.a.bnp);
    this.a.b.blO();
  }
  
  public void vO(int paramInt)
  {
    QQStoryBasicSettingsActivity.a(this.a);
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 1001: 
      this.a.bV(0);
      return;
    case 2: 
      this.a.bV(1);
      return;
    case 3: 
      this.a.bV(2);
      return;
    }
    QQToast.a(this.a, acfp.m(2131712211), 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qon
 * JD-Core Version:    0.7.0.1
 */