import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class gcm
  implements Runnable
{
  public gcm(int paramInt) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.a, 0).b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gcm
 * JD-Core Version:    0.7.0.1
 */