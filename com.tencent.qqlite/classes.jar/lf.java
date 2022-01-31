import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public final class lf
  implements LoadedBack
{
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt == 0) && (QLog.isColorLevel())) {
      QLog.i("HtmlCheckUpdate", 2, "CODE_SUCCESS");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lf
 * JD-Core Version:    0.7.0.1
 */