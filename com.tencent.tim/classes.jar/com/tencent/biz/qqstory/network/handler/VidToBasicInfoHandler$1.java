package com.tencent.biz.qqstory.network.handler;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ppv;
import ppw;
import pyc;
import pzl;
import ram;

public class VidToBasicInfoHandler$1
  implements Runnable
{
  public VidToBasicInfoHandler$1(pyc parampyc) {}
  
  public void run()
  {
    Object localObject;
    if (pyc.a(this.this$0))
    {
      localObject = this.this$0.mVidList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        Long localLong = (Long)pyc.i().get(str);
        if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() < 300000L))
        {
          ((Iterator)localObject).remove();
          ram.b("Q.qqstory.net:VidToBasicInfoHandler", "remove same request for vid info:%s", str);
        }
        else
        {
          pyc.i().put(str, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (this.this$0.mVidList.size() > 0)
    {
      ram.b("Q.qqstory.net:VidToBasicInfoHandler", "request for vid info:%s", this.this$0.mVidList);
      localObject = new pzl();
      ((pzl)localObject).nv = this.this$0.mVidList;
      ppv.a().a((ppw)localObject, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToBasicInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */