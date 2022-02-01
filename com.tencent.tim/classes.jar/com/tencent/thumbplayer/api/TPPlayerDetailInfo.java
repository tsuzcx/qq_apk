package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDetailInfoType;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPPlayerDetailInfo
{
  @TPNativeKeyMap.MapDetailInfoType(0)
  public static final int TP_PLAYER_DETAIL_INFO_TYPE_TRACKING_FIRST_START = 0;
  @TPNativeKeyMap.MapDetailInfoType(-1)
  public static final int TP_PLAYER_DETAIL_INFO_TYPE_UNKNOWN = -1;
  public long timeSince1970Ms;
  @TPPlayerDetailInfoType
  public int type;
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TPPlayerDetailInfoType {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPPlayerDetailInfo
 * JD-Core Version:    0.7.0.1
 */