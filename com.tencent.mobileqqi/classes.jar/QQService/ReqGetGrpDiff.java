package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class ReqGetGrpDiff
  extends JceStruct
{
  static ArrayList cache_GrpStamps;
  static ReqHeader cache_stHeader;
  public ArrayList GrpStamps = null;
  public ReqHeader stHeader = null;
  
  static
  {
    if (!ReqGetGrpDiff.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqGetGrpDiff()
  {
    setStHeader(this.stHeader);
    setGrpStamps(this.GrpStamps);
  }
  
  public ReqGetGrpDiff(ReqHeader paramReqHeader, ArrayList paramArrayList)
  {
    setStHeader(paramReqHeader);
    setGrpStamps(paramArrayList);
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
    paramStringBuilder.display(this.stHeader, "stHeader");
    paramStringBuilder.display(this.GrpStamps, "GrpStamps");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (ReqGetGrpDiff)paramObject;
    return (JceUtil.equals(this.stHeader, paramObject.stHeader)) && (JceUtil.equals(this.GrpStamps, paramObject.GrpStamps));
  }
  
  public ArrayList getGrpStamps()
  {
    return this.GrpStamps;
  }
  
  public ReqHeader getStHeader()
  {
    return this.stHeader;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    setStHeader((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_GrpStamps == null)
    {
      cache_GrpStamps = new ArrayList();
      GrpStamp localGrpStamp = new GrpStamp();
      cache_GrpStamps.add(localGrpStamp);
    }
    setGrpStamps((ArrayList)paramJceInputStream.read(cache_GrpStamps, 1, true));
  }
  
  public void setGrpStamps(ArrayList paramArrayList)
  {
    this.GrpStamps = paramArrayList;
  }
  
  public void setStHeader(ReqHeader paramReqHeader)
  {
    this.stHeader = paramReqHeader;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpStamps, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqGetGrpDiff
 * JD-Core Version:    0.7.0.1
 */