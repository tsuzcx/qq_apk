package oicq.wlogin_sdk.tlv_type;

import oicq.wlogin_sdk.tools.util;

public class tlv_t186
  extends tlv_t
{
  private int _pwdflag;
  
  public tlv_t186()
  {
    this._cmd = 390;
  }
  
  public boolean getPwdflag()
  {
    return this._pwdflag == 1;
  }
  
  public Boolean verify()
  {
    if (this._body_len < 2) {
      return Boolean.FALSE;
    }
    this._pwdflag = util.buf_to_int8(this._buf, this._head_len + 1);
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t186
 * JD-Core Version:    0.7.0.1
 */