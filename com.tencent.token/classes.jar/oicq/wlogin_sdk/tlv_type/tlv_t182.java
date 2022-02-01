package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t182
  extends tlv_t
{
  int _msgCnt = 0;
  int _timeLimit = 0;
  
  public tlv_t182()
  {
    this._cmd = 386;
  }
  
  public int getMsgCnt()
  {
    return this._msgCnt;
  }
  
  public int getTimeLimit()
  {
    return this._timeLimit;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 5) {
      return Boolean.FALSE;
    }
    this._msgCnt = util.buf_to_int16(this._buf, this._head_len + 1);
    this._timeLimit = util.buf_to_int16(this._buf, this._head_len + 1 + 2);
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t182
 * JD-Core Version:    0.7.0.1
 */