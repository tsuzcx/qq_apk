package NearbyGroup;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspGetNearbyGroupArea
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_vGroupArea;
  public ArrayList vGroupArea = null;
  
  static
  {
    if (!RspGetNearbyGroupArea.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RspGetNearbyGroupArea() {}
  
  public RspGetNearbyGroupArea(ArrayList paramArrayList)
  {
    this.vGroupArea = paramArrayList;
  }
  
  public String className()
  {
    return "NearbyGroup.RspGetNearbyGroupArea";
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
    new JceDisplayer(paramStringBuilder, paramInt).display(this.vGroupArea, "vGroupArea");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.vGroupArea, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    paramObject = (RspGetNearbyGroupArea)paramObject;
    return JceUtil.equals(this.vGroupArea, paramObject.vGroupArea);
  }
  
  public String fullClassName()
  {
    return "NearbyGroup.RspGetNearbyGroupArea";
  }
  
  public ArrayList getVGroupArea()
  {
    return this.vGroupArea;
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
    if (cache_vGroupArea == null)
    {
      cache_vGroupArea = new ArrayList();
      GroupArea localGroupArea = new GroupArea();
      cache_vGroupArea.add(localGroupArea);
    }
    this.vGroupArea = ((ArrayList)paramJceInputStream.read(cache_vGroupArea, 0, false));
  }
  
  public void setVGroupArea(ArrayList paramArrayList)
  {
    this.vGroupArea = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vGroupArea != null) {
      paramJceOutputStream.write(this.vGroupArea, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NearbyGroup.RspGetNearbyGroupArea
 * JD-Core Version:    0.7.0.1
 */