import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class dwh
  implements Runnable
{
  public dwh(int paramInt) {}
  
  public void run()
  {
    QQToast localQQToast = new QQToast(BaseApplicationImpl.getContext());
    localQQToast.a(2130837981);
    localQQToast.c(3000);
    localQQToast.b(this.a);
    localQQToast.b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dwh
 * JD-Core Version:    0.7.0.1
 */