package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCallInfo
  extends JceStruct
{
  public boolean switch_call_live = true;
  public boolean switch_call_new = true;
  
  public stCallInfo() {}
  
  public stCallInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.switch_call_live = paramBoolean1;
    this.switch_call_new = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.switch_call_live = paramJceInputStream.read(this.switch_call_live, 0, false);
    this.switch_call_new = paramJceInputStream.read(this.switch_call_new, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.switch_call_live, 0);
    paramJceOutputStream.write(this.switch_call_new, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     UserGrowth.stCallInfo
 * JD-Core Version:    0.7.0.1
 */