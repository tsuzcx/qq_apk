package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UNBINDMBL_LIST
  extends JceStruct
{
  static ArrayList cache__unbindMblList;
  public long _curIndex = 0L;
  public ArrayList _unbindMblList = null;
  
  public UNBINDMBL_LIST() {}
  
  public UNBINDMBL_LIST(long paramLong, ArrayList paramArrayList)
  {
    this._curIndex = paramLong;
    this._unbindMblList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._curIndex = paramJceInputStream.read(this._curIndex, 0, true);
    if (cache__unbindMblList == null)
    {
      cache__unbindMblList = new ArrayList();
      MOBILE_LIST_ITEM localMOBILE_LIST_ITEM = new MOBILE_LIST_ITEM();
      cache__unbindMblList.add(localMOBILE_LIST_ITEM);
    }
    this._unbindMblList = ((ArrayList)paramJceInputStream.read(cache__unbindMblList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._curIndex, 0);
    paramJceOutputStream.write(this._unbindMblList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.UNBINDMBL_LIST
 * JD-Core Version:    0.7.0.1
 */