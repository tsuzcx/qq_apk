import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class yxv
{
  private static yxw a(int paramInt)
  {
    yyf localyyf = null;
    if ((paramInt == 0) || (1 == paramInt) || (2 == paramInt) || (3 == paramInt)) {
      localyyf = new yyf();
    }
    return localyyf;
  }
  
  public static void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if ((paramInt1 < 0) || (paramInt1 >= 3)) {}
    yxw localyxw;
    do
    {
      do
      {
        yyc.a(BaseApplicationImpl.getApplication(), new GdtAd(paramAdInfo), paramInt1, paramInt2, false);
        return;
      } while ((paramInt2 < 0) || (paramInt2 >= 4));
      localyxw = a(paramInt2);
    } while (localyxw == null);
    localyxw.a(paramInt1, paramInt2, paramAdInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yxv
 * JD-Core Version:    0.7.0.1
 */