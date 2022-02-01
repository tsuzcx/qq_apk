package NS_KING_INTERFACE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stPostFeedDingRsp
  extends JceStruct
{
  public int is_ding;
  
  public stPostFeedDingRsp() {}
  
  public stPostFeedDingRsp(int paramInt)
  {
    this.is_ding = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_ding = paramJceInputStream.read(this.is_ding, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_ding, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_INTERFACE.stPostFeedDingRsp
 * JD-Core Version:    0.7.0.1
 */