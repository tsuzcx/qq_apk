package com.tencent.intervideo.nowproxy;

public class NowProxyConstants
{
  public static final int NOWSDK_VERSION_CODE = 4;
  public static final String NOWSDK_VERSION_NAME = "1.1";
  
  public class AbnormalExitReason
  {
    public static final int KICK_OUT = 1;
    public static final int TIKET_EXPIRED = 2;
    
    public AbnormalExitReason() {}
  }
  
  public class AccountInfoKey
  {
    public static final String A2 = "A2";
    public static final String QQ = "QQ";
    public static final String SKEY = "SKEY";
    public static final String ST = "ST";
    public static final String STKEY = "STKEY";
    public static final String UID = "UIN";
    
    public AccountInfoKey() {}
  }
  
  public class Action
  {
    public static final int ACTION_CLOSE_ROOM = 12;
    public static final int ACTION_DO_ACTION = 6;
    public static final int ACTION_GET_OVERPLUGIN_LOADED = 9;
    public static final int ACTION_KILL_PLUGIN_PROCESS = 4;
    public static final int ACTION_ON_QUERY_PHONE_AUTH_STATE = 7;
    public static final int ACTION_OPEN_ROOM = 1;
    public static final int ACTION_PREINSTALL = 8;
    public static final int ACTION_PRELOAD = 2;
    public static final int ACTION_PRELOAD_COMMON = 10;
    public static final int ACTION_PUSH_MESSAGE = 11;
    public static final int ACTION_UPDATE_FREE_FLOW = 13;
    public static final int ACTION_UPDATE_LOGIN_DATA = 3;
    
    public Action() {}
  }
  
  public class CustomedFlag
  {
    public static final int CSCHANNEL = 4;
    public static final int PAY = 1;
    public static final int REPORT = 512;
    public static final int ROOM_LIFECYCLE = 1024;
    public static final int SHARE = 2;
    public static final int SHARE_MENU_PYQ = 64;
    public static final int SHARE_MENU_QQ = 8;
    public static final int SHARE_MENU_QZONE = 16;
    public static final int SHARE_MENU_WEIBO = 128;
    public static final int SHARE_MENU_WX = 32;
    public static final int SUBSCRIBE = 256;
    
    public CustomedFlag() {}
  }
  
  public class FirstJump
  {
    public static final int FIRST_APP = 1;
    public static final int FIRST_H5 = 3;
    public static final int FIRST_SDK = 2;
    
    public FirstJump() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.NowProxyConstants
 * JD-Core Version:    0.7.0.1
 */