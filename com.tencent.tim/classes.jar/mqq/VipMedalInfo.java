package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VipMedalInfo
  extends JceStruct
{
  public int type;
  public String value = "";
  
  public VipMedalInfo() {}
  
  public VipMedalInfo(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.value = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.value = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.value, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MQQ.VipMedalInfo
 * JD-Core Version:    0.7.0.1
 */