package MAAccessClient;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSinglePkgSigRsp
  extends JceStruct
{
  public String pkgSig = "";
  public int ret;
  
  public GetSinglePkgSigRsp() {}
  
  public GetSinglePkgSigRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.pkgSig = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.pkgSig = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.pkgSig, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MAAccessClient.GetSinglePkgSigRsp
 * JD-Core Version:    0.7.0.1
 */