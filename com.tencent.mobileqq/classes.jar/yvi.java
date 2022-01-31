import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public final class yvi
  implements Runnable
{
  public yvi(int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getApplication(), "角色: " + this.a + " 装扮不足7件", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvi
 * JD-Core Version:    0.7.0.1
 */