package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class setUserProfileRsp
  extends JceStruct
{
  public int ret;
  public String url = "";
  
  public setUserProfileRsp() {}
  
  public setUserProfileRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ProfileLogic.QC.setUserProfileRsp
 * JD-Core Version:    0.7.0.1
 */