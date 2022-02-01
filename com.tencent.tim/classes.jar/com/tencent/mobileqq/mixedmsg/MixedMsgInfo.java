package com.tencent.mobileqq.mixedmsg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MixedMsgInfo
{
  private List<MsgNode> CQ = new ArrayList(41);
  
  public void a(MsgNode paramMsgNode)
  {
    if (paramMsgNode != null) {
      this.CQ.add(paramMsgNode);
    }
  }
  
  public boolean aqq()
  {
    Iterator localIterator = this.CQ.iterator();
    while (localIterator.hasNext()) {
      if (((MsgNode)localIterator.next() instanceof PhotoMsgNode)) {
        return true;
      }
    }
    return false;
  }
  
  public List<MsgNode> fx()
  {
    return this.CQ;
  }
  
  public List<String> fy()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.CQ.iterator();
    while (localIterator.hasNext())
    {
      MsgNode localMsgNode = (MsgNode)localIterator.next();
      if ((localMsgNode instanceof PhotoMsgNode)) {
        localArrayList.add(((PhotoMsgNode)localMsgNode).getPhotoItem().path);
      }
    }
    return localArrayList;
  }
  
  public String text()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.CQ.size())
    {
      localStringBuilder.append(((MsgNode)this.CQ.get(i)).text());
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String xi()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.CQ.iterator();
    while (localIterator.hasNext())
    {
      MsgNode localMsgNode = (MsgNode)localIterator.next();
      if ((localMsgNode instanceof TextMsgNode)) {
        localStringBuilder.append(localMsgNode.text());
      }
    }
    return localStringBuilder.toString();
  }
  
  public static abstract class MsgNode
    implements Serializable
  {
    public int length()
    {
      if (text() == null) {
        return 0;
      }
      return text().length();
    }
    
    public abstract String text();
  }
  
  public static class PhotoItem
    implements Serializable
  {
    public boolean isOriginal;
    public String path;
    
    public PhotoItem() {}
    
    public PhotoItem(String paramString, boolean paramBoolean)
    {
      this.isOriginal = paramBoolean;
      this.path = paramString;
    }
  }
  
  public static class PhotoMsgNode
    extends MixedMsgInfo.MsgNode
  {
    public static final String PHOTO_TAG = "[图片]";
    private MixedMsgInfo.PhotoItem photoItem;
    
    public PhotoMsgNode(MixedMsgInfo.PhotoItem paramPhotoItem)
    {
      this.photoItem = paramPhotoItem;
    }
    
    public MixedMsgInfo.PhotoItem getPhotoItem()
    {
      return this.photoItem;
    }
    
    public String text()
    {
      return "[图片]";
    }
  }
  
  public static enum TextLocation
  {
    HEADER,  INLINE,  TAILOR;
    
    private TextLocation() {}
  }
  
  public static class TextMsgNode
    extends MixedMsgInfo.MsgNode
  {
    private String text;
    
    public TextMsgNode(String paramString)
    {
      this.text = paramString;
    }
    
    public String text()
    {
      return this.text;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgInfo
 * JD-Core Version:    0.7.0.1
 */