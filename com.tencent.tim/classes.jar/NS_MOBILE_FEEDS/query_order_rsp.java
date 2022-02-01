package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class query_order_rsp
  extends JceStruct
{
  public int iProduct;
  public int iResult;
  public int iStatus;
  
  public query_order_rsp() {}
  
  public query_order_rsp(int paramInt1, int paramInt2, int paramInt3)
  {
    this.iResult = paramInt1;
    this.iProduct = paramInt2;
    this.iStatus = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iResult = paramJceInputStream.read(this.iResult, 0, false);
    this.iProduct = paramJceInputStream.read(this.iProduct, 1, false);
    this.iStatus = paramJceInputStream.read(this.iStatus, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iResult, 0);
    paramJceOutputStream.write(this.iProduct, 1);
    paramJceOutputStream.write(this.iStatus, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.query_order_rsp
 * JD-Core Version:    0.7.0.1
 */