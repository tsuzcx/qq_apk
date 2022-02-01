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
    String str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    int i = this.type;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    i = this.bq;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    i = this.br;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    i = this.bgColor;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.aj
 * JD-Core Version:    0.7.0.1
 */