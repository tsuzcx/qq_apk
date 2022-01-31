import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class gcr
  implements Runnable
{
  public gcr(int paramInt) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.a(2130837931);
    localQQToast.c(3000);
    localQQToast.b(this.a);
    localQQToast.b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gcr
 * JD-Core Version:    0.7.0.1
 */