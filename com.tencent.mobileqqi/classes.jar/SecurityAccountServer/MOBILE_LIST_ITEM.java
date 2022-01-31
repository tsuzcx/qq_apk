package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MOBILE_LIST_ITEM
  extends JceStruct
{
  public int _accountAbi = 0;
  public long _bind_uin = 0L;
  public int _commFrdCount = 0;
  public int _flag = 0;
  public long _isFriend = 0L;
  public long _isRecommend = 0L;
  public String _mobile = "";
  public String _mobileCode = "";
  public String _mobileInDCache = "";
  public String _name = "";
  public String _nameInDCache = "";
  public String _nationCode = "";
  public String _nick_name = "";
  public long _originBinder = 0L;
  public long _recommendDate = 0L;
  public int _rmdScore = 0;
  public String _value = "";
  
  public MOBILE_LIST_ITEM() {}
  
  public MOBILE_LIST_ITEM(String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong3, String paramString7, String paramString8, long paramLong4, long paramLong5, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._mobile = paramString1;
    this._name = paramString2;
    this._bind_uin = paramLong1;
    this._isRecommend = paramLong2;
    this._value = paramString3;
    this._nationCode = paramString4;
    this._mobileCode = paramString5;
    this._nick_name = paramString6;
    this._isFriend = paramLong3;
    this._mobileInDCache = paramString7;
    this._nameInDCache = paramString8;
    this._recommendDate = paramLong4;
    this._originBinder = paramLong5;
    this._accountAbi = paramInt1;
    this._commFrdCount = paramInt2;
    this._flag = paramInt3;
    this._rmdScore = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._mobile = paramJceInputStream.readString(0, true);
    this._name = paramJceInputStream.readString(1, true);
    this._bind_uin = paramJceInputStream.read(this._bind_uin, 2, true);
    this._isRecommend = paramJceInputStream.read(this._isRecommend, 3, false);
    this._value = paramJceInputStream.readString(4, false);
    this._nationCode = paramJceInputStream.readString(5, false);
    this._mobileCode = paramJceInputStream.readString(6, false);
    this._nick_name = paramJceInputStream.readString(7, false);
    this._isFriend = paramJceInputStream.read(this._isFriend, 8, false);
    this._mobileInDCache = paramJceInputStream.readString(9, false);
    this._nameInDCache = paramJceInputStream.readString(10, false);
    this._recommendDate = paramJceInputStream.read(this._recommendDate, 11, false);
    this._originBinder = paramJceInputStream.read(this._originBinder, 12, false);
    this._accountAbi = paramJceInputStream.read(this._accountAbi, 13, false);
    this._commFrdCount = paramJceInputStream.read(this._commFrdCount, 14, false);
    this._flag = paramJceInputStream.read(this._flag, 15, false);
    this._rmdScore = paramJceInputStream.read(this._rmdScore, 16, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._mobile, 0);
    paramJceOutputStream.write(this._name, 1);
    paramJceOutputStream.write(this._bind_uin, 2);
    paramJceOutputStream.write(this._isRecommend, 3);
    if (this._value != null) {
      paramJceOutputStream.write(this._value, 4);
    }
    if (this._nationCode != null) {
      paramJceOutputStream.write(this._nationCode, 5);
    }
    if (this._mobileCode != null) {
      paramJceOutputStream.write(this._mobileCode, 6);
    }
    if (this._nick_name != null) {
      paramJceOutputStream.write(this._nick_name, 7);
    }
    paramJceOutputStream.write(this._isFriend, 8);
    if (this._mobileInDCache != null) {
      paramJceOutputStream.write(this._mobileInDCache, 9);
    }
    if (this._nameInDCache != null) {
      paramJceOutputStream.write(this._nameInDCache, 10);
    }
    paramJceOutputStream.write(this._recommendDate, 11);
    paramJceOutputStream.write(this._originBinder, 12);
    paramJceOutputStream.write(this._accountAbi, 13);
    paramJceOutputStream.write(this._commFrdCount, 14);
    paramJceOutputStream.write(this._flag, 15);
    paramJceOutputStream.write(this._rmdScore, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.MOBILE_LIST_ITEM
 * JD-Core Version:    0.7.0.1
 */