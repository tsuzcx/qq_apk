package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.b.ad;
import oicq.wlogin_sdk.b.ay;
import oicq.wlogin_sdk.b.bi;
import oicq.wlogin_sdk.b.bn;
import oicq.wlogin_sdk.b.cm;
import oicq.wlogin_sdk.b.cn;
import oicq.wlogin_sdk.b.f;
import oicq.wlogin_sdk.b.g;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
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
  public f _t104 = new f();
  public g _t105 = new g();
  public ad _t126 = new ad();
  public ay _t165 = new ay();
  public bi _t174 = new bi();
  public bn _t17b = new bn();
  public cm _t402 = new cm();
  public cn _t403 = new cn();
  public byte[] _tgtgt_key = new byte[16];
  public byte[] _tmp_no_pic_sig = new byte[0];
  public byte[] _tmp_pwd = new byte[16];
  public int _tmp_pwd_type = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.async_context
 * JD-Core Version:    0.7.0.1
 */