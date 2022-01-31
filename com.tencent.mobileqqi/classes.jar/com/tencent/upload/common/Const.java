package com.tencent.upload.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imageservice.ImageProcessUtil;
import com.tencent.upload.biz.UploadActionFlowWrapper;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadAction;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.IUploadReport;
import com.tencent.upload.uinterface.IUploadService.IUploadServiceContext;
import com.tencent.upload.uinterface.IUploadTaskCallback;
import com.tencent.upload.uinterface.IUploadTaskType;
import com.tencent.upload.uinterface.Report;
import com.tencent.upload.uinterface.Utility;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;

public class Const
{
  public static final int GIF_COPY_SATISFY = 2;
  public static final String GIF_COPY_TAG = "Gif=";
  public static final int GIF_COPY_UNSATISFY = 5;
  public static final int GIF_ONESHOT_COPY = 3;
  public static final int GIF_ORIGINAL_SATISFY = 1;
  public static final int GIF_ORIGINAL_UNSATISFY = 4;
  public static final String IMAGE_COPY_TAG = "uploadCopy=";
  public static final String IMAGE_COPY_TAG_CACHE = "cache";
  public static final String IMAGE_COPY_TAG_COMPRESS = "compress";
  public static final String IMAGE_COPY_TAG_COPY = "copy";
  public static final String IMAGE_COPY_TAG_ORIGINAL = "original";
  
  private static final void abortTask(AbstractUploadTask paramAbstractUploadTask, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramAbstractUploadTask.uploadTaskCallback != null)
    {
      paramAbstractUploadTask.uploadTaskCallback.onUploadError(paramAbstractUploadTask, paramInt, paramString2);
      paramAbstractUploadTask.uploadTaskCallback.onUploadStateChange(paramAbstractUploadTask, 5);
      UploadLog.v("ServiceImpl", "onUploadStateChange=5");
    }
    if (paramBoolean)
    {
      int i = 0;
      if (paramInt == 700) {
        i = UploadConfiguration.getCurrentNetworkCategory();
      }
      report(paramInt, paramString1, paramAbstractUploadTask.flowId, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.getUploadTaskType(), getUppAppId(paramAbstractUploadTask), 0L, 0L, 0L, "", 0, i, 0, getVideoSource(paramAbstractUploadTask));
    }
    UploadLog.w("ServiceImpl", paramString1);
  }
  
  public static final void copyAndUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString)
  {
    boolean bool = copyTaskFile(paramAbstractUploadTask);
    if (bool) {}
    for (paramString = paramString + " || " + "uploadCopy=" + "copy";; paramString = paramString + " || " + "uploadCopy=" + "original")
    {
      uploadTask(paramIUploadServiceContext, paramAbstractUploadTask, bool, paramString);
      return;
    }
  }
  
  public static final void copyAndUploadTaskBySize(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString, int paramInt)
  {
    boolean bool2 = false;
    File localFile = new File(paramAbstractUploadTask.uploadFilePath);
    boolean bool1 = bool2;
    String str = paramString;
    if (localFile != null)
    {
      bool1 = bool2;
      str = paramString;
      if (paramInt > 0)
      {
        bool1 = bool2;
        str = paramString;
        if (localFile.length() < paramInt)
        {
          bool1 = copyTaskFile(paramAbstractUploadTask);
          str = paramString + " copy pic sizeThreshold ";
        }
      }
    }
    if (bool1) {}
    for (paramString = str + " || " + "uploadCopy=" + "copy";; paramString = str + " || " + "uploadCopy=" + "original")
    {
      uploadTask(paramIUploadServiceContext, paramAbstractUploadTask, bool1, paramString);
      return;
    }
  }
  
  public static final boolean copyTaskFile(AbstractUploadTask paramAbstractUploadTask)
  {
    String str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    boolean bool1;
    if (TextUtils.isEmpty(str)) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = FileUtils.copyFile(paramAbstractUploadTask.uploadFilePath, str);
      bool1 = bool2;
    } while (!bool2);
    paramAbstractUploadTask.uploadFilePath = str;
    return bool2;
  }
  
  public static final Object getProperty(AbstractUploadTask paramAbstractUploadTask, String paramString)
  {
    if ((paramAbstractUploadTask == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = paramAbstractUploadTask.getClass().getField(paramString);
      if (paramString == null) {
        return null;
      }
      paramAbstractUploadTask = paramString.get(paramAbstractUploadTask);
      return paramAbstractUploadTask;
    }
    catch (NoSuchFieldException paramAbstractUploadTask)
    {
      UploadLog.v(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
      return null;
    }
    catch (IllegalArgumentException paramAbstractUploadTask)
    {
      UploadLog.v(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
      return null;
    }
    catch (IllegalAccessException paramAbstractUploadTask)
    {
      UploadLog.v(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
      return null;
    }
    catch (NullPointerException paramAbstractUploadTask)
    {
      UploadLog.v(Utility.class.getSimpleName(), paramAbstractUploadTask.toString());
    }
    return null;
  }
  
  public static final String getUppAppId(AbstractUploadTask paramAbstractUploadTask)
  {
    paramAbstractUploadTask = getProperty(paramAbstractUploadTask, "sfUppAppId");
    if ((paramAbstractUploadTask instanceof String)) {
      return (String)paramAbstractUploadTask;
    }
    return null;
  }
  
  public static final int getVideoSource(AbstractUploadTask paramAbstractUploadTask)
  {
    int i = 1;
    paramAbstractUploadTask = getProperty(paramAbstractUploadTask, "iIsNew");
    if ((paramAbstractUploadTask instanceof Integer))
    {
      if (((Integer)paramAbstractUploadTask).intValue() == 1) {
        i = 2;
      }
      return i;
    }
    return 0;
  }
  
  private static final int processGif(AbstractUploadTask paramAbstractUploadTask)
  {
    int i = UploadConfiguration.getCurrentNetworkCategory();
    long l = new File(paramAbstractUploadTask.uploadFilePath).length();
    UploadLog.i("ServiceImpl", "processGif, networkType:" + i + " length:" + l + " flowId:" + paramAbstractUploadTask.flowId);
    if (((i == 1) && (l < 5242880L)) || ((i == 3) && (l < 819200L)) || ((i == 2) && (l < 2097152L)))
    {
      UploadLog.v("ServiceImpl", "processGif() 满足上传原图条件 flowId=" + paramAbstractUploadTask.flowId);
      if (copyTaskFile(paramAbstractUploadTask)) {
        return 2;
      }
      return 1;
    }
    Object localObject = new BitmapFactory.Options();
    localObject = ImageProcessUtil.decodeFileWithRetry(paramAbstractUploadTask.uploadFilePath, (BitmapFactory.Options)localObject);
    String str = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    if ((localObject != null) && (str != null) && (ImageProcessUtil.bitmapToFile((Bitmap)localObject, str, 80, false, false, null)))
    {
      paramAbstractUploadTask.uploadFilePath = str;
      ((Bitmap)localObject).recycle();
      UploadLog.v("ServiceImpl", "processGif() 取第一帧上传 flowId=" + paramAbstractUploadTask.flowId);
      return 3;
    }
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    UploadLog.v("ServiceImpl", "processGif() 上传原图 flowId=" + paramAbstractUploadTask.flowId);
    if (copyTaskFile(paramAbstractUploadTask)) {
      return 5;
    }
    return 4;
  }
  
  public static void processPictureTypeUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new File(paramAbstractUploadTask.uploadFilePath);
    UploadLog.d("ServiceImpl", paramAbstractUploadTask.getClass().getSimpleName() + " processPictureTypeUploadTask() flowId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath + " size= " + ((File)localObject1).length() + " uploadType:" + paramInt + " autoRotate:" + paramBoolean);
    if (!((File)localObject1).exists()) {
      uploadTaskByTempFile(paramIUploadServiceContext, paramAbstractUploadTask, null, "processPictureTypeUploadTask");
    }
    label581:
    label585:
    for (;;)
    {
      return;
      localObject1 = ImageProcessUtil.decodeBitmapOptions(paramAbstractUploadTask.uploadFilePath);
      if ("image/gif".equalsIgnoreCase(((BitmapFactory.Options)localObject1).outMimeType))
      {
        paramInt = processGif(paramAbstractUploadTask);
        if ((paramInt != 2) && (paramInt != 3) && (paramInt != 5)) {}
        for (paramBoolean = false;; paramBoolean = true)
        {
          uploadTask(paramIUploadServiceContext, paramAbstractUploadTask, paramBoolean, "Gif=" + paramInt);
          return;
        }
      }
      int i = 100;
      boolean bool = "image/jpeg".equalsIgnoreCase(((BitmapFactory.Options)localObject1).outMimeType);
      if (bool) {
        i = UploadConfiguration.getPictureQuality(paramAbstractUploadTask.uploadFilePath);
      }
      int j = i;
      if (i <= 0) {
        j = 100;
      }
      Object localObject2 = new IUploadConfig.UploadImageSize(((BitmapFactory.Options)localObject1).outWidth, ((BitmapFactory.Options)localObject1).outHeight, 100);
      if ((((IUploadConfig.UploadImageSize)localObject2).width == 0) && (((IUploadConfig.UploadImageSize)localObject2).height == 0))
      {
        abortTask(paramAbstractUploadTask, -7, "processPictureTypeUploadTask() size illegal. path=" + paramAbstractUploadTask.uploadFilePath, "文件不存在或无效文件", true);
        return;
      }
      localObject1 = UploadGlobalConfig.getConfig();
      IUploadConfig.UploadImageSize localUploadImageSize = ((IUploadConfig)localObject1).getUploadImageSize((IUploadConfig.UploadImageSize)localObject2, paramInt, paramAbstractUploadTask);
      UploadLog.d("ServiceImpl", "processPictureTypeUploadTask() size=" + localObject2 + " targetSize=" + localUploadImageSize + " q:" + j + " jpg:" + bool);
      if ((localUploadImageSize != null) && (localUploadImageSize.height > 0) && (localUploadImageSize.width > 0) && (localUploadImageSize.quality > 0))
      {
        i = 0;
        if ((i == 0) && ((((IUploadConfig.UploadImageSize)localObject2).width > localUploadImageSize.width) || (((IUploadConfig.UploadImageSize)localObject2).height > localUploadImageSize.height) || (j > localUploadImageSize.quality))) {
          break label480;
        }
        if (i == 0) {
          break label472;
        }
      }
      label472:
      for (localObject1 = "illegelTargetSize";; localObject1 = "size<targetSize")
      {
        copyAndUploadTask(paramIUploadServiceContext, paramAbstractUploadTask, (String)localObject1);
        return;
        i = 1;
        break;
      }
      label480:
      if (j < localUploadImageSize.quality) {
        localUploadImageSize.quality = j;
      }
      localObject2 = paramAbstractUploadTask.getUploadTaskType();
      if ((localObject2 != null) && (((IUploadTaskType)localObject2).getProtocolUploadType() == 0))
      {
        i = 1;
        if ((!Utility.isCompressToWebp(((IUploadConfig)localObject1).getCompressToWebpFlag(), paramInt)) || (i == 0)) {
          break label581;
        }
      }
      for (bool = true;; bool = false)
      {
        if (paramIUploadServiceContext.compressUploadTask(paramAbstractUploadTask, localUploadImageSize, paramBoolean, bool)) {
          break label585;
        }
        copyAndUploadTask(paramIUploadServiceContext, paramAbstractUploadTask, "processPictureTypeUploadTask=noCompress");
        UploadLog.i("ServiceImpl", "processPictureTypeUploadTask()没有发到图片压缩进程");
        return;
        i = 0;
        break;
      }
    }
  }
  
  public static void processUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask)
  {
    uploadTask(paramIUploadServiceContext, paramAbstractUploadTask, false, null);
  }
  
  private static void report(int paramInt1, String paramString1, int paramInt2, String paramString2, IUploadTaskType paramIUploadTaskType, String paramString3, long paramLong1, long paramLong2, long paramLong3, String paramString4, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramString1 = new Report(paramInt1, paramString1, paramInt2, paramString2, paramIUploadTaskType, paramString3, paramLong1, paramLong2, paramLong3, paramString4, paramInt3, paramInt4, paramInt5, paramInt6);
    UploadGlobalConfig.getUploadReport().onUploadReport(paramString1);
  }
  
  public static void startUploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      return;
    }
    if ((paramAbstractUploadTask.iLoginType == 1) && (paramAbstractUploadTask.b2Gt != null)) {
      paramAbstractUploadTask.vLoginData = Convert.encryptTea(paramAbstractUploadTask.vLoginData, paramAbstractUploadTask.b2Gt);
    }
    if ((paramAbstractUploadTask.vLoginData == null) || (paramAbstractUploadTask.vLoginData.length == 0))
    {
      abortTask(paramAbstractUploadTask, 505, "startUploadTask taskId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath, "账号加密失败，请稍后重试或重新登录", true);
      return;
    }
    paramAbstractUploadTask.onProcessUploadTask(paramIUploadServiceContext);
  }
  
  public static void uploadTask(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, boolean paramBoolean, String paramString)
  {
    boolean bool = true;
    Object localObject = paramAbstractUploadTask.getClass().getSimpleName();
    long l = new File(paramAbstractUploadTask.uploadFilePath).length();
    UploadLog.d("ServiceImpl", localObject + " uploadTask() flowId=" + paramAbstractUploadTask.flowId + " file=" + paramAbstractUploadTask.uploadFilePath + " size= " + l + " deleteAfter=" + paramBoolean + " errMsg:" + paramString);
    if (l == 0L)
    {
      paramIUploadServiceContext = localObject + " uploadTask(), not exist path:" + paramAbstractUploadTask.uploadFilePath + " errMsg:" + paramString;
      paramBoolean = bool;
      if (paramAbstractUploadTask.hasRetried) {
        paramBoolean = false;
      }
      abortTask(paramAbstractUploadTask, 700, paramIUploadServiceContext, "文件不存在", paramBoolean);
      return;
    }
    try
    {
      localObject = paramAbstractUploadTask.onCreateUploadAction(paramBoolean);
      if ((paramString != null) && ((localObject instanceof UploadActionFlowWrapper))) {
        ((UploadActionFlowWrapper)localObject).setReportAppendMsg(paramString);
      }
      paramIUploadServiceContext.uploadAction((IUploadAction)localObject);
      return;
    }
    catch (Exception paramIUploadServiceContext)
    {
      abortTask(paramAbstractUploadTask, 499, Log.getStackTraceString(paramIUploadServiceContext), null, true);
    }
  }
  
  public static final void uploadTaskByTempFile(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
    }
    if (FileUtils.isValidTempFile(paramString2))
    {
      paramAbstractUploadTask.uploadFilePath = paramString2;
      uploadTask(paramIUploadServiceContext, paramAbstractUploadTask, true, str + " uploadTaskByTempFile" + " || " + "uploadCopy=" + "cache");
      return;
    }
    abortTask(paramAbstractUploadTask, 700, str + " uploadTaskByTempFile() file inexistent. path=" + paramAbstractUploadTask.uploadFilePath, "文件不存在", true);
  }
  
  public static final void uploadTaskWithoutFile(IUploadService.IUploadServiceContext paramIUploadServiceContext, AbstractUploadTask paramAbstractUploadTask, boolean paramBoolean, String paramString)
  {
    try
    {
      IUploadAction localIUploadAction = paramAbstractUploadTask.onCreateUploadAction(false);
      if ((paramString != null) && ((localIUploadAction instanceof UploadActionFlowWrapper))) {
        ((UploadActionFlowWrapper)localIUploadAction).setReportAppendMsg(paramString);
      }
      paramIUploadServiceContext.uploadAction(localIUploadAction);
      return;
    }
    catch (Exception paramIUploadServiceContext)
    {
      abortTask(paramAbstractUploadTask, 499, Log.getStackTraceString(paramIUploadServiceContext), null, true);
    }
  }
  
  public static final boolean verifyUploadFileDirectly(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool = true;
    if (!FileUtils.isFileExist(paramAbstractUploadTask.uploadFilePath))
    {
      String str = "verifyUploadFileDirectly() file !exist. path=" + paramAbstractUploadTask.uploadFilePath;
      if (paramAbstractUploadTask.hasRetried) {
        bool = false;
      }
      abortTask(paramAbstractUploadTask, 700, str, "文件不存在", bool);
      return false;
    }
    return true;
  }
  
  public static final boolean verifyUploadFileFully(AbstractUploadTask paramAbstractUploadTask)
  {
    boolean bool2 = true;
    if (!FileUtils.isFileExist(paramAbstractUploadTask.uploadFilePath))
    {
      bool1 = true;
      localObject2 = UploadGlobalConfig.getContext();
      localObject1 = FileUtils.getTempFilePath((Context)localObject2, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5, paramAbstractUploadTask.flowId);
      if (!FileUtils.isValidTempFile((String)localObject1))
      {
        localObject2 = FileUtils.getFilePathByPrefix((Context)localObject2, paramAbstractUploadTask.uploadFilePath, paramAbstractUploadTask.md5);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label119;
        }
      }
      label119:
      for (bool1 = false; !bool1; bool1 = FileUtils.copyFile((String)localObject2, (String)localObject1))
      {
        localObject1 = "verifyUploadFileFully() file !exist. path=" + paramAbstractUploadTask.uploadFilePath;
        bool1 = bool2;
        if (paramAbstractUploadTask.hasRetried) {
          bool1 = false;
        }
        abortTask(paramAbstractUploadTask, 700, (String)localObject1, "文件不存在", bool1);
        return false;
      }
    }
    boolean bool1 = false;
    Object localObject1 = new SoftReference(new byte[0]);
    Object localObject2 = ImageProcessUtil.decodeBitmapSize(paramAbstractUploadTask.uploadFilePath);
    if (((SoftReference)localObject1).get() == null) {
      bool1 = true;
    }
    if ((((IUploadConfig.UploadImageSize)localObject2).height <= 0) || (((IUploadConfig.UploadImageSize)localObject2).width <= 0))
    {
      abortTask(paramAbstractUploadTask, 701, "verifyUploadFileFully() file !valid. path=" + paramAbstractUploadTask.uploadFilePath, "无效文件", bool1);
      return false;
    }
    return true;
  }
  
  public static final boolean verifyUploadTask(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null) {
      UploadLog.e("ServiceImpl", "verifyUploadTask task==null");
    }
    do
    {
      return false;
      if (paramAbstractUploadTask.iUin == 0L)
      {
        abortTask(paramAbstractUploadTask, 703, " iUin=0", "登录账号出错", true);
        return false;
      }
      if (paramAbstractUploadTask.iLoginType == 1)
      {
        if ((paramAbstractUploadTask.vLoginData == null) || (paramAbstractUploadTask.vLoginData.length == 0) || (paramAbstractUploadTask.vLoginKey == null) || (paramAbstractUploadTask.vLoginKey.length == 0))
        {
          abortTask(paramAbstractUploadTask, 702, " verifyUploadTask a2b2=0. iloginType=" + paramAbstractUploadTask.iLoginType + " path=" + paramAbstractUploadTask.uploadFilePath, "登录账号出错", true);
          return false;
        }
      }
      else if ((paramAbstractUploadTask.vLoginData == null) || (paramAbstractUploadTask.vLoginData.length == 0))
      {
        abortTask(paramAbstractUploadTask, 702, " verifyUploadTask a2=0, iLoginType=" + paramAbstractUploadTask.iLoginType + " path=" + paramAbstractUploadTask.uploadFilePath, "登录账号出错", true);
        return false;
      }
    } while (!paramAbstractUploadTask.onVerifyUploadFile());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.upload.common.Const
 * JD-Core Version:    0.7.0.1
 */