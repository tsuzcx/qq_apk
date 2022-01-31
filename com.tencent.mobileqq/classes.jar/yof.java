import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class yof
{
  private static yog a(int paramInt)
  {
    yop localyop = null;
    if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt) || (3 == paramInt)) {
      localyop = new yop();
    }
    return localyop;
  }
  
  public static void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {}
    yog localyog;
    do
    {
      do
      {
        yom.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
        return;
      } while ((paramInt2 < 0) || (paramInt2 >= 4));
      localyog = a(paramInt2);
    } while (localyog == null);
    localyog.a(paramInt1, paramInt2, paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */