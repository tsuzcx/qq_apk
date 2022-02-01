package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupInfo
  extends JceStruct
{
  public byte cGroupId;
  public String strGroupName = "";
  
  public GroupInfo() {}
  
  public GroupInfo(byte paramByte, String paramString)
  {
    this.cGroupId = paramByte;
    this.strGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 0, true);
    this.strGroupName = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cGroupId, 0);
    paramJceOutputStream.write(this.strGroupName, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     EncounterSvc.GroupInfo
 * JD-Core Version:    0.7.0.1
 */