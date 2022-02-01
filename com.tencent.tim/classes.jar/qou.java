import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

public class qou
  extends pmd
{
  public qou(QQStoryShieldActivity paramQQStoryShieldActivity) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo)
  {
    boolean bool = true;
    QQStoryShieldActivity.a(this.a);
    Switch localSwitch;
    if ((paramBoolean) && (paramQQStoryUserInfo != null))
    {
      this.a.v.setOnCheckedChangeListener(null);
      this.a.w.setOnCheckedChangeListener(null);
      localSwitch = this.a.v;
      if (paramQQStoryUserInfo.isAllowed != 1) {
        break label119;
      }
      paramBoolean = true;
      localSwitch.setChecked(paramBoolean);
      localSwitch = this.a.w;
      if (paramQQStoryUserInfo.isInterested != 1) {
        break label124;
      }
    }
    label119:
    label124:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      this.a.v.setOnCheckedChangeListener(this.a);
      this.a.w.setOnCheckedChangeListener(this.a);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public void m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramBoolean2 = true;
    this.a.a.dismiss();
    if (paramBoolean1) {
      return;
    }
    QQToast.a(this.a, 2131696746, 0).show(this.a.getTitleBarHeight());
    if (paramBoolean3)
    {
      localSwitch = this.a.v;
      if (!this.a.v.isChecked()) {}
      for (paramBoolean1 = paramBoolean2;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    Switch localSwitch = this.a.w;
    if (!this.a.w.isChecked()) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localSwitch.setChecked(paramBoolean1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qou
 * JD-Core Version:    0.7.0.1
 */