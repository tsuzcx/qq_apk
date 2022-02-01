package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetFacadeReqExt
  extends JceStruct
{
  public String cachedChecksum = "";
  
  public GetFacadeReqExt() {}
  
  public GetFacadeReqExt(String paramString)
  {
    this.cachedChecksum = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cachedChecksum = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cachedChecksum != null) {
      paramJceOutputStream.write(this.cachedChecksum, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     FACADE_DIY.GetFacadeReqExt
 * JD-Core Version:    0.7.0.1
 */