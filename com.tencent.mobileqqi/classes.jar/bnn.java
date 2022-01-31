import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public final class bnn
  implements LoadedBack
{
  public void a(int paramInt)
  {
    if ((paramInt == 0) && (QLog.isColorLevel())) {
      QLog.i("HtmlCheckUpdate", 2, "CODE_SUCCESS");
    }
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bnn
 * JD-Core Version:    0.7.0.1
 */