package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAddPoiTraceRsp
  extends JceStruct
{
  public int iTotalNum = 0;
  
  public stAddPoiTraceRsp() {}
  
  public stAddPoiTraceRsp(int paramInt)
  {
    this.iTotalNum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTotalNum, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBSClientInterfaceV2.stAddPoiTraceRsp
 * JD-Core Version:    0.7.0.1
 */