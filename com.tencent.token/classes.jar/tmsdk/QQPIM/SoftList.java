package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SoftList
  extends JceStruct
  implements Cloneable
{
  static ArrayList<SoftElementInfo> fd;
  static SoftListInfo fe;
  public SoftListInfo softListInfo = null;
  public ArrayList<SoftElementInfo> vctSofts = null;
  
  public SoftList() {}
  
  public SoftList(ArrayList<SoftElementInfo> paramArrayList, SoftListInfo paramSoftListInfo)
  {
    this.vctSofts = paramArrayList;
    this.softListInfo = paramSoftListInfo;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SoftList";
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.vctSofts, "vctSofts");
    paramStringBuilder.display(this.softListInfo, "softListInfo");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SoftList)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.vctSofts, paramObject.vctSofts))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.softListInfo, paramObject.softListInfo)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.SoftList";
  }
  
  public SoftListInfo getSoftListInfo()
  {
    return this.softListInfo;
  }
  
  public ArrayList<SoftElementInfo> getVctSofts()
  {
    return this.vctSofts;
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
    if (fd == null)
    {
      fd = new ArrayList();
      SoftElementInfo localSoftElementInfo = new SoftElementInfo();
      fd.add(localSoftElementInfo);
    }
    this.vctSofts = ((ArrayList)paramJceInputStream.read(fd, 0, true));
    if (fe == null) {
      fe = new SoftListInfo();
    }
    this.softListInfo = ((SoftListInfo)paramJceInputStream.read(fe, 1, false));
  }
  
  public void setSoftListInfo(SoftListInfo paramSoftListInfo)
  {
    this.softListInfo = paramSoftListInfo;
  }
  
  public void setVctSofts(ArrayList<SoftElementInfo> paramArrayList)
  {
    this.vctSofts = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vctSofts, 0);
    SoftListInfo localSoftListInfo = this.softListInfo;
    if (localSoftListInfo != null) {
      paramJceOutputStream.write(localSoftListInfo, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftList
 * JD-Core Version:    0.7.0.1
 */