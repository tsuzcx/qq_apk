import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import java.util.List;

public class ycn
  extends TroopObserver
{
  public ycn(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void a(String paramString, boolean paramBoolean, List paramList, int paramInt, long paramLong)
  {
    if ((!TextUtils.isEmpty(this.a.b)) && (!this.a.b.equals(paramString))) {
      return;
    }
    ThreadManager.post(new yco(this, paramList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ycn
 * JD-Core Version:    0.7.0.1
 */