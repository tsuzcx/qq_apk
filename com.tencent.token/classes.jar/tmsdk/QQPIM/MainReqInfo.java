package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class MainReqInfo
  extends JceStruct
  implements Cloneable
{
  static TipsReqInfo dy;
  public String oldtipsid = "";
  public TipsReqInfo reqinfo = null;
  
  public MainReqInfo()
  {
    setOldtipsid(this.oldtipsid);
    setReqinfo(this.reqinfo);
  }
  
  public MainReqInfo(String paramString, TipsReqInfo paramTipsReqInfo)
  {
    setOldtipsid(paramString);
    setReqinfo(paramTipsReqInfo);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.MainReqInfo";
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
    paramObject = (MainReqInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.oldtipsid, paramObject.oldtipsid))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.reqinfo, paramObject.reqinfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.MainReqInfo";
  }
  
  public String getOldtipsid()
  {
    return this.oldtipsid;
  }
  
  public TipsReqInfo getReqinfo()
  {
    return this.reqinfo;
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
    setOldtipsid(paramJceInputStream.readString(0, true));
    if (dy == null) {
      dy = new TipsReqInfo();
    }
    setReqinfo((TipsReqInfo)paramJceInputStream.read(dy, 1, false));
  }
  
  public void setOldtipsid(String paramString)
  {
    this.oldtipsid = paramString;
  }
  
  public void setReqinfo(TipsReqInfo paramTipsReqInfo)
  {
    this.reqinfo = paramTipsReqInfo;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oldtipsid, 0);
    TipsReqInfo localTipsReqInfo = this.reqinfo;
    if (localTipsReqInfo != null) {
      paramJceOutputStream.write(localTipsReqInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.MainReqInfo
 * JD-Core Version:    0.7.0.1
 */