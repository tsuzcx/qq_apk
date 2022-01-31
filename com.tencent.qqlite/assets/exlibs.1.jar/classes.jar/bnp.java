import android.view.View;
import com.tencent.mobileqq.activity.TroopManageActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.widget.Switch;

public class bnp
  extends BizTroopObserver
{
  public bnp(TroopManageActivity paramTroopManageActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
      ((TroopInfo)localObject).dwGroupFlagExt ^= 0x40000000;
      localObject = (TroopManager)this.a.app.getManager(44);
      if (localObject != null) {
        ((TroopManager)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      }
      return;
    }
    this.a.a(1, this.a.getString(2131362567));
    Object localObject = ((FormSwitchItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[7].findViewById(2131298549)).a();
    ((Switch)localObject).setOnCheckedChangeListener(null);
    if (!paramBoolean2) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((Switch)localObject).setChecked(paramBoolean1);
      ((Switch)localObject).setOnCheckedChangeListener(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bnp
 * JD-Core Version:    0.7.0.1
 */