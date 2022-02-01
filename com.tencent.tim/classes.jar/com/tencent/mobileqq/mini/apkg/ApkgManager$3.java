package com.tencent.mobileqq.mini.apkg;

class ApkgManager$3
  implements ApkgManager.OnInitApkgListener
{
  ApkgManager$3(ApkgManager paramApkgManager, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if (paramInt == 0) {
      if (this.val$listener != null) {
        this.val$listener.onGetApkgInfo(paramApkgInfo, paramInt, paramString);
      }
    }
    while (this.val$listener == null) {
      return;
    }
    this.val$listener.onGetApkgInfo(null, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.3
 * JD-Core Version:    0.7.0.1
 */