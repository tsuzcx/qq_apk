package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspTemplate
  extends JceStruct
{
  static ArrayList eH;
  public ArrayList rspTemp = null;
  
  static
  {
    if (!RspTemplate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RspTemplate()
  {
    setRspTemp(this.rspTemp);
  }
  
  public RspTemplate(ArrayList paramArrayList)
  {
    setRspTemp(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RspTemplate";
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
  
  public boolean equals(Object paramObject)
  {
    paramObject = (RspTemplate)paramObject;
    return JceUtil.equals(this.rspTemp, paramObject.rspTemp);
  }
  
  public ArrayList getRspTemp()
  {
    return this.rspTemp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (eH == null)
    {
      eH = new ArrayList();
      UrlCheckResponse localUrlCheckResponse = new UrlCheckResponse();
      eH.add(localUrlCheckResponse);
    }
    setRspTemp((ArrayList)paramJceInputStream.read(eH, 0, false));
  }
  
  public void setRspTemp(ArrayList paramArrayList)
  {
    this.rspTemp = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.rspTemp != null) {
      paramJceOutputStream.write(this.rspTemp, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RspTemplate
 * JD-Core Version:    0.7.0.1
 */