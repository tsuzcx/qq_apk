package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class CloudInfo
  extends JceStruct
  implements Cloneable
{
  static BaseInfo dR;
  static TimeCtrl dS;
  static TipsInfo dT;
  static ArrayList dU;
  public BaseInfo base = null;
  public ArrayList cloudcmds = null;
  public TimeCtrl time = null;
  public TipsInfo tips = null;
  
  static
  {
    if (!CloudInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public CloudInfo()
  {
    setBase(this.base);
    setTime(this.time);
    setTips(this.tips);
    setCloudcmds(this.cloudcmds);
  }
  
  public CloudInfo(BaseInfo paramBaseInfo, TimeCtrl paramTimeCtrl, TipsInfo paramTipsInfo, ArrayList paramArrayList)
  {
    setBase(paramBaseInfo);
    setTime(paramTimeCtrl);
    setTips(paramTipsInfo);
    setCloudcmds(paramArrayList);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CloudInfo";
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
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (CloudInfo)paramObject;
    } while ((!JceUtil.equals(this.base, paramObject.base)) || (!JceUtil.equals(this.time, paramObject.time)) || (!JceUtil.equals(this.tips, paramObject.tips)) || (!JceUtil.equals(this.cloudcmds, paramObject.cloudcmds)));
    return true;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CloudInfo";
  }
  
  public BaseInfo getBase()
  {
    return this.base;
  }
  
  public ArrayList getCloudcmds()
  {
    return this.cloudcmds;
  }
  
  public TimeCtrl getTime()
  {
    return this.time;
  }
  
  public TipsInfo getTips()
  {
    return this.tips;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (dR == null) {
      dR = new BaseInfo();
    }
    setBase((BaseInfo)paramJceInputStream.read(dR, 0, true));
    if (dS == null) {
      dS = new TimeCtrl();
    }
    setTime((TimeCtrl)paramJceInputStream.read(dS, 1, true));
    if (dT == null) {
      dT = new TipsInfo();
    }
    setTips((TipsInfo)paramJceInputStream.read(dT, 2, false));
    if (dU == null)
    {
      dU = new ArrayList();
      CloudCmd localCloudCmd = new CloudCmd();
      dU.add(localCloudCmd);
    }
    setCloudcmds((ArrayList)paramJceInputStream.read(dU, 3, false));
  }
  
  public void setBase(BaseInfo paramBaseInfo)
  {
    this.base = paramBaseInfo;
  }
  
  public void setCloudcmds(ArrayList paramArrayList)
  {
    this.cloudcmds = paramArrayList;
  }
  
  public void setTime(TimeCtrl paramTimeCtrl)
  {
    this.time = paramTimeCtrl;
  }
  
  public void setTips(TipsInfo paramTipsInfo)
  {
    this.tips = paramTipsInfo;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.base, 0);
    paramJceOutputStream.write(this.time, 1);
    if (this.tips != null) {
      paramJceOutputStream.write(this.tips, 2);
    }
    if (this.cloudcmds != null) {
      paramJceOutputStream.write(this.cloudcmds, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CloudInfo
 * JD-Core Version:    0.7.0.1
 */