import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.TenDocWebPreLoadHelper.1;

public class aulu
{
  public static volatile String cka = "";
  
  public static void RM(String paramString)
  {
    QLog.d("TenDocWebPreLoadHelper", 1, "tendocpreload preloadTenDocUrl ");
    if (!TextUtils.isEmpty(paramString))
    {
      cka = paramString;
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label61;
      }
      if ((ault.pP(paramString)) && (!aulv.a().pR(paramString)))
      {
        aulv.a().init(paramString);
        aulv.a().pR(paramString);
      }
    }
    return;
    label61:
    new Handler(Looper.getMainLooper()).post(new TenDocWebPreLoadHelper.1(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulu
 * JD-Core Version:    0.7.0.1
 */