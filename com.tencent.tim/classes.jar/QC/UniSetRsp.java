package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniSetRsp
  extends JceStruct
{
  static HamletCheck cache_stHamletItem = new HamletCheck();
  static ArrayList<Hamlet> cache_stHamletItemList = new ArrayList();
  public String errmsg = "";
  public int ret;
  public HamletCheck stHamletItem;
  public ArrayList<Hamlet> stHamletItemList;
  public String url = "";
  
  static
  {
    Hamlet localHamlet = new Hamlet();
    cache_stHamletItemList.add(localHamlet);
  }
  
  public UniSetRsp() {}
  
  public UniSetRsp(int paramInt, String paramString1, HamletCheck paramHamletCheck, String paramString2, ArrayList<Hamlet> paramArrayList)
  {
    this.ret = paramInt;
    this.errmsg = paramString1;
    this.stHamletItem = paramHamletCheck;
    this.url = paramString2;
    this.stHamletItemList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.stHamletItem = ((HamletCheck)paramJceInputStream.read(cache_stHamletItem, 2, false));
    this.url = paramJceInputStream.readString(3, false);
    this.stHamletItemList = ((ArrayList)paramJceInputStream.read(cache_stHamletItemList, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.stHamletItem != null) {
      paramJceOutputStream.write(this.stHamletItem, 2);
    }
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 3);
    }
    if (this.stHamletItemList != null) {
      paramJceOutputStream.write(this.stHamletItemList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.UniSetRsp
 * JD-Core Version:    0.7.0.1
 */