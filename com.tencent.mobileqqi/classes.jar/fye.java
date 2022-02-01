import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class fye
  implements Runnable
{
  public fye(int paramInt) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.a(2130837933);
    localQQToast.c(3000);
    localQQToast.b(this.a);
    localQQToast.b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fye
 * JD-Core Version:    0.7.0.1
 */