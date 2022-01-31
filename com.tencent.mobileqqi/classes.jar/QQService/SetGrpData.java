package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SetGrpData
  extends JceStruct
{
  public String GrpName = "";
  
  static
  {
    if (!SetGrpData.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SetGrpData()
  {
    setGrpName(this.GrpName);
  }
  
  public SetGrpData(String paramString)
  {
    setGrpName(paramString);
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.GrpName, "GrpName");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SetGrpData)paramObject;
    return JceUtil.equals(this.GrpName, paramObject.GrpName);
  }
  
  public String getGrpName()
  {
    return this.GrpName;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setGrpName(paramJceInputStream.readString(0, true));
  }
  
  public void setGrpName(String paramString)
  {
    this.GrpName = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GrpName, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SetGrpData
 * JD-Core Version:    0.7.0.1
 */