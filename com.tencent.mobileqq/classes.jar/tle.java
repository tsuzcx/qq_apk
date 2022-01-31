import com.tencent.qphone.base.util.QLog;

class tle
  extends bjke
{
  tle(tld paramtld) {}
  
  public void a(String paramString)
  {
    tld.a = 1;
    tld.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallBegin  STATE_PRELOAD_BEGIN sPreloadPluginState = " + tld.a);
  }
  
  public void a(String paramString, float paramFloat, long paramLong) {}
  
  public void a(String paramString, int paramInt)
  {
    tld.a = -1;
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallError  STATE_PRELOAD_ERR sPreloadPluginState = " + tld.a);
  }
  
  public void b(String paramString)
  {
    tld.a = 2;
    tld.a(this.a);
    QLog.i("QzoneVerticalVideoPluginApk", 1, "QzoneVerticalVideoPluginApk state == STATE_DOWNLOADED onInstallFinish  STATE_PRELOAD_FINISH sPreloadPluginState = " + tld.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tle
 * JD-Core Version:    0.7.0.1
 */