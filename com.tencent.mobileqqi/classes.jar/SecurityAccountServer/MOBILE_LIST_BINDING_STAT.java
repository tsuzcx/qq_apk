package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MOBILE_LIST_BINDING_STAT
  extends JceStruct
{
  static ArrayList cache__mobileList;
  public long _curIndex = 0L;
  public long _curIndex4QryMblCttSession = 0L;
  public ArrayList _mobileList = null;
  
  public MOBILE_LIST_BINDING_STAT() {}
  
  public MOBILE_LIST_BINDING_STAT(long paramLong1, ArrayList paramArrayList, long paramLong2)
  {
    this._curIndex = paramLong1;
    this._mobileList = paramArrayList;
    this._curIndex4QryMblCttSession = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._curIndex = paramJceInputStream.read(this._curIndex, 0, true);
    if (cache__mobileList == null)
    {
      cache__mobileList = new ArrayList();
      MOBILE_LIST_ITEM localMOBILE_LIST_ITEM = new MOBILE_LIST_ITEM();
      cache__mobileList.add(localMOBILE_LIST_ITEM);
    }
    this._mobileList = ((ArrayList)paramJceInputStream.read(cache__mobileList, 1, true));
    this._curIndex4QryMblCttSession = paramJceInputStream.read(this._curIndex4QryMblCttSession, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._curIndex, 0);
    paramJceOutputStream.write(this._mobileList, 1);
    paramJceOutputStream.write(this._curIndex4QryMblCttSession, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.MOBILE_LIST_BINDING_STAT
 * JD-Core Version:    0.7.0.1
 */