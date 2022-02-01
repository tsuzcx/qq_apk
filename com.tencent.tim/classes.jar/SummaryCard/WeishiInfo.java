package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class WeishiInfo
  extends JceStruct
  implements Cloneable
{
  static ArrayList<WeishiFeed> cache_vecWeishiFeeds;
  public String strSchema = "";
  public ArrayList<WeishiFeed> vecWeishiFeeds;
  
  static
  {
    if (!WeishiInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_vecWeishiFeeds = new ArrayList();
      WeishiFeed localWeishiFeed = new WeishiFeed();
      cache_vecWeishiFeeds.add(localWeishiFeed);
      return;
    }
  }
  
  public WeishiInfo() {}
  
  public WeishiInfo(ArrayList<WeishiFeed> paramArrayList, String paramString)
  {
    this.vecWeishiFeeds = paramArrayList;
    this.strSchema = paramString;
  }
  
  public String className()
  {
    return "SummaryCard.WeishiInfo";
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
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.vecWeishiFeeds, "vecWeishiFeeds");
    paramStringBuilder.display(this.strSchema, "strSchema");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.vecWeishiFeeds, true);
    paramStringBuilder.displaySimple(this.strSchema, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (WeishiInfo)paramObject;
    } while ((!JceUtil.equals(this.vecWeishiFeeds, paramObject.vecWeishiFeeds)) || (!JceUtil.equals(this.strSchema, paramObject.strSchema)));
    return true;
  }
  
  public String fullClassName()
  {
    return "SummaryCard.WeishiInfo";
  }
  
  public String getStrSchema()
  {
    return this.strSchema;
  }
  
  public ArrayList<WeishiFeed> getVecWeishiFeeds()
  {
    return this.vecWeishiFeeds;
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
    this.vecWeishiFeeds = ((ArrayList)paramJceInputStream.read(cache_vecWeishiFeeds, 0, false));
    this.strSchema = paramJceInputStream.readString(1, false);
  }
  
  public void setStrSchema(String paramString)
  {
    this.strSchema = paramString;
  }
  
  public void setVecWeishiFeeds(ArrayList<WeishiFeed> paramArrayList)
  {
    this.vecWeishiFeeds = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecWeishiFeeds != null) {
      paramJceOutputStream.write(this.vecWeishiFeeds, 0);
    }
    if (this.strSchema != null) {
      paramJceOutputStream.write(this.strSchema, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SummaryCard.WeishiInfo
 * JD-Core Version:    0.7.0.1
 */