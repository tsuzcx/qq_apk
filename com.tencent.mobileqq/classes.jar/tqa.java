import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.download_action.AdDownloadUtil.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tqa
{
  public static void a(txh paramtxh, tqb paramtqb)
  {
    if (paramtxh == null)
    {
      paramtqb.a(false);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new AdDownloadUtil.1(paramtxh, paramtqb));
  }
  
  public static boolean a(String paramString)
  {
    return obb.a(BaseApplicationImpl.getContext(), paramString);
  }
  
  public static boolean a(txh paramtxh)
  {
    if ((paramtxh == null) || (TextUtils.isEmpty(paramtxh.d))) {
      return false;
    }
    return a(paramtxh.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqa
 * JD-Core Version:    0.7.0.1
 */