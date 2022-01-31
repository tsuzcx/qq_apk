package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.qphone.base.util.QLog;

public class GetShareAlbumInfo
  extends AsyncStep
{
  protected int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "ShareAlbum onGetShareAlbumInfo");
    }
    QZoneShareAlbumAssistantManager localQZoneShareAlbumAssistantManager = QZoneShareAlbumAssistantManager.a();
    if (localQZoneShareAlbumAssistantManager != null) {
      localQZoneShareAlbumAssistantManager.b(this.a.a);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetShareAlbumInfo
 * JD-Core Version:    0.7.0.1
 */