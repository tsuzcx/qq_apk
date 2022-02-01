package com.tencent.thumbplayer.tplayer;

import android.os.ParcelFileDescriptor;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import java.util.Map;

class TPThreadSwitchCommons
{
  static class TPAudioTrackSourceParams
  {
    TPDownloadParamData dlParamData;
    String name;
    String url;
  }
  
  static class TPDataSourceParams
  {
    Map<String, String> httpHeader;
    ITPMediaAsset mediaAsset;
    ParcelFileDescriptor pfd;
    String url;
  }
  
  static class TPDrmPropertyParams
  {
    String propertyName;
    String value;
  }
  
  static class TPLoopbackParams
  {
    boolean isLoopback;
    long loopEndPositionMs = -1L;
    long loopStartPositionMs = 0L;
  }
  
  static class TPOnPlayCallBackParams
  {
    Object ext1;
    Object ext2;
    Object ext3;
    Object ext4;
    int messageType;
  }
  
  static class TPOnReadDataParams
  {
    int fileId;
    String fileKey;
    long length;
    long offset;
  }
  
  static class TPOnStartReadDataParams
  {
    int fileId;
    String fileKey;
    long requestEnd;
    long requestStart;
  }
  
  static class TPProgramInfoResult
  {
    TPProgramInfo[] programInfos;
    
    void reset()
    {
      this.programInfos = null;
    }
  }
  
  static class TPSubTitleParams
  {
    TPDownloadParamData downloadParamData;
    String mimeType;
    String name;
    String url;
  }
  
  static class TPSwitchCommonParams
  {
    long arg1;
    long arg2;
    Object extraObject;
  }
  
  static class TPSwitchDefParams
  {
    long defID;
    ITPMediaAsset mediaAsset;
    int mode;
    String url;
    TPVideoInfo videoInfo;
  }
  
  static class TPTrackInfoResult
  {
    TPTrackInfo[] trackInfos;
    
    void reset()
    {
      this.trackInfos = null;
    }
  }
  
  static class TPVideoCaptureParams
  {
    TPCaptureCallBack callBack;
    TPCaptureParams params;
  }
  
  static class TPVideoSizeResult
  {
    int height;
    int width;
    
    void resetHeight()
    {
      this.height = 0;
    }
    
    void resetWidth()
    {
      this.width = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.TPThreadSwitchCommons
 * JD-Core Version:    0.7.0.1
 */