import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.qphone.base.util.QLog;

public class bog
  implements TabBarView.OnTabChangeListener
{
  public bog(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt2 == 0)
    {
      this.a.g = true;
      str2 = "1";
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListActivity", 2, "onTabSelected, isPositiveSort=" + this.a.g);
      }
      if (this.a.a != null) {
        this.a.a.a();
      }
      str1 = "";
      if (this.a.v != 1) {
        break label139;
      }
      str1 = "Clk_lastactivetime";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1)) {
        this.a.a(str1, str2, this.a.p);
      }
      return;
      if (paramInt2 != 1) {
        break;
      }
      this.a.g = false;
      str2 = "0";
      break;
      label139:
      if (this.a.v == 2) {
        str1 = "Clk_mberlevel";
      } else if (this.a.v == 4) {
        str1 = "Clk_jointime";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bog
 * JD-Core Version:    0.7.0.1
 */