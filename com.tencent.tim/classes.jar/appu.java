import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class appu
  extends ViewPager.SimpleOnPageChangeListener
{
  public appu(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    String str1;
    String str3;
    if (this.this$0.a != null)
    {
      if (!VisitorTroopCardFragment.a(this.this$0)) {
        break label85;
      }
      str1 = "grpData_admin";
      str3 = this.this$0.a.troopUin;
      if (!VisitorTroopCardFragment.a(this.this$0)) {
        break label91;
      }
    }
    label85:
    label91:
    for (String str2 = aqfr.a(this.this$0.a);; str2 = "1")
    {
      aqfr.b("Grp_set_new", str1, "slide_head", 0, 0, new String[] { str3, str2 });
      return;
      str1 = "grpData_visitor";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appu
 * JD-Core Version:    0.7.0.1
 */