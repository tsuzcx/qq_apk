package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class STMatchRule_Optional
  extends JceStruct
{
  public String postfix = "";
  public String prefix = "";
  public int type = 0;
  public int unit = 0;
  
  public STMatchRule_Optional() {}
  
  public STMatchRule_Optional(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.unit = paramInt1;
    this.type = paramInt2;
    this.prefix = paramString1;
    this.postfix = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.unit = paramJceInputStream.read(this.unit, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.prefix = paramJceInputStream.readString(2, false);
    this.postfix = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.unit, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.prefix != null) {
      paramJceOutputStream.write(this.prefix, 2);
    }
    if (this.postfix != null) {
      paramJceOutputStream.write(this.postfix, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.STMatchRule_Optional
 * JD-Core Version:    0.7.0.1
 */