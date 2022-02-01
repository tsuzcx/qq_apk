package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapVideoH264SeiType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPVideoSeiH264Type
{
  @TPNativeKeyMap.MapVideoH264SeiType(147)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_ALTERNATIVE_TRRANSFER = 147;
  @TPNativeKeyMap.MapVideoH264SeiType(0)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_BUFFERING_PERIOD = 0;
  @TPNativeKeyMap.MapVideoH264SeiType(47)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_DISPLAY_ORIENTATION = 47;
  @TPNativeKeyMap.MapVideoH264SeiType(3)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_FILLER_PAYLOAD = 3;
  @TPNativeKeyMap.MapVideoH264SeiType(45)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_FRAME_PACKING = 45;
  @TPNativeKeyMap.MapVideoH264SeiType(56)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_GREEN_METADATA = 56;
  @TPNativeKeyMap.MapVideoH264SeiType(137)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_MASTERING_DISPLAY_COLOUR_VOLUME = 137;
  @TPNativeKeyMap.MapVideoH264SeiType(-1)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_NONE = -1;
  @TPNativeKeyMap.MapVideoH264SeiType(2)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_PAN_SCAN_RECT = 2;
  @TPNativeKeyMap.MapVideoH264SeiType(1)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_PIC_TIMING = 1;
  @TPNativeKeyMap.MapVideoH264SeiType(6)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_RECOVERY_POINT = 6;
  @TPNativeKeyMap.MapVideoH264SeiType(4)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_USER_DATA_REGISTERED = 4;
  @TPNativeKeyMap.MapVideoH264SeiType(5)
  public static final int TP_PLAYER_VIDEO_SEI_H264_TYPE_USER_DATA_UNREGISTERED = 5;
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VIDEO_SEI_H264_TYPE {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPVideoSeiH264Type
 * JD-Core Version:    0.7.0.1
 */