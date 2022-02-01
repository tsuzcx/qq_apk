package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class Hamlet
  extends JceStruct
{
  static ArrayList<UniBusinessItem> cache_itemlist = new ArrayList();
  public ArrayList<UniBusinessItem> itemlist;
  public int locationtype;
  public long uid;
  
  static
  {
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    cache_itemlist.add(localUniBusinessItem);
  }
  
  public Hamlet() {}
  
  public Hamlet(long paramLong, int paramInt, ArrayList<UniBusinessItem> paramArrayList)
  {
    this.uid = paramLong;
    this.locationtype = paramInt;
    this.itemlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.read(this.uid, 0, false);
    this.locationtype = paramJceInputStream.read(this.locationtype, 1, false);
    this.itemlist = ((ArrayList)paramJceInputStream.read(cache_itemlist, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uid, 0);
    paramJceOutputStream.write(this.locationtype, 1);
    if (this.itemlist != null) {
      paramJceOutputStream.write(this.itemlist, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.Hamlet
 * JD-Core Version:    0.7.0.1
 */