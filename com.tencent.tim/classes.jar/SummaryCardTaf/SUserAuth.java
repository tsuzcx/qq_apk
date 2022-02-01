package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SUserAuth
  extends JceStruct
{
  static int cache_keytype;
  public String keystr = "";
  public int keytype;
  
  public SUserAuth() {}
  
  public SUserAuth(int paramInt, String paramString)
  {
    this.keytype = paramInt;
    this.keystr = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.keytype = paramJceInputStream.read(this.keytype, 0, true);
    this.keystr = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.keytype, 0);
    paramJceOutputStream.write(this.keystr, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCardTaf.SUserAuth
 * JD-Core Version:    0.7.0.1
 */