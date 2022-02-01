package oicq.wlogin_sdk.request;

import java.io.Serializable;

public class UinInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public boolean _hasPassword;
  public Long _uin;
  private int pwdState = 0;
  
  public UinInfo(Long paramLong, boolean paramBoolean)
  {
    this._uin = paramLong;
    this._hasPassword = paramBoolean;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      this.pwdState = i;
      return;
    }
  }
  
  public boolean getHasPassword()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!this._hasPassword) {
      if (this.pwdState > 1) {
        break label31;
      }
    }
    label31:
    for (bool1 = bool2;; bool1 = false)
    {
      this._hasPassword = bool1;
      return this._hasPassword;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.UinInfo
 * JD-Core Version:    0.7.0.1
 */