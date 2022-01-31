package com.tencent.sc.qzonepush.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class SvcMsgPush
  extends JceStruct
{
  static ArrayList cache_vecMsgInfos;
  public byte cMore = 0;
  public int iUnread = 0;
  public ArrayList vecMsgInfos = null;
  
  static
  {
    if (!SvcMsgPush.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public SvcMsgPush()
  {
    setCMore(this.cMore);
    setIUnread(this.iUnread);
    setVecMsgInfos(this.vecMsgInfos);
  }
  
  public SvcMsgPush(byte paramByte, int paramInt, ArrayList paramArrayList)
  {
    setCMore(paramByte);
    setIUnread(paramInt);
    setVecMsgInfos(paramArrayList);
  }
  
  public String className()
  {
    return "com.tencent.sc.qzonepush.QQService.SvcMsgPush";
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
    paramStringBuilder.display(this.cMore, "cMore");
    paramStringBuilder.display(this.iUnread, "iUnread");
    paramStringBuilder.display(this.vecMsgInfos, "vecMsgInfos");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (SvcMsgPush)paramObject;
    return (JceUtil.equals(this.cMore, paramObject.cMore)) && (JceUtil.equals(this.iUnread, paramObject.iUnread)) && (JceUtil.equals(this.vecMsgInfos, paramObject.vecMsgInfos));
  }
  
  public byte getCMore()
  {
    return this.cMore;
  }
  
  public int getIUnread()
  {
    return this.iUnread;
  }
  
  public ArrayList getVecMsgInfos()
  {
    return this.vecMsgInfos;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setCMore(paramJceInputStream.read(this.cMore, 0, true));
    setIUnread(paramJceInputStream.read(this.iUnread, 1, true));
    if (cache_vecMsgInfos == null)
    {
      cache_vecMsgInfos = new ArrayList();
      SvcMsgInfo localSvcMsgInfo = new SvcMsgInfo();
      cache_vecMsgInfos.add(localSvcMsgInfo);
    }
    setVecMsgInfos((ArrayList)paramJceInputStream.read(cache_vecMsgInfos, 2, true));
  }
  
  public void setCMore(byte paramByte)
  {
    this.cMore = paramByte;
  }
  
  public void setIUnread(int paramInt)
  {
    this.iUnread = paramInt;
  }
  
  public void setVecMsgInfos(ArrayList paramArrayList)
  {
    this.vecMsgInfos = paramArrayList;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cMore, 0);
    paramJceOutputStream.write(this.iUnread, 1);
    paramJceOutputStream.write(this.vecMsgInfos, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.sc.qzonepush.QQService.SvcMsgPush
 * JD-Core Version:    0.7.0.1
 */