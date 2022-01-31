import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ymj
  implements TVK_SDKMgr.InstallListener
{
  ymj(yme paramyme) {}
  
  public void onInstallProgress(float paramFloat)
  {
    yny.a("GdtMvViewController", "installSDK onInstallProgress arg0=" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    yny.a("GdtMvViewController", "installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    yny.a("GdtMvViewController", "installSDK onInstalledSuccessed");
    yme.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ymj
 * JD-Core Version:    0.7.0.1
 */