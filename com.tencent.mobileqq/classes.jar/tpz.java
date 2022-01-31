import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class tpz
  implements IStatusListener
{
  public tpz(QQSettingMe paramQQSettingMe) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (this.a.c)
    {
      if (paramInt != 100) {
        this.a.a(2131435296);
      }
      this.a.B();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tpz
 * JD-Core Version:    0.7.0.1
 */