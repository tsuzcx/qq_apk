package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ExtendFriend
  extends JceStruct
{
  public int fontid;
  
  public ExtendFriend() {}
  
  public ExtendFriend(int paramInt)
  {
    this.fontid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fontid = paramJceInputStream.read(this.fontid, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fontid, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.ExtendFriend
 * JD-Core Version:    0.7.0.1
 */