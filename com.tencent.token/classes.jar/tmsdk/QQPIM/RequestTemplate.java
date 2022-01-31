package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RequestTemplate
  extends JceStruct
{
  static ArrayList eG;
  public ArrayList reqTemp = null;
  
  static
  {
    if (!RequestTemplate.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RequestTemplate()
  {
    setReqTemp(this.reqTemp);
  }
  
  public RequestTemplate(ArrayList paramArrayList)
  {
    setReqTemp(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RequestTemplate";
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
    paramObject = (RequestTemplate)paramObject;
    return JceUtil.equals(this.reqTemp, paramObject.reqTemp);
  }
  
  public ArrayList getReqTemp()
  {
    return this.reqTemp;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (eG == null)
    {
      eG = new ArrayList();
      UrlCheckRequest localUrlCheckRequest = new UrlCheckRequest();
      eG.add(localUrlCheckRequest);
    }
    setReqTemp((ArrayList)paramJceInputStream.read(eG, 0, false));
  }
  
  public void setReqTemp(ArrayList paramArrayList)
  {
    this.reqTemp = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reqTemp != null) {
      paramJceOutputStream.write(this.reqTemp, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RequestTemplate
 * JD-Core Version:    0.7.0.1
 */