package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QMCalendarFolderCache
{
  private ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, QMCalendarFolder>> mFolderMap = new ConcurrentHashMap();
  
  public boolean addFolder(int paramInt, QMCalendarFolder paramQMCalendarFolder)
  {
    if (this.mFolderMap.get(Integer.valueOf(paramInt)) == null) {
      this.mFolderMap.putIfAbsent(Integer.valueOf(paramInt), new ConcurrentHashMap());
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mFolderMap.get(Integer.valueOf(paramInt));
    paramInt = paramQMCalendarFolder.getId();
    if (localConcurrentHashMap.get(Integer.valueOf(paramInt)) != null)
    {
      localConcurrentHashMap.remove(Integer.valueOf(paramInt));
      localConcurrentHashMap.put(Integer.valueOf(paramInt), paramQMCalendarFolder);
      return true;
    }
    localConcurrentHashMap.put(Integer.valueOf(paramQMCalendarFolder.getId()), paramQMCalendarFolder);
    return false;
  }
  
  public void clear()
  {
    this.mFolderMap.clear();
  }
  
  public Map<Integer, QMCalendarFolder> getAccountFolders(int paramInt)
  {
    return (Map)this.mFolderMap.get(Integer.valueOf(paramInt));
  }
  
  public int getAccountSize()
  {
    int j = this.mFolderMap.size();
    int i = j;
    if (j == 2147483647) {
      i = 0;
    }
    return i;
  }
  
  public Collection<Integer> getAllAccountIds()
  {
    ArrayList localArrayList = new ArrayList(getAccountSize());
    Iterator localIterator = this.mFolderMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getKey());
    }
    return localArrayList;
  }
  
  public ArrayList<QMCalendarFolder> getAllFolder()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.mFolderMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ConcurrentHashMap)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext()) {
        localArrayList.add((QMCalendarFolder)((Map.Entry)localIterator2.next()).getValue());
      }
    }
    return localArrayList;
  }
  
  public QMCalendarFolder getFolder(int paramInt1, int paramInt2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mFolderMap.get(Integer.valueOf(paramInt1));
    if (localConcurrentHashMap == null) {
      return null;
    }
    return (QMCalendarFolder)localConcurrentHashMap.get(Integer.valueOf(paramInt2));
  }
  
  public ArrayList<QMCalendarFolder> getFolder(FolderFilter paramFolderFilter)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.mFolderMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ConcurrentHashMap)((Map.Entry)localIterator1.next()).getValue()).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        QMCalendarFolder localQMCalendarFolder = (QMCalendarFolder)((Map.Entry)localIterator2.next()).getValue();
        if (paramFolderFilter.filter(localQMCalendarFolder)) {
          localArrayList.add(localQMCalendarFolder);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean hasFolders(int paramInt)
  {
    Map localMap = (Map)this.mFolderMap.get(Integer.valueOf(paramInt));
    if (localMap == null) {
      return false;
    }
    if (!localMap.isEmpty()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void removeFolder(int paramInt1, int paramInt2)
  {
    Map localMap = (Map)this.mFolderMap.get(Integer.valueOf(paramInt1));
    if (localMap == null) {
      return;
    }
    localMap.remove(Integer.valueOf(paramInt2));
  }
  
  public void removeFolders(int paramInt)
  {
    this.mFolderMap.remove(Integer.valueOf(paramInt));
  }
  
  public static abstract interface FolderFilter
  {
    public abstract boolean filter(QMCalendarFolder paramQMCalendarFolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarFolderCache
 * JD-Core Version:    0.7.0.1
 */