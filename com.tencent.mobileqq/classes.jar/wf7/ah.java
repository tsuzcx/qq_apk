package wf7;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class ah
  extends JceStruct
  implements Cloneable
{
  static ArrayList<ak> cE;
  public int cA = 0;
  public int cB = 0;
  public String cC = "";
  public ArrayList<ak> cD = null;
  public String cz = "";
  
  static
  {
    if (!ah.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      cF = bool;
      return;
    }
  }
  
  public ah()
  {
    b(this.cz);
    b(this.cA);
    c(this.cB);
    c(this.cC);
    a(this.cD);
  }
  
  public void a(ArrayList<ak> paramArrayList)
  {
    this.cD = paramArrayList;
  }
  
  public void b(int paramInt)
  {
    this.cA = paramInt;
  }
  
  public void b(String paramString)
  {
    this.cz = paramString;
  }
  
  public void c(int paramInt)
  {
    this.cB = paramInt;
  }
  
  public void c(String paramString)
  {
    this.cC = paramString;
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
      while (cF) {}
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
      paramObject = (ah)paramObject;
    } while ((!JceUtil.equals(this.cz, paramObject.cz)) || (!JceUtil.equals(this.cA, paramObject.cA)) || (!JceUtil.equals(this.cB, paramObject.cB)) || (!JceUtil.equals(this.cC, paramObject.cC)) || (!JceUtil.equals(this.cD, paramObject.cD)));
    return true;
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
    b(paramJceInputStream.readString(0, true));
    b(paramJceInputStream.read(this.cA, 1, false));
    c(paramJceInputStream.read(this.cB, 2, false));
    c(paramJceInputStream.readString(3, false));
    if (cE == null)
    {
      cE = new ArrayList();
      ak localak = new ak();
      cE.add(localak);
    }
    a((ArrayList)paramJceInputStream.read(cE, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cz, 0);
    paramJceOutputStream.write(this.cA, 1);
    paramJceOutputStream.write(this.cB, 2);
    if (this.cC != null) {
      paramJceOutputStream.write(this.cC, 3);
    }
    if (this.cD != null) {
      paramJceOutputStream.write(this.cD, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ah
 * JD-Core Version:    0.7.0.1
 */