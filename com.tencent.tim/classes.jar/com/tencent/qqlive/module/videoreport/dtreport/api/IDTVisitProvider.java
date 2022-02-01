package com.tencent.qqlive.module.videoreport.dtreport.api;

import java.lang.annotation.Annotation;

public abstract interface IDTVisitProvider
{
  public abstract String getCallFrom();
  
  public abstract String getCallScheme();
  
  public abstract int getStartType();
  
  public static @interface StartType
  {
    public static final int ICON = 0;
    public static final int NONE = -1;
    public static final int PUSH = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.IDTVisitProvider
 * JD-Core Version:    0.7.0.1
 */