package com.tencent.tavsticker.core;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVResourceType;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerAudioResource;
import com.tencent.tavsticker.model.TAVStickerResource;
import com.tencent.tavsticker.utils.FileIOUtils;
import com.tencent.tavsticker.utils.ThreadPoolManager;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class TAVStickerResourceExporter
{
  private static final String ERROR_MSG_CREATE_FILE_FAILED = "创建文件失败，请检查权限设置。";
  private static final String ERROR_MSG_DUPLICATE_EXPORT = "正在导出，请不要重复操作。";
  private static final String ERROR_MSG_EXPORT_PATH_EMPTY = "导出文件路径为空。";
  private static final String ERROR_MSG_EXPORT_PATH_INVALID = "导出文件路径无效。";
  private static final String ERROR_MSG_ILLEGAL_PARAMETER = "参数错误。";
  private static final String ERROR_MSG_NO_DATA = "没有数据。";
  private static final String TAG = TAVStickerResourceExporter.class.getSimpleName();
  private List<String> mExportList = new ArrayList();
  
  private boolean checkExportFilePath(String paramString, IStickerResourceExportListener paramIStickerResourceExportListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      notifyExportFailed(paramString, paramIStickerResourceExportListener, "导出文件路径为空。");
      return false;
    }
    File localFile1 = new File(paramString);
    if (localFile1.isDirectory())
    {
      notifyExportFailed(paramString, paramIStickerResourceExportListener, "导出文件路径无效。");
      return false;
    }
    if ((localFile1.isFile()) && (localFile1.exists())) {
      localFile1.delete();
    }
    File localFile2 = localFile1.getParentFile();
    if (localFile2 != null) {
      localFile2.mkdirs();
    }
    try
    {
      localFile1.createNewFile();
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyExportFailed(paramString, paramIStickerResourceExportListener, "创建文件失败，请检查权限设置。");
    }
    return false;
  }
  
  public static TAVStickerResourceExporter getInstance()
  {
    return SingletonHolder.sInstance;
  }
  
  private TAVStickerResource getStickerResource(TAVSticker paramTAVSticker, TAVResourceType paramTAVResourceType, String paramString)
  {
    if (paramTAVSticker == null) {
      return null;
    }
    switch (TAVStickerResourceExporter.1.$SwitchMap$com$tencent$tavsticker$model$TAVResourceType[paramTAVResourceType.ordinal()])
    {
    case 2: 
    case 3: 
    case 4: 
    default: 
      return null;
    }
    return new TAVStickerAudioResource(TAVResourceType.AUDIO, paramString, paramTAVSticker.getAudioData(), new CMTime(paramTAVSticker.getAudioStartTime()));
  }
  
  private void notifyExportFailed(String paramString1, IStickerResourceExportListener paramIStickerResourceExportListener, String paramString2)
  {
    if (paramIStickerResourceExportListener != null) {
      paramIStickerResourceExportListener.failed(paramString1, paramString2);
    }
  }
  
  public void export(TAVSticker paramTAVSticker, TAVResourceType paramTAVResourceType, String paramString, IStickerResourceExportListener paramIStickerResourceExportListener)
  {
    for (;;)
    {
      try
      {
        if (this.mExportList.contains(paramString))
        {
          notifyExportFailed(paramString, paramIStickerResourceExportListener, "正在导出，请不要重复操作。");
          return;
        }
        if ((paramTAVSticker == null) || (TextUtils.isEmpty(paramString))) {
          break label142;
        }
        if (!checkExportFilePath(paramString, paramIStickerResourceExportListener)) {
          continue;
        }
        paramTAVSticker = getStickerResource(paramTAVSticker, paramTAVResourceType, paramString);
        if ((paramTAVSticker != null) && (paramTAVSticker.getByteBuffer() != null))
        {
          if (paramIStickerResourceExportListener != null) {
            paramIStickerResourceExportListener.start(paramTAVSticker);
          }
          this.mExportList.add(paramString);
          paramTAVSticker = new ResourceExportTask(paramTAVSticker, paramIStickerResourceExportListener);
          ThreadPoolManager.get().start(paramTAVSticker);
          continue;
        }
        notifyExportFailed(paramString, paramIStickerResourceExportListener, "没有数据。");
      }
      finally {}
      new File(paramString).delete();
      continue;
      label142:
      notifyExportFailed(paramString, paramIStickerResourceExportListener, "参数错误。");
    }
  }
  
  public void exportAudioData(TAVSticker paramTAVSticker, String paramString, IStickerResourceExportListener paramIStickerResourceExportListener)
  {
    try
    {
      export(paramTAVSticker, TAVResourceType.AUDIO, paramString, paramIStickerResourceExportListener);
      return;
    }
    finally
    {
      paramTAVSticker = finally;
      throw paramTAVSticker;
    }
  }
  
  public static abstract interface IStickerResourceExportListener
  {
    public abstract void exporting(TAVStickerResource paramTAVStickerResource, float paramFloat);
    
    public abstract void failed(String paramString1, String paramString2);
    
    public abstract void start(TAVStickerResource paramTAVStickerResource);
    
    public abstract void succeed(TAVStickerResource paramTAVStickerResource);
  }
  
  class ResourceExportTask
    implements Runnable
  {
    public static final int BUFFER_SIZE = 8192;
    private TAVStickerResourceExporter.IStickerResourceExportListener exportListener = null;
    private TAVStickerResource exportResource = null;
    
    public ResourceExportTask(TAVStickerResource paramTAVStickerResource, TAVStickerResourceExporter.IStickerResourceExportListener paramIStickerResourceExportListener)
    {
      this.exportResource = paramTAVStickerResource;
      this.exportListener = paramIStickerResourceExportListener;
    }
    
    public void run()
    {
      if ((this.exportResource != null) && (this.exportResource.getByteBuffer() != null))
      {
        ByteBuffer localByteBuffer = this.exportResource.getByteBuffer();
        int j = localByteBuffer.capacity();
        if (j > 0)
        {
          int i = 0;
          localByteBuffer.position(0);
          if (i < j)
          {
            if (j - i > 8192) {}
            for (byte[] arrayOfByte = new byte[8192];; arrayOfByte = new byte[j - i])
            {
              localByteBuffer.get(arrayOfByte);
              i = localByteBuffer.position();
              FileIOUtils.writeFileFromBytesByStream(this.exportResource.getFilePath(), arrayOfByte, true);
              if (this.exportListener != null)
              {
                float f = 1.0F * i / j;
                TLog.d(TAVStickerResourceExporter.TAG, "pos : " + i + ", size : " + j + ", progress : " + f + ", ThreadId : " + Thread.currentThread().getId());
                this.exportListener.exporting(this.exportResource, f);
                if (i == j)
                {
                  this.exportListener.succeed(this.exportResource);
                  TAVStickerResourceExporter.this.mExportList.remove(this.exportResource.getFilePath());
                }
              }
              break;
            }
          }
        }
        else if (this.exportListener != null)
        {
          this.exportListener.failed(this.exportResource.getFilePath(), "没有数据。");
          TAVStickerResourceExporter.this.mExportList.remove(this.exportResource.getFilePath());
        }
      }
    }
  }
  
  static class SingletonHolder
  {
    private static final TAVStickerResourceExporter sInstance = new TAVStickerResourceExporter(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerResourceExporter
 * JD-Core Version:    0.7.0.1
 */