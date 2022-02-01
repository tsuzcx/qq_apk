package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RequestTemplate
  extends JceStruct
{
  static ArrayList<UrlCheckRequest> eG;
  public ArrayList<UrlCheckRequest> reqTemp = null;
  
  public RequestTemplate()
  {
    setReqTemp(this.reqTemp);
  }
  
  public RequestTemplate(ArrayList<UrlCheckRequest> paramArrayList)
  {
    setReqTemp(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RequestTemplate";
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (RequestTemplate)paramObject;
    return JceUtil.equals(this.reqTemp, paramObject.reqTemp);
  }
  
  public ArrayList<UrlCheckRequest> getReqTemp()
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
  
  public void setReqTemp(ArrayList<UrlCheckRequest> paramArrayList)
  {
    this.reqTemp = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.reqTemp;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RequestTemplate
 * JD-Core Version:    0.7.0.1
 */