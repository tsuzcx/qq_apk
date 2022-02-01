package com.tencent.qqmail.ftn.util;

import android.content.Context;
import android.net.UrlQuerySanitizer;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.attachment.model.AttachPreview;
import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.ftn.model.FtnComposeInfo;
import com.tencent.qqmail.ftn.model.FtnDownloadInfo;
import com.tencent.qqmail.ftn.model.FtnUploadInfo;
import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.ImageScaleDegree;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FtnCommonUtils
{
  public static final int ROTATE_ANGLE_0 = 0;
  public static final int ROTATE_ANGLE_180 = 2;
  public static final int ROTATE_ANGLE_270 = 3;
  public static final int ROTATE_ANGLE_90 = 1;
  public static final String UPLOAD_FILENAME_HEADER = "Photo_";
  private static long ftnLevel = 0L;
  
  public static String LogUpload(FtnUploadInfo paramFtnUploadInfo)
  {
    if (paramFtnUploadInfo != null) {
      return "up_info[ addr: " + paramFtnUploadInfo.hashCode() + " name: " + paramFtnUploadInfo.getName() + " rid: " + paramFtnUploadInfo.getRid() + " fid: " + paramFtnUploadInfo.getFid() + " filesize: " + paramFtnUploadInfo.getFileSize() + " uploadsize: " + paramFtnUploadInfo.getUploadedSize() + " sha: " + paramFtnUploadInfo.getSha() + " ip: " + paramFtnUploadInfo.getIp() + " progress: " + paramFtnUploadInfo.getProgress() + " schedule: " + paramFtnUploadInfo.getSchedule() + " state: " + uploadStateFormat(paramFtnUploadInfo.getStage()) + " stage: " + uploadStageFormat(paramFtnUploadInfo.getStage()) + " ]";
    }
    return "";
  }
  
  public static String autoGenerateUploadFileName(int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(2);
    int j = localCalendar.get(5);
    localStringBuffer.append("Photo_");
    if (i < 9) {
      localStringBuffer.append("0");
    }
    localStringBuffer.append(i + 1);
    if (j < 10) {
      localStringBuffer.append("0");
    }
    localStringBuffer.append(j);
    localStringBuffer.append("_");
    localStringBuffer.append(paramInt1);
    if (paramInt2 == 0) {
      localStringBuffer.append("a");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      if (paramInt2 == 1) {
        localStringBuffer.append("b");
      } else if (paramInt2 == 2) {
        localStringBuffer.append("c");
      } else if (paramInt2 == 3) {
        localStringBuffer.append("d");
      }
    }
  }
  
  public static FileInfo bigAttach2fileInfo(MailBigAttach paramMailBigAttach)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.filename = paramMailBigAttach.getName();
    localFileInfo.fid = paramMailBigAttach.getFid();
    localFileInfo.filesize = paramMailBigAttach.getBytes();
    localFileInfo.viewtype = Integer.parseInt(paramMailBigAttach.getPreview().getIviewtype());
    localFileInfo.code = paramMailBigAttach.getCode();
    localFileInfo.key = paramMailBigAttach.getKey();
    localFileInfo.sha = paramMailBigAttach.getSha();
    localFileInfo.md5 = paramMailBigAttach.getMd5();
    localFileInfo.expiretime = ((int)(paramMailBigAttach.getExpire().getTime() / 1000L));
    localFileInfo.createtime = paramMailBigAttach.getCreateTime();
    localFileInfo.downloadtimes = paramMailBigAttach.getDownloadTimes();
    return localFileInfo;
  }
  
  public static void buildComposeData(ArrayList<FtnComposeInfo> paramArrayList, String paramString, FileInfo paramFileInfo)
  {
    if ((paramFileInfo == null) || (StringExtention.isNullOrEmpty(paramString))) {
      return;
    }
    paramArrayList.clear();
    paramArrayList.add(fileInfo2ComposeInfo(paramString, paramFileInfo));
  }
  
  public static int calcProgress(long paramLong1, long paramLong2, double paramDouble)
  {
    if (paramLong2 == 0L) {
      return 0;
    }
    return (int)(100L * paramLong1 / paramLong2 * paramDouble);
  }
  
  public static int detectFileSizeLegal(String paramString, long paramLong1, long paramLong2)
  {
    paramString = new File(paramString);
    if (paramString.exists())
    {
      long l = paramString.length();
      if ((l > paramLong1) && (l < paramLong2)) {
        return 0;
      }
      if (l <= paramLong1) {
        return -1;
      }
      return 1;
    }
    return -2;
  }
  
  public static SingleSizeInfo estimateSize(String paramString)
  {
    SingleSizeInfo localSingleSizeInfo = new SingleSizeInfo();
    localSingleSizeInfo.setRealSize((float)getFileSize(paramString));
    float f1 = 1.0F / ComposeMailUI.ImageScaleDegree.getSampleSize(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Low);
    float f2 = 1.0F / ComposeMailUI.ImageScaleDegree.getSampleSize(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_Middle);
    float f3 = 1.0F / ComposeMailUI.ImageScaleDegree.getSampleSize(ComposeMailUI.ImageScaleDegree.ImageScaleDegree_High);
    if (FileUtil.getFileNameSuffix(paramString) == "png")
    {
      localSingleSizeInfo.setLowSize(f1 * f1 * localSingleSizeInfo.getRealSize());
      localSingleSizeInfo.setMiddleSize(f2 * f2 * localSingleSizeInfo.getRealSize());
      localSingleSizeInfo.setHighSize(f3 * f3 * localSingleSizeInfo.getRealSize());
      return localSingleSizeInfo;
    }
    localSingleSizeInfo.setLowSize(f1 * f1 * localSingleSizeInfo.getRealSize() * 1.7F);
    localSingleSizeInfo.setMiddleSize(f2 * f2 * localSingleSizeInfo.getRealSize() * 1.7F);
    localSingleSizeInfo.setHighSize(f3 * f3 * localSingleSizeInfo.getRealSize() * 1.7F);
    return localSingleSizeInfo;
  }
  
  public static MailBigAttach fileInfo2BigAttach(FileInfo paramFileInfo)
  {
    MailBigAttach localMailBigAttach = new MailBigAttach(false);
    Object localObject = paramFileInfo.filename;
    String str = FileUtil.getFileNameSuffix((String)localObject);
    localMailBigAttach.setFid(paramFileInfo.fid);
    localMailBigAttach.setName((String)localObject);
    localMailBigAttach.setSuffix(str);
    long l2 = paramFileInfo.filesize;
    long l1 = l2;
    if (l2 < 0L)
    {
      l1 = Math.pow(2.0D, 31.0D);
      l1 = l2 + l1 + l1;
    }
    localMailBigAttach.setSize(l1 + "");
    localMailBigAttach.setBytes(l1);
    localMailBigAttach.getPreview().setIviewtype(paramFileInfo.viewtype + "");
    localMailBigAttach.getPreview().setItype(AttachType.valueOf(QMAttachUtils.attachFileType(str)));
    localObject = FtnManager.sharedInstance().getDownloadInfo(paramFileInfo.fid);
    if (localObject != null) {
      localMailBigAttach.getPreview().setMyDisk(((FtnDownloadInfo)localObject).getSavePath());
    }
    localMailBigAttach.setCode(paramFileInfo.code);
    localMailBigAttach.setKey(paramFileInfo.key);
    localMailBigAttach.setSha(paramFileInfo.sha);
    localMailBigAttach.setMd5(paramFileInfo.md5);
    localMailBigAttach.setType("qqmail");
    localMailBigAttach.setExpire(new Date(paramFileInfo.expiretime * 1000L));
    localMailBigAttach.getPreview().setDownloadUrl("http://mail.qq.com/cgi-bin/ftnExs_download?k=" + paramFileInfo.key + "&t=exs_ftn_download&code=" + paramFileInfo.code);
    localMailBigAttach.setCreateTime(paramFileInfo.createtime);
    localMailBigAttach.setDownloadTimes(paramFileInfo.downloadtimes);
    try
    {
      localMailBigAttach.setInfoBytes(paramFileInfo.toByteArray());
      return localMailBigAttach;
    }
    catch (IOException paramFileInfo)
    {
      paramFileInfo.printStackTrace();
    }
    return localMailBigAttach;
  }
  
  public static FtnComposeInfo fileInfo2ComposeInfo(String paramString, FileInfo paramFileInfo)
  {
    MailBigAttach localMailBigAttach = fileInfo2BigAttach(paramFileInfo);
    String str1 = paramFileInfo.expiretime + "";
    Object localObject = paramFileInfo.key;
    String str2 = paramFileInfo.code;
    long l2 = paramFileInfo.filesize;
    long l1 = l2;
    if (l2 < 0L)
    {
      l1 = Math.pow(2.0D, 31.0D);
      l1 = l2 + l1 + l1;
    }
    String str3 = StringExtention.getHumanReadableSizeString(l1);
    str1 = String.format("&k=%s&temp=%s&code=%s&expire=%s&fsize=%s&expiretime=%s&fsize=%s&suffix=%s", new Object[] { localObject, str2, str2, str1, str3, str1, str3, FileUtil.getFileNameSuffix(paramFileInfo.filename) });
    localObject = new FtnComposeInfo();
    ((FtnComposeInfo)localObject).setHref("ftn_compose_info" + str1);
    ((FtnComposeInfo)localObject).setFid(paramFileInfo.fid);
    ((FtnComposeInfo)localObject).setName(paramFileInfo.filename);
    ((FtnComposeInfo)localObject).setSize(getFileSizeStr(paramFileInfo));
    ((FtnComposeInfo)localObject).setMailAttach(localMailBigAttach);
    ((FtnComposeInfo)localObject).setThumbUrl(getThumbUrl(paramString, paramFileInfo.fid, "2", "2", localMailBigAttach.getAccountId()));
    return localObject;
  }
  
  public static String generateExpireTime(Date paramDate)
  {
    if (paramDate == null) {
      paramDate = "0";
    }
    String str;
    do
    {
      return paramDate;
      str = String.valueOf(paramDate.getTime() / 1000L);
      paramDate = str;
    } while (!str.contains("64092211200"));
    return "-1";
  }
  
  public static int getExpireTimeFromNowSecond(int paramInt)
  {
    return (int)(System.currentTimeMillis() / 1000L) + 86400 * paramInt;
  }
  
  public static String getExpireTimeString(Date paramDate)
  {
    Object localObject = new Date();
    long l = (paramDate.getTime() - ((Date)localObject).getTime()) / 1000L;
    int j = (int)Math.floor(l / 86400);
    int i = (int)Math.ceil(l % 86400 / 3600);
    if (l < 0L) {
      localObject = "已过期";
    }
    for (;;)
    {
      if (paramDate.getTime() == new Date(0L).getTime()) {
        localObject = QMApplicationContext.sharedInstance().getString(2131694055);
      }
      return localObject;
      if (j > 2)
      {
        localObject = new StringBuilder();
        if (i % 24 > 0) {}
        for (i = 1;; i = 0)
        {
          localObject = i + j + "天";
          break;
        }
      }
      if (j > 0)
      {
        if (i > 0) {
          localObject = j + "天" + i + "小时";
        } else {
          localObject = j + "天";
        }
      }
      else if (i > 0) {
        localObject = i + "小时";
      } else {
        localObject = "即将过期";
      }
    }
  }
  
  public static long getFileSize(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.length();
    }
    return 0L;
  }
  
  public static String getFileSizeFormat(String paramString)
  {
    return StringExtention.getHumanReadableSizeString(Long.parseLong(paramString + ""));
  }
  
  public static String getFileSizeStr(FileInfo paramFileInfo)
  {
    if (paramFileInfo != null)
    {
      long l2 = paramFileInfo.filesize;
      long l1 = l2;
      if (l2 < 0L)
      {
        l1 = Math.pow(2.0D, 31.0D);
        l1 = l2 + l1 + l1;
      }
      return StringExtention.getHumanReadableSizeString(l1);
    }
    return "";
  }
  
  public static String getFileType(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(FileUtil.getFileNameSuffix(paramString))).name().toLowerCase(Locale.getDefault());
  }
  
  public static int getImageRotateAngle(Context paramContext, String paramString)
  {
    int i = 3;
    int j = ImageUtil.getImageOrientation(paramContext, paramString);
    if (j == 6) {
      i = 1;
    }
    do
    {
      return i;
      if (j == 3) {
        return 2;
      }
    } while (j == 8);
    return 0;
  }
  
  public static String getThumbUrl(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((localAccount != null) && (localAccount.isBizMail())) {
      localStringBuilder.append("https://ftn.exmail.qq.com/cgi-bin/ftnthumbnail?head_path=getpreviewpicurl&head_method=read&&appid=2");
    }
    for (;;)
    {
      return "&pictype=" + paramString3 + "&sizetype=" + paramString4 + "&u=" + paramString1 + "&fid=" + paramString2;
      localStringBuilder.append("https://ftn.mail.qq.com/cgi-bin/ftnthumbnail?head_path=getpreviewpicurl&head_method=read&&appid=2");
    }
  }
  
  public static boolean isAbortExpire(int paramInt)
  {
    if (paramInt <= 0) {}
    long l;
    do
    {
      return true;
      Date localDate1 = new Date(paramInt * 1000L);
      Date localDate2 = new Date();
      l = (localDate1.getTime() - localDate2.getTime()) / 1000L;
      paramInt = (int)Math.floor(l / 86400);
    } while ((l > 0L) && (paramInt < 3));
    return false;
  }
  
  public static boolean isBigAttachDownloadComplete(MailBigAttach paramMailBigAttach)
  {
    if (paramMailBigAttach != null)
    {
      FtnDownloadInfo localFtnDownloadInfo = FtnManager.sharedInstance().getDownloadInfo(paramMailBigAttach.getFid());
      if ((localFtnDownloadInfo != null) && (FileUtil.isFileExist(localFtnDownloadInfo.getSavePath())) && (paramMailBigAttach.getBytes() == localFtnDownloadInfo.getSize())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isFileTypeImage(String paramString)
  {
    return AttachType.valueOf(QMAttachUtils.attachFileType(paramString)).name().toLowerCase(Locale.getDefault()).equals("image");
  }
  
  public static Boolean isNotExpireSoon(Date paramDate)
  {
    Date localDate = new Date();
    if ((int)Math.floor((paramDate.getTime() - localDate.getTime()) / 1000L / 86400) > 2) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public static boolean isSupportRenew()
  {
    QQMailAccount localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
    return (ftnLevel > 0L) || ((localQQMailAccount != null) && (!localQQMailAccount.isBizMail()));
  }
  
  public static FtnComposeInfo mailBigAttach2FtnComposeInfo(MailBigAttach paramMailBigAttach)
  {
    FtnComposeInfo localFtnComposeInfo = new FtnComposeInfo();
    localFtnComposeInfo.setThumbUrl(getThumbUrl(AccountManager.shareInstance().getAccountList().getDefaultFtnAccount().getUin(), paramMailBigAttach.getFid(), "2", "2", paramMailBigAttach.getAccountId()));
    localFtnComposeInfo.setMailAttach(paramMailBigAttach);
    localFtnComposeInfo.setName(paramMailBigAttach.getName());
    return localFtnComposeInfo;
  }
  
  public static String netErrorFormat(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return " [ cgicode: " + paramInt1 + " logicCode: " + paramInt2 + " errtype: " + paramInt3 + " desc: " + paramString + " ]";
  }
  
  public static void parseFtnNeceParamFromUrl(MailBigAttach paramMailBigAttach)
  {
    if ((paramMailBigAttach == null) || (StringExtention.isNullOrEmpty(paramMailBigAttach.getPreview().getDownloadUrl()))) {}
    do
    {
      return;
      localObject = paramMailBigAttach.getCode();
    } while ((!StringExtention.isNullOrEmpty(paramMailBigAttach.getKey())) && (!StringExtention.isNullOrEmpty((String)localObject)));
    Object localObject = new UrlQuerySanitizer();
    ((UrlQuerySanitizer)localObject).setAllowUnregisteredParamaters(true);
    ((UrlQuerySanitizer)localObject).parseUrl(paramMailBigAttach.getPreview().getDownloadUrl());
    paramMailBigAttach.setKey(((UrlQuerySanitizer)localObject).getValue("k"));
    paramMailBigAttach.setCode(((UrlQuerySanitizer)localObject).getValue("code"));
  }
  
  public static void setFtnLevel(long paramLong)
  {
    ftnLevel = paramLong;
  }
  
  public static String uploadStageFormat(int paramInt)
  {
    if (paramInt == 0) {
      return "to->signfile";
    }
    if (paramInt == 1) {
      return "to->createfile";
    }
    if (paramInt == 2) {
      return "to->fileupload";
    }
    return "> <";
  }
  
  public static String uploadStateFormat(int paramInt)
  {
    if (paramInt == 1) {
      return "scanning";
    }
    if (paramInt == 3) {
      return "pause";
    }
    if (paramInt == 2) {
      return "uploading";
    }
    if (paramInt == 4) {
      return "error";
    }
    return "> <";
  }
  
  public static class SingleSizeInfo
  {
    private float highSize;
    private float lowSize;
    private float middleSize;
    private float realSize;
    
    public float getHighSize()
    {
      return this.highSize;
    }
    
    public float getLowSize()
    {
      return this.lowSize;
    }
    
    public float getMiddleSize()
    {
      return this.middleSize;
    }
    
    public float getRealSize()
    {
      return this.realSize;
    }
    
    public void setHighSize(float paramFloat)
    {
      this.highSize = paramFloat;
    }
    
    public void setLowSize(float paramFloat)
    {
      this.lowSize = paramFloat;
    }
    
    public void setMiddleSize(float paramFloat)
    {
      this.middleSize = paramFloat;
    }
    
    public void setRealSize(float paramFloat)
    {
      this.realSize = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.util.FtnCommonUtils
 * JD-Core Version:    0.7.0.1
 */