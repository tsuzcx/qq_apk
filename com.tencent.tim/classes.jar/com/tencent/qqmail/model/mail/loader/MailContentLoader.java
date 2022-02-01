package com.tencent.qqmail.model.mail.loader;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.attachment.QMAttachManager;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.model.mail.watcher.DownloadImgWatcher;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.task.QMDownloadTask;
import com.tencent.qqmail.model.task.QMInlineImgDownloadTask;
import com.tencent.qqmail.model.task.QMTask;
import com.tencent.qqmail.model.task.QMTaskManager;
import com.tencent.qqmail.qmimagecache.ImageCompresser;
import com.tencent.qqmail.utilities.common.QMMailContentParser;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

public class MailContentLoader
{
  public static final String DATA_IMAGE = "data:image/";
  public static final String INLINE_TOKEN = "cid:";
  public static final String LOCAL_TOKEN = "file://";
  public static String TAG = "MailContentLoader";
  private DownloadImgWatcher downloadImgWatcher = new MailContentLoader.1(this);
  private boolean isUseCompress = true;
  public MailContentLoaderCallback mCallback = null;
  private Mail mMail;
  public int mMaxConcurrent = 8;
  private List<String> mSrcList;
  private List<QMTask> mTaskList;
  public QMTaskManager mTaskMgr = null;
  
  public MailContentLoader(Mail paramMail)
  {
    this.mMail = paramMail;
    init(null);
  }
  
  public MailContentLoader(Mail paramMail, List<String> paramList)
  {
    this.mMail = paramMail;
    init(paramList);
  }
  
  public MailContentLoader(Mail paramMail, boolean paramBoolean)
  {
    this(paramMail);
    this.isUseCompress = paramBoolean;
  }
  
  private String getOriginSrc(String paramString)
  {
    int i = 0;
    while (i < this.mSrcList.size())
    {
      String str = (String)this.mSrcList.get(i);
      if (StringEscapeUtils.unescapeHtml4(str).equals(paramString)) {
        return str;
      }
      i += 1;
    }
    return paramString;
  }
  
  private String getSendUrlCacheImagePath(String paramString)
  {
    ImageCompresser localImageCompresser = ImageCompresser.getInstance();
    String str;
    Object localObject;
    if (paramString.startsWith("cid:"))
    {
      str = SendMailHelper.removeInlineImgCid(paramString);
      paramString = ImageCompresser.getInstance().getCompressPath(str, 1);
      localObject = paramString;
      if (StringUtils.isBlank(paramString))
      {
        paramString = QMAttachManager.sharedInstance().getInlineImageMyDisk(str);
        localObject = paramString;
        if (this.isUseCompress)
        {
          localObject = paramString;
          if (!StringUtils.isEmpty(paramString))
          {
            localObject = paramString;
            if (!isGif(paramString))
            {
              localImageCompresser.compressImage(str, paramString, "", 1, null);
              localObject = paramString;
            }
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          if (paramString.startsWith("file://")) {
            return paramString.replace("file://localhost", "");
          }
          str = ImageCompresser.getInstance().getCompressPath(paramString, 1);
          localObject = str;
        } while (!StringUtils.isBlank(str));
        localObject = ImageDownloadManager.shareInstance().getThumbBitmapFromDiskCache(paramString);
        if (localObject == null) {
          break;
        }
        str = ((File)localObject).getAbsolutePath();
        localObject = str;
      } while (!this.isUseCompress);
      localObject = str;
    } while (isGif(str));
    localImageCompresser.compressImage(paramString, str, "", 1, null);
    return str;
    return "";
  }
  
  private QMTask getTaskInDownTaskList(QMTaskManager paramQMTaskManager, String paramString)
  {
    if (paramQMTaskManager == null) {
      return null;
    }
    paramQMTaskManager = paramQMTaskManager.getTaskList();
    if (paramQMTaskManager == null) {
      return null;
    }
    int i = QMDownloadTask.generateId(paramString);
    paramQMTaskManager = paramQMTaskManager.iterator();
    while (paramQMTaskManager.hasNext())
    {
      paramString = (QMTask)paramQMTaskManager.next();
      if (paramString.getId() == i) {
        return paramString;
      }
    }
    return null;
  }
  
  private void handleDownloadSuccess(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if ((this.isUseCompress) && (!paramBoolean) && (!isGif(paramString3)))
    {
      Threads.runInBackground(new MailContentLoader.3(this, paramString2, paramString3, paramString1));
      return;
    }
    Threads.runOnMainThread(new MailContentLoader.4(this, paramString1, paramString3));
  }
  
  private void init(List<String> paramList)
  {
    this.mTaskMgr = new QMTaskManager(2);
    this.mTaskMgr.setRunningTaskCount(this.mMaxConcurrent);
    Object localObject = paramList;
    if (paramList == null)
    {
      MailContent localMailContent = this.mMail.getContent();
      localObject = paramList;
      if (localMailContent != null)
      {
        localObject = paramList;
        if (!StringUtils.isEmpty(localMailContent.getBody())) {
          localObject = QMMailContentParser.findAllImages(localMailContent.getBody());
        }
      }
    }
    this.mSrcList = new ArrayList();
    if (localObject != null)
    {
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        if (!this.mSrcList.contains(localObject)) {
          this.mSrcList.add(localObject);
        }
      }
    }
  }
  
  private boolean isGif(String paramString)
  {
    return (!StringExtention.isNullOrEmpty(paramString)) && (FileUtil.getFileType(paramString).equals("gif"));
  }
  
  private boolean isImageCached(String paramString)
  {
    boolean bool2 = true;
    paramString = transformUrl(paramString);
    boolean bool1;
    if (paramString.startsWith("cid:")) {
      bool1 = QMAttachManager.sharedInstance().isMailInlineImageCached(SendMailHelper.removeInlineImgCid(paramString));
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramString.startsWith("file://"));
      bool1 = bool2;
    } while (ImageDownloadManager.shareInstance().isThumbBitmapExistLocal(paramString) != 0);
    return false;
  }
  
  public static boolean sameCid(Attach paramAttach, String paramString)
  {
    return StringUtils.equals(paramAttach.getProtocol().getCid(), SendMailHelper.removeInlineImgCid(paramString));
  }
  
  public static String transformUrl(String paramString)
  {
    return StringEscapeUtils.unescapeHtml4(paramString.replaceAll("#.*$", ""));
  }
  
  public void destroy()
  {
    try
    {
      this.mTaskMgr.cancelAll();
      if ((this.mTaskList != null) && (this.mTaskList.size() > 0))
      {
        int i = 0;
        while (i < this.mTaskList.size())
        {
          QMTask localQMTask = (QMTask)this.mTaskList.get(i);
          if ((localQMTask instanceof QMInlineImgDownloadTask)) {
            ((QMInlineImgDownloadTask)localQMTask).unbindDownloadImageWatcher(this.downloadImgWatcher);
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, TAG, "cancel taskManager fail:" + localException.toString());
      }
      this.mTaskList.clear();
      this.mTaskMgr = null;
      this.mCallback = null;
    }
  }
  
  public String getCacheImagePath(String paramString)
  {
    return getSendUrlCacheImagePath(transformUrl(paramString));
  }
  
  public HashMap<String, String> getDownloadedImageInfo()
  {
    HashMap localHashMap = new HashMap();
    if (this.mSrcList != null)
    {
      int i = 0;
      while (i < this.mSrcList.size())
      {
        String str1 = (String)this.mSrcList.get(i);
        String str2 = getCacheImagePath(str1);
        if (StringUtils.isEmpty(str2)) {
          localHashMap.put(transformUrl(str1), str2);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public boolean hasResource()
  {
    return (this.mSrcList != null) && (this.mSrcList.size() > 0);
  }
  
  public boolean hasResource(String paramString)
  {
    if ((this.mSrcList == null) || (this.mSrcList.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.mSrcList.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).indexOf(paramString) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isAllImageCached()
  {
    if (this.mSrcList != null)
    {
      int i = 0;
      while (i < this.mSrcList.size())
      {
        if (!isImageCached((String)this.mSrcList.get(i))) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void setCallback(MailContentLoaderCallback paramMailContentLoaderCallback)
  {
    this.mCallback = paramMailContentLoaderCallback;
  }
  
  public void start()
  {
    if ((this.mSrcList != null) && (this.mSrcList.size() > 0) && (this.mCallback != null))
    {
      QMLog.log(4, TAG, "start:" + this.mSrcList.size() + "; " + this.mMail.getInformation().getRemoteId());
      int i = this.mMail.getInformation().getAccountId();
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(i);
      if (localAccount != null) {
        QMLog.log(4, TAG, "account:" + localAccount.getProtocol() + "; " + localAccount.getEmail());
      }
      Threads.runInBackground(new MailContentLoader.2(this, this.mMail.getInformation().getAttachList()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.loader.MailContentLoader
 * JD-Core Version:    0.7.0.1
 */