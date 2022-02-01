import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class wvn
  implements wvr
{
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt)
  {
    anot.a(paramQQAppInterface, "dc00898", "", "", "0X8008C70", "0X8008C70", ykm.fq(paramInt), 0, "", "", "", "");
    paramString = ahxs.ls(paramString);
    if ((paramString != null) && (paramString.length() > 20))
    {
      QQToast.a(paramContext, acfp.m(2131707137), 0).show();
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X800932C", "0X800932C", 0, 0, "", "", "", "");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvn
 * JD-Core Version:    0.7.0.1
 */