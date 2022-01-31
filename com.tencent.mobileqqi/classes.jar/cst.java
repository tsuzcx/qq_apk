import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;

public class cst
  extends TroopObserver
{
  public cst(ForwardRecentActivity paramForwardRecentActivity) {}
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ForwardRecentActivity.b(this.a);
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramArrayList != null) && (paramArrayList.size() > 0) && (paramBoolean2)) {
      ForwardRecentActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cst
 * JD-Core Version:    0.7.0.1
 */