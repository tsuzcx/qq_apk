import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;

public class bem
  implements IStatusListener
{
  public bem(QQSetting paramQQSetting) {}
  
  public void a(int paramInt, RichStatus paramRichStatus)
  {
    if (QQSetting.c(this.a))
    {
      if (paramInt != 100) {
        this.a.a(2131363679);
      }
      this.a.n();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bem
 * JD-Core Version:    0.7.0.1
 */