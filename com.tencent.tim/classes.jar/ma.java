import com.immersion.touchsensesdk.IConnection;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import java.io.IOException;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRRsp;

public class ma
  implements IConnection
{
  private oidb_0xa4d.IMMRRsp a;
  
  public ma(oidb_0xa4d.IMMRRsp paramIMMRRsp)
  {
    this.a = paramIMMRRsp;
  }
  
  public void disconnect() {}
  
  public int getContentLength()
  {
    return this.a.bytes_rsp_data.get().toByteArray().length;
  }
  
  public long getLastModified()
  {
    return this.a.int64_last_modified.get();
  }
  
  public int getResponseCode()
    throws IOException
  {
    return this.a.int32_ret.get();
  }
  
  public byte[] readAllData()
    throws IOException
  {
    return this.a.bytes_rsp_data.get().toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ma
 * JD-Core Version:    0.7.0.1
 */