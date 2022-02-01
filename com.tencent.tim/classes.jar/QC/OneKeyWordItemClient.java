package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class OneKeyWordItemClient
  extends JceStruct
{
  public String sKeyWordContent = "";
  public long uGroupNum;
  public long uWordExpiredFlag;
  public long uWordId;
  public long uWordStatus;
  
  public OneKeyWordItemClient() {}
  
  public OneKeyWordItemClient(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4)
  {
    this.uWordId = paramLong1;
    this.sKeyWordContent = paramString;
    this.uGroupNum = paramLong2;
    this.uWordExpiredFlag = paramLong3;
    this.uWordStatus = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uWordId = paramJceInputStream.read(this.uWordId, 0, false);
    this.sKeyWordContent = paramJceInputStream.readString(1, false);
    this.uGroupNum = paramJceInputStream.read(this.uGroupNum, 2, false);
    this.uWordExpiredFlag = paramJceInputStream.read(this.uWordExpiredFlag, 3, false);
    this.uWordStatus = paramJceInputStream.read(this.uWordStatus, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uWordId, 0);
    if (this.sKeyWordContent != null) {
      paramJceOutputStream.write(this.sKeyWordContent, 1);
    }
    paramJceOutputStream.write(this.uGroupNum, 2);
    paramJceOutputStream.write(this.uWordExpiredFlag, 3);
    paramJceOutputStream.write(this.uWordStatus, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QC.OneKeyWordItemClient
 * JD-Core Version:    0.7.0.1
 */