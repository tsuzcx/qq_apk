package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FacadeEditData
  extends JceStruct
{
  public int iIndexId;
  public String strImageUrl = "";
  public String strText = "";
  
  public FacadeEditData() {}
  
  public FacadeEditData(int paramInt, String paramString1, String paramString2)
  {
    this.iIndexId = paramInt;
    this.strText = paramString1;
    this.strImageUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iIndexId = paramJceInputStream.read(this.iIndexId, 0, false);
    this.strText = paramJceInputStream.readString(1, false);
    this.strImageUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iIndexId, 0);
    if (this.strText != null) {
      paramJceOutputStream.write(this.strText, 1);
    }
    if (this.strImageUrl != null) {
      paramJceOutputStream.write(this.strImageUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FacadeEditData
 * JD-Core Version:    0.7.0.1
 */