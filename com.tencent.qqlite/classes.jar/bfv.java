import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class bfv
  implements IStatusListener
{
  public bfv(QQSettingMe paramQQSettingMe) {}
  
  public void a(int paramInt, RichStatus paramRichStatus)
  {
    if (this.a.b)
    {
      if (paramInt != 100) {
        this.a.a(2131363679);
      }
      this.a.q();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bfv
 * JD-Core Version:    0.7.0.1
 */