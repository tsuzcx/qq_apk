package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import tmsdk.Protocol.MCommon.Sharkfin;

public final class at
  extends JceStruct
{
  static Sharkfin jdField_do = new Sharkfin();
  static ArrayList dp = new ArrayList();
  public int dc = 0;
  public int dd = 0;
  public int dl = 1;
  public Sharkfin dm = null;
  public ArrayList dn = null;
  
  static
  {
    as localas = new as();
    dp.add(localas);
  }
  
  public JceStruct newInit()
  {
    return new at();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dc = paramJceInputStream.read(this.dc, 0, false);
    this.dd = paramJceInputStream.read(this.dd, 1, false);
    this.dl = paramJceInputStream.read(this.dl, 2, false);
    this.dm = ((Sharkfin)paramJceInputStream.read(jdField_do, 3, false));
    this.dn = ((ArrayList)paramJceInputStream.read(dp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.dc != 0) {
      paramJceOutputStream.write(this.dc, 0);
    }
    if (this.dd != 0) {
      paramJceOutputStream.write(this.dd, 1);
    }
    if (this.dl != 1) {
      paramJceOutputStream.write(this.dl, 2);
    }
    if (this.dm != null) {
      paramJceOutputStream.write(this.dm, 3);
    }
    if (this.dn != null) {
      paramJceOutputStream.write(this.dn, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.at
 * JD-Core Version:    0.7.0.1
 */