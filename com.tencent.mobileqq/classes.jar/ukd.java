import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.widget.Switch;

public class ukd
  extends ssy
{
  public ukd(QQStoryShieldActivity paramQQStoryShieldActivity) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo)
  {
    boolean bool = true;
    QQStoryShieldActivity.a(this.a);
    Switch localSwitch;
    if ((paramBoolean) && (paramQQStoryUserInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      this.a.b.setOnCheckedChangeListener(null);
      localSwitch = this.a.jdField_a_of_type_ComTencentWidgetSwitch;
      if (paramQQStoryUserInfo.isAllowed != 1) {
        break label119;
      }
      paramBoolean = true;
      localSwitch.setChecked(paramBoolean);
      localSwitch = this.a.b;
      if (paramQQStoryUserInfo.isInterested != 1) {
        break label124;
      }
    }
    label119:
    label124:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
      this.a.b.setOnCheckedChangeListener(this.a);
      return;
      paramBoolean = false;
      break;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    paramBoolean2 = true;
    this.a.jdField_a_of_type_Bcpt.b();
    if (paramBoolean1) {
      return;
    }
    bcpw.a(this.a, 2131694974, 0).b(this.a.getTitleBarHeight());
    if (paramBoolean3)
    {
      localSwitch = this.a.jdField_a_of_type_ComTencentWidgetSwitch;
      if (!this.a.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {}
      for (paramBoolean1 = paramBoolean2;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    Switch localSwitch = this.a.b;
    if (!this.a.b.isChecked()) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localSwitch.setChecked(paramBoolean1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */