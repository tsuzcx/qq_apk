import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class duy
  implements Runnable
{
  public duy(int paramInt) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.a(2130837966);
    localQQToast.c(3000);
    localQQToast.b(this.a);
    localQQToast.b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     duy
 * JD-Core Version:    0.7.0.1
 */