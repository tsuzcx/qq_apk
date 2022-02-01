package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

public final class Category
  extends JceStruct
  implements Cloneable
{
  static ArrayList<String> dL;
  static byte[] dM;
  public int autoalert = 0;
  public int categorytype = 0;
  public int count = 0;
  public String description = "";
  public int endtime = 0;
  public byte[] expand = null;
  public String icon = "";
  public int id = 0;
  public String name = "";
  public int rank = 0;
  public int sign = 0;
  public int source = 1;
  public int state = 0;
  public ArrayList<String> vecSubtitle = null;
  public int viewtimes = 0;
  public String welcome = "";
  
  public Category()
  {
    setId(this.id);
    setName(this.name);
    setIcon(this.icon);
    setCount(this.count);
    setWelcome(this.welcome);
    setAutoalert(this.autoalert);
    setEndtime(this.endtime);
    setCategorytype(this.categorytype);
    setSource(this.source);
    setVecSubtitle(this.vecSubtitle);
    setDescription(this.description);
    setSign(this.sign);
    setState(this.state);
    setViewtimes(this.viewtimes);
    setExpand(this.expand);
    setRank(this.rank);
  }
  
  public Category(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ArrayList<String> paramArrayList, String paramString4, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte, int paramInt10)
  {
    setId(paramInt1);
    setName(paramString1);
    setIcon(paramString2);
    setCount(paramInt2);
    setWelcome(paramString3);
    setAutoalert(paramInt3);
    setEndtime(paramInt4);
    setCategorytype(paramInt5);
    setSource(paramInt6);
    setVecSubtitle(paramArrayList);
    setDescription(paramString4);
    setSign(paramInt7);
    setState(paramInt8);
    setViewtimes(paramInt9);
    setExpand(paramArrayOfByte);
    setRank(paramInt10);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.Category";
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
    paramObject = (Category)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.id, paramObject.id))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.name, paramObject.name))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.icon, paramObject.icon))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.count, paramObject.count))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.welcome, paramObject.welcome))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.autoalert, paramObject.autoalert))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.endtime, paramObject.endtime))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.categorytype, paramObject.categorytype))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.source, paramObject.source))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.vecSubtitle, paramObject.vecSubtitle))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.description, paramObject.description))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.sign, paramObject.sign))
                          {
                            bool1 = bool2;
                            if (JceUtil.equals(this.state, paramObject.state))
                            {
                              bool1 = bool2;
                              if (JceUtil.equals(this.viewtimes, paramObject.viewtimes))
                              {
                                bool1 = bool2;
                                if (JceUtil.equals(this.expand, paramObject.expand))
                                {
                                  bool1 = bool2;
                                  if (JceUtil.equals(this.rank, paramObject.rank)) {
                                    bool1 = true;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
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
    return "tmsdk.QQPIM.Category";
  }
  
  public int getAutoalert()
  {
    return this.autoalert;
  }
  
  public int getCategorytype()
  {
    return this.categorytype;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getEndtime()
  {
    return this.endtime;
  }
  
  public byte[] getExpand()
  {
    return this.expand;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getRank()
  {
    return this.rank;
  }
  
  public int getSign()
  {
    return this.sign;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public ArrayList<String> getVecSubtitle()
  {
    return this.vecSubtitle;
  }
  
  public int getViewtimes()
  {
    return this.viewtimes;
  }
  
  public String getWelcome()
  {
    return this.welcome;
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
    setId(paramJceInputStream.read(this.id, 0, true));
    setName(paramJceInputStream.readString(1, true));
    setIcon(paramJceInputStream.readString(2, true));
    setCount(paramJceInputStream.read(this.count, 3, true));
    setWelcome(paramJceInputStream.readString(4, false));
    setAutoalert(paramJceInputStream.read(this.autoalert, 5, false));
    setEndtime(paramJceInputStream.read(this.endtime, 6, false));
    setCategorytype(paramJceInputStream.read(this.categorytype, 7, false));
    setSource(paramJceInputStream.read(this.source, 8, false));
    if (dL == null)
    {
      dL = new ArrayList();
      dL.add("");
    }
    setVecSubtitle((ArrayList)paramJceInputStream.read(dL, 9, false));
    setDescription(paramJceInputStream.readString(10, false));
    setSign(paramJceInputStream.read(this.sign, 11, false));
    setState(paramJceInputStream.read(this.state, 12, false));
    setViewtimes(paramJceInputStream.read(this.viewtimes, 13, false));
    if (dM == null)
    {
      dM = (byte[])new byte[1];
      ((byte[])dM)[0] = 0;
    }
    setExpand((byte[])paramJceInputStream.read(dM, 14, false));
    setRank(paramJceInputStream.read(this.rank, 15, false));
  }
  
  public void setAutoalert(int paramInt)
  {
    this.autoalert = paramInt;
  }
  
  public void setCategorytype(int paramInt)
  {
    this.categorytype = paramInt;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setEndtime(int paramInt)
  {
    this.endtime = paramInt;
  }
  
  public void setExpand(byte[] paramArrayOfByte)
  {
    this.expand = paramArrayOfByte;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setRank(int paramInt)
  {
    this.rank = paramInt;
  }
  
  public void setSign(int paramInt)
  {
    this.sign = paramInt;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
  
  public void setVecSubtitle(ArrayList<String> paramArrayList)
  {
    this.vecSubtitle = paramArrayList;
  }
  
  public void setViewtimes(int paramInt)
  {
    this.viewtimes = paramInt;
  }
  
  public void setWelcome(String paramString)
  {
    this.welcome = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.id, 0);
    paramJceOutputStream.write(this.name, 1);
    paramJceOutputStream.write(this.icon, 2);
    paramJceOutputStream.write(this.count, 3);
    Object localObject = this.welcome;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.autoalert, 5);
    paramJceOutputStream.write(this.endtime, 6);
    paramJceOutputStream.write(this.categorytype, 7);
    paramJceOutputStream.write(this.source, 8);
    localObject = this.vecSubtitle;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
    localObject = this.description;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.sign, 11);
    paramJceOutputStream.write(this.state, 12);
    paramJceOutputStream.write(this.viewtimes, 13);
    localObject = this.expand;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 14);
    }
    paramJceOutputStream.write(this.rank, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.Category
 * JD-Core Version:    0.7.0.1
 */