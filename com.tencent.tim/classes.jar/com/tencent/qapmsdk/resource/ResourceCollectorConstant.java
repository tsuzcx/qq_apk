package com.tencent.qapmsdk.resource;

import android.os.Process;

public class ResourceCollectorConstant
{
  public static final int IMMEDIATE_SIZE = 900;
  static final int MANUAL_SIZE = 100;
  public static final int MAX_REPORT_COUNT = 3;
  public static final int MAX_STORE_FILE = 10;
  static final String PID_REG = "^" + Process.myPid() + "\\s+";
  static final String SYS_REG = "(\\d+)%user\\s+(\\d+)%nice\\s+(\\d+)%sys";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.ResourceCollectorConstant
 * JD-Core Version:    0.7.0.1
 */