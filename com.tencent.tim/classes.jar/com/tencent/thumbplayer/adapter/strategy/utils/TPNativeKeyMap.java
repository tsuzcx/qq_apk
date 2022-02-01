package com.tencent.thumbplayer.adapter.strategy.utils;

import androidx.annotation.Keep;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerAudioCodecType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerAudioDecoderType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerAudioSampleFormat;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerDemuxerType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerDrmType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerHDRType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerMediaType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerPixelFormat;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerReduceLantencyType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerSubtitleFormat;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerVideoCodecType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerVideoDecoderType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerVideoH264SeiType;
import com.tencent.thumbplayer.api.TPCommonEnum.InnerVideoHevcSeiType;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeConnectionAction;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeConnectionConfig;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeErrorType;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeInitConfig;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeMsgInfo;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeOptionalId;
import com.tencent.thumbplayer.api.TPCommonEnum.NativePropertyId;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeSeekMode;
import com.tencent.thumbplayer.api.TPCommonEnum.NativeSwitchDefMode;
import com.tencent.thumbplayer.api.TPCommonEnum.OptionalIdType;
import com.tencent.thumbplayer.api.TPErrorCode;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPVideoSeiH264Type;
import com.tencent.thumbplayer.api.TPVideoSeiHevcType;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionConstant;
import com.tencent.thumbplayer.core.common.TPDetailInfo.TPDetailInfoType;
import com.tencent.thumbplayer.utils.TPDontFuckingProguard;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Keep
@TPDontFuckingProguard
public class TPNativeKeyMap
{
  public static final int INVALID_VALUE = -1;
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapAudioCodecType
  {
    @TPCommonEnum.InnerAudioCodecType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapAudioDecoderType
  {
    @TPCommonEnum.InnerAudioDecoderType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapAudioSampleFormat
  {
    @TPCommonEnum.InnerAudioSampleFormat
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=0L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapCodecType
  {
    @TPCommonEnum.InnerVideoCodecType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPPlayerConnectionConstant.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapConnectionAction
  {
    @TPCommonEnum.NativeConnectionAction
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPPlayerConnectionConstant.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapConnectionConfig
  {
    @TPCommonEnum.NativeConnectionConfig
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapDemuxerType
  {
    @TPCommonEnum.InnerDemuxerType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPPlayerDetailInfo.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapDetailInfoType
  {
    @TPDetailInfo.TPDetailInfoType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=0L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapDrmType
  {
    @TPCommonEnum.InnerDrmType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=1001L, searchClass=TPErrorCode.class, tpDefValue=1001L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapErrorType
  {
    @TPCommonEnum.NativeErrorType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=0L, searchClass=TPCommonEnum.class, tpDefValue=0L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapHdrType
  {
    @TPCommonEnum.InnerHDRType
    int value();
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapInitConfig
  {
    String keyName();
    
    @TPCommonEnum.OptionalIdType
    int type();
    
    @TPCommonEnum.NativeInitConfig
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapMediaType
  {
    @TPCommonEnum.InnerMediaType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPPlayerMsg.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapMsgInfo
  {
    @TPCommonEnum.NativeMsgInfo
    int value();
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapOptionalId
  {
    String keyName();
    
    @TPCommonEnum.OptionalIdType
    int type();
    
    @TPCommonEnum.NativeOptionalId
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapPixelFormat
  {
    @TPCommonEnum.InnerPixelFormat
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPPropertyID.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapPropertyId
  {
    @TPCommonEnum.NativePropertyId
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=0L, searchClass=TPCommonEnum.class, tpDefValue=0L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapReduceLantencyType
  {
    @TPCommonEnum.InnerReduceLantencyType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=2L, searchClass=ITPPlayer.class, tpDefValue=2L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapSeekMode
  {
    @TPCommonEnum.NativeSeekMode
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPSubtitleRenderModel.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapSubtitleFontStyle
  {
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPSubtitleFrameBuffer.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapSubtitleFormat
  {
    @TPCommonEnum.InnerSubtitleFormat
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPSubtitleRenderModel.class, tpDefValue=-1L, valueClass=long.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapSubtitleRenderParams
  {
    long value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=0L, searchClass=ITPPlayer.class, tpDefValue=1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapSwitchDefMode
  {
    @TPCommonEnum.NativeSwitchDefMode
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPCommonEnum.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapVideoDecoderType
  {
    @TPCommonEnum.InnerVideoDecoderType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPVideoSeiH264Type.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapVideoH264SeiType
  {
    @TPCommonEnum.InnerVideoH264SeiType
    int value();
  }
  
  @TPNativeKeyMap.SearchConfig(nativeDefValue=-1L, searchClass=TPVideoSeiHevcType.class, tpDefValue=-1L, valueClass=int.class)
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface MapVideoHevcSeiType
  {
    @TPCommonEnum.InnerVideoHevcSeiType
    int value();
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
  static @interface SearchConfig
  {
    long nativeDefValue();
    
    Class<?> searchClass();
    
    long tpDefValue();
    
    Class<? extends Number> valueClass();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap
 * JD-Core Version:    0.7.0.1
 */