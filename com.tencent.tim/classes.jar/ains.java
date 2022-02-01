import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ains
  extends acfd
{
  public ains(ListenTogetherManager paramListenTogetherManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("ListenTogether.Manager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      String str = aiob.H(2, String.valueOf(paramObject));
      if (ListenTogetherManager.a(this.this$0).equals(str))
      {
        ((ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0))).status = 3;
        ((ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0))).deR = 3;
        aing.k(ListenTogetherManager.a(this.this$0), String.valueOf(paramObject), false);
        this.this$0.a(true, (ListenTogetherSession)ListenTogetherManager.a(this.this$0).get(ListenTogetherManager.a(this.this$0)), 1007);
        this.this$0.r(2, String.valueOf(paramObject), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ains
 * JD-Core Version:    0.7.0.1
 */