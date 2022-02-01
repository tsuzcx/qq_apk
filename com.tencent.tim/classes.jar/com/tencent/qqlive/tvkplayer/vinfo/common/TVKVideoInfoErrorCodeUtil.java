package com.tencent.qqlive.tvkplayer.vinfo.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TVKVideoInfoErrorCodeUtil
{
  private static HashMap<String, Integer> sErrorCodeMap = new HashMap();
  
  static
  {
    sErrorCodeMap.put("ConnectException", Integer.valueOf(3));
    sErrorCodeMap.put("FileNotFoundException", Integer.valueOf(8));
    sErrorCodeMap.put("SSLException", Integer.valueOf(16));
    sErrorCodeMap.put("SSLHandshakeException", Integer.valueOf(17));
    sErrorCodeMap.put("SSLKeyException", Integer.valueOf(18));
    sErrorCodeMap.put("SSLPeerUnverifiedException", Integer.valueOf(19));
    sErrorCodeMap.put("SSLProtocolException", Integer.valueOf(20));
    sErrorCodeMap.put("SocketException", Integer.valueOf(21));
    sErrorCodeMap.put("SocketTimeoutException", Integer.valueOf(5));
    sErrorCodeMap.put("XmlPullParserException", Integer.valueOf(15));
    sErrorCodeMap.put("UnknownHostException", Integer.valueOf(2));
    sErrorCodeMap.put("UnsupportedEncodingException", Integer.valueOf(15));
  }
  
  public static int getErrCodeByThrowable(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return 1;
    }
    Iterator localIterator = sErrorCodeMap.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while (!paramThrowable.toString().contains((CharSequence)localEntry.getKey()));
    for (int i = ((Integer)localEntry.getValue()).intValue();; i = 1) {
      return i;
    }
  }
  
  public static final class Code
  {
    public static final int CODE_BODY_PARSE_ERROR = 23;
    public static final int CODE_CGI_ERROR = 14;
    public static final int CODE_CGI_RECEIVE_NOT_XML = 13;
    public static final int CODE_CIRCULAR_REDIRECT = 10;
    public static final int CODE_CLIENT_PROTOCOL = 9;
    public static final int CODE_CONNECTION_ERROR = 3;
    public static final int CODE_CONNECTION_TIMEOUT = 4;
    public static final int CODE_FILE_NOTFOUND_ERROR = 8;
    public static final int CODE_GENNERAL_IO_ERROR = 6;
    public static final int CODE_HTTP_STATUS_CODE = 12;
    public static final int CODE_ILLEGAL_ARGUMENT = 7;
    public static final int CODE_NETWORK_UNREACHABLE = 22;
    public static final int CODE_NO_HTTP_RESPONSE = 11;
    public static final int CODE_REQUEST_TIME_OUT = 5;
    public static final int CODE_SOCKET_EXCEPTION = 21;
    public static final int CODE_SSL_EXCEPTION = 16;
    public static final int CODE_SSL_HANDSHAKE_EXCEPTION = 17;
    public static final int CODE_SSL_KEY_EXCEPEION = 18;
    public static final int CODE_SSL_PEERUNVERIFIED_EXCEPTION = 19;
    public static final int CODE_SSL_PROTOCOL_EXCEPTION = 20;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNKNONW_HOST = 2;
    public static final int CODE_UNKNOW = 1;
    public static final int CODE_XML_PARSE_ERROR = 15;
  }
  
  public static final class ModuleBase
  {
    public static final int VOD_GETVINFO_MODULE_BASE = 1401000;
    public static final int VOD_GETVKEY_MODULE_BASE = 1402000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.common.TVKVideoInfoErrorCodeUtil
 * JD-Core Version:    0.7.0.1
 */