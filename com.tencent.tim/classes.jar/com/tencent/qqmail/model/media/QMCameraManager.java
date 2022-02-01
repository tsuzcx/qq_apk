package com.tencent.qqmail.model.media;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.os.StrictMode.VmPolicy.Builder;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;

public class QMCameraManager
{
  public static final int STATE_PENDING = 0;
  public static final int STATE_WILL_TAKE = 1;
  private static QMCameraManager _instance = new QMCameraManager();
  private String cameraPhotoPath = "";
  private String cameraViewPath = "";
  private int state = 0;
  
  public static QMCameraManager sharedInstance()
  {
    return _instance;
  }
  
  public String getCameraPhotoPath()
  {
    return this.cameraPhotoPath;
  }
  
  public String getCameraViewPath()
  {
    return this.cameraViewPath;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setCameraPhotoPath(String paramString)
  {
    this.cameraPhotoPath = paramString;
  }
  
  public void setCameraViewPath(String paramString)
  {
    this.cameraViewPath = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void startCamera(StartRunnable paramStartRunnable)
  {
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
    this.state = 1;
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    File localFile = new File(this.cameraPhotoPath);
    if (!FileUtil.tryMkdirs(localFile.getParentFile())) {
      QMLog.log(6, "Take-photo", "no path for photo saved");
    }
    localIntent.putExtra("output", Uri.fromFile(localFile));
    if (paramStartRunnable != null)
    {
      QMLog.log(4, "Take-photo", "start camera run");
      try
      {
        paramStartRunnable.run(localIntent);
        return;
      }
      catch (Throwable paramStartRunnable)
      {
        QMLog.log(6, "Take-photo", paramStartRunnable.getMessage(), paramStartRunnable);
        Toast.makeText(QMApplicationContext.sharedInstance(), "拍照功能不能正常使用", 1).show();
        return;
      }
    }
    QMLog.log(6, "Take-photo", "start camera runnable is null");
  }
  
  public void startVideo(StartRunnable paramStartRunnable)
  {
    this.state = 1;
    Intent localIntent = new Intent("android.media.action.VIDEO_CAPTURE");
    localIntent.putExtra("android.intent.extra.videoQuality", 1);
    File localFile = new File(this.cameraPhotoPath);
    FileUtil.tryMkdirs(localFile.getParentFile());
    localIntent.putExtra("output", Uri.fromFile(localFile));
    if (paramStartRunnable != null)
    {
      paramStartRunnable.run(localIntent);
      return;
    }
    QMLog.log(6, "Take-video", "start camera runnable is null");
  }
  
  public static abstract interface StartRunnable
  {
    public abstract void run(Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.media.QMCameraManager
 * JD-Core Version:    0.7.0.1
 */