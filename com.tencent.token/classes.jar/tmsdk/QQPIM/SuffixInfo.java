package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SuffixInfo
  extends JceStruct
{
  public int filecount = 0;
  public long maxSize = 0L;
  public long minSize = 0L;
  public long size = 0L;
  public String suffixname = "";
  
  public JceStruct newInit()
  {
    return new SuffixInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.suffixname = paramJceInputStream.readString(0, true);
    this.filecount = paramJceInputStream.read(this.filecount, 1, true);
    this.size = paramJceInputStream.read(this.size, 2, false);
    this.maxSize = paramJceInputStream.read(this.maxSize, 3, false);
    this.minSize = paramJceInputStream.read(this.minSize, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.suffixname, 0);
    paramJceOutputStream.write(this.filecount, 1);
    long l = this.size;
    if (l != 0L) {
      paramJceOutputStream.write(l, 2);
    }
    l = this.maxSize;
    if (l != 0L) {
      paramJceOutputStream.write(l, 3);
    }
    l = this.minSize;
    if (l != 0L) {
      paramJceOutputStream.write(l, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SuffixInfo
 * JD-Core Version:    0.7.0.1
 */