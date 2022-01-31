import com.tencent.common.app.BaseApplicationImpl;

class yuq
  implements yui
{
  yuq(yuo paramyuo) {}
  
  public void a(yuf paramyuf)
  {
    yxs.b("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramyuf.a, paramyuf.b, paramyuf.c }));
    yyf.a(BaseApplicationImpl.getApplication(), yuo.a(yuo.a()), 0, -2147483648);
  }
  
  public void a(yuf paramyuf, int paramInt)
  {
    yxs.b("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramyuf.a, paramyuf.b, paramyuf.c, Integer.valueOf(paramInt) }));
    yyf.a(BaseApplicationImpl.getApplication(), yuo.a(yuo.a()), paramInt);
  }
  
  public void a(yuf paramyuf, int paramInt1, int paramInt2)
  {
    yxs.d("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramyuf.a, paramyuf.b, paramyuf.c, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    yyf.a(BaseApplicationImpl.getApplication(), yuo.a(yuo.a()), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yuq
 * JD-Core Version:    0.7.0.1
 */