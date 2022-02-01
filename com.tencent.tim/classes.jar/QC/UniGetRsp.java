package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniGetRsp
  extends JceStruct
{
  static ArrayList<UniBusinessItem> cache_uniBusinessItemList = new ArrayList();
  public String errmsg = "";
  public int ret;
  public ArrayList<UniBusinessItem> uniBusinessItemList;
  
  static
  {
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    cache_uniBusinessItemList.add(localUniBusinessItem);
  }
  
  public UniGetRsp() {}
  
  public UniGetRsp(int paramInt, String paramString, ArrayList<UniBusinessItem> paramArrayList)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.uniBusinessItemList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.uniBusinessItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusinessItemList, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.uniBusinessItemList != null) {
      paramJceOutputStream.write(this.uniBusinessItemList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.UniGetRsp
 * JD-Core Version:    0.7.0.1
 */