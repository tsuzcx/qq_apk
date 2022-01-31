import android.content.Context;

final class ykz
{
  public int a = -2147483648;
  public int b = -2147483648;
  public int c = -2147483648;
  public int d = -2147483648;
  
  public ykz(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      yny.d("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    this.a = Double.valueOf(0.02892561983471075D * paramInt1).intValue();
    this.b = Double.valueOf(0.02666666666666667D * paramInt2).intValue();
    this.c = Double.valueOf(0.06666666666666667D * paramInt2).intValue();
    this.d = Double.valueOf(0.16D * paramInt2).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ykz
 * JD-Core Version:    0.7.0.1
 */