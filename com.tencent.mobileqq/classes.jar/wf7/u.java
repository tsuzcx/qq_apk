package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class u
  extends JceStruct
{
  static dl bV = new dl();
  public dl bS = null;
  public String bT = "";
  public String bU = "";
  
  public JceStruct newInit()
  {
    return new u();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bS = ((dl)paramJceInputStream.read(bV, 0, true));
    this.bT = paramJceInputStream.readString(1, true);
    this.bU = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bS, 0);
    paramJceOutputStream.write(this.bT, 1);
    String str = this.bU;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.u
 * JD-Core Version:    0.7.0.1
 */