package LBSAPIProtocol;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class Cell
  extends JceStruct
{
  public int iCellId = -1;
  public int iLac = -1;
  public short shMcc = -1;
  public short shMnc = -1;
  
  static
  {
    if (!Cell.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public Cell()
  {
    setShMcc(this.shMcc);
    setShMnc(this.shMnc);
    setILac(this.iLac);
    setICellId(this.iCellId);
  }
  
  public Cell(short paramShort1, short paramShort2, int paramInt1, int paramInt2)
  {
    setShMcc(paramShort1);
    setShMnc(paramShort2);
    setILac(paramInt1);
    setICellId(paramInt2);
  }
  
  public String className()
  {
    return "LBSAPIProtocol.Cell";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.shMcc, "shMcc");
    paramStringBuilder.display(this.shMnc, "shMnc");
    paramStringBuilder.display(this.iLac, "iLac");
    paramStringBuilder.display(this.iCellId, "iCellId");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (Cell)paramObject;
    return (JceUtil.equals(this.shMcc, paramObject.shMcc)) && (JceUtil.equals(this.shMnc, paramObject.shMnc)) && (JceUtil.equals(this.iLac, paramObject.iLac)) && (JceUtil.equals(this.iCellId, paramObject.iCellId));
  }
  
  public String fullClassName()
  {
    return "LBSAPIProtocol.Cell";
  }
  
  public int getICellId()
  {
    return this.iCellId;
  }
  
  public int getILac()
  {
    return this.iLac;
  }
  
  public short getShMcc()
  {
    return this.shMcc;
  }
  
  public short getShMnc()
  {
    return this.shMnc;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setShMcc(paramJceInputStream.read(this.shMcc, 0, true));
    setShMnc(paramJceInputStream.read(this.shMnc, 1, true));
    setILac(paramJceInputStream.read(this.iLac, 2, true));
    setICellId(paramJceInputStream.read(this.iCellId, 3, true));
  }
  
  public void setICellId(int paramInt)
  {
    this.iCellId = paramInt;
  }
  
  public void setILac(int paramInt)
  {
    this.iLac = paramInt;
  }
  
  public void setShMcc(short paramShort)
  {
    this.shMcc = paramShort;
  }
  
  public void setShMnc(short paramShort)
  {
    this.shMnc = paramShort;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shMcc, 0);
    paramJceOutputStream.write(this.shMnc, 1);
    paramJceOutputStream.write(this.iLac, 2);
    paramJceOutputStream.write(this.iCellId, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     LBSAPIProtocol.Cell
 * JD-Core Version:    0.7.0.1
 */