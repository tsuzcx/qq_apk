package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespIncreaseVisitor
  extends JceStruct
{
  static RespHead cache_stHeader;
  static ArrayList cache_vVisitor;
  public int iVistorIncrement = 0;
  public int lTime = 0;
  public RespHead stHeader = null;
  public ArrayList vVisitor = null;
  
  public RespIncreaseVisitor() {}
  
  public RespIncreaseVisitor(RespHead paramRespHead, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHead;
    this.iVistorIncrement = paramInt1;
    this.lTime = paramInt2;
    this.vVisitor = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.iVistorIncrement = paramJceInputStream.read(this.iVistorIncrement, 1, true);
    this.lTime = paramJceInputStream.read(this.lTime, 2, true);
    if (cache_vVisitor == null)
    {
      cache_vVisitor = new ArrayList();
      Visitor localVisitor = new Visitor();
      cache_vVisitor.add(localVisitor);
    }
    this.vVisitor = ((ArrayList)paramJceInputStream.read(cache_vVisitor, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.iVistorIncrement, 1);
    paramJceOutputStream.write(this.lTime, 2);
    if (this.vVisitor != null) {
      paramJceOutputStream.write(this.vVisitor, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespIncreaseVisitor
 * JD-Core Version:    0.7.0.1
 */