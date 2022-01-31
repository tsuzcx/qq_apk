package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestRegisterAndroid
  extends JceStruct
{
  public long ulRequestOptional = 0L;
  
  public SvcRequestRegisterAndroid() {}
  
  public SvcRequestRegisterAndroid(long paramLong)
  {
    this.ulRequestOptional = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ulRequestOptional = paramJceInputStream.read(this.ulRequestOptional, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ulRequestOptional, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     RegisterProxySvcPack.SvcRequestRegisterAndroid
 * JD-Core Version:    0.7.0.1
 */