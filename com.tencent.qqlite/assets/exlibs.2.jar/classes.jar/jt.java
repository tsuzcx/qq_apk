import com.tencent.biz.JoinGroupHandler;
import com.tencent.biz.JoinGroupHandler.IJoinGroupCB;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;

public class jt
  extends TroopObserver
{
  public jt(JoinGroupHandler paramJoinGroupHandler) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramLong != JoinGroupHandler.a(this.a)) {
      return;
    }
    JoinGroupHandler.a(this.a, 0L);
    JoinGroupHandler.a(this.a);
    if (paramBoolean)
    {
      JoinGroupHandler.a(this.a, paramTroopInfo);
      return;
    }
    JoinGroupHandler.a(this.a, 2131363385, 1);
    JoinGroupHandler.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     jt
 * JD-Core Version:    0.7.0.1
 */