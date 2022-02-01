package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BubbleReq
  extends JceStruct
{
  public int bubbleID;
  
  public BubbleReq() {}
  
  public BubbleReq(int paramInt)
  {
    this.bubbleID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bubbleID = paramJceInputStream.read(this.bubbleID, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bubbleID, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.BubbleReq
 * JD-Core Version:    0.7.0.1
 */