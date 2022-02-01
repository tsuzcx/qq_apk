package com.tencent.qqmail.activity.webviewexplorer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.webkit.WebView.HitTestResult;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.fragment.base.MailFragment;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.fragment.base.BaseFragmentActivity;
import org.apache.commons.lang3.StringEscapeUtils;

public class InlineImageSaver
{
  public static final String SAVE_IMG_PATH = Environment.getExternalStorageDirectory() + "/tencent/Tim/QQmail/download";
  private final String TAG = InlineImageSaver.class.getSimpleName();
  private Activity activity = null;
  private QMBottomDialog.BottomListSheetBuilder builder = null;
  private ISaveToAlbumCallBack callback = null;
  private HashMap<String, String> mAllImageInfo = null;
  private String mChooseImagePath = "";
  private String mChooseImageSrc = "";
  private HashMap<String, String> mProtocolImageInfo = null;
  private HashMap<String, String> mQQMailImageInfo = null;
  private String mQRCodeResult;
  private boolean mShow;
  private HashMap<String, String> mWebviewImageInfo = null;
  
  public InlineImageSaver(String paramString, HashMap<String, String> paramHashMap, Activity paramActivity, ISaveToAlbumCallBack paramISaveToAlbumCallBack)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.mChooseImagePath = str;
    setAllImageInfo(paramHashMap);
    initChooseSrc();
    this.activity = paramActivity;
    this.builder = new QMBottomDialog.BottomListSheetBuilder(this.activity);
    this.callback = paramISaveToAlbumCallBack;
  }
  
  private void addDialogItemCopyImageLink()
  {
    this.builder.addItem(getString(2131692328), getString(2131692328));
  }
  
  private void addDialogItemOpenImageLink()
  {
    this.builder.addItem(getString(2131696657), getString(2131696657));
  }
  
  private void addDialogItemRecogniseQRCode()
  {
    this.builder.addItem(getString(2131717214), getString(2131717214));
  }
  
  private void addDialogItemSaveAllToAblum()
  {
    this.builder.addItem(getString(2131718921), getString(2131718921));
  }
  
  private void addDialogItemSaveToAblum()
  {
    this.builder.addItem(getString(2131718960), getString(2131718960));
  }
  
  @TargetApi(8)
  private String copyFileToAlbum(String paramString, File paramFile)
  {
    Object localObject1 = new File(SAVE_IMG_PATH);
    if (!FileUtil.tryMkdirs((File)localObject1)) {
      paramString = null;
    }
    Object localObject2;
    do
    {
      return paramString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File((String)localObject1);
      paramString = (String)localObject1;
    } while (((File)localObject2).exists());
    FileUtil.copyFile(paramFile, (File)localObject2);
    return localObject1;
  }
  
  private void doCopyLink(String paramString)
  {
    CommUtils.copyText(paramString);
  }
  
  private void doOpenLink(String paramString)
  {
    paramString = WebViewExplorer.createIntent(paramString, "", 0, false);
    this.activity.startActivity(paramString);
  }
  
  private void doSaveAllToAlbum()
  {
    Iterator localIterator;
    String str;
    if (this.mProtocolImageInfo != null)
    {
      localIterator = this.mProtocolImageInfo.keySet().iterator();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          str = (String)this.mProtocolImageInfo.get(str);
          trySaveToAlbum(generateName(), str);
        }
      }
    }
    if (this.mQQMailImageInfo != null)
    {
      localIterator = this.mQQMailImageInfo.keySet().iterator();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          str = (String)this.mQQMailImageInfo.get(str);
          trySaveToAlbum(generateName(), str);
        }
      }
    }
  }
  
  private void doSaveToAlbum(String paramString, File paramFile)
  {
    paramFile = copyFileToAlbum(paramString, paramFile);
    registerFileToContentResolver(this.activity, paramString, paramFile);
  }
  
  private void doSaveToAlbum(String paramString1, String paramString2)
  {
    paramString2 = copyFileToAlbum(paramString1, new File(paramString2));
    registerFileToContentResolver(this.activity, paramString1, paramString2);
  }
  
  private String generateName()
  {
    return new Date().getTime() + ".jpg";
  }
  
  private String getChooseSrc()
  {
    if ((this.mChooseImageSrc != null) && (!this.mChooseImageSrc.equals(""))) {
      return this.mChooseImageSrc;
    }
    initChooseSrc();
    return this.mChooseImageSrc;
  }
  
  private String getString(int paramInt)
  {
    return this.activity.getResources().getString(paramInt);
  }
  
  private void initChooseSrc()
  {
    if (this.mAllImageInfo != null)
    {
      Iterator localIterator = this.mAllImageInfo.keySet().iterator();
      if (localIterator != null) {
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((String)this.mAllImageInfo.get(str)).contains(this.mChooseImagePath)) {
            this.mChooseImageSrc = str;
          }
        }
      }
    }
  }
  
  private boolean isShowSaveAll()
  {
    if (isWebImage()) {
      return false;
    }
    if (this.mProtocolImageInfo != null) {}
    for (int i = this.mProtocolImageInfo.size() + 0;; i = 0)
    {
      int j = i;
      if (this.mQQMailImageInfo != null) {
        j = i + this.mQQMailImageInfo.size();
      }
      if (j <= 1) {
        break;
      }
      return true;
    }
  }
  
  private boolean isWebImage()
  {
    return (this.mWebviewImageInfo != null) && (this.mWebviewImageInfo.get(this.mChooseImageSrc) != null);
  }
  
  private void registerFileToContentResolver(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getContentResolver();
    ContentValues localContentValues = new ContentValues(4);
    localContentValues.put("title", paramString1);
    localContentValues.put("_display_name", paramString1);
    localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("mime_type", "image/jpg");
    localContentValues.put("orientation", Integer.valueOf(0));
    localContentValues.put("_data", paramString2);
    paramContext.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, localContentValues);
  }
  
  private void trySaveToAlbum(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("http"))
    {
      paramString2 = StringEscapeUtils.unescapeHtml4(paramString2);
      File localFile = ImageDownloadManager.shareInstance().getThumbBitmapFromDiskCache(StringEscapeUtils.unescapeHtml4(paramString2));
      if ((localFile != null) && (localFile.exists()))
      {
        doSaveToAlbum(paramString1, localFile);
        return;
      }
      Threads.runInBackground(new InlineImageSaver.2(this, paramString2, paramString1), 3000L);
      return;
    }
    doSaveToAlbum(paramString1, paramString2);
  }
  
  public void setAllImageInfo(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      this.mAllImageInfo = paramHashMap;
      if (this.mProtocolImageInfo == null)
      {
        this.mProtocolImageInfo = new HashMap();
        if (this.mQQMailImageInfo != null) {
          break label147;
        }
        this.mQQMailImageInfo = new HashMap();
        label45:
        if (this.mWebviewImageInfo != null) {
          break label157;
        }
        this.mWebviewImageInfo = new HashMap();
        label63:
        paramHashMap = this.mAllImageInfo.keySet().iterator();
        if (paramHashMap == null) {
          return;
        }
      }
      for (;;)
      {
        if (!paramHashMap.hasNext()) {
          return;
        }
        String str1 = (String)paramHashMap.next();
        String str2 = (String)this.mAllImageInfo.get(str1);
        if (CommonMatch.PROTOCOL_PATTERN.matcher(str1).find())
        {
          this.mProtocolImageInfo.put(str1, str2);
          continue;
          this.mProtocolImageInfo.clear();
          break;
          label147:
          this.mQQMailImageInfo.clear();
          break label45;
          label157:
          this.mWebviewImageInfo.clear();
          break label63;
        }
        if ((CommonMatch.QQMAIL_CGI_PATTERN.matcher(str1).find()) || (CommonMatch.QQMAIL_NOTE_CDN_PATTERN.matcher(str1).find())) {
          this.mQQMailImageInfo.put(str1, str2);
        } else {
          this.mWebviewImageInfo.put(str1, str2);
        }
      }
    }
  }
  
  public void setQRCodeResult(String paramString)
  {
    this.mQRCodeResult = paramString;
    if (this.mShow)
    {
      this.builder.addItem(getString(2131717214), getString(2131717214));
      this.builder.notifyDataSetChanged();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void show()
  {
    if (isWebImage())
    {
      addDialogItemOpenImageLink();
      addDialogItemCopyImageLink();
      QMLog.log(4, this.TAG, "Inline-image-save add-dialog-item open-and-copy-link");
    }
    addDialogItemSaveToAblum();
    if (isShowSaveAll())
    {
      addDialogItemSaveAllToAblum();
      QMLog.log(4, this.TAG, "Inline-image-save add-dialog-item save-all");
    }
    if (this.mQRCodeResult != null) {
      addDialogItemRecogniseQRCode();
    }
    if ((((this.activity instanceof BaseActivity)) && (!((BaseActivity)this.activity).isDestroyed())) || (((this.activity instanceof BaseFragmentActivity)) && ((((BaseFragmentActivity)this.activity).getCurrentFragment() instanceof MailFragment))))
    {
      this.builder.setOnSheetItemClickListener(new InlineImageSaver.1(this));
      this.builder.build().show();
      this.mShow = true;
    }
  }
  
  public static abstract interface ISaveToAlbumCallBack
  {
    public abstract void handleSaveImageByType(HashMap<String, String> paramHashMap, WebView.HitTestResult paramHitTestResult, int paramInt1, int paramInt2);
    
    public abstract void onBeforeSaved();
    
    public abstract void onCompleteSaved();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.InlineImageSaver
 * JD-Core Version:    0.7.0.1
 */