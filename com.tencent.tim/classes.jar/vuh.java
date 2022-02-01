import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class vuh
  extends acfd
{
  public vuh(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  protected void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      SettingUncommUsedContactsActivity.a(this.a, this.a.aA.a(), paramBoolean2);
      SettingUncommUsedContactsActivity.a(this.a, this.a.aB.a(), paramBoolean3);
    }
  }
  
  protected void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.cf(2131719890, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.aA.a(), paramBoolean2);
    }
  }
  
  protected void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.cf(2131719890, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.aB.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vuh
 * JD-Core Version:    0.7.0.1
 */