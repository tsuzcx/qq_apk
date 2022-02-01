package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioCodecType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioDecoderType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapAudioSampleFormat;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapCodecType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDemuxerType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDrmType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapHdrType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapMediaType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapPixelFormat;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapReduceLantencyType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoDecoderType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TPCommonEnum
{
  @TPNativeKeyMap.MapMediaType(4)
  public static final int MEDIA_TYPE_ATTACHMENT = 4;
  @TPNativeKeyMap.MapMediaType(1)
  public static final int MEDIA_TYPE_AUDIO = 1;
  @TPNativeKeyMap.MapMediaType(2)
  public static final int MEDIA_TYPE_DATA = 2;
  @TPNativeKeyMap.MapMediaType(3)
  public static final int MEDIA_TYPE_SUBTITLE = 3;
  @TPNativeKeyMap.MapMediaType(-1)
  public static final int MEDIA_TYPE_UNKNOWN = -1;
  @TPNativeKeyMap.MapMediaType(0)
  public static final int MEDIA_TYPE_VIDEO = 0;
  public static final int PLAYER_DESC_ID_ANDROIDPLAYER = 1;
  public static final int PLAYER_DESC_ID_THUMBPLAYER = 2;
  public static final int PLAYER_DESC_ID_THUMBPLAYER_SOFT = 3;
  public static final int PLAYER_DESC_ID_UNKNOWN = 0;
  @TPNativeKeyMap.MapAudioCodecType(5002)
  public static final int TP_ACODEC_TYPE_AAC = 5002;
  @TPNativeKeyMap.MapAudioCodecType(5003)
  public static final int TP_ACODEC_TYPE_AC3 = 5003;
  @TPNativeKeyMap.MapAudioCodecType(5004)
  public static final int TP_ACODEC_TYPE_DTS = 5004;
  @TPNativeKeyMap.MapAudioCodecType(5040)
  public static final int TP_ACODEC_TYPE_EAC3 = 5040;
  @TPNativeKeyMap.MapAudioCodecType(5012)
  public static final int TP_ACODEC_TYPE_FLAC = 5012;
  public static final int TP_ACODEC_TYPE_UNKNOWN = -1;
  @TPNativeKeyMap.MapAudioDecoderType(4)
  public static final int TP_AUDIO_DECODER_DOLBY = 4;
  @TPNativeKeyMap.MapAudioDecoderType(1)
  public static final int TP_AUDIO_DECODER_FFMPEG = 1;
  @TPNativeKeyMap.MapAudioDecoderType(2)
  public static final int TP_AUDIO_DECODER_MEDIACODEC = 2;
  @TPNativeKeyMap.MapAudioDecoderType(5)
  public static final int TP_AUDIO_DECODER_STANDALONE = 5;
  public static final int TP_AUDIO_RENDERER_TYPE_AAUDIO = 2;
  public static final int TP_AUDIO_RENDERER_TYPE_AUDIOTRACK = 1;
  public static final int TP_AUDIO_RENDERER_TYPE_OBOE = 3;
  public static final int TP_AUDIO_RENDERER_TYPE_OPENAL = 5;
  public static final int TP_AUDIO_RENDERER_TYPE_OPENSL = 4;
  @TPNativeKeyMap.MapAudioSampleFormat(4)
  public static final int TP_AUDIO_SAMPLE_FORMAT_DBL = 4;
  @TPNativeKeyMap.MapAudioSampleFormat(9)
  public static final int TP_AUDIO_SAMPLE_FORMAT_DBLP = 9;
  @TPNativeKeyMap.MapAudioSampleFormat(3)
  public static final int TP_AUDIO_SAMPLE_FORMAT_FLT = 3;
  @TPNativeKeyMap.MapAudioSampleFormat(8)
  public static final int TP_AUDIO_SAMPLE_FORMAT_FLTP = 8;
  @TPNativeKeyMap.MapAudioSampleFormat(-1)
  public static final int TP_AUDIO_SAMPLE_FORMAT_NONE = -1;
  @TPNativeKeyMap.MapAudioSampleFormat(1)
  public static final int TP_AUDIO_SAMPLE_FORMAT_S16 = 1;
  @TPNativeKeyMap.MapAudioSampleFormat(6)
  public static final int TP_AUDIO_SAMPLE_FORMAT_S16P = 6;
  @TPNativeKeyMap.MapAudioSampleFormat(2)
  public static final int TP_AUDIO_SAMPLE_FORMAT_S32 = 2;
  @TPNativeKeyMap.MapAudioSampleFormat(7)
  public static final int TP_AUDIO_SAMPLE_FORMAT_S32P = 7;
  @TPNativeKeyMap.MapAudioSampleFormat(10)
  public static final int TP_AUDIO_SAMPLE_FORMAT_S64 = 10;
  @TPNativeKeyMap.MapAudioSampleFormat(11)
  public static final int TP_AUDIO_SAMPLE_FORMAT_S64P = 11;
  @TPNativeKeyMap.MapAudioSampleFormat(0)
  public static final int TP_AUDIO_SAMPLE_FORMAT_U8 = 0;
  @TPNativeKeyMap.MapAudioSampleFormat(5)
  public static final int TP_AUDIO_SAMPLE_FORMAT_U8P = 5;
  public static final int TP_DECODER_UNKNOWN = -1;
  @TPNativeKeyMap.MapDemuxerType(0)
  public static final int TP_DEMUXER_FFMPEG = 0;
  @TPNativeKeyMap.MapDemuxerType(1)
  public static final int TP_DEMUXER_STANDALONE = 1;
  @TPNativeKeyMap.MapDemuxerType(-1)
  public static final int TP_DEMUXER_UNKNOWN = -1;
  @TPNativeKeyMap.MapDrmType(2)
  public static final int TP_DRM_TYPE_CHINADRM_HW = 2;
  @TPNativeKeyMap.MapDrmType(3)
  public static final int TP_DRM_TYPE_SELF_CHINADRM = 3;
  @TPNativeKeyMap.MapDrmType(0)
  public static final int TP_DRM_TYPE_WIDEVINE_HW = 0;
  @TPNativeKeyMap.MapDrmType(1)
  public static final int TP_DRM_TYPE_WIDEVINE_SW = 1;
  @TPNativeKeyMap.MapHdrType(0)
  public static final int TP_HDR_TYPE_HDR10 = 0;
  @TPNativeKeyMap.MapHdrType(1)
  public static final int TP_HDR_TYPE_HDR10PLUS = 1;
  @TPNativeKeyMap.MapHdrType(4)
  public static final int TP_HDR_TYPE_HDRCUVAVISION = 4;
  @TPNativeKeyMap.MapHdrType(2)
  public static final int TP_HDR_TYPE_HDRDOLBYVISION = 2;
  @TPNativeKeyMap.MapHdrType(3)
  public static final int TP_HDR_TYPE_HDRHLG = 3;
  @TPNativeKeyMap.MapReduceLantencyType(0)
  public static final int TP_REDUCE_LIVE_LATENCY_ACTION_NONE = 0;
  @TPNativeKeyMap.MapReduceLantencyType(2)
  public static final int TP_REDUCE_LIVE_LATENCY_ACTION_SKIP_FRAME = 2;
  @TPNativeKeyMap.MapReduceLantencyType(1)
  public static final int TP_REDUCE_LIVE_LATENCY_ACTION_SPEED_UP = 1;
  public static final int TP_RENDERER_TYPE_NONE = -1;
  public static final int TP_SUBTITLE_OUTPUT_RGBA = 1;
  public static final int TP_SUBTITLE_OUTPUT_TEXT = 0;
  @TPNativeKeyMap.MapCodecType(1029)
  public static final int TP_VCODEC_TYPE_AV1 = 1029;
  @TPNativeKeyMap.MapCodecType(192)
  public static final int TP_VCODEC_TYPE_AVS3 = 192;
  @TPNativeKeyMap.MapCodecType(26)
  public static final int TP_VCODEC_TYPE_H264 = 26;
  @TPNativeKeyMap.MapCodecType(172)
  public static final int TP_VCODEC_TYPE_HEVC = 172;
  @TPNativeKeyMap.MapCodecType(-1)
  public static final int TP_VCODEC_TYPE_UNKNOWN = 0;
  @TPNativeKeyMap.MapVideoDecoderType(101)
  public static final int TP_VIDEO_DECODER_FFMPEG = 101;
  @TPNativeKeyMap.MapVideoDecoderType(102)
  public static final int TP_VIDEO_DECODER_MEDIACODEC = 102;
  @TPNativeKeyMap.MapVideoDecoderType(104)
  public static final int TP_VIDEO_DECODER_STANDALONE = 104;
  @TPNativeKeyMap.MapPixelFormat(-1)
  public static final int TP_VIDEO_OUTPUT_FORMAT_NONE = -1;
  @TPNativeKeyMap.MapPixelFormat(37)
  public static final int TP_VIDEO_OUTPUT_FORMAT_RGB565 = 37;
  @TPNativeKeyMap.MapPixelFormat(26)
  public static final int TP_VIDEO_OUTPUT_FORMAT_RGBA = 26;
  @TPNativeKeyMap.MapPixelFormat(0)
  public static final int TP_VIDEO_OUTPUT_FORMAT_YUV420P = 0;
  @TPNativeKeyMap.MapPixelFormat(12)
  public static final int TP_VIDEO_OUTPUT_FORMAT_YUVJ420P = 12;
  public static final int TP_VIDEO_RENDERER_TYPE_OPENGL = 101;
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerAudioCodecType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerAudioDecoderType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerAudioSampleFormat {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerDemuxerType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerDrmType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE})
  public static @interface InnerHDRType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerMediaType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerPixelFormat {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerReduceLantencyType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerSubtitleFormat {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerVideoCodecType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerVideoDecoderType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerVideoH264SeiType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.PARAMETER})
  public static @interface InnerVideoHevcSeiType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface MEDIA_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD})
  public static @interface NativeConnectionAction {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD})
  public static @interface NativeConnectionConfig {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeErrorType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeInitConfig {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
  public static @interface NativeMsgInfo {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeOptionalId {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.LOCAL_VARIABLE})
  public static @interface NativePropertyId {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeSeekMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface NativeSwitchDefMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface OptionalIdType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PlayerType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface TPErrorType {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
  public static @interface TPMsgInfo {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD})
  public static @interface TPOptionalId {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER})
  public static @interface TPSeekMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.PARAMETER})
  public static @interface TPSwitchDefMode {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_AUDIO_CODEC_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_AUDIO_DECODER_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_AUDIO_SAMPLE_FORMAT {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_DRM_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_HDR_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_SUBTITLE_OUTPUT_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_VIDEO_CODEC_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_VIDEO_DECODER_TYPE {}
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TP_VIDEO_PIXEL_FORMAT {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPCommonEnum
 * JD-Core Version:    0.7.0.1
 */