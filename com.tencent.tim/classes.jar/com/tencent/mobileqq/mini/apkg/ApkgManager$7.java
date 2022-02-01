package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadRequest.OnResponseDataListener;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class ApkgManager$7
  implements DownloadRequest.OnResponseDataListener
{
  boolean completed = false;
  int fileCount = 0;
  int index = 0;
  int indexAreaLength = 0;
  Map<String, ApkgUnpackFileInfo> mapFileInfo = new HashMap();
  byte[] totalContent = null;
  
  ApkgManager$7(ApkgManager paramApkgManager, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener) {}
  
  private boolean enablePipeline()
  {
    boolean bool = false;
    if (QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_download_pipeline_enable", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onRecvData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean)
  {
    if (!enablePipeline()) {}
    for (;;)
    {
      return;
      if ((!this.completed) && (paramInt3 == 0) && (paramLong > 0L))
      {
        if (this.totalContent == null) {
          this.totalContent = new byte[(int)paramLong * 2];
        }
        try
        {
          ApkgUnpackFileInfo localApkgUnpackFileInfo1 = (ApkgUnpackFileInfo)this.mapFileInfo.get("/app-config.json");
          ApkgUnpackFileInfo localApkgUnpackFileInfo2 = (ApkgUnpackFileInfo)this.mapFileInfo.get("/app-service.js");
          if ((localApkgUnpackFileInfo1 != null) && (localApkgUnpackFileInfo1.isCompleted()) && (localApkgUnpackFileInfo2 != null) && (localApkgUnpackFileInfo2.isCompleted()))
          {
            this.completed = true;
            if (this.val$listener == null) {
              continue;
            }
            this.val$listener.onFakeApkgInfo(localApkgUnpackFileInfo1.fileContent, localApkgUnpackFileInfo2.fileContent);
          }
        }
        catch (Exception paramArrayOfByte)
        {
          this.completed = true;
          QLog.e("ApkgManager", 1, "to download OnResponseDataListener error.", paramArrayOfByte);
          return;
        }
      }
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.totalContent, this.index, paramInt2);
    this.index += paramInt2;
    unpackFileContent("/app-config.json");
    unpackFileContent("/app-service.js");
  }
  
  public final int readInt(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramArrayOfByte[paramInt] & 0xFF;
    int j = paramArrayOfByte[(paramInt + 1)] & 0xFF;
    int k = paramArrayOfByte[(paramInt + 2)] & 0xFF;
    paramInt = paramArrayOfByte[(paramInt + 3)] & 0xFF;
    if ((i | j | k | paramInt) < 0) {
      throw new EOFException();
    }
    return (i << 24) + (j << 16) + (k << 8) + (paramInt << 0);
  }
  
  boolean unpackFileContent(String paramString)
    throws Exception
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    label319:
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.index < 17);
        if ((this.index >= 18) && (this.fileCount <= 0))
        {
          this.indexAreaLength = readInt(this.totalContent, 5);
          this.fileCount = readInt(this.totalContent, 14);
        }
      } while (this.index < this.indexAreaLength + 18 - 1);
      int j;
      int i;
      if (!this.mapFileInfo.containsKey(paramString))
      {
        j = 18;
        i = 0;
      }
      for (;;)
      {
        if (i < this.fileCount)
        {
          int k = readInt(this.totalContent, j);
          j += 4;
          localObject = new String(this.totalContent, j, k);
          j += k;
          k = readInt(this.totalContent, j);
          j += 4;
          int m = readInt(this.totalContent, j);
          j += 4;
          if (((String)localObject).equals(paramString))
          {
            QLog.e("ApkgManager", 1, "to download file=" + (String)localObject + " offset=" + k + " size=" + m + " currRecvLength=" + this.index);
            localObject = new ApkgUnpackFileInfo();
            ((ApkgUnpackFileInfo)localObject).filename = paramString;
            ((ApkgUnpackFileInfo)localObject).offset = k;
            ((ApkgUnpackFileInfo)localObject).length = m;
            this.mapFileInfo.put(paramString, localObject);
          }
        }
        else
        {
          localObject = (ApkgUnpackFileInfo)this.mapFileInfo.get(paramString);
          if (localObject == null) {
            break;
          }
          if (TextUtils.isEmpty(((ApkgUnpackFileInfo)localObject).fileContent)) {
            break label319;
          }
          return true;
        }
        i += 1;
      }
    } while (this.index < ((ApkgUnpackFileInfo)localObject).offset + ((ApkgUnpackFileInfo)localObject).length);
    ((ApkgUnpackFileInfo)localObject).fileContent = new String(this.totalContent, ((ApkgUnpackFileInfo)localObject).offset, ((ApkgUnpackFileInfo)localObject).length);
    QLog.e("ApkgManager", 1, "to download and unpack sub file is done! " + paramString + " : " + ((ApkgUnpackFileInfo)localObject).fileContent.substring(0, 100));
    return true;
  }
  
  class ApkgUnpackFileInfo
  {
    public String fileContent;
    public String filename;
    public int length;
    public int offset;
    
    ApkgUnpackFileInfo() {}
    
    public boolean isCompleted()
    {
      return !TextUtils.isEmpty(this.fileContent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.7
 * JD-Core Version:    0.7.0.1
 */