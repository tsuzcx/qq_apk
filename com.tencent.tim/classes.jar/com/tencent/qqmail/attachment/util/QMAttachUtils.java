package com.tencent.qqmail.attachment.util;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.primitives.Longs;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.activity.compose.ComposeMailView;
import com.tencent.qqmail.activity.media.MediaItemInfo;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.ftn.FtnLogicStorage;
import com.tencent.qqmail.ftn.model.FtnComposeInfo;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.QMIndexCounter;
import com.tencent.qqmail.utilities.dateextension.DateExtension;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.imageextention.QMImageLoader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class QMAttachUtils
{
  public static final String AFTER_ADD_ATTACHS = "afterAddAttachs";
  private static final long ORIENTED_IMAGE_MAX_SIZE = 524288L;
  private static final String TAG = "QMAttachUtils";
  public static HashMap<String, String> attachFileType = null;
  
  public static boolean ableToPreview(AttachInfo paramAttachInfo)
  {
    if (paramAttachInfo.isTraceLog()) {
      return false;
    }
    String str = paramAttachInfo.getAttachPostFix();
    if (paramAttachInfo.getAttach() != null)
    {
      paramAttachInfo = ((Attach)paramAttachInfo.getAttach()).getPreview().getMyDisk();
      label35:
      if (!FileUtil.isFileExist(paramAttachInfo)) {
        break label66;
      }
      if ((FileUtil.isSuffixEml(str)) || (isApkFile(str))) {
        break label68;
      }
    }
    label66:
    label68:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramAttachInfo = paramAttachInfo.getAttachPath();
      break label35;
      break;
    }
  }
  
  public static List<AttachInfo> addAttachWithPath(String paramString, boolean paramBoolean, ComposeMailUI paramComposeMailUI)
  {
    AttachInfo localAttachInfo = buildAttachWithPath(paramString, paramBoolean, paramComposeMailUI);
    if (localAttachInfo == null) {
      return null;
    }
    paramComposeMailUI.setForceSync(false);
    QMLog.log(4, "addAttachWithPath ", "add file path = " + paramString);
    paramString = new ArrayList();
    paramString.add(localAttachInfo);
    handleAddAttach(paramString, paramComposeMailUI);
    return paramString;
  }
  
  public static List<AttachInfo> addAttachWithPathList(ArrayList<String> paramArrayList, boolean paramBoolean, ComposeMailUI paramComposeMailUI)
  {
    paramArrayList = buildAttachWithPaths(paramArrayList, paramBoolean, paramComposeMailUI);
    if (paramArrayList.size() > 0)
    {
      paramComposeMailUI.setForceSync(false);
      handleAddAttach(paramArrayList, paramComposeMailUI);
      return paramArrayList;
    }
    return null;
  }
  
  private static void addAttachs(List<AttachInfo> paramList, int paramInt, ComposeMailUI paramComposeMailUI)
  {
    ArrayList localArrayList1 = paramComposeMailUI.getAddAttachInfoList();
    if (localArrayList1 == null)
    {
      localArrayList1 = new ArrayList();
      paramComposeMailUI.setAddAttachInfoList(localArrayList1);
    }
    for (;;)
    {
      ArrayList localArrayList2 = paramComposeMailUI.getTotalAttachInfoList();
      if (localArrayList2 == null)
      {
        localArrayList2 = new ArrayList();
        paramComposeMailUI.setTotalAttachInfoList(localArrayList2);
      }
      for (;;)
      {
        ArrayList localArrayList3 = new ArrayList();
        long l1 = FileUtil.getSdcardAllSpace();
        Iterator localIterator = paramList.iterator();
        Object localObject1;
        if (localIterator.hasNext())
        {
          localObject1 = (AttachInfo)localIterator.next();
          Object localObject2 = localArrayList1.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            AttachInfo localAttachInfo = (AttachInfo)((Iterator)localObject2).next();
            if ((localAttachInfo.getAbsAttachPath() != null) && (!"".equals(localAttachInfo.getAbsAttachPath())) && (localAttachInfo.getAbsAttachPath().equals(((AttachInfo)localObject1).getAbsAttachPath())))
            {
              localObject2 = "" + localAttachInfo.getAttachName() + "已添加";
              Toast.makeText(QMApplicationContext.sharedInstance(), (CharSequence)localObject2, 0).show();
            }
          }
        }
        for (int i = 1;; i = 0)
        {
          long l2 = l1;
          long l3;
          if (i == 0)
          {
            if (!FileUtil.isFileExist(((AttachInfo)localObject1).getAttachPath()))
            {
              localArrayList3.add(localObject1);
              localObject1 = ((AttachInfo)localObject1).getAttachName();
              if ((localObject1 != null) && (!"".equals(localObject1))) {}
              for (localObject1 = "附件" + (String)localObject1 + "不存在,无法添加!";; localObject1 = "附件不存在,无法添加!")
              {
                Toast.makeText(QMApplicationContext.sharedInstance(), (CharSequence)localObject1, 0).show();
                break;
              }
            }
            l3 = FileUtil.getFileSize(((AttachInfo)localObject1).getAttachPath());
            if (l1 > 52428800L)
            {
              l2 = 52428800L;
              label330:
              if (((l3 <= 0L) || (l3 >= l2)) && ((!isWithinFtnSizeRange(l3)) || (!((AttachInfo)localObject1).isNeedFtnUpload())) && (AccountManager.shareInstance().getAccountList().hasQQMailAccounts())) {
                break label469;
              }
              l1 -= l3;
              ((AttachInfo)localObject1).setHashId(Attach.generateHashId(paramComposeMailUI.getComposeDate(), String.valueOf(((AttachInfo)localObject1).getRealSize()), ((AttachInfo)localObject1).getAttachName()));
              if (paramInt < 0) {
                break label458;
              }
              localArrayList1.add(paramInt, localObject1);
            }
            for (;;)
            {
              localArrayList2.add(localObject1);
              l2 = l1;
              if (!isSameNameWithOldFwdAttach(((AttachInfo)localObject1).getAttachName(), paramComposeMailUI)) {
                break label583;
              }
              ((AttachInfo)localObject1).setIsNewSameName(true);
              break;
              l2 = l1;
              break label330;
              label458:
              localArrayList1.add(localObject1);
            }
            label469:
            if (l3 < 52428800L) {
              break label590;
            }
            Toast.makeText(QMApplicationContext.sharedInstance(), "" + ((AttachInfo)localObject1).getAttachName() + "超过50M, 建议先添加到QQ中转站后再添加", 0).show();
          }
          for (;;)
          {
            QMLog.log(6, "QMAttachUtils", "add attach fail " + ((AttachInfo)localObject1).getAttachName() + " fileSize " + l3 + " maxAttachSize " + l2);
            localArrayList3.add(localObject1);
            l2 = l1;
            label583:
            l1 = l2;
            break;
            label590:
            if (l3 > l2) {
              Toast.makeText(QMApplicationContext.sharedInstance(), "没有足够的拷贝空间, " + ((AttachInfo)localObject1).getAttachName() + "无法添加", 0).show();
            }
          }
          paramList.removeAll(localArrayList3);
          QMNotification.postNotification("afterAddAttachs", paramList);
          return;
        }
      }
    }
  }
  
  private static void addAttachs(List<AttachInfo> paramList, ComposeMailUI paramComposeMailUI)
  {
    addAttachs(paramList, -1, paramComposeMailUI);
  }
  
  public static boolean addRotateInfo(AttachInfo paramAttachInfo)
  {
    return true;
  }
  
  public static String attachFileType(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      paramString = "OTHERS";
    }
    Object localObject;
    do
    {
      return paramString;
      paramString = paramString.toLowerCase();
      if (attachFileType == null)
      {
        attachFileType = new HashMap();
        localObject = new String[79];
        localObject[0] = "zip";
        localObject[1] = "rar";
        localObject[2] = "7z";
        localObject[3] = "gz";
        localObject[4] = "bz2";
        localObject[5] = "tar";
        localObject[6] = "xls";
        localObject[7] = "xlsx";
        localObject[8] = "xlt";
        localObject[9] = "xltx";
        localObject[10] = "et";
        localObject[11] = "csv";
        localObject[12] = "xlsm";
        localObject[13] = "ett";
        localObject[14] = "doc";
        localObject[15] = "wps";
        localObject[16] = "docx";
        localObject[17] = "dot";
        localObject[18] = "dotx";
        localObject[19] = "docm";
        localObject[20] = "rtf";
        localObject[21] = "wpt";
        localObject[22] = "ppt";
        localObject[23] = "pptx";
        localObject[24] = "pot";
        localObject[25] = "potx";
        localObject[26] = "dps";
        localObject[27] = "pps";
        localObject[28] = "pptm";
        localObject[29] = "dpt";
        localObject[30] = "psd";
        localObject[31] = "html";
        localObject[32] = "htm";
        localObject[33] = "pdf";
        localObject[34] = "flash";
        localObject[35] = "eml";
        localObject[36] = "txt";
        localObject[37] = "xml";
        localObject[38] = "ini";
        localObject[39] = "cpp";
        localObject[40] = "c";
        localObject[41] = "java";
        localObject[42] = "m";
        localObject[43] = "h";
        localObject[44] = "plist";
        localObject[45] = "stp";
        localObject[46] = "mp3";
        localObject[47] = "amr";
        localObject[48] = "wma";
        localObject[49] = "wav";
        localObject[50] = "m4a";
        localObject[51] = "aiff";
        localObject[52] = "mp4";
        localObject[53] = "avi";
        localObject[54] = "rm";
        localObject[55] = "rmvb";
        localObject[56] = "wmv";
        localObject[57] = "mkv";
        localObject[58] = "swf";
        localObject[59] = "flv";
        localObject[60] = "mpg";
        localObject[61] = "mov";
        localObject[62] = "3gp";
        localObject[63] = "m4v";
        localObject[64] = "jpeg";
        localObject[65] = "jpg";
        localObject[66] = "png";
        localObject[67] = "gif";
        localObject[68] = "bmp";
        localObject[69] = "tif";
        localObject[70] = "tiff";
        localObject[71] = "ico";
        localObject[72] = "wps";
        localObject[73] = "dps";
        localObject[74] = "et";
        localObject[75] = "knt";
        localObject[76] = "pages";
        localObject[77] = "numbers";
        localObject[78] = "ics";
        while (i < localObject.length)
        {
          attachFileType.put(localObject[i], new String[] { "COMPRESS", "COMPRESS", "COMPRESS", "COMPRESS", "COMPRESS", "COMPRESS", "EXCEL", "EXCEL", "EXCEL", "EXCEL", "EXCEL", "EXCEL", "EXCEL", "EXCEL", "WORD", "WORD", "WORD", "WORD", "WORD", "WORD", "WORD", "WORD", "PPT", "PPT", "PPT", "PPT", "PPT", "PPT", "PPT", "PPT", "PSD", "HTML", "HTML", "PDF", "FLASH", "EML", "TXT", "TXT", "TXT", "TXT", "TXT", "TXT", "TXT", "TXT", "TXT", "TXT", "AUDIO", "AUDIO", "AUDIO", "AUDIO", "AUDIO", "AUDIO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "VIDEO", "IMAGE", "IMAGE", "IMAGE", "IMAGE", "IMAGE", "IMAGE", "IMAGE", "IMAGE", "WORD", "PPT", "EXCEL", "KEYNOTE", "PAGES", "NUMBERS", "ICS" }[i]);
          i += 1;
        }
      }
      localObject = (String)attachFileType.get(paramString);
      if (paramString == null) {
        break;
      }
      paramString = (String)localObject;
    } while (localObject != null);
    return "OTHERS";
  }
  
  public static FtnComposeInfo attachInfo2FtnComposeInfo(AttachInfo paramAttachInfo)
  {
    if (!paramAttachInfo.isBigAttach()) {
      return null;
    }
    FtnComposeInfo localFtnComposeInfo = new FtnComposeInfo();
    if ((paramAttachInfo.getAttach() instanceof MailBigAttach))
    {
      MailBigAttach localMailBigAttach = (MailBigAttach)paramAttachInfo.getAttach();
      localFtnComposeInfo.setMailAttach(localMailBigAttach);
      localFtnComposeInfo.setFid(localMailBigAttach.getFid());
    }
    localFtnComposeInfo.setThumbUrl(paramAttachInfo.getThumbnailPath());
    return localFtnComposeInfo;
  }
  
  public static MediaItemInfo attachInfo2MediaItemInfo(AttachInfo paramAttachInfo)
  {
    if (paramAttachInfo == null) {
      return null;
    }
    MediaItemInfo localMediaItemInfo = new MediaItemInfo();
    localMediaItemInfo.setDataPath(paramAttachInfo.getAbsAttachPath());
    localMediaItemInfo.setFileName(paramAttachInfo.getAttachName());
    localMediaItemInfo.setFileSize(paramAttachInfo.getRealSize());
    localMediaItemInfo.setOriDataPath(paramAttachInfo.getOriAbsAttachPath());
    Log.d("QMAttachUtils", "attachInfo2MediaItemInfo getOriDataPath:" + localMediaItemInfo.getOriDataPath() + ", getDataPath:" + localMediaItemInfo.getDataPath());
    return localMediaItemInfo;
  }
  
  public static void attachOpenOssLog(String paramString1, String paramString2)
  {
    if ((!StringExtention.isNullOrEmpty(paramString2)) && (new File(paramString2).exists())) {}
  }
  
  private static AttachInfo buildAttachWithPath(String paramString, boolean paramBoolean, ComposeMailUI paramComposeMailUI)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return null;
    }
    if (paramComposeMailUI == null)
    {
      QMLog.log(6, "QMAttachUtils", "addAttachWithPath. composemail is null");
      return null;
    }
    if (paramComposeMailUI.getAddAttachInfoList() != null)
    {
      localObject = paramComposeMailUI.getAddAttachInfoList().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localAttachInfo = (AttachInfo)((Iterator)localObject).next();
        if (paramString.equals(localAttachInfo.getAbsAttachPath()))
        {
          Toast.makeText(QMApplicationContext.sharedInstance(), "" + localAttachInfo.getAttachName() + " 已添加", 0).show();
          return null;
        }
      }
    }
    AttachInfo localAttachInfo = new AttachInfo();
    localAttachInfo.setAttachPath(paramString);
    localAttachInfo.setAbsAttachPath(paramString);
    Object localObject = paramString.split(File.separator);
    if (localObject.length > 0) {}
    for (localObject = localObject[(localObject.length - 1)];; localObject = "file")
    {
      localAttachInfo.setAttachName((String)localObject);
      if ((paramBoolean) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FEED_BACK)) {
        localAttachInfo.setNewAdded(false);
      }
      localAttachInfo.setFromOtherApp(paramBoolean);
      long l = FileUtil.getFileSize(paramString);
      localAttachInfo.setRealSize(l);
      if (FileUtil.isImageSuffix(FileUtil.getFileNameSuffix(localAttachInfo.getAttachName()))) {
        localAttachInfo.setFileType(AttachType.IMAGE);
      }
      if ((paramBoolean) && (AccountManager.shareInstance().getAccountList().hasQQMailAccounts()) && (isWithinFtnSizeRange(l)))
      {
        localAttachInfo.setNeedFtnUpload(true);
        localAttachInfo.setBigAttach(true);
      }
      return localAttachInfo;
    }
  }
  
  @NonNull
  public static List<AttachInfo> buildAttachWithPaths(List<String> paramList, boolean paramBoolean, ComposeMailUI paramComposeMailUI)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      AttachInfo localAttachInfo = buildAttachWithPath(str, paramBoolean, paramComposeMailUI);
      if (localAttachInfo != null)
      {
        QMLog.log(4, "addAttachWithPath ", "add file path = " + str);
        localArrayList.add(localAttachInfo);
      }
    }
    return localArrayList;
  }
  
  public static int calcImageRealSizeForAttachInfo(AttachInfo paramAttachInfo, ComposeMailUI paramComposeMailUI)
  {
    double d1 = paramAttachInfo.getRealSize();
    double d2 = ComposeMailUI.ImageScaleDegree.getRatio(paramComposeMailUI.getImageScale()) * 10.0F;
    if ((int)(d2 - 3.0D) == 0) {
      d1 = paramAttachInfo.getLowSize();
    }
    for (;;)
    {
      return (int)d1;
      if ((int)(d2 - 5.0D) == 0) {
        d1 = paramAttachInfo.getMiddleSize();
      } else if ((int)(d2 - 8.0D) == 0) {
        d1 = paramAttachInfo.getHighSize();
      }
    }
  }
  
  private static String checkAttachComposePathValid(AttachInfo paramAttachInfo, String paramString)
  {
    String str2 = paramAttachInfo.getAttachName();
    String str1 = paramString;
    Object localObject = str2;
    int i = 0;
    while (FileUtil.isFileExist(str1))
    {
      int j = str2.lastIndexOf('.');
      if (j > 0)
      {
        localObject = new StringBuilder().append(str2.substring(0, j)).append("[");
        i += 1;
      }
      for (localObject = i + "]" + str2.substring(j);; localObject = i + "]")
      {
        j = paramString.lastIndexOf('.');
        if (j <= 0) {
          break label193;
        }
        str1 = paramString.substring(0, j) + "[" + i + "]" + paramString.substring(j);
        break;
        localObject = new StringBuilder().append(str2).append("[");
        i += 1;
      }
      label193:
      str1 = paramString + "[" + i + "]";
    }
    paramAttachInfo.setAttachName((String)localObject);
    return str1;
  }
  
  public static AttachInfo favAttach2AttachInfo(Attach paramAttach)
  {
    String str1 = paramAttach.getSize();
    String str2 = paramAttach.getName();
    String str3 = FileUtil.getFileNameSuffix(str2);
    AttachInfo localAttachInfo = new AttachInfo();
    localAttachInfo.setForwardAttach(true);
    localAttachInfo.setHashId(paramAttach.getHashId());
    localAttachInfo.setProtocolAttach(paramAttach.isProtocol());
    localAttachInfo.setProcessed(true);
    localAttachInfo.setNewAdded(true);
    localAttachInfo.setAttach(paramAttach);
    localAttachInfo.setAttachName(str2);
    localAttachInfo.setAttachSize(str1);
    localAttachInfo.setFileType(AttachType.valueOf(attachFileType(str3)));
    localAttachInfo.setPreviewPath(paramAttach.getPreview().getDownloadUrl());
    localAttachInfo.setIsFromFav(true);
    return localAttachInfo;
  }
  
  @NonNull
  private static ArrayList<AttachInfo> filterSameFavAttaches(ArrayList<AttachInfo> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList1 = paramArrayList1.iterator();
    for (;;)
    {
      if (!paramArrayList1.hasNext()) {
        return localArrayList;
      }
      Long localLong = (Long)paramArrayList1.next();
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        AttachInfo localAttachInfo = (AttachInfo)localIterator.next();
        if ((!localAttachInfo.isFromFav()) || (localAttachInfo.getHashId() != localLong.longValue())) {
          break;
        }
        paramArrayList1.remove();
        localArrayList.add(localAttachInfo);
      }
    }
    return localArrayList;
  }
  
  @Nullable
  private static void filterTheSameInfos(ArrayList<FtnComposeInfo> paramArrayList, ArrayList<AttachInfo> paramArrayList1, ArrayList<String> paramArrayList2, ComposeMailUI paramComposeMailUI)
  {
    paramComposeMailUI = paramComposeMailUI.getAddAttachInfoList();
    if (paramComposeMailUI == null) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FtnComposeInfo localFtnComposeInfo = (FtnComposeInfo)paramArrayList.next();
        if (localFtnComposeInfo.getMailAttach() != null)
        {
          AttachInfo localAttachInfo = hasAdded(paramComposeMailUI, localFtnComposeInfo);
          if (localAttachInfo != null)
          {
            paramArrayList1.add(localAttachInfo);
            paramArrayList2.add(localFtnComposeInfo.getMailAttach().getFid());
            paramArrayList.remove();
          }
        }
      }
    }
  }
  
  public static String generateUploadFileName(AttachInfo paramAttachInfo)
  {
    String str = "jpg";
    if (paramAttachInfo != null)
    {
      str = paramAttachInfo.getAttachName();
      if (StringExtention.isNullOrEmpty(str)) {
        break label82;
      }
    }
    label82:
    for (str = FileUtil.getFileNameSuffix(str);; str = FileUtil.getFileNameSuffix(paramAttachInfo.getAttachPath()))
    {
      paramAttachInfo = QMIndexCounter.shareInstance().getFileIndex();
      paramAttachInfo = DateExtension.currentTimeString_MMdd() + '_' + paramAttachInfo;
      return paramAttachInfo + '.' + str;
    }
  }
  
  public static String getOriginAttachName(AttachInfo paramAttachInfo)
  {
    if ((paramAttachInfo.getAttachPath() != null) && (!paramAttachInfo.getAttachPath().contains(paramAttachInfo.getAttachName())))
    {
      int i = paramAttachInfo.getAttachPath().lastIndexOf(File.separator);
      if ((i > 0) && (paramAttachInfo.getAttachPath().length() > i)) {
        return paramAttachInfo.getAttachPath().substring(i, paramAttachInfo.getAttachPath().length());
      }
    }
    return paramAttachInfo.getAttachName();
  }
  
  public static int getPreviewType(Context paramContext, String paramString)
  {
    if (IntentUtil.canDisplayBySelf(paramString)) {
      return 0;
    }
    if (IntentUtil.canDisplayByOtherApp(paramContext, paramString)) {
      return 1;
    }
    return 2;
  }
  
  public static Bitmap getThumbnail(AttachInfo paramAttachInfo)
  {
    if (paramAttachInfo == null) {
      return null;
    }
    Object localObject1 = paramAttachInfo.getThumbnailData();
    if ((localObject1 instanceof Bitmap))
    {
      localObject2 = (Bitmap)localObject1;
      localObject1 = localObject2;
      if (((Bitmap)localObject2).isRecycled()) {
        paramAttachInfo.setThumbnailData(null);
      }
    }
    else
    {
      localObject1 = null;
    }
    String str = paramAttachInfo.getThumbnailPath();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      if (paramAttachInfo.getFileType() != AttachType.IMAGE)
      {
        localObject2 = localObject1;
        if (paramAttachInfo.getFileType() != AttachType.VIDEO) {}
      }
      else
      {
        localObject2 = localObject1;
        if (paramAttachInfo.isProcessed()) {
          localObject2 = ImageUtil.memSafeScaleImage(str, 1, 1.0F);
        }
      }
    }
    return localObject2;
  }
  
  @TargetApi(11)
  public static long goToDownload(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    for (;;)
    {
      long l;
      try
      {
        int i = QMApplicationContext.sharedInstance().getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        if ((i != 2) && (i != 3)) {
          if (i != 4) {
            break label150;
          }
        }
      }
      catch (Exception paramContext)
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), "找不到下载应用", 0).show();
        return -1L;
      }
      try
      {
        paramString2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        paramString2.setData(Uri.parse("package:" + "com.android.providers.downloads"));
        paramString2.addFlags(268435456);
        QMLog.log(5, "QMAttachUtils", "download app not started");
        Toast.makeText(QMApplicationContext.sharedInstance(), "请启动下载应用", 0).show();
        QMApplicationContext.sharedInstance().startActivity(paramString2);
        l = -1L;
      }
      catch (Exception paramString2)
      {
        tryBrowserDownload(paramContext, paramString1);
        l = -1L;
        continue;
      }
      return l;
      label150:
      if (Integer.parseInt(Build.VERSION.SDK) >= 9)
      {
        if ((paramString3 == null) && (Integer.parseInt(Build.VERSION.SDK) <= 11))
        {
          QMLog.log(4, "QMAttachUtils", "goToDownload. api<=11. try download with browser.");
          tryBrowserDownload(paramContext, paramString1);
          return -1L;
        }
        Object localObject;
        try
        {
          localObject = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS;
          if (FileUtil.hasSdcard())
          {
            FileUtil.tryMkdirs(new File((String)localObject));
            String str = paramString2;
            if (Integer.parseInt(Build.VERSION.SDK) < 11)
            {
              str = paramString2;
              if (new File((String)localObject + File.separator + paramString2).exists()) {
                str = FileUtil.uniqueFileName(paramString2, (String)localObject + File.separator);
              }
            }
            paramString2 = (DownloadManager)paramContext.getSystemService("download");
            localObject = new DownloadManager.Request(Uri.parse(paramString1));
            if (Integer.parseInt(Build.VERSION.SDK) >= 11) {
              ((DownloadManager.Request)localObject).setNotificationVisibility(1);
            }
            ((DownloadManager.Request)localObject).setAllowedNetworkTypes(3);
            ((DownloadManager.Request)localObject).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str);
            if (paramString3 != null) {
              ((DownloadManager.Request)localObject).addRequestHeader("Cookie", paramString3);
            }
            if (paramInt != 0) {
              break label480;
            }
            l = paramString2.enqueue((DownloadManager.Request)localObject);
            continue;
          }
          QMUIHelper.showToast(paramContext, 2131719259, "");
          return -1L;
        }
        catch (Exception paramString2)
        {
          QMLog.log(6, "QMAttachUtils", "goToDownload err:" + paramString2.toString() + ". try download with browser.");
          tryBrowserDownload(paramContext, paramString1);
          l = -1L;
        }
        continue;
        label480:
        if (paramInt == 2) {
          l = paramString2.enqueue((DownloadManager.Request)localObject);
        } else {
          try
          {
            ((DownloadManager.Request)localObject).setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "qqmail.apk");
            l = paramString2.enqueue((DownloadManager.Request)localObject);
          }
          catch (Exception paramString3)
          {
            for (;;)
            {
              QMUIHelper.showToast(paramContext, 2131719246, "");
            }
          }
        }
      }
      else
      {
        tryBrowserDownload(paramContext, paramString1);
        l = -1L;
      }
    }
  }
  
  public static List<AttachInfo> handelRemoveAlbumAttach(List<AttachInfo> paramList, ComposeMailUI paramComposeMailUI, ComposeMailView paramComposeMailView)
  {
    Object localObject1 = paramList;
    if (paramList == null) {
      localObject1 = new ArrayList();
    }
    Object localObject2 = paramComposeMailUI.getAddAttachInfoList();
    if (localObject2 == null) {
      return Collections.EMPTY_LIST;
    }
    if (paramComposeMailUI.getTotalAttachInfoList() == null) {
      return Collections.EMPTY_LIST;
    }
    paramList = new ArrayList();
    paramComposeMailUI = ((ArrayList)localObject2).iterator();
    while (paramComposeMailUI.hasNext())
    {
      localObject2 = (AttachInfo)paramComposeMailUI.next();
      if (isFromAlbum((AttachInfo)localObject2)) {
        paramList.add(localObject2);
      }
    }
    paramComposeMailUI = ((List)localObject1).iterator();
    while (paramComposeMailUI.hasNext())
    {
      localObject1 = (AttachInfo)paramComposeMailUI.next();
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AttachInfo localAttachInfo = (AttachInfo)((Iterator)localObject2).next();
        if (((AttachInfo)localObject1).getAbsAttachPath().equals(localAttachInfo.getAbsAttachPath()))
        {
          paramComposeMailUI.remove();
          ((Iterator)localObject2).remove();
        }
        else if ((!TextUtils.isEmpty(((AttachInfo)localObject1).getOriAbsAttachPath())) && ((((AttachInfo)localObject1).getOriAbsAttachPath().equals(localAttachInfo.getAbsAttachPath())) || (((AttachInfo)localObject1).getOriAbsAttachPath().equals(localAttachInfo.getOriAbsAttachPath()))) && (localAttachInfo.isRename()))
        {
          String str = localAttachInfo.getAttachName();
          renameAttachInfo(System.currentTimeMillis() + "_" + str, localAttachInfo, paramComposeMailView);
          ((AttachInfo)localObject1).setAttachName(str);
          ((AttachInfo)localObject1).setRename(true);
        }
      }
    }
    return paramList;
  }
  
  public static List<AttachInfo> handelRemoveAttachWithPahs(List<String> paramList, ComposeMailUI paramComposeMailUI)
  {
    Object localObject1 = paramComposeMailUI.getAddAttachInfoList();
    if (localObject1 == null) {
      return Collections.EMPTY_LIST;
    }
    if (paramComposeMailUI.getTotalAttachInfoList() == null) {
      return Collections.EMPTY_LIST;
    }
    paramComposeMailUI = paramList;
    if (paramList == null) {
      paramComposeMailUI = new ArrayList();
    }
    paramList = new ArrayList();
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)((Iterator)localObject2).next();
      if (paramComposeMailUI.contains(localAttachInfo.getAbsAttachPath()))
      {
        paramComposeMailUI.remove(localAttachInfo.getAbsAttachPath());
        paramList.add(localAttachInfo);
        if (localAttachInfo.isNeedFtnUpload()) {
          Toast.makeText(QMApplicationContext.sharedInstance(), "" + localAttachInfo.getAttachName() + " 已添加", 0).show();
        }
      }
    }
    paramComposeMailUI = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AttachInfo)((Iterator)localObject1).next();
      if (isFromSystemFileExplorer((AttachInfo)localObject2)) {
        paramComposeMailUI.add(localObject2);
      }
    }
    paramComposeMailUI.removeAll(paramList);
    return paramComposeMailUI;
  }
  
  public static void handleAddAttach(List<AttachInfo> paramList, ComposeMailUI paramComposeMailUI)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    addAttachs((List)localObject, paramComposeMailUI);
  }
  
  public static long[] handleRemoveFromFavAttachment(long[] paramArrayOfLong, ArrayList<AttachInfo> paramArrayList, Runnable paramRunnable)
  {
    if (paramArrayOfLong == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    if (unselectFavAttaches(paramArrayList, filterSameFavAttaches(paramArrayList, localArrayList)).size() > 0) {
      paramRunnable.run();
    }
    return Longs.toArray(localArrayList);
  }
  
  public static AttachInfo hasAdded(ArrayList<AttachInfo> paramArrayList, FtnComposeInfo paramFtnComposeInfo)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)paramArrayList.next();
      if ((localAttachInfo.getFid() != null) && (localAttachInfo.getFid().equals(paramFtnComposeInfo.getMailAttach().getFid()))) {
        return localAttachInfo;
      }
    }
    return null;
  }
  
  public static void insertAttach(AttachInfo paramAttachInfo, int paramInt, ComposeMailUI paramComposeMailUI)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAttachInfo);
    addAttachs(localArrayList, paramInt, paramComposeMailUI);
  }
  
  public static boolean isAddToSandBox(AttachInfo paramAttachInfo, String paramString, ArrayList<AttachInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramString = paramArrayList.iterator();
    while (paramString.hasNext())
    {
      paramArrayList = (AttachInfo)paramString.next();
      if ((!"".equals(paramArrayList.getAbsAttachPath())) && (paramArrayList.getAbsAttachPath().equals(paramAttachInfo.getAbsAttachPath())) && (paramArrayList.getAttachPath() != null) && (!paramArrayList.getAttachPath().equals(paramArrayList.getAbsAttachPath())) && (FileUtil.isFileExist(paramArrayList.getAttachPath())))
      {
        paramAttachInfo.setCanCopyToSandBox(paramArrayList.canCopyToSandBox());
        paramAttachInfo.setAttachPath(paramArrayList.getAttachPath());
        paramAttachInfo.setAttachName(paramArrayList.getAttachName());
        paramAttachInfo.estimateAndSetSizeByRealSize(paramArrayList.getRealSize());
        return true;
      }
    }
    return false;
  }
  
  private static boolean isApkFile(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "apk";
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < arrayOfString.length)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isAttachVirtual(Attach paramAttach)
  {
    if (paramAttach == null) {}
    do
    {
      return true;
      paramAttach = paramAttach.getSize();
    } while ((notEmpty(paramAttach)) && (paramAttach.equals("0.00B")));
    return false;
  }
  
  public static boolean isFromAlbum(AttachInfo paramAttachInfo)
  {
    return (isFromSystemFileExplorer(paramAttachInfo)) && ((paramAttachInfo.isImage()) || (paramAttachInfo.isVideo()));
  }
  
  public static boolean isFromSystemFileExplorer(AttachInfo paramAttachInfo)
  {
    return (paramAttachInfo.isBinaryAttach()) && (!paramAttachInfo.isFromFav());
  }
  
  private static boolean isSameNameWithOldFwdAttach(String paramString, ComposeMailUI paramComposeMailUI)
  {
    if ((paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY) || (paramComposeMailUI.getType() == ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL)) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    paramComposeMailUI = paramComposeMailUI.getOriginAttachList();
    if (paramComposeMailUI != null)
    {
      paramComposeMailUI = paramComposeMailUI.iterator();
      while (paramComposeMailUI.hasNext()) {
        if (paramString.equals(((Attach)paramComposeMailUI.next()).getName())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isSizeAutoDownload(long paramLong)
  {
    if (QMNetworkUtils.isWifiConnected())
    {
      if (paramLong > 10485760L) {}
    }
    else {
      do
      {
        return true;
        if (!QMNetworkUtils.isMobileConnected()) {
          break;
        }
      } while (paramLong <= 2097152L);
    }
    while (QMNetworkUtils.isNetworkConnected()) {
      return false;
    }
    return true;
  }
  
  public static boolean isSuffixImage(String paramString)
  {
    return AttachType.valueOf(attachFileType(paramString)).name().toLowerCase(Locale.getDefault()).equals("image");
  }
  
  private static boolean isWithinFtnSizeRange(long paramLong)
  {
    return (paramLong >= 52428800L) && (paramLong < 2147483648L);
  }
  
  public static AttachInfo mediaItemInfo2AttachInfo(MediaItemInfo paramMediaItemInfo)
  {
    if (paramMediaItemInfo == null) {
      return null;
    }
    AttachInfo localAttachInfo = new AttachInfo();
    localAttachInfo.setAttachPath(paramMediaItemInfo.getDataPath());
    localAttachInfo.setAbsAttachPath(paramMediaItemInfo.getDataPath());
    localAttachInfo.setAttachName(paramMediaItemInfo.getFileName());
    localAttachInfo.setRealSize(paramMediaItemInfo.getFileSize());
    Bitmap localBitmap = QMImageLoader.getInstance().loadImageByKey(paramMediaItemInfo.getDataPath());
    if (localBitmap != null) {
      localAttachInfo.setThumbnailData(localBitmap);
    }
    if (!paramMediaItemInfo.isVideo())
    {
      localAttachInfo.setAttachName(generateUploadFileName(localAttachInfo));
      localAttachInfo.setFileType(AttachType.IMAGE);
    }
    for (;;)
    {
      localAttachInfo.setOriAbsAttachPath(paramMediaItemInfo.getOriDataPath());
      Log.d("QMAttachUtils", "mediaItemInfo2AttachInfo getOriAbsAttachPath:" + localAttachInfo.getOriAbsAttachPath());
      return localAttachInfo;
      localAttachInfo.setFileType(AttachType.VIDEO);
    }
  }
  
  public static boolean notEmpty(String paramString)
  {
    return (paramString != null) && (!paramString.equals(""));
  }
  
  public static String removeIllegalString(String paramString)
  {
    String str = paramString;
    if (paramString.contains("#38;")) {
      str = paramString.replace("#38;", "");
    }
    return str;
  }
  
  public static boolean renameAttachInfo(String paramString, AttachInfo paramAttachInfo, ComposeMailView paramComposeMailView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      File localFile = new File(paramAttachInfo.getAttachPath());
      bool1 = bool2;
      Object localObject = FileUtil.getParentPath(paramAttachInfo.getAttachPath());
      bool1 = bool2;
      paramString = FileUtil.rename((String)localObject, paramString);
      bool1 = bool2;
      localObject = new File((String)localObject + File.separator + paramString);
      bool1 = bool2;
      bool2 = localFile.renameTo((File)localObject);
      bool1 = bool2;
      QMLog.log(4, "QMAttachUtils", "rename from " + paramAttachInfo.getAttachPath() + " to " + ((File)localObject).getPath() + " ret " + bool2);
      if (bool2)
      {
        bool1 = bool2;
        paramAttachInfo.setAttachName(paramString);
        bool1 = bool2;
        paramAttachInfo.setRename(true);
        bool1 = bool2;
        paramComposeMailView.replaceInlineImageSrc(paramAttachInfo.getAttachPath(), ((File)localObject).getAbsolutePath());
        bool1 = bool2;
        paramAttachInfo.setAttachPath(((File)localObject).getAbsolutePath());
        return bool2;
      }
      bool1 = bool2;
      Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131718795), 0).show();
      return bool2;
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMAttachUtils", "rename local file error");
    }
    return bool1;
  }
  
  public static void saveThumbnail(AttachInfo paramAttachInfo, String paramString)
  {
    if (FileUtil.isFileExist(paramAttachInfo.getThumbnailPath())) {
      return;
    }
    if (((Bitmap)paramAttachInfo.getThumbnailData() == null) && (paramAttachInfo.getFileType() == AttachType.VIDEO)) {
      paramAttachInfo.setThumbnailData(ThumbnailUtils.createVideoThumbnail(paramAttachInfo.getAbsAttachPath(), 3));
    }
    Object localObject = (Bitmap)paramAttachInfo.getThumbnailData();
    paramAttachInfo.setThumbnailData(null);
    Bitmap localBitmap = ImageUtil.fixImageOrientationRecursively((Bitmap)localObject, paramAttachInfo.getAttachPath(), 4);
    if (localBitmap != null) {
      localObject = localBitmap;
    }
    paramString = FileUtil.createThumbnailDirAtRootPath(paramString);
    paramString = paramString + File.separator + "thumbnail_" + paramAttachInfo.getAttachName().hashCode();
    paramAttachInfo.setThumbnailPath(paramString);
    try
    {
      ImageUtil.writeBitmapToLocation((Bitmap)localObject, Bitmap.CompressFormat.JPEG, 100, paramString);
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        paramAttachInfo.setThumbnailData(null);
        return;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      paramAttachInfo.setThumbnailData(localObject);
    }
  }
  
  public static void saveToSandbox(AttachInfo paramAttachInfo, String paramString)
  {
    boolean bool = true;
    String str2 = paramAttachInfo.getAttachPath();
    paramString = FileUtil.createPhotoDirAtRootPath(paramString);
    String str1 = paramString + paramAttachInfo.getAttachName();
    if (paramAttachInfo.hasSavedToSandbox()) {}
    do
    {
      return;
      paramString = str1;
      if (!paramAttachInfo.isNeedCopy()) {
        break label216;
      }
      str1 = checkAttachComposePathValid(paramAttachInfo, str1);
      paramString = new File(str2);
      if (str1.equals(str2)) {
        break label187;
      }
      paramAttachInfo.setAttachPath(str1);
      if (FileUtil.copyFile(paramString, new File(str1)) != 0) {
        break;
      }
      paramAttachInfo.setCanCopyToSandBox(bool);
    } while (!bool);
    for (;;)
    {
      if (paramAttachInfo.canPreView()) {}
      try
      {
        ImageUtil.createOrientedImage(524288L, paramAttachInfo);
        paramString = new FileInputStream(new File(str1));
        int i = paramString.available();
        if (i != paramAttachInfo.getRealSize()) {
          paramAttachInfo.setRealSize(i);
        }
        paramString.close();
      }
      catch (Exception paramString)
      {
        label170:
        break label170;
      }
      paramAttachInfo.estimateAndSetSizeByRealSize(FileUtil.getFileSize(paramAttachInfo.getAttachPath()));
      return;
      bool = false;
      break;
      label187:
      paramString = str1;
      if (str1 != null)
      {
        paramString = str1;
        if (!"".equals(str1))
        {
          paramAttachInfo.setCanCopyToSandBox(true);
          paramString = str1;
        }
      }
      label216:
      str1 = paramString;
    }
  }
  
  private static void tryBrowserDownload(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      localIntent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
        return;
      }
      catch (Exception paramString)
      {
        QMUIHelper.showToast(paramContext, 2131696372, "");
      }
    }
  }
  
  private static boolean unselectBigAttachs(ArrayList<String> paramArrayList, ComposeMailUI paramComposeMailUI)
  {
    paramComposeMailUI = paramComposeMailUI.getInformation().getBigAttachList();
    if ((paramComposeMailUI != null) && (paramComposeMailUI.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramComposeMailUI.iterator();
      while (localIterator.hasNext())
      {
        MailBigAttach localMailBigAttach = (MailBigAttach)localIterator.next();
        if (paramArrayList.contains(localMailBigAttach.getFid())) {
          localArrayList.add(localMailBigAttach);
        }
      }
      paramArrayList = new ArrayList();
      paramArrayList.addAll(paramComposeMailUI);
      paramArrayList.removeAll(localArrayList);
      paramComposeMailUI.removeAll(paramArrayList);
      if (paramArrayList.size() > 0) {
        return true;
      }
    }
    return false;
  }
  
  @NonNull
  private static ArrayList<AttachInfo> unselectFavAttaches(ArrayList<AttachInfo> paramArrayList1, ArrayList<AttachInfo> paramArrayList2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList1.iterator();
    while (localIterator.hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)localIterator.next();
      if (localAttachInfo.isFromFav()) {
        localArrayList.add(localAttachInfo);
      }
    }
    localArrayList.removeAll(paramArrayList2);
    paramArrayList1.removeAll(localArrayList);
    return localArrayList;
  }
  
  public static boolean unselectFtn(Bundle paramBundle, ComposeMailUI paramComposeMailUI)
  {
    if (paramBundle == null) {}
    do
    {
      return false;
      paramBundle = FtnLogicStorage.fetchOutComposeInfos();
    } while (paramBundle.size() == 0);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    filterTheSameInfos(paramBundle, localArrayList1, localArrayList2, paramComposeMailUI);
    FtnLogicStorage.getComposeInfos().addAll(paramBundle);
    return unselectFtnAddAttachInfos(localArrayList1, paramComposeMailUI) | unselectBigAttachs(localArrayList2, paramComposeMailUI);
  }
  
  private static boolean unselectFtnAddAttachInfos(ArrayList<AttachInfo> paramArrayList, ComposeMailUI paramComposeMailUI)
  {
    paramComposeMailUI = paramComposeMailUI.getAddAttachInfoList();
    if (paramComposeMailUI == null) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramComposeMailUI.iterator();
    while (localIterator.hasNext())
    {
      AttachInfo localAttachInfo = (AttachInfo)localIterator.next();
      if ((localAttachInfo.isBigAttach()) && (!localAttachInfo.isNeedFtnUpload())) {
        localArrayList.add(localAttachInfo);
      }
    }
    localArrayList.removeAll(paramArrayList);
    paramComposeMailUI.removeAll(localArrayList);
    return localArrayList.size() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.QMAttachUtils
 * JD-Core Version:    0.7.0.1
 */