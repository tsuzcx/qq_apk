package com.tencent.intervideo.nowproxy.common;

public class ChannelConstants
{
  public static final String KEY_RET_CODE = "retcode";
  
  public class CSRetCode
  {
    public static final int CS_RET_FAIL = 10001;
    public static final int CS_RET_SUCCESS = 0;
    public static final int CS_RET_TIMEOUT = 10002;
    
    public CSRetCode() {}
  }
  
  public class CmdInner
  {
    public static final int CMD_RSP = 1;
    public static final int CMD_TIMEOUT = 2;
    
    public CmdInner() {}
  }
  
  public class MainCmd
  {
    public static final int CMD_ACCOUNT = 3;
    public static final int CMD_CS = 1;
    public static final int CMD_PUSH = 2;
    public static final int CMD_SHARE = 4;
    
    public MainCmd() {}
  }
  
  public class Plugin2SdkMsg
  {
    public static final String ACTION_NO_LOGIN = "action.now.nologin";
    
    public Plugin2SdkMsg() {}
  }
  
  public class Sdk2PluginMsg
  {
    public static final String ACTION_LOGIN = "action.now.set.logindata";
    public static final String ACTION_LOGOUT = "action.now.logout";
    
    public Sdk2PluginMsg() {}
  }
  
  public class SdkInner
  {
    public static final String ACTION_JSBRIDGE = "action.now.jscall";
    public static final String ACTION_LOGINDATA_INVALID = "action.now.logindata.invalid";
    public static final String ACTION_LOGINDATA_READY = "action.now.logindata.ready";
    
    public SdkInner() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.ChannelConstants
 * JD-Core Version:    0.7.0.1
 */