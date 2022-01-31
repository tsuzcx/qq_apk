import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class yvx
  implements TVK_SDKMgr.InstallListener
{
  yvx(yvs paramyvs) {}
  
  public void onInstallProgress(float paramFloat)
  {
    yxp.a("GdtMvViewController", "installSDK onInstallProgress arg0=" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    yxp.a("GdtMvViewController", "installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    yxp.a("GdtMvViewController", "installSDK onInstalledSuccessed");
    yvs.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yvx
 * JD-Core Version:    0.7.0.1
 */