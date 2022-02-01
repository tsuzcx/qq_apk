package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList<e> bB = new ArrayList();
  public ArrayList<e> bA = null;
  public int bv = 0;
  
  static
  {
    e locale = new e();
    bB.add(locale);
  }
  
  public JceStruct newInit()
  {
    return new h();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bv = paramJceInputStream.read(this.bv, 0, false);
    this.bA = ((ArrayList)paramJceInputStream.read(bB, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bv != 0) {
      paramJceOutputStream.write(this.bv, 0);
    }
    if (this.bA != null) {
      paramJceOutputStream.write(this.bA, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     Protocol.MConch.h
 * JD-Core Version:    0.7.0.1
 */