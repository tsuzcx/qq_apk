package com.tencent.mobileqq.utils.pathtracker;

import java.text.SimpleDateFormat;

public enum DumpUtils
{
  INSTANCE;
  
  public static final String DUMP_PATH = "/Tencent/QQLite/log/";
  private final SimpleDateFormat mDateFormat = new SimpleDateFormat("MM.dd-HH:mm:ss");
  private Integer mPid = null;
  
  public void dumpToFile(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.pathtracker.DumpUtils
 * JD-Core Version:    0.7.0.1
 */