package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class FRIEND_LIST
  extends JceStruct
{
  static ArrayList cache__friendUinList;
  public ArrayList _friendUinList = null;
  
  public FRIEND_LIST() {}
  
  public FRIEND_LIST(ArrayList paramArrayList)
  {
    this._friendUinList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache__friendUinList == null)
    {
      cache__friendUinList = new ArrayList();
      cache__friendUinList.add(Long.valueOf(0L));
    }
    this._friendUinList = ((ArrayList)paramJceInputStream.read(cache__friendUinList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this._friendUinList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.FRIEND_LIST
 * JD-Core Version:    0.7.0.1
 */