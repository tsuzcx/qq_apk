import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class tkn
{
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (b(paramAdvertisementInfo))
    {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.c == 0) {
        return 3;
      }
      return 4;
    }
    if (c(paramAdvertisementInfo)) {
      return 5;
    }
    if (a(paramAdvertisementInfo)) {
      return 2;
    }
    if (d(paramAdvertisementInfo)) {
      return 6;
    }
    if (e(paramAdvertisementInfo)) {
      return 7;
    }
    if (f(paramAdvertisementInfo)) {
      return 8;
    }
    if (g(paramAdvertisementInfo)) {
      return 9;
    }
    return 1;
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((paramAdvertisementInfo.mChannelID != 0L) || (!TextUtils.isEmpty(ubd.a(paramAdvertisementInfo, "AdsIconText")))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.isSoftAd());
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    return tpp.a(paramAdvertisementInfo);
  }
  
  private static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((paramAdvertisementInfo.mImaxShowAdType != 1001) && (paramAdvertisementInfo.mImaxShowAdType != 1002)) {
      return false;
    }
    return true;
  }
  
  private static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo == null)) {}
    while (5001 != paramAdvertisementInfo.mAdvertisementExtInfo.i) {
      return false;
    }
    return true;
  }
  
  private static boolean f(AdvertisementInfo paramAdvertisementInfo)
  {
    return e(paramAdvertisementInfo);
  }
  
  private static boolean g(AdvertisementInfo paramAdvertisementInfo)
  {
    return tqa.m(paramAdvertisementInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkn
 * JD-Core Version:    0.7.0.1
 */