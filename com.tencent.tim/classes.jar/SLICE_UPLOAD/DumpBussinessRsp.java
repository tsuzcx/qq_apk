package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DumpBussinessRsp
  extends JceStruct
{
  static byte[] cache_biz_rsp = (byte[])new byte[1];
  static stResult cache_result = new stResult();
  public byte[] biz_rsp = null;
  public stResult result = null;
  
  static
  {
    ((byte[])cache_biz_rsp)[0] = 0;
  }
  
  public DumpBussinessRsp() {}
  
  public DumpBussinessRsp(byte[] paramArrayOfByte, stResult paramstResult)
  {
    this.biz_rsp = paramArrayOfByte;
    this.result = paramstResult;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.biz_rsp = ((byte[])paramJceInputStream.read(cache_biz_rsp, 0, false));
    this.result = ((stResult)paramJceInputStream.read(cache_result, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.biz_rsp != null) {
      paramJceOutputStream.write(this.biz_rsp, 0);
    }
    if (this.result != null) {
      paramJceOutputStream.write(this.result, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.DumpBussinessRsp
 * JD-Core Version:    0.7.0.1
 */