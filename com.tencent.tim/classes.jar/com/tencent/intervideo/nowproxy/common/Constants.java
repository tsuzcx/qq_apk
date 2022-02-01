package com.tencent.intervideo.nowproxy.common;

public class Constants
{
  public static final int PROXY_VERSION = 12;
  
  public static class CheckFlag
  {
    public static final int CHECK_FAIL = 2;
    public static final int CHECK_SUCCESS = 1;
    public static final int NO_FLAG = 0;
  }
  
  public static class Command
  {
    public static final String IPC_CMD_OPENROOM_RESULT = "cmd_openroom_result";
  }
  
  public static class DownloadEngine
  {
    public static final int DOWNLOAD_ENGINE_DEFAULT = 0;
    public static final int DOWNLOAD_ENGINE_HOST_DEFAULT = 1;
    public static final int DOWNLOAD_ENGINE_HOST_HELLY = 2;
  }
  
  public static class DownloadFlag
  {
    public static final int FIRST_DOWNLOAD = 1;
    public static final int FORCE_DOWNLOAD = 3;
    public static final int NORMAL_DOWNLOAD = 2;
    public static final int NO_FLAG = 0;
    public static final int RETRY_DOWNLOAD = 4;
  }
  
  public static class ErrorCode
  {
    public static final int ERROR_START_FAIL = 1002;
    public static final int ERR_DOWNLOAD_FAIL = 1000;
    public static final int ERR_LOAD_FAIL = 1001;
    public static final int ERR_OPENPARAMS_INVALID = 1;
  }
  
  public static class Flag
  {
    public static final int FLAG_STOP_EXCECUTE_NEXT = 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.Constants
 * JD-Core Version:    0.7.0.1
 */