package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.aoi;
import java.util.ArrayList;
import java.util.Collection;

public final class at
  extends JceStruct
{
  static aoi jdField_do = new aoi();
  static ArrayList<as> dp = new ArrayList();
  public int dc = 0;
  public int dd = 0;
  public int dl = 1;
  public aoi dm = null;
  public ArrayList<as> dn = null;
  
  static
  {
    as localas = new as();
    dp.add(localas);
  }
  
  public final JceStruct newInit()
  {
    return new at();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.dc = paramJceInputStream.read(this.dc, 0, false);
    this.dd = paramJceInputStream.read(this.dd, 1, false);
    this.dl = paramJceInputStream.read(this.dl, 2, false);
    this.dm = ((aoi)paramJceInputStream.read(jdField_do, 3, false));
    this.dn = ((ArrayList)paramJceInputStream.read(dp, 4, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.dc;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.dd;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.dl;
    if (i != 1) {
      paramJceOutputStream.write(i, 2);
    }
    Object localObject = this.dm;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.dn;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.at
 * JD-Core Version:    0.7.0.1
 */