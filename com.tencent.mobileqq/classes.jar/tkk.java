import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tkk
{
  public static void a(tqt paramtqt, tkl paramtkl)
  {
    if (paramtqt == null)
    {
      paramtkl.a(false);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AdDownloadUtil.1(paramtqt, paramtkl));
  }
  
  public static boolean a(String paramString)
  {
    return nzq.a(BaseApplicationImpl.getContext(), paramString);
  }
  
  public static boolean a(tqt paramtqt)
  {
    if ((paramtqt == null) || (TextUtils.isEmpty(paramtqt.d))) {
      return false;
    }
    return a(paramtqt.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkk
 * JD-Core Version:    0.7.0.1
 */