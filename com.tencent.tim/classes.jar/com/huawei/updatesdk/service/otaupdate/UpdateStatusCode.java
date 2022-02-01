package com.huawei.updatesdk.service.otaupdate;

public abstract interface UpdateStatusCode
{
  public static final int CANCEL = 4;
  public static final int CHECK_FAILED = 6;
  public static final int CONNECT_ERROR = 2;
  public static final int HAS_UPGRADE_INFO = 7;
  public static final int INSTALL_FAILED = 5;
  public static final int IN_MARKET_UPDATING = 9;
  public static final int MARKET_FORBID = 8;
  public static final int NO_UPGRADE_INFO = 3;
  public static final int PARAMER_ERROR = 1;
  
  public static abstract interface DialogButton
  {
    public static final int CANCEL = 100;
    public static final int CONFIRM = 101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.UpdateStatusCode
 * JD-Core Version:    0.7.0.1
 */