package VA_PROFILE_COMM_TASK;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommTaskRsp
  extends JceStruct
{
  static byte[] cache_vTaskData = (byte[])new byte[1];
  public long iRetCode;
  public String sRetMsg = "";
  public byte[] vTaskData;
  
  static
  {
    ((byte[])cache_vTaskData)[0] = 0;
  }
  
  public CommTaskRsp() {}
  
  public CommTaskRsp(long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    this.iRetCode = paramLong;
    this.sRetMsg = paramString;
    this.vTaskData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRetCode = paramJceInputStream.read(this.iRetCode, 0, false);
    this.sRetMsg = paramJceInputStream.readString(1, false);
    this.vTaskData = ((byte[])paramJceInputStream.read(cache_vTaskData, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRetCode, 0);
    if (this.sRetMsg != null) {
      paramJceOutputStream.write(this.sRetMsg, 1);
    }
    if (this.vTaskData != null) {
      paramJceOutputStream.write(this.vTaskData, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     VA_PROFILE_COMM_TASK.CommTaskRsp
 * JD-Core Version:    0.7.0.1
 */