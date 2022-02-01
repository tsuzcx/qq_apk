class tht
  implements thj.a
{
  tht(thr paramthr) {}
  
  public void a(thi paramthi)
  {
    tkw.i("GdtInterstitialPreDownloader", String.format("onPreDownloaded appName:%s view:%s minVersion:%s", new Object[] { paramthi.appName, paramthi.appView, paramthi.minVersion }));
  }
  
  public void a(thi paramthi, int paramInt)
  {
    tkw.i("GdtInterstitialPreDownloader", String.format("onStatusChanged appName:%s view:%s minVersion:%s status:%d", new Object[] { paramthi.appName, paramthi.appView, paramthi.minVersion, Integer.valueOf(paramInt) }));
  }
  
  public void a(thi paramthi, int paramInt1, int paramInt2)
  {
    tkw.e("GdtInterstitialPreDownloader", String.format("onFailedToPreDownload appName:%s view:%s minVersion:%s error:%d arkError:%d", new Object[] { paramthi.appName, paramthi.appView, paramthi.minVersion, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tht
 * JD-Core Version:    0.7.0.1
 */