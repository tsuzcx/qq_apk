package com.tencent.qqmail.InlineImage.fetcher;

import android.app.Activity;
import android.content.res.AssetManager;
import com.tencent.qqmail.InlineImage.timing.ReadMailTimer;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.note.ReadNoteActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import java.io.IOException;
import java.io.InputStream;

abstract class BaseFetcher
  implements Fetcher
{
  private static final String TAG = "BaseFetcher";
  protected InputStream inputStream = null;
  
  private void fetchErrorImage()
  {
    try
    {
      this.inputStream = QMApplicationContext.sharedInstance().getAssets().open("mail/image_fail.png");
      return;
    }
    catch (IOException localIOException)
    {
      QMLog.log(4, "BaseFetcher", "Fail to fetch error Image" + localIOException.getMessage());
      localIOException.printStackTrace();
    }
  }
  
  private boolean showImage()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if ((localActivity == null) || ((localActivity instanceof ComposeMailActivity)) || ((localActivity instanceof ReadNoteActivity)) || ((localActivity instanceof ComposeNoteActivity))) {
      return true;
    }
    switch (QMSettingManager.sharedInstance().getMailLoadImgType())
    {
    case 0: 
    default: 
      return true;
    case 1: 
      return QMNetworkUtils.isWifiConnected();
    }
    return false;
  }
  
  public final InputStream fetch(String paramString)
  {
    QMLog.log(4, "BaseFetcher", "Fetching url " + paramString);
    try
    {
      if (showImage()) {
        fetchFromNetwork(paramString);
      }
      for (;;)
      {
        if (this.inputStream == null)
        {
          QMLog.log(4, "BaseFetcher", "fetching error Image for " + paramString);
          fetchErrorImage();
        }
        ReadMailTimer.updateLastTime();
        return this.inputStream;
        QMLog.log(4, "BaseFetcher", "Setting not show image");
        this.inputStream = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.inputStream = null;
      }
    }
  }
  
  protected abstract void fetchFromNetwork(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.BaseFetcher
 * JD-Core Version:    0.7.0.1
 */