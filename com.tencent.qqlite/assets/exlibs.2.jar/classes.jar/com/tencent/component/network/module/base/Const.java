package com.tencent.component.network.module.base;

import com.tencent.component.network.downloader.strategy.KeepAliveStrategy.KeepAlive;

public class Const
{
  public static final long CONN_CLEAN_PERIOD_MILLIS = 30000L;
  public static final long DEFAULT_IP_VALID_TIME = 604800000L;
  public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE = KeepAliveStrategy.KeepAlive.DISABLE;
  public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE_PROXY = KeepAliveStrategy.KeepAlive.DISABLE;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;
  
  public class DownloadType
  {
    public static final int DOWNLOADER_TYPE_COMMON = 2;
    public static final int DOWNLOADER_TYPE_IMAGE = 1;
    
    public DownloadType() {}
  }
  
  public class ErrorCode
  {
    public static final int LOCAL_RET_CODE_CLIENT_PROTOCOL_EXP = 8;
    public static final int LOCAL_RET_CODE_CONNECT_CLOSED_EXP = 14;
    public static final int LOCAL_RET_CODE_CONNECT_POOL_TIMEOUT_EXP = 13;
    public static final int LOCAL_RET_CODE_CONNECT_TIMEOUT_EXP = 10;
    public static final int LOCAL_RET_CODE_DECODE_FAILED = -4;
    public static final int LOCAL_RET_CODE_EXP = 4;
    public static final int LOCAL_RET_CODE_FNF_EXP = 1;
    public static final int LOCAL_RET_CODE_ILLEGAL_FORMAT = -1;
    public static final int LOCAL_RET_CODE_ILL_EXP = 5;
    public static final int LOCAL_RET_CODE_IO_EXP = 2;
    public static final int LOCAL_RET_CODE_LENGTH_MISMATCH = -3;
    public static final int LOCAL_RET_CODE_NETWORK_FAIL = -99997;
    public static final int LOCAL_RET_CODE_NO_CACHE = -2;
    public static final int LOCAL_RET_CODE_NO_HTTP_RSP_EXP = 11;
    public static final int LOCAL_RET_CODE_OOM_ERR = 3;
    public static final int LOCAL_RET_CODE_SOCKET_EXP = 6;
    public static final int LOCAL_RET_CODE_SOCKET_TO_EXP = 7;
    public static final int LOCAL_RET_CODE_SSL_PEER_UNVERIFIED_EXP = 12;
    public static final int LOCAL_RET_CODE_TRY_FAILED = -99998;
    public static final int LOCAL_RET_CODE_TYPE_MISMATCH = -99996;
    public static final int LOCAL_RET_CODE_UNKNOW = -99999;
    public static final int LOCAL_RET_CODE_UNKNOW_HOST_EXP = 9;
    
    public ErrorCode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.base.Const
 * JD-Core Version:    0.7.0.1
 */