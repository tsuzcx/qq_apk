import com.tencent.mobileqq.activity.TroopMemberGagActivity;
import com.tencent.mobileqq.activity.TroopMemberGagActivity.GagItemListener;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagItem;

public class boh
  implements TroopMemberGagActivity.GagItemListener
{
  public boh(TroopMemberGagActivity paramTroopMemberGagActivity) {}
  
  public void a(TroopGagMgr.GagItem paramGagItem)
  {
    if (paramGagItem.a > 0) {
      this.a.a = paramGagItem.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     boh
 * JD-Core Version:    0.7.0.1
 */