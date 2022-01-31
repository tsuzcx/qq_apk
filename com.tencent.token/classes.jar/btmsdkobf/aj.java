package btmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aj
  extends JceStruct
{
  public int bgColor = 0;
  public int bq = 0;
  public int br = 0;
  public String msg = "";
  public String title = "";
  public int type = 0;
  
  public JceStruct newInit()
  {
    return new aj();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.bq = paramJceInputStream.read(this.bq, 3, false);
    this.br = paramJceInputStream.read(this.br, 4, false);
    this.bgColor = paramJceInputStream.read(this.bgColor, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.type != 0) {
      paramJceOutputStream.write(this.type, 2);
    }
    if (this.bq != 0) {
      paramJceOutputStream.write(this.bq, 3);
    }
    if (this.br != 0) {
      paramJceOutputStream.write(this.br, 4);
    }
    if (this.bgColor != 0) {
      paramJceOutputStream.write(this.bgColor, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aj
 * JD-Core Version:    0.7.0.1
 */