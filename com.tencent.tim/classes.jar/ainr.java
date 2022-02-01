import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ainr
  extends acnd
{
  public ainr(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void cG(String paramString, int paramInt)
  {
    QLog.i("ListenTogether.Manager", 1, "onPassiveExit troopUin: " + paramString);
    String str = aiob.H(1, paramString);
    if (ListenTogetherManager.a(this.this$0).equals(str))
    {
      ((ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0))).status = 3;
      ((ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0))).deR = 3;
      aing.j(ListenTogetherManager.a(this.this$0), paramString, false);
      this.this$0.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0)), 1007);
      this.this$0.r(1, paramString, false);
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    QLog.i("ListenTogether.Manager", 1, "onTroopManagerSuccess result: " + paramInt2 + " troopUin: " + paramString);
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2)))
    {
      String str = aiob.H(1, paramString);
      if (ListenTogetherManager.a(this.this$0).equals(str))
      {
        ((ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0))).status = 3;
        ((ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0))).deR = 3;
        aing.j(ListenTogetherManager.a(this.this$0), paramString, false);
        this.this$0.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0)), 1007);
        this.this$0.r(1, paramString, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ainr
 * JD-Core Version:    0.7.0.1
 */