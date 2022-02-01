package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class CloudInfo
  extends JceStruct
  implements Cloneable
{
  static BaseInfo dR;
  static TimeCtrl dS;
  static TipsInfo dT;
  static ArrayList<CloudCmd> dU;
  public BaseInfo base = null;
  public ArrayList<CloudCmd> cloudcmds = null;
  public TimeCtrl time = null;
  public TipsInfo tips = null;
  
  public CloudInfo()
  {
    setBase(this.base);
    setTime(this.time);
    setTips(this.tips);
    setCloudcmds(this.cloudcmds);
  }
  
  public CloudInfo(BaseInfo paramBaseInfo, TimeCtrl paramTimeCtrl, TipsInfo paramTipsInfo, ArrayList<CloudCmd> paramArrayList)
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (CloudInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.base, paramObject.base))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.time, paramObject.time))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.tips, paramObject.tips))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.cloudcmds, paramObject.cloudcmds)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CloudInfo";
  }
  
  public BaseInfo getBase()
  {
    return this.base;
  }
  
  public ArrayList<CloudCmd> getCloudcmds()
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
  
  public void setCloudcmds(ArrayList<CloudCmd> paramArrayList)
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
    Object localObject = this.tips;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.cloudcmds;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CloudInfo
 * JD-Core Version:    0.7.0.1
 */