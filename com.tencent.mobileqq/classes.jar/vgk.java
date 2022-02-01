import com.tencent.biz.qcircleshadow.lib.delegate.IToastDelegate;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class vgk
  implements IToastDelegate
{
  public int getIconTypeDefault()
  {
    return 0;
  }
  
  public int getIconTypeError()
  {
    return 1;
  }
  
  public int getIconTypeNone()
  {
    return -1;
  }
  
  public int getIconTypeSuccess()
  {
    return 2;
  }
  
  public void makeTextAndShow(int paramInt1, String paramString, int paramInt2)
  {
    QQToast.a(BaseApplicationImpl.getContext(), paramInt1, paramString, paramInt2).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgk
 * JD-Core Version:    0.7.0.1
 */