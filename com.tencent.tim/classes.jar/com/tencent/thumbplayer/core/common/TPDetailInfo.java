package com.tencent.thumbplayer.core.common;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPDetailInfo
{
  public static final int TP_DETAIL_INFO_TYPE_TRACKING_FIRST_START = 0;
  public static final int TP_DETAIL_INFO_TYPE_UNKNOWN = -1;
  public long timeSince1970Us;
  @TPDetailInfoType
  public int type;
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface TPDetailInfoType {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPDetailInfo
 * JD-Core Version:    0.7.0.1
 */