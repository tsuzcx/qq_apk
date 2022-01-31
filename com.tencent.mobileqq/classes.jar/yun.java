import com.tencent.common.app.BaseApplicationImpl;

class yun
  implements yuf
{
  yun(yul paramyul) {}
  
  public void a(yuc paramyuc)
  {
    yxp.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramyuc.a, paramyuc.b, paramyuc.c }));
    yyc.a(BaseApplicationImpl.getApplication(), yul.a(yul.a()), 0, -2147483648);
  }
  
  public void a(yuc paramyuc, int paramInt)
  {
    yxp.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramyuc.a, paramyuc.b, paramyuc.c, Integer.valueOf(paramInt) }));
    yyc.a(BaseApplicationImpl.getApplication(), yul.a(yul.a()), paramInt);
  }
  
  public void a(yuc paramyuc, int paramInt1, int paramInt2)
  {
    yxp.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramyuc.a, paramyuc.b, paramyuc.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    yyc.a(BaseApplicationImpl.getApplication(), yul.a(yul.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yun
 * JD-Core Version:    0.7.0.1
 */