package com.tencent.qqmail.attachment.util;

import android.widget.ImageView;
import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageResourceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttachToolbox
{
  public static final int INFO_THUMB_HEIGHT = 350;
  public static final int INFO_THUMB_WIDTH = 320;
  public static final int LIST_THUMB_HEIGHT = 160;
  public static final int LIST_THUMB_WIDTH = 160;
  
  public static boolean attachSizeExceedTen(Attach paramAttach, long paramLong)
  {
    return StringExtention.sizeStrToLong(paramAttach.getSize()) > paramLong;
  }
  
  public static String buildAttachFolderLockStatusKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("attachfolder_lockstatus");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt + "");
    return localStringBuilder.toString();
  }
  
  public static String buildAttachFolderSyncTokenKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("attachfolder_synctoken");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt + "");
    return localStringBuilder.toString();
  }
  
  public static String formatThumbnailUrl(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&width=").append(paramInt1);
    localStringBuilder.append("&height=").append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static AttachType getAttachType(Attach paramAttach)
  {
    if (paramAttach == null) {
      return AttachType.NONE;
    }
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName())));
  }
  
  public static AttachType getAttachTypeByName(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return AttachType.NONE;
    }
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString)));
  }
  
  public static String getGroupMailAttFromUrl(String paramString)
  {
    String str3 = "";
    String str1 = str3;
    String str2;
    if (!StringExtention.isNullOrEmpty(paramString)) {
      str2 = str3;
    }
    try
    {
      paramString = Pattern.compile("att=.*?($|&)").matcher(paramString);
      str1 = str3;
      str2 = str3;
      if (paramString.find())
      {
        str2 = str3;
        paramString = paramString.group(0);
        str1 = paramString;
        str2 = paramString;
        if (!StringExtention.isNullOrEmpty(paramString))
        {
          str2 = paramString;
          str1 = paramString.replaceAll("att=", "").replaceAll("&", "");
        }
      }
      return str1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str2;
  }
  
  public static String getViewMode(AttachType paramAttachType)
  {
    if ((paramAttachType == AttachType.EXCEL) || (paramAttachType == AttachType.WORD) || (paramAttachType == AttachType.PPT) || (paramAttachType == AttachType.PSD) || (paramAttachType == AttachType.HTML) || (paramAttachType == AttachType.PDF) || (paramAttachType == AttachType.TXT) || (paramAttachType == AttachType.EML) || (paramAttachType == AttachType.PAGES) || (paramAttachType == AttachType.NUMBERS) || (paramAttachType == AttachType.KEYNOTE)) {
      return "doc";
    }
    if (paramAttachType == AttachType.IMAGE) {
      return "img";
    }
    if (paramAttachType == AttachType.VIDEO) {
      return "video";
    }
    if (paramAttachType == AttachType.AUDIO) {
      return "music";
    }
    return "";
  }
  
  public static String getViewModeByName(String paramString)
  {
    return getViewMode(getAttachTypeByName(paramString));
  }
  
  public static boolean isAttachEml(String paramString)
  {
    paramString = FileUtil.getFileNameSuffix(paramString);
    return (paramString != null) && (paramString.equals("eml"));
  }
  
  public static boolean isAttachICS(String paramString)
  {
    paramString = FileUtil.getFileNameSuffix(paramString);
    return (paramString != null) && (paramString.equals("ics"));
  }
  
  public static boolean isAttachTypeImage(Attach paramAttach)
  {
    boolean bool = true;
    if (paramAttach == null) {
      return false;
    }
    String str = paramAttach.getViewMode();
    if (str != null) {
      if (!str.equals("img")) {
        break label58;
      }
    }
    for (;;)
    {
      return bool;
      paramAttach = QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramAttach.getName())).toLowerCase(Locale.getDefault());
      if ((paramAttach == null) || (!paramAttach.equals("image"))) {
        label58:
        bool = false;
      }
    }
  }
  
  public static boolean isGroupMail(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return false;
    }
    return paramString.contains("cgi-bin/groupattachment");
  }
  
  public static void loadImageAttachThumb(int paramInt, String paramString, ImageView paramImageView, ImageDownloadListener paramImageDownloadListener)
  {
    setDefaultThumbByType(paramImageView, "image");
    if ((StringExtention.isNullOrEmpty(paramString)) || (isGroupMail(paramString))) {}
    do
    {
      return;
      int i = ImageDownloadManager.shareInstance().isThumbBitmapExistLocal(paramString);
      if ((i != 2) && (i != 1)) {
        break;
      }
      paramString = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramString);
    } while (paramString == null);
    paramImageView.setImageBitmap(paramString);
    return;
    paramImageView = new DownloadInfo();
    paramImageView.setAccountId(paramInt);
    paramImageView.setUrl(paramString);
    paramImageView.setImageDownloadListener(paramImageDownloadListener);
    ImageDownloadManager.shareInstance().fetchImage(paramImageView);
  }
  
  public static void setDefaultThumbByType(ImageView paramImageView, String paramString)
  {
    paramImageView.setImageResource(ImageResourceUtil.getImageResource(paramString, ImageResourceUtil.IMAGE_SIZE_58));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.util.AttachToolbox
 * JD-Core Version:    0.7.0.1
 */