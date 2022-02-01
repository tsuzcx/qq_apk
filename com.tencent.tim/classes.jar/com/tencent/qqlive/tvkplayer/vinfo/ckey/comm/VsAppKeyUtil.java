package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VsAppKeyUtil
{
  private static VsAppKeyUtil instance = new VsAppKeyUtil();
  List<VsAppKeyBean> mArray = new CopyOnWriteArrayList();
  
  public static VsAppKeyUtil getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new VsAppKeyUtil();
      }
      return instance;
    }
    finally {}
  }
  
  public void add(VsAppKeyBean paramVsAppKeyBean)
  {
    Iterator localIterator = this.mArray.iterator();
    while (localIterator.hasNext())
    {
      VsAppKeyBean localVsAppKeyBean = (VsAppKeyBean)localIterator.next();
      if ((localVsAppKeyBean.getPlatform().equals(paramVsAppKeyBean.getPlatform())) || (localVsAppKeyBean.getSdtfrom().equals(paramVsAppKeyBean.getSdtfrom()))) {
        return;
      }
    }
    this.mArray.add(paramVsAppKeyBean);
  }
  
  public VsAppKeyBean getAppKey(String paramString)
  {
    Iterator localIterator = this.mArray.iterator();
    while (localIterator.hasNext())
    {
      VsAppKeyBean localVsAppKeyBean = (VsAppKeyBean)localIterator.next();
      if (localVsAppKeyBean.getPlatform().equals(paramString)) {
        return localVsAppKeyBean;
      }
    }
    return null;
  }
  
  public int getCount()
  {
    return this.mArray.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyUtil
 * JD-Core Version:    0.7.0.1
 */