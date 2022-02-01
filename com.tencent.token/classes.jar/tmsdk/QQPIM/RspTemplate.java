package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspTemplate
  extends JceStruct
{
  static ArrayList<UrlCheckResponse> eH;
  public ArrayList<UrlCheckResponse> rspTemp = null;
  
  public RspTemplate()
  {
    setRspTemp(this.rspTemp);
  }
  
  public RspTemplate(ArrayList<UrlCheckResponse> paramArrayList)
  {
    setRspTemp(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.RspTemplate";
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
    paramObject = (RspTemplate)paramObject;
    return JceUtil.equals(this.rspTemp, paramObject.rspTemp);
  }
  
  public ArrayList<UrlCheckResponse> getRspTemp()
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
  
  public void setRspTemp(ArrayList<UrlCheckResponse> paramArrayList)
  {
    this.rspTemp = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.rspTemp;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.RspTemplate
 * JD-Core Version:    0.7.0.1
 */