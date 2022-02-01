package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stBlockRecommPersonReq
  extends JceStruct
{
  public String personId = "";
  
  public stBlockRecommPersonReq() {}
  
  public stBlockRecommPersonReq(String paramString)
  {
    this.personId = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.personId = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.personId != null) {
      paramJceOutputStream.write(this.personId, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stBlockRecommPersonReq
 * JD-Core Version:    0.7.0.1
 */