package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class CommElementInfo
  extends JceStruct
  implements Cloneable
{
  public String data1 = "";
  public String data2 = "";
  public String data3 = "";
  public String data4 = "";
  public String data5 = "";
  public String data6 = "";
  public String data7 = "";
  public String data8 = "";
  
  public CommElementInfo() {}
  
  public CommElementInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.data1 = paramString1;
    this.data2 = paramString2;
    this.data3 = paramString3;
    this.data4 = paramString4;
    this.data5 = paramString5;
    this.data6 = paramString6;
    this.data7 = paramString7;
    this.data8 = paramString8;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.CommElementInfo";
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
    paramStringBuilder.display(this.data1, "data1");
    paramStringBuilder.display(this.data2, "data2");
    paramStringBuilder.display(this.data3, "data3");
    paramStringBuilder.display(this.data4, "data4");
    paramStringBuilder.display(this.data5, "data5");
    paramStringBuilder.display(this.data6, "data6");
    paramStringBuilder.display(this.data7, "data7");
    paramStringBuilder.display(this.data8, "data8");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (CommElementInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.data1, paramObject.data1))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.data2, paramObject.data2))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.data3, paramObject.data3))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.data4, paramObject.data4))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.data5, paramObject.data5))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.data6, paramObject.data6))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.data7, paramObject.data7))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.data8, paramObject.data8)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "tmsdk.QQPIM.CommElementInfo";
  }
  
  public String getData1()
  {
    return this.data1;
  }
  
  public String getData2()
  {
    return this.data2;
  }
  
  public String getData3()
  {
    return this.data3;
  }
  
  public String getData4()
  {
    return this.data4;
  }
  
  public String getData5()
  {
    return this.data5;
  }
  
  public String getData6()
  {
    return this.data6;
  }
  
  public String getData7()
  {
    return this.data7;
  }
  
  public String getData8()
  {
    return this.data8;
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
    this.data1 = paramJceInputStream.readString(0, false);
    this.data2 = paramJceInputStream.readString(1, false);
    this.data3 = paramJceInputStream.readString(3, false);
    this.data4 = paramJceInputStream.readString(4, false);
    this.data5 = paramJceInputStream.readString(5, false);
    this.data6 = paramJceInputStream.readString(6, false);
    this.data7 = paramJceInputStream.readString(7, false);
    this.data8 = paramJceInputStream.readString(8, false);
  }
  
  public void setData1(String paramString)
  {
    this.data1 = paramString;
  }
  
  public void setData2(String paramString)
  {
    this.data2 = paramString;
  }
  
  public void setData3(String paramString)
  {
    this.data3 = paramString;
  }
  
  public void setData4(String paramString)
  {
    this.data4 = paramString;
  }
  
  public void setData5(String paramString)
  {
    this.data5 = paramString;
  }
  
  public void setData6(String paramString)
  {
    this.data6 = paramString;
  }
  
  public void setData7(String paramString)
  {
    this.data7 = paramString;
  }
  
  public void setData8(String paramString)
  {
    this.data8 = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.data1;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.data2;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.data3;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.data4;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.data5;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.data6;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.data7;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    str = this.data8;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.CommElementInfo
 * JD-Core Version:    0.7.0.1
 */