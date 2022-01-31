package tmsdk.Protocol.MConfigUpdate;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GameConfigReport
  extends JceStruct
{
  public String fileMd5 = "";
  public String fileName = "";
  public int success = 0;
  public int type = 1;
  
  public JceStruct newInit()
  {
    return new GameConfigReport();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fileName = paramJceInputStream.readString(0, true);
    this.fileMd5 = paramJceInputStream.readString(1, true);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.success = paramJceInputStream.read(this.success, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fileName, 0);
    paramJceOutputStream.write(this.fileMd5, 1);
    if (1 != this.type) {
      paramJceOutputStream.write(this.type, 2);
    }
    paramJceOutputStream.write(this.success, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.Protocol.MConfigUpdate.GameConfigReport
 * JD-Core Version:    0.7.0.1
 */