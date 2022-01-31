package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Source
  extends JceStruct
{
  public int subtype = 0;
  public int termtype = 0;
  
  public Source() {}
  
  public Source(int paramInt1, int paramInt2)
  {
    this.subtype = paramInt1;
    this.termtype = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.subtype = paramJceInputStream.read(this.subtype, 0, false);
    this.termtype = paramJceInputStream.read(this.termtype, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.subtype, 0);
    paramJceOutputStream.write(this.termtype, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.Source
 * JD-Core Version:    0.7.0.1
 */