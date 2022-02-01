package com.tencent.oskplayer.model;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface IPStackType
{
  public static final int DUAL = 3;
  public static final int IPV4 = 1;
  public static final int IPV6 = 2;
  public static final int NONE = 0;
  public static final int NOT_SET = -1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.model.IPStackType
 * JD-Core Version:    0.7.0.1
 */