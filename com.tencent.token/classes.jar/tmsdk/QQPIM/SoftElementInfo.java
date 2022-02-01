package tmsdk.QQPIM;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SoftElementInfo
  extends JceStruct
  implements Cloneable
{
  public String cert = "";
  public String expanda = "";
  public int isOfficial = 0;
  public String name = "";
  public String path = "";
  public String pkgname = "";
  public int softsize = 0;
  
  public SoftElementInfo() {}
  
  public SoftElementInfo(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    this.pkgname = paramString1;
    this.cert = paramString2;
    this.softsize = paramInt1;
    this.path = paramString3;
    this.name = paramString4;
    this.isOfficial = paramInt2;
    this.expanda = paramString5;
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.SoftElementInfo";
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
    paramStringBuilder.display(this.pkgname, "pkgname");
    paramStringBuilder.display(this.cert, "cert");
    paramStringBuilder.display(this.softsize, "softsize");
    paramStringBuilder.display(this.path, "path");
    paramStringBuilder.display(this.name, "name");
    paramStringBuilder.display(this.isOfficial, "isOfficial");
    paramStringBuilder.display(this.expanda, "expanda");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SoftElementInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.pkgname, paramObject.pkgname))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.cert, paramObject.cert))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.softsize, paramObject.softsize))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.path, paramObject.path))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.name, paramObject.name))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.isOfficial, paramObject.isOfficial))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.expanda, paramObject.expanda)) {
                  bool1 = true;
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
    return "tmsdk.QQPIM.SoftElementInfo";
  }
  
  public String getCert()
  {
    return this.cert;
  }
  
  public String getExpanda()
  {
    return this.expanda;
  }
  
  public int getIsOfficial()
  {
    return this.isOfficial;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getPkgname()
  {
    return this.pkgname;
  }
  
  public int getSoftsize()
  {
    return this.softsize;
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
    this.pkgname = paramJceInputStream.readString(0, true);
    this.cert = paramJceInputStream.readString(1, true);
    this.softsize = paramJceInputStream.read(this.softsize, 3, false);
    this.path = paramJceInputStream.readString(4, false);
    this.name = paramJceInputStream.readString(5, false);
    this.isOfficial = paramJceInputStream.read(this.isOfficial, 6, false);
    this.expanda = paramJceInputStream.readString(7, false);
  }
  
  public void setCert(String paramString)
  {
    this.cert = paramString;
  }
  
  public void setExpanda(String paramString)
  {
    this.expanda = paramString;
  }
  
  public void setIsOfficial(int paramInt)
  {
    this.isOfficial = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setPkgname(String paramString)
  {
    this.pkgname = paramString;
  }
  
  public void setSoftsize(int paramInt)
  {
    this.softsize = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pkgname, 0);
    paramJceOutputStream.write(this.cert, 1);
    paramJceOutputStream.write(this.softsize, 3);
    String str = this.path;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.isOfficial, 6);
    str = this.expanda;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.SoftElementInfo
 * JD-Core Version:    0.7.0.1
 */