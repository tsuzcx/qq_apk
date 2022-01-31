import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class duy
  implements Runnable
{
  public duy(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 1, this.a, 0).b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     duy
 * JD-Core Version:    0.7.0.1
 */