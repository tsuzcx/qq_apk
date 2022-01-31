package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SolutionItem
  extends JceStruct
{
  static byte[] a = (byte[])new byte[1];
  public int adapterId = 0;
  public long commSoluId = 0L;
  public long extSoluId = 0L;
  public String policyId = "";
  public byte[] soluInfo = null;
  public int soluType = 0;
  
  static
  {
    ((byte[])a)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new SolutionItem();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commSoluId = paramJceInputStream.read(this.commSoluId, 0, true);
    this.extSoluId = paramJceInputStream.read(this.extSoluId, 1, true);
    this.soluType = paramJceInputStream.read(this.soluType, 2, true);
    this.adapterId = paramJceInputStream.read(this.adapterId, 3, true);
    this.soluInfo = ((byte[])paramJceInputStream.read(a, 4, true));
    this.policyId = paramJceInputStream.readString(5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.commSoluId, 0);
    paramJceOutputStream.write(this.extSoluId, 1);
    paramJceOutputStream.write(this.soluType, 2);
    paramJceOutputStream.write(this.adapterId, 3);
    paramJceOutputStream.write(this.soluInfo, 4);
    paramJceOutputStream.write(this.policyId, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.SolutionItem
 * JD-Core Version:    0.7.0.1
 */