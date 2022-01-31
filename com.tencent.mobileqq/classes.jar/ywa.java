import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class ywa
  implements TVK_SDKMgr.InstallListener
{
  ywa(yvv paramyvv) {}
  
  public void onInstallProgress(float paramFloat)
  {
    yxs.a("GdtMvViewController", "installSDK onInstallProgress arg0=" + paramFloat);
  }
  
  public void onInstalledFailed(int paramInt)
  {
    yxs.a("GdtMvViewController", "installSDK onInstalledFailed arg0=" + paramInt);
  }
  
  public void onInstalledSuccessed()
  {
    yxs.a("GdtMvViewController", "installSDK onInstalledSuccessed");
    yvv.a(this.a).sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ywa
 * JD-Core Version:    0.7.0.1
 */