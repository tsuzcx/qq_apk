package com.tencent.qqmail.activity.aba;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.model.media.QMAlbumManager;
import com.tencent.qqmail.model.media.QMCameraManager;
import com.tencent.qqmail.model.media.QMUploadImageManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;

public class QMAbaActivity
  extends BaseActivityEx
{
  static String ABA_TYPE = "aba_file_type";
  public static String Aba_FROM_BG_PUSH = "fromBgPush";
  static int MaxStageTag = 2048;
  private static final String TAG = "QMAbaActivity";
  private static List<AttachInfo> selectedResult;
  private QMAbaTextManager.QMAttachIntentType intentType = QMAbaTextManager.QMAttachIntentType.QMAttachIntentType_NORMAIL;
  
  private void TakePhotos()
  {
    String str = FileUtil.getAttachDownloadDir();
    if ((str != null) && (!str.equals("")))
    {
      str = FileUtil.createPhotoDirAtRootPath(str) + QMAttachUtils.generateUploadFileName(null);
      QMCameraManager.sharedInstance().setCameraPhotoPath(str);
      RxPermissions.getInstance(getActivity()).request(new String[] { "android.permission.CAMERA" }).subscribe(new QMAbaActivity.1(this));
      return;
    }
    QMLog.log(6, "QMAbaActivity", "click camera wrong path ");
    Toast.makeText(QMApplicationContext.sharedInstance(), "还没有创建缓存目录", 0).show();
  }
  
  public static Intent createIntent(QMAbaTextManager.QMAttachIntentType paramQMAttachIntentType)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), QMAbaActivity.class);
    localIntent.putExtra(ABA_TYPE, paramQMAttachIntentType.toString());
    return localIntent;
  }
  
  public static int detectFileSizeLegal(String paramString, long paramLong1, long paramLong2)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      long l = paramString.length();
      if ((l > paramLong1) && (l < 1048576L * paramLong2)) {
        return 0;
      }
      if (l <= paramLong1) {
        return -1;
      }
      return 1;
    }
    return -2;
  }
  
  private void handSelectVideo(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getStringExtra("selected") != "0")
      {
        handleDone(VideoData.selectedInfo, false);
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  private void handleDone(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    ((List)localObject).add(toImage(paramString));
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (MediaItemInfo)paramString.next();
      AttachInfo localAttachInfo = new AttachInfo();
      localAttachInfo.setAttachPath(((MediaItemInfo)localObject).getDataPath());
      localAttachInfo.setAbsAttachPath(((MediaItemInfo)localObject).getDataPath());
      localAttachInfo.setAttachName(((MediaItemInfo)localObject).getFileName());
      localAttachInfo.setRealSize(((MediaItemInfo)localObject).getFileSize());
      localAttachInfo.setFileType(AttachType.IMAGE);
      localAttachInfo.setThumbnailData(((MediaItemInfo)localObject).getThumbnail(true));
      localAttachInfo.setAttachName(QMAttachUtils.generateUploadFileName(localAttachInfo));
      localArrayList.add(localAttachInfo);
    }
    setSelectedResult(localArrayList);
    if ((this.intentType == QMAbaTextManager.QMAttachIntentType.QMAttachIntentType_PUSH) && (selectedResult != null))
    {
      paramString = QMAbaTextManager.shareInstance().attachCallback;
      if (paramString != null) {
        paramString.handleSelectMedias(selectedResult);
      }
    }
  }
  
  private void handleDone(List<VideoItemInfo> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoItemInfo localVideoItemInfo = (VideoItemInfo)paramList.next();
      AttachInfo localAttachInfo = new AttachInfo();
      localAttachInfo.setAttachPath(localVideoItemInfo.dataPath);
      localAttachInfo.setAbsAttachPath(localVideoItemInfo.dataPath);
      localAttachInfo.setAttachName(localVideoItemInfo.fileName);
      localAttachInfo.setRealSize(localVideoItemInfo.fileSize);
      localAttachInfo.setFileType(AttachType.IMAGE);
      localAttachInfo.setThumbnailData(localVideoItemInfo.getThumbnail(paramBoolean));
      localAttachInfo.setAttachName(QMAttachUtils.generateUploadFileName(localAttachInfo));
      localArrayList.add(localAttachInfo);
    }
    setSelectedResult(localArrayList);
    if ((this.intentType == QMAbaTextManager.QMAttachIntentType.QMVideoIntentType_PUSH) && (selectedResult != null))
    {
      paramList = QMAbaTextManager.shareInstance().attachCallback;
      if (paramList != null) {
        paramList.handleSelectMedias(selectedResult);
      }
    }
  }
  
  private void handleSelectFile(Intent paramIntent)
    throws InterruptedException
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("filePath");
      int i = detectFileSizeLegal(paramIntent, 0L, MaxStageTag);
      if (i == 0)
      {
        handleDone(paramIntent);
        return;
      }
      if (i == -1) {
        showUploadErrEmptyFile();
      }
      for (;;)
      {
        finish();
        return;
        if (i == 1) {
          showUploadErrOverSize();
        } else {
          showUploadErrFileNotExist();
        }
      }
    }
    showUploadErrFileNotExist();
    finish();
  }
  
  private void handleTakePhoto(Intent paramIntent)
  {
    paramIntent = new File(QMCameraManager.sharedInstance().getCameraPhotoPath());
    if (paramIntent.length() > 0L)
    {
      handleDone(paramIntent.getAbsolutePath());
      return;
    }
    finish();
  }
  
  private void handleTakeVideo(Intent paramIntent)
  {
    paramIntent = new File(QMCameraManager.sharedInstance().getCameraPhotoPath());
    if (paramIntent.length() > 0L)
    {
      paramIntent = paramIntent.getAbsolutePath();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(toVideo(paramIntent));
      handleDone(localArrayList, true);
      return;
    }
    finish();
  }
  
  @Deprecated
  public static void setSelectedResult(List<AttachInfo> paramList)
  {
    selectedResult = paramList;
  }
  
  private void showUploadErrEmptyFile()
  {
    Toast.makeText(QMApplicationContext.sharedInstance(), "不能传空文件", 0).show();
  }
  
  private void showUploadErrFileNotExist()
  {
    Toast.makeText(QMApplicationContext.sharedInstance(), "所选择的文件不存在", 0).show();
  }
  
  private void showUploadErrOverSize()
  {
    Toast.makeText(QMApplicationContext.sharedInstance(), "所选择的附件过大", 0).show();
  }
  
  public void initDataSource()
  {
    Object localObject = getIntent().getStringExtra(ABA_TYPE);
    if (StringUtils.isEmpty((CharSequence)localObject)) {}
    for (this.intentType = QMAbaTextManager.QMAttachIntentType.QMAttachIntentType_NORMAIL;; this.intentType = QMAbaTextManager.QMAttachIntentType.valueOf((String)localObject))
    {
      if (getIntent().getBooleanExtra(Aba_FROM_BG_PUSH, false))
      {
        localObject = (PushWebAttach)getIntent().getParcelableExtra("body");
        if (localObject != null)
        {
          QMUploadImageManager.sharedInstance().init((PushWebAttach)localObject, false);
          QMAlbumManager.shareInstance().albumCallback = QMUploadImageManager.sharedInstance().getCallback();
        }
      }
      return;
    }
  }
  
  public void initDom() {}
  
  public void initUI()
  {
    setContentView(2131558472);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 5) {
      try
      {
        handleSelectFile(paramIntent);
        return;
      }
      catch (InterruptedException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    }
    if (paramInt1 == 3)
    {
      handleTakePhoto(paramIntent);
      return;
    }
    if (paramInt1 == 4)
    {
      handSelectVideo(paramIntent);
      return;
    }
    if (paramInt1 == 6)
    {
      handleTakeVideo(paramIntent);
      return;
    }
    finish();
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onFetchCursor()
  {
    TakePhotos();
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  public MediaItemInfo toImage(String paramString)
  {
    MediaItemInfo localMediaItemInfo = new MediaItemInfo();
    localMediaItemInfo.setId(0);
    localMediaItemInfo.setDataPath(paramString);
    if (!new File(localMediaItemInfo.getDataPath()).exists()) {
      return null;
    }
    paramString = new File(paramString);
    localMediaItemInfo.setFileName(paramString.getName());
    localMediaItemInfo.setFileSize(paramString.length());
    return localMediaItemInfo;
  }
  
  public VideoItemInfo toVideo(String paramString)
  {
    VideoItemInfo localVideoItemInfo = new VideoItemInfo();
    localVideoItemInfo.id = 0;
    localVideoItemInfo.dataPath = paramString;
    if (!new File(localVideoItemInfo.dataPath).exists()) {
      return null;
    }
    paramString = new File(paramString);
    localVideoItemInfo.fileName = paramString.getName();
    localVideoItemInfo.fileSize = paramString.length();
    return localVideoItemInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.aba.QMAbaActivity
 * JD-Core Version:    0.7.0.1
 */