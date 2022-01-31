import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.widget.QQToast;

public final class gco
  implements Runnable
{
  public gco(String paramString) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.a, 1).b(FMToastUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gco
 * JD-Core Version:    0.7.0.1
 */