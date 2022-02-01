package com.tencent.token;

public class ape
{
  public static final int ERR_NETWORK_CLIENTPROTOCOLEXCEPTION = -110000;
  public static final int ERR_NETWORK_COM = -10000;
  public static final int ERR_NETWORK_CON_TIMEOUT = -20000;
  public static final int ERR_NETWORK_EXCEPTION = -150000;
  public static final int ERR_NETWORK_ILLEGALACCESSERROR = -80000;
  public static final int ERR_NETWORK_ILLEGALSTATEEXCEPTION = -90000;
  public static final int ERR_NETWORK_IOEXCEPTION = -140000;
  public static final int ERR_NETWORK_NEED_WIFIAPPROVEMENT = -160000;
  public static final int ERR_NETWORK_NOT_OUR_SERVER = -170000;
  public static final int ERR_NETWORK_PROTOCOLEXCEPTION = -100000;
  public static final int ERR_NETWORK_RECEIVER_FAILED = -40000;
  public static final int ERR_NETWORK_RECV_TIMEOUT = -50000;
  public static final int ERR_NETWORK_REDIRECT = -60000;
  public static final int ERR_NETWORK_SEND_FAILED = -30000;
  public static final int ERR_NETWORK_SOCKETEXCEPTION = -120000;
  public static final int ERR_NETWORK_SOCKETTIMEOUTEXCEPTION = -130000;
  public static final int ERR_NETWORK_SOCKET_CLOSED = -190000;
  public static final int ERR_NETWORK_SOCKET_NO_CONNECTION = -180000;
  public static final int ERR_NETWORK_UNKNOWN = -200000;
  public static final int ERR_NETWORK_UNKNOWNHOSTEXCEPTION = -70000;
  public static final int ERR_NONE = 0;
  public static final int ERR_NORMAL_CLOUDCMD_DONT_CONNECT = -7;
  public static final int ERR_NORMAL_DATA = -5;
  public static final int ERR_NORMAL_ILLEGAL_ARGUMENT = -10;
  public static final int ERR_NORMAL_MORTAL = -9;
  public static final int ERR_NORMAL_NEED_WIFI_APPROVEMENT = -6;
  public static final int ERR_NORMAL_NETWORK_FAILD = -3;
  public static final int ERR_NORMAL_NORESP = -8;
  public static final int ERR_NORMAL_NO_CONNECT = -2;
  public static final int ERR_NORMAL_TIMEOUT = -4;
  public static final int ERR_NORMAL_UNKNOWN = -1;
  public static final int ERR_SHARK_DECODE = -300;
  public static final int ERR_SHARK_DECODE_JCE = -400;
  public static final int ERR_SHARK_FREQUECY_DEFENCE = -700;
  public static final int ERR_SHARK_GET_SHARK = -600;
  public static final int ERR_SHARK_GUID_FAILED = -200;
  public static final int ERR_SHARK_NO_RESP = -500;
  public static final int ERR_SHARK_RSAKEY_FAILED = -100;
  public static final String SHARK_OCEAN = "ocean";
  
  public static final int filterNetworkCode(int paramInt)
  {
    return paramInt % 1000000 - filterSharkCode(paramInt) - filterNormalCode(paramInt);
  }
  
  public static final int filterNormalCode(int paramInt)
  {
    return paramInt % 20;
  }
  
  public static final int filterSharkCode(int paramInt)
  {
    return paramInt % 10000 - filterNormalCode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ape
 * JD-Core Version:    0.7.0.1
 */