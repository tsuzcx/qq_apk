package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ScanTypeInfo
  extends JceStruct
  implements Cloneable
{
  public int advice = 0;
  public String desc = "";
  public int id = 0;
  public int level = 0;
  public String name = "";
  public int scan = 0;
  public String shortdesc = "";
  public int type = 0;
  
  public ScanTypeInfo() {}
  
  public ScanTypeInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, int paramInt4, int paramInt5)
  {
    this.id = paramInt1;
    this.name = paramString1;
    this.shortdesc = paramString2;
    this.level = paramInt2;
    this.advice = paramInt3;
    this.desc = paramString3;
    this.scan = paramInt4;
    this.type = paramInt5;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.ScanTypeInfo";
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
    paramStringBuilder.display(this.id, "id");
    paramStringBuilder.display(this.name, "name");
    paramStringBuilder.display(this.shortdesc, "shortdesc");
    paramStringBuilder.display(this.level, "level");
    paramStringBuilder.display(this.advice, "advice");
    paramStringBuilder.display(this.desc, "desc");
    paramStringBuilder.display(this.scan, "scan");
    paramStringBuilder.display(this.type, "type");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ScanTypeInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.name, paramObject.name))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.shortdesc, paramObject.shortdesc))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.level, paramObject.level))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.advice, paramObject.advice))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.desc, paramObject.desc))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.scan, paramObject.scan))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.type, paramObject.type)) {
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
    return "tmsdk.QQPIM.ScanTypeInfo";
  }
  
  public int getAdvice()
  {
    return this.advice;
  }
  
  public String getDesc()
  {
    return this.desc;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getScan()
  {
    return this.scan;
  }
  
  public String getShortdesc()
  {
    return this.shortdesc;
  }
  
  public int getType()
  {
    return this.type;
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
    this.id = paramJceInputStream.read(this.id, 0, true);
    this.name = paramJceInputStream.readString(1, true);
    this.shortdesc = paramJceInputStream.readString(2, true);
    this.level = paramJceInputStream.read(this.level, 3, true);
    this.advice = paramJceInputStream.read(this.advice, 4, true);
    this.desc = paramJceInputStream.readString(5, true);
    this.scan = paramJceInputStream.read(this.scan, 6, true);
    this.type = paramJceInputStream.read(this.type, 7, true);
  }
  
  public void setAdvice(int paramInt)
  {
    this.advice = paramInt;
  }
  
  public void setDesc(String paramString)
  {
    this.desc = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setScan(int paramInt)
  {
    this.scan = paramInt;
  }
  
  public void setShortdesc(String paramString)
  {
    this.shortdesc = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.shortdesc, 2);
    paramJceOutputStream.write(this.level, 3);
    paramJceOutputStream.write(this.advice, 4);
    paramJceOutputStream.write(this.desc, 5);
    paramJceOutputStream.write(this.scan, 6);
    paramJceOutputStream.write(this.type, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.ScanTypeInfo
 * JD-Core Version:    0.7.0.1
 */