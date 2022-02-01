package com.tencent.thumbplayer.adapter.player.thumbplayer;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioSampleFormat;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapCodecType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDetailInfoType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDrmType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapMediaType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapPixelFormat;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSubtitleFontStyle;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSubtitleFormat;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapSubtitleRenderParams;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoH264SeiType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoHevcSeiType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaCodecInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPMediaDrmInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPVideoSeiInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo;
import com.tencent.thumbplayer.api.TPSurfaceRenderInfo.TPVideoCropInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPDetailInfo;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.MediaDrmInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoCropInfo;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo;
import com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo;
import com.tencent.thumbplayer.core.subtitle.TPNativeSubtitleRenderParams;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TPThumbPlayerUtils
{
  public static final int OPTIONAL_ID_TYPE_BOOL = 3;
  public static final int OPTIONAL_ID_TYPE_FLOAT = 7;
  public static final int OPTIONAL_ID_TYPE_ILLEGAL = -1;
  public static final int OPTIONAL_ID_TYPE_INT = 4;
  public static final int OPTIONAL_ID_TYPE_LONG = 1;
  public static final int OPTIONAL_ID_TYPE_OBJECT = 8;
  public static final int OPTIONAL_ID_TYPE_QUEUE_INT = 5;
  public static final int OPTIONAL_ID_TYPE_QUEUE_STRING = 6;
  public static final int OPTIONAL_ID_TYPE_STRING = 2;
  private static String TAG = "TPThumbPlayerUtils";
  
  public static TPAudioFrameBuffer convert2TPAudioFrameBuffer(TPAudioFrame paramTPAudioFrame)
  {
    if (paramTPAudioFrame == null) {
      return null;
    }
    TPAudioFrameBuffer localTPAudioFrameBuffer = new TPAudioFrameBuffer();
    localTPAudioFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapAudioSampleFormat.class, paramTPAudioFrame.format);
    localTPAudioFrameBuffer.data = paramTPAudioFrame.data;
    localTPAudioFrameBuffer.size = paramTPAudioFrame.linesize;
    localTPAudioFrameBuffer.sampleRate = paramTPAudioFrame.sampleRate;
    localTPAudioFrameBuffer.channelLayout = paramTPAudioFrame.channelLayout;
    localTPAudioFrameBuffer.ptsMs = (paramTPAudioFrame.ptsUs / 1000L);
    localTPAudioFrameBuffer.nbSamples = paramTPAudioFrame.nbSamples;
    localTPAudioFrameBuffer.channels = paramTPAudioFrame.channels;
    return localTPAudioFrameBuffer;
  }
  
  public static TPPlayerMsg.TPMediaCodecInfo convert2TPMediaCodecInfo(ITPNativePlayerMessageCallback.MediaCodecInfo paramMediaCodecInfo)
  {
    if (paramMediaCodecInfo == null) {
      return null;
    }
    TPPlayerMsg.TPMediaCodecInfo localTPMediaCodecInfo = new TPPlayerMsg.TPMediaCodecInfo();
    switch (paramMediaCodecInfo.mediaType)
    {
    default: 
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_UNKNOWN;
      switch (paramMediaCodecInfo.infoType)
      {
      default: 
        localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_UNKNOWN;
      }
      break;
    }
    for (;;)
    {
      localTPMediaCodecInfo.msg = paramMediaCodecInfo.msg;
      return localTPMediaCodecInfo;
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_VIDEO;
      break;
      localTPMediaCodecInfo.mediaType = TPPlayerMsg.TPMediaCodecInfo.TP_DEC_MEDIA_TYPE_AUDIO;
      break;
      localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_READY;
      continue;
      localTPMediaCodecInfo.infoType = TPPlayerMsg.TPMediaCodecInfo.TP_INFO_MEDIA_CODEC_EXCEPTION;
    }
  }
  
  public static TPPlayerMsg.TPMediaDrmInfo convert2TPMediaDrmInfo(ITPNativePlayerMessageCallback.MediaDrmInfo paramMediaDrmInfo)
  {
    if (paramMediaDrmInfo == null) {
      return null;
    }
    TPPlayerMsg.TPMediaDrmInfo localTPMediaDrmInfo = new TPPlayerMsg.TPMediaDrmInfo();
    localTPMediaDrmInfo.supportSecureDecoder = paramMediaDrmInfo.supportSecureDecoder;
    localTPMediaDrmInfo.supportSecureDecrypt = paramMediaDrmInfo.supportSecureDecrypt;
    localTPMediaDrmInfo.componentName = paramMediaDrmInfo.componentName;
    localTPMediaDrmInfo.drmType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, paramMediaDrmInfo.drmType);
    return localTPMediaDrmInfo;
  }
  
  private static int convert2TPNativeFontStyleFlags(long paramLong)
  {
    Iterator localIterator = TPNativeKeyMapUtil.getEntrySetOfToNativeMap(TPNativeKeyMap.MapSubtitleFontStyle.class).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Number)localEntry.getKey()).intValue() & paramLong) <= 0L) {
        break label75;
      }
      i = ((Number)localEntry.getValue()).intValue() | i;
    }
    label75:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private static long convert2TPNativeSubtitleParamsFlags(long paramLong)
  {
    Iterator localIterator = TPNativeKeyMapUtil.getEntrySetOfToNativeMap(TPNativeKeyMap.MapSubtitleRenderParams.class).iterator();
    long l = 0L;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Number)localEntry.getKey()).longValue() & paramLong) <= 0L) {
        break label77;
      }
      l = ((Number)localEntry.getValue()).longValue() | l;
    }
    label77:
    for (;;)
    {
      break;
      return l;
    }
  }
  
  public static TPNativeSubtitleRenderParams convert2TPNativeSubtitleRenderParams(TPSubtitleRenderModel paramTPSubtitleRenderModel)
  {
    if (paramTPSubtitleRenderModel == null) {
      return null;
    }
    TPNativeSubtitleRenderParams localTPNativeSubtitleRenderParams = new TPNativeSubtitleRenderParams();
    localTPNativeSubtitleRenderParams.canvasWidth = paramTPSubtitleRenderModel.canvasWidth;
    localTPNativeSubtitleRenderParams.canvasHeight = paramTPSubtitleRenderModel.canvasHeight;
    localTPNativeSubtitleRenderParams.paramFlags = convert2TPNativeSubtitleParamsFlags(paramTPSubtitleRenderModel.paramFlags);
    localTPNativeSubtitleRenderParams.familyName = paramTPSubtitleRenderModel.familyName;
    localTPNativeSubtitleRenderParams.fontSize = paramTPSubtitleRenderModel.fontSize;
    localTPNativeSubtitleRenderParams.fontColor = paramTPSubtitleRenderModel.fontColor;
    localTPNativeSubtitleRenderParams.fontStyleFlags = convert2TPNativeFontStyleFlags(paramTPSubtitleRenderModel.fontStyleFlags);
    localTPNativeSubtitleRenderParams.outlineWidth = paramTPSubtitleRenderModel.outlineWidth;
    localTPNativeSubtitleRenderParams.outlineColor = paramTPSubtitleRenderModel.outlineColor;
    localTPNativeSubtitleRenderParams.lineSpace = paramTPSubtitleRenderModel.lineSpace;
    localTPNativeSubtitleRenderParams.startMargin = paramTPSubtitleRenderModel.startMargin;
    localTPNativeSubtitleRenderParams.endMargin = paramTPSubtitleRenderModel.endMargin;
    localTPNativeSubtitleRenderParams.verticalMargin = paramTPSubtitleRenderModel.verticalMargin;
    localTPNativeSubtitleRenderParams.fontScale = paramTPSubtitleRenderModel.fontScale;
    return localTPNativeSubtitleRenderParams;
  }
  
  public static TPPlayerDetailInfo convert2TPPlayerDetailInfo(TPDetailInfo paramTPDetailInfo)
  {
    if (paramTPDetailInfo == null) {
      return null;
    }
    TPPlayerDetailInfo localTPPlayerDetailInfo = new TPPlayerDetailInfo();
    localTPPlayerDetailInfo.type = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDetailInfoType.class, paramTPDetailInfo.type);
    localTPPlayerDetailInfo.timeSince1970Ms = (paramTPDetailInfo.timeSince1970Us / 1000L);
    return localTPPlayerDetailInfo;
  }
  
  public static TPSurfaceRenderInfo convert2TPPlayerSurfaceRenderInfo(TPNativePlayerSurfaceRenderInfo paramTPNativePlayerSurfaceRenderInfo)
  {
    if (paramTPNativePlayerSurfaceRenderInfo == null) {
      return null;
    }
    TPSurfaceRenderInfo localTPSurfaceRenderInfo = new TPSurfaceRenderInfo();
    localTPSurfaceRenderInfo.displayWidth = paramTPNativePlayerSurfaceRenderInfo.displayWidth;
    localTPSurfaceRenderInfo.displayHeight = paramTPNativePlayerSurfaceRenderInfo.displayHeight;
    localTPSurfaceRenderInfo.videoCropInfo = convert2TPVideoCropInfo(paramTPNativePlayerSurfaceRenderInfo.videoCropInfo);
    return localTPSurfaceRenderInfo;
  }
  
  public static TPPostProcessFrame convert2TPPostProcessFrame(TPPostProcessFrameBuffer paramTPPostProcessFrameBuffer)
  {
    if (paramTPPostProcessFrameBuffer == null) {
      return null;
    }
    TPPostProcessFrame localTPPostProcessFrame = new TPPostProcessFrame();
    localTPPostProcessFrame.mediaType = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapMediaType.class, paramTPPostProcessFrameBuffer.mediaType);
    if (localTPPostProcessFrame.mediaType == 0) {
      localTPPostProcessFrame.format = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPixelFormat.class, paramTPPostProcessFrameBuffer.format);
    }
    for (;;)
    {
      localTPPostProcessFrame.data = paramTPPostProcessFrameBuffer.data;
      localTPPostProcessFrame.linesize = paramTPPostProcessFrameBuffer.size;
      localTPPostProcessFrame.sampleRate = paramTPPostProcessFrameBuffer.sampleRate;
      localTPPostProcessFrame.channelLayout = paramTPPostProcessFrameBuffer.channelLayout;
      localTPPostProcessFrame.ptsUs = (paramTPPostProcessFrameBuffer.ptsMs * 1000L);
      localTPPostProcessFrame.nbSamples = paramTPPostProcessFrameBuffer.nbSamples;
      localTPPostProcessFrame.channels = paramTPPostProcessFrameBuffer.channels;
      localTPPostProcessFrame.width = paramTPPostProcessFrameBuffer.width;
      localTPPostProcessFrame.height = paramTPPostProcessFrameBuffer.height;
      localTPPostProcessFrame.sampleAspectRatioNum = paramTPPostProcessFrameBuffer.sampleAspectRatioNum;
      localTPPostProcessFrame.sampleAspectRatioDen = paramTPPostProcessFrameBuffer.sampleAspectRatioDen;
      localTPPostProcessFrame.rotation = paramTPPostProcessFrameBuffer.rotation;
      localTPPostProcessFrame.perfData = paramTPPostProcessFrameBuffer.perfData;
      return localTPPostProcessFrame;
      if (localTPPostProcessFrame.mediaType == 1) {
        localTPPostProcessFrame.format = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioSampleFormat.class, paramTPPostProcessFrameBuffer.format);
      }
    }
  }
  
  public static TPPostProcessFrameBuffer convert2TPPostProcessFrameBuffer(TPPostProcessFrame paramTPPostProcessFrame)
  {
    if (paramTPPostProcessFrame == null) {
      return null;
    }
    TPPostProcessFrameBuffer localTPPostProcessFrameBuffer = new TPPostProcessFrameBuffer();
    localTPPostProcessFrameBuffer.mediaType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMediaType.class, paramTPPostProcessFrame.mediaType);
    if (localTPPostProcessFrameBuffer.mediaType == 0) {
      localTPPostProcessFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapPixelFormat.class, paramTPPostProcessFrame.format);
    }
    for (;;)
    {
      localTPPostProcessFrameBuffer.data = paramTPPostProcessFrame.data;
      localTPPostProcessFrameBuffer.size = paramTPPostProcessFrame.linesize;
      localTPPostProcessFrameBuffer.sampleRate = paramTPPostProcessFrame.sampleRate;
      localTPPostProcessFrameBuffer.channelLayout = paramTPPostProcessFrame.channelLayout;
      localTPPostProcessFrameBuffer.ptsMs = (paramTPPostProcessFrame.ptsUs / 1000L);
      localTPPostProcessFrameBuffer.nbSamples = paramTPPostProcessFrame.nbSamples;
      localTPPostProcessFrameBuffer.channels = paramTPPostProcessFrame.channels;
      localTPPostProcessFrameBuffer.width = paramTPPostProcessFrame.width;
      localTPPostProcessFrameBuffer.height = paramTPPostProcessFrame.height;
      localTPPostProcessFrameBuffer.sampleAspectRatioNum = paramTPPostProcessFrame.sampleAspectRatioNum;
      localTPPostProcessFrameBuffer.sampleAspectRatioDen = paramTPPostProcessFrame.sampleAspectRatioDen;
      localTPPostProcessFrameBuffer.rotation = paramTPPostProcessFrame.rotation;
      localTPPostProcessFrameBuffer.perfData = paramTPPostProcessFrame.perfData;
      return localTPPostProcessFrameBuffer;
      if (localTPPostProcessFrameBuffer.mediaType == 1) {
        localTPPostProcessFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapAudioSampleFormat.class, paramTPPostProcessFrame.format);
      }
    }
  }
  
  public static TPSubtitleFrameBuffer convert2TPSubtitleFrameBuffer(TPSubtitleFrame paramTPSubtitleFrame)
  {
    if (paramTPSubtitleFrame == null) {
      return null;
    }
    TPSubtitleFrameBuffer localTPSubtitleFrameBuffer = new TPSubtitleFrameBuffer();
    localTPSubtitleFrameBuffer.data = paramTPSubtitleFrame.data;
    localTPSubtitleFrameBuffer.lineSize = paramTPSubtitleFrame.linesize;
    localTPSubtitleFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapSubtitleFormat.class, paramTPSubtitleFrame.format);
    localTPSubtitleFrameBuffer.srcHeight = paramTPSubtitleFrame.height;
    localTPSubtitleFrameBuffer.srcWidth = paramTPSubtitleFrame.width;
    localTPSubtitleFrameBuffer.dstHeight = paramTPSubtitleFrame.height;
    localTPSubtitleFrameBuffer.dstWidth = paramTPSubtitleFrame.width;
    localTPSubtitleFrameBuffer.rotation = paramTPSubtitleFrame.rotation;
    localTPSubtitleFrameBuffer.ptsMs = (paramTPSubtitleFrame.ptsUs / 1000L);
    return localTPSubtitleFrameBuffer;
  }
  
  public static TPPlayerMsg.TPVideoCropInfo convert2TPVideoCropInfo(ITPNativePlayerMessageCallback.VideoCropInfo paramVideoCropInfo)
  {
    if (paramVideoCropInfo == null) {
      return null;
    }
    TPPlayerMsg.TPVideoCropInfo localTPVideoCropInfo = new TPPlayerMsg.TPVideoCropInfo();
    localTPVideoCropInfo.width = paramVideoCropInfo.width;
    localTPVideoCropInfo.height = paramVideoCropInfo.height;
    localTPVideoCropInfo.cropLeft = paramVideoCropInfo.cropLeft;
    localTPVideoCropInfo.cropRight = paramVideoCropInfo.cropRight;
    localTPVideoCropInfo.cropTop = paramVideoCropInfo.cropTop;
    localTPVideoCropInfo.cropBottom = paramVideoCropInfo.cropBottom;
    return localTPVideoCropInfo;
  }
  
  private static TPSurfaceRenderInfo.TPVideoCropInfo convert2TPVideoCropInfo(TPNativePlayerSurfaceRenderInfo.TPVideoCropInfo paramTPVideoCropInfo)
  {
    if (paramTPVideoCropInfo == null) {
      return null;
    }
    TPSurfaceRenderInfo.TPVideoCropInfo localTPVideoCropInfo = new TPSurfaceRenderInfo.TPVideoCropInfo();
    localTPVideoCropInfo.cropLeft = paramTPVideoCropInfo.cropLeft;
    localTPVideoCropInfo.cropRight = paramTPVideoCropInfo.cropRight;
    localTPVideoCropInfo.cropTop = paramTPVideoCropInfo.cropTop;
    localTPVideoCropInfo.cropBottom = paramTPVideoCropInfo.cropBottom;
    localTPVideoCropInfo.width = paramTPVideoCropInfo.width;
    localTPVideoCropInfo.height = paramTPVideoCropInfo.height;
    return localTPVideoCropInfo;
  }
  
  public static TPVideoFrameBuffer convert2TPVideoFrameBuffer(TPVideoFrame paramTPVideoFrame)
  {
    TPVideoFrameBuffer localTPVideoFrameBuffer = new TPVideoFrameBuffer();
    localTPVideoFrameBuffer.data = paramTPVideoFrame.data;
    localTPVideoFrameBuffer.lineSize = paramTPVideoFrame.linesize;
    localTPVideoFrameBuffer.format = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapPixelFormat.class, paramTPVideoFrame.format);
    localTPVideoFrameBuffer.srcHeight = paramTPVideoFrame.height;
    localTPVideoFrameBuffer.srcWidth = paramTPVideoFrame.width;
    localTPVideoFrameBuffer.dstHeight = paramTPVideoFrame.height;
    localTPVideoFrameBuffer.dstWidth = paramTPVideoFrame.width;
    if ((paramTPVideoFrame.sampleAspectRatioDen > 0) && (paramTPVideoFrame.sampleAspectRatioNum > 0)) {
      localTPVideoFrameBuffer.dstWidth = Math.round(paramTPVideoFrame.sampleAspectRatioNum / paramTPVideoFrame.sampleAspectRatioDen * localTPVideoFrameBuffer.dstWidth);
    }
    localTPVideoFrameBuffer.rotation = paramTPVideoFrame.rotation;
    localTPVideoFrameBuffer.ptsMs = (paramTPVideoFrame.ptsUs / 1000L);
    return localTPVideoFrameBuffer;
  }
  
  public static TPPlayerMsg.TPVideoSeiInfo convert2TPVideoSeiInfo(ITPNativePlayerMessageCallback.VideoSeiInfo paramVideoSeiInfo)
  {
    if (paramVideoSeiInfo == null) {
      return null;
    }
    TPPlayerMsg.TPVideoSeiInfo localTPVideoSeiInfo = new TPPlayerMsg.TPVideoSeiInfo();
    localTPVideoSeiInfo.videoCodecType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapCodecType.class, paramVideoSeiInfo.videoCodecType);
    if (localTPVideoSeiInfo.videoCodecType == 26) {
      localTPVideoSeiInfo.videoSeiType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapVideoH264SeiType.class, paramVideoSeiInfo.videoSeiType);
    }
    for (;;)
    {
      localTPVideoSeiInfo.seiDataSize = paramVideoSeiInfo.dataSize;
      localTPVideoSeiInfo.seiData = Arrays.copyOf(paramVideoSeiInfo.data, paramVideoSeiInfo.dataSize);
      return localTPVideoSeiInfo;
      if (localTPVideoSeiInfo.videoCodecType == 172) {
        localTPVideoSeiInfo.videoSeiType = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapVideoHevcSeiType.class, paramVideoSeiInfo.videoSeiType);
      }
    }
  }
  
  public static class OptionIdMapping
  {
    private final int nativePlayerOptionalID;
    private final int optionalIDType;
    
    public OptionIdMapping()
    {
      this.optionalIDType = -1;
      this.nativePlayerOptionalID = -1;
    }
    
    public OptionIdMapping(int paramInt1, int paramInt2)
    {
      this.optionalIDType = paramInt1;
      this.nativePlayerOptionalID = paramInt2;
    }
    
    public int getNativePlayerOptionalID()
    {
      return this.nativePlayerOptionalID;
    }
    
    public int getOptionalIDType()
    {
      return this.optionalIDType;
    }
    
    public boolean isIllegal()
    {
      return (this.optionalIDType == -1) || (this.nativePlayerOptionalID == -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils
 * JD-Core Version:    0.7.0.1
 */