package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadHandShakeReq
  extends JceStruct
{
  public int iRedirect = 0;
  
  public FileUploadHandShakeReq() {}
  
  public FileUploadHandShakeReq(int paramInt)
  {
    this.iRedirect = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRedirect = paramJceInputStream.read(this.iRedirect, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRedirect, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     FileUpload.FileUploadHandShakeReq
 * JD-Core Version:    0.7.0.1
 */