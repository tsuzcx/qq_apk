package oicq.wlogin_sdk.devicelock;

import oicq.wlogin_sdk.tools.util;

public class TLV_CommRsp
  extends e
{
  public byte[] ErrInfo = new byte[0];
  public int ErrInfoType;
  public byte[] ErrMsg = new byte[0];
  public byte[] ErrTitle = new byte[0];
  public int Reason = 0;
  public int RetCode = -1;
  
  public TLV_CommRsp()
  {
    this._type = 1;
  }
  
  public void parse()
  {
    int i = this._head_len;
    this.RetCode = util.buf_to_int32(this._buf, i);
    i += 4;
    this.Reason = util.buf_to_int32(this._buf, i);
    int j = i + 4;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.ErrTitle = new byte[i];
    System.arraycopy(this._buf, j, this.ErrTitle, 0, i);
    j += i;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.ErrMsg = new byte[i];
    System.arraycopy(this._buf, j, this.ErrMsg, 0, i);
    i = j + i;
    this.ErrInfoType = util.buf_to_int16(this._buf, i);
    j = i + 2;
    i = util.buf_to_int16(this._buf, j);
    j += 2;
    this.ErrInfo = new byte[i];
    System.arraycopy(this._buf, j, this.ErrInfo, 0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.devicelock.TLV_CommRsp
 * JD-Core Version:    0.7.0.1
 */