import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class udt
{
  public static void a(ule paramule, udu paramudu)
  {
    if (paramule == null)
    {
      paramudu.a(false);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AdDownloadUtil.1(paramule, paramudu));
  }
  
  public static boolean a(String paramString)
  {
    return ois.a(BaseApplicationImpl.getContext(), paramString);
  }
  
  public static boolean a(ule paramule)
  {
    if ((paramule == null) || (TextUtils.isEmpty(paramule.d))) {
      return false;
    }
    return a(paramule.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udt
 * JD-Core Version:    0.7.0.1
 */