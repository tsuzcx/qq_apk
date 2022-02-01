package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RespGetDiscuss
  extends JceStruct
  implements Cloneable
{
  static ArrayList<DiscussInfo> cache_DiscussList;
  static ArrayList<DiscussInfo> cache_FavoriteDiscussList;
  public ArrayList<DiscussInfo> DiscussList;
  public ArrayList<DiscussInfo> FavoriteDiscussList;
  
  static
  {
    if (!RespGetDiscuss.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RespGetDiscuss() {}
  
  public RespGetDiscuss(ArrayList<DiscussInfo> paramArrayList1, ArrayList<DiscussInfo> paramArrayList2)
  {
    this.DiscussList = paramArrayList1;
    this.FavoriteDiscussList = paramArrayList2;
  }
  
  public String className()
  {
    return "QQService.RespGetDiscuss";
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
    paramStringBuilder.display(this.DiscussList, "DiscussList");
    paramStringBuilder.display(this.FavoriteDiscussList, "FavoriteDiscussList");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.DiscussList, true);
    paramStringBuilder.displaySimple(this.FavoriteDiscussList, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RespGetDiscuss)paramObject;
    } while ((!JceUtil.equals(this.DiscussList, paramObject.DiscussList)) || (!JceUtil.equals(this.FavoriteDiscussList, paramObject.FavoriteDiscussList)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.RespGetDiscuss";
  }
  
  public ArrayList<DiscussInfo> getDiscussList()
  {
    return this.DiscussList;
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
    DiscussInfo localDiscussInfo;
    if (cache_DiscussList == null)
    {
      cache_DiscussList = new ArrayList();
      localDiscussInfo = new DiscussInfo();
      cache_DiscussList.add(localDiscussInfo);
    }
    this.DiscussList = ((ArrayList)paramJceInputStream.read(cache_DiscussList, 0, true));
    if (cache_FavoriteDiscussList == null)
    {
      cache_FavoriteDiscussList = new ArrayList();
      localDiscussInfo = new DiscussInfo();
      cache_FavoriteDiscussList.add(localDiscussInfo);
    }
    this.FavoriteDiscussList = ((ArrayList)paramJceInputStream.read(cache_FavoriteDiscussList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussList, 0);
    if (this.FavoriteDiscussList != null) {
      paramJceOutputStream.write(this.FavoriteDiscussList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.RespGetDiscuss
 * JD-Core Version:    0.7.0.1
 */