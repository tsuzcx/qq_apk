package com.tencent.qqlive.module.videoreport.reportdata;

import com.tencent.qqlive.module.videoreport.data.DataEntity;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PathData
{
  private Object mPage;
  private final Deque<DataEntity> mPathPackages = new ArrayDeque();
  
  public void addFirst(DataEntity paramDataEntity)
  {
    this.mPathPackages.addFirst(paramDataEntity);
  }
  
  public void addLast(DataEntity paramDataEntity)
  {
    this.mPathPackages.addLast(paramDataEntity);
  }
  
  public PathData copy()
  {
    PathData localPathData = new PathData();
    localPathData.mPage = this.mPage;
    Iterator localIterator = this.mPathPackages.iterator();
    while (localIterator.hasNext())
    {
      DataEntity localDataEntity = (DataEntity)localIterator.next();
      localPathData.mPathPackages.addLast(localDataEntity);
    }
    return localPathData;
  }
  
  public Iterator<DataEntity> descendingIterator()
  {
    return this.mPathPackages.descendingIterator();
  }
  
  public Object getPage()
  {
    return this.mPage;
  }
  
  public boolean isEmpty()
  {
    return this.mPathPackages.isEmpty();
  }
  
  public Iterator<DataEntity> iterator()
  {
    return this.mPathPackages.iterator();
  }
  
  public void removeFirst()
  {
    if (!this.mPathPackages.isEmpty()) {
      this.mPathPackages.removeFirst();
    }
  }
  
  public void setPage(Object paramObject)
  {
    this.mPage = paramObject;
  }
  
  public int size()
  {
    return this.mPathPackages.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.reportdata.PathData
 * JD-Core Version:    0.7.0.1
 */