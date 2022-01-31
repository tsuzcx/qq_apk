package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t17b;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tools.ErrMsg;

public class async_context
{
  public byte[] _G = new byte[16];
  public long _appid = 0L;
  DevlockInfo _devlock_info = new DevlockInfo();
  public byte[] _dpwd = new byte[16];
  boolean _isSmslogin = false;
  ErrMsg _last_err_msg = new ErrMsg();
  public int _last_flowid = 0;
  public int _login_bitmap = 0;
  public int _main_sigmap = 0;
  String _mpasswd = "";
  long _msalt = 0L;
  public long _sappid = 0L;
  public boolean _sec_guid_flag = false;
  String _smslogin_msg = "";
  int _smslogin_msgcnt = 0;
  int _smslogin_timelimit = 0;
  public long _sub_appid = 0L;
  public long[] _sub_appid_list = new long[0];
  public tlv_t104 _t104 = new tlv_t104();
  public tlv_t105 _t105 = new tlv_t105();
  public tlv_t126 _t126 = new tlv_t126();
  public tlv_t165 _t165 = new tlv_t165();
  public tlv_t174 _t174 = new tlv_t174();
  public tlv_t17b _t17b = new tlv_t17b();
  public tlv_t402 _t402 = new tlv_t402();
  public tlv_t403 _t403 = new tlv_t403();
  public byte[] _tgtgt_key = new byte[16];
  public byte[] _tmp_no_pic_sig = new byte[0];
  public byte[] _tmp_pwd = new byte[16];
  public int _tmp_pwd_type = 0;
  public byte[] tgtQR = new byte[0];
  public tlv_t tlv528;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.async_context
 * JD-Core Version:    0.7.0.1
 */