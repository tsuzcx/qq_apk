package com.tencent.qqmail.model.cache;

import android.util.SparseIntArray;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.ConcurrentHashSet;
import com.tencent.qqmail.utilities.QMUtilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class QMFolderIndex
  implements IIndexable<Integer, QMFolder, ArrayList<QMFolder>>
{
  private static final int[] folderTypes = { 1, 3, 4, 5, 6, 8, 16, 17, 15, 18, 19 };
  private ConcurrentHashMap<Integer, ArrayList<QMFolder>> folderArrayIndexesByType = new ConcurrentHashMap(16, 0.9F, 1);
  private ConcurrentHashMap<Integer, ArrayList<QMFolder>> folderArrayIndexesByTypeExcludeVipAndUnread = new ConcurrentHashMap(16, 0.9F, 1);
  private ConcurrentHashMap<Integer, int[]> folderIds = new ConcurrentHashMap(16, 0.9F, 1);
  private ConcurrentHashMap<Integer, ConcurrentHashSet<QMFolder>> folderSetIndexesByType = new ConcurrentHashMap(16, 0.9F, 1);
  private ConcurrentHashMap<Integer, ConcurrentSkipListSet<QMFolder>> folderSetIndexesByTypeExcludeVipAndUnread = new ConcurrentHashMap(16, 0.9F, 1);
  private SparseIntArray hasTag = new SparseIntArray();
  private QMCacheVersionManager<Integer> versionManager = new QMCacheVersionManager();
  
  private void updateListIndexesByAccount(int paramInt)
  {
    ConcurrentSkipListSet localConcurrentSkipListSet = new ConcurrentSkipListSet((SortedSet)this.folderSetIndexesByTypeExcludeVipAndUnread.get(Integer.valueOf(paramInt)));
    if (localConcurrentSkipListSet != null)
    {
      this.folderArrayIndexesByTypeExcludeVipAndUnread.put(Integer.valueOf(paramInt), new ArrayList(localConcurrentSkipListSet));
      this.versionManager.incrVersion(Integer.valueOf(paramInt));
    }
  }
  
  private void updateListIndexesByType(int paramInt)
  {
    ConcurrentHashSet localConcurrentHashSet = new ConcurrentHashSet((ConcurrentHashSet)this.folderSetIndexesByType.get(Integer.valueOf(paramInt)));
    if (localConcurrentHashSet != null)
    {
      this.folderArrayIndexesByType.put(Integer.valueOf(paramInt), new ArrayList(localConcurrentHashSet));
      this.versionManager.incrVersion(Integer.valueOf(paramInt));
    }
  }
  
  public void clear()
  {
    this.folderSetIndexesByTypeExcludeVipAndUnread.clear();
    this.folderArrayIndexesByTypeExcludeVipAndUnread.clear();
    this.versionManager.clear();
  }
  
  public boolean dataHasChanged(Integer paramInteger, int paramInt)
  {
    return this.versionManager.dataHasChanged(paramInteger, paramInt);
  }
  
  public void dropFolderIdIndex(int paramInt)
  {
    this.folderIds.remove(Integer.valueOf(paramInt));
  }
  
  public void dropIndexes(QMFolder paramQMFolder)
  {
    if (paramQMFolder != null)
    {
      int i = paramQMFolder.getAccountId();
      Object localObject = new ConcurrentSkipListSet((SortedSet)this.folderSetIndexesByTypeExcludeVipAndUnread.get(Integer.valueOf(i)));
      if (localObject != null)
      {
        ((ConcurrentSkipListSet)localObject).remove(paramQMFolder);
        this.folderSetIndexesByTypeExcludeVipAndUnread.put(Integer.valueOf(i), localObject);
        updateListIndexesByAccount(i);
      }
      int j = paramQMFolder.getType();
      localObject = (ConcurrentHashSet)this.folderSetIndexesByType.get(Integer.valueOf(j));
      if (localObject != null) {
        ((ConcurrentHashSet)localObject).remove(paramQMFolder);
      }
      localObject = (int[])this.folderIds.get(Integer.valueOf(i));
      if (localObject != null)
      {
        int k = QMUtilities.indexOf(folderTypes, j);
        if (k != -1) {
          localObject[k] = paramQMFolder.getId();
        }
      }
      if (j == 14) {
        this.hasTag.put(i, this.hasTag.get(i) - 1);
      }
    }
  }
  
  public void ensureIndexes(QMFolder paramQMFolder)
  {
    if (paramQMFolder != null)
    {
      int i = paramQMFolder.getAccountId();
      Object localObject2 = (ConcurrentSkipListSet)this.folderSetIndexesByTypeExcludeVipAndUnread.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ConcurrentSkipListSet();
        this.folderSetIndexesByTypeExcludeVipAndUnread.put(Integer.valueOf(i), localObject1);
      }
      int j = paramQMFolder.getType();
      if ((j != 17) && (j != 18))
      {
        ((ConcurrentSkipListSet)localObject1).remove(paramQMFolder);
        ((ConcurrentSkipListSet)localObject1).add(paramQMFolder);
      }
      updateListIndexesByAccount(i);
      localObject2 = (ConcurrentHashSet)this.folderSetIndexesByType.get(Integer.valueOf(j));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ConcurrentHashSet();
        this.folderSetIndexesByType.put(Integer.valueOf(j), localObject1);
      }
      ((ConcurrentHashSet)localObject1).add(paramQMFolder);
      updateListIndexesByType(j);
      localObject2 = (int[])this.folderIds.get(Integer.valueOf(i));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new int[folderTypes.length];
        Arrays.fill((int[])localObject1, 0);
        this.folderIds.put(Integer.valueOf(i), localObject1);
      }
      int k = QMUtilities.indexOf(folderTypes, j);
      if (k != -1) {
        localObject1[k] = paramQMFolder.getId();
      }
      if (j == 14) {
        this.hasTag.put(i, this.hasTag.get(i) + 1);
      }
    }
  }
  
  public ArrayList<QMFolder> get(Integer paramInteger)
  {
    return null;
  }
  
  public ArrayList<QMFolder> getByAccount(Integer paramInteger)
  {
    paramInteger = (ArrayList)this.folderArrayIndexesByTypeExcludeVipAndUnread.get(paramInteger);
    if (paramInteger != null) {
      return new ArrayList(paramInteger);
    }
    return new ArrayList();
  }
  
  public ArrayList<QMFolder> getByType(Integer paramInteger)
  {
    paramInteger = (ArrayList)this.folderArrayIndexesByType.get(paramInteger);
    if (paramInteger != null) {
      return new ArrayList(paramInteger);
    }
    return new ArrayList();
  }
  
  public int[] getFolderIds(int paramInt)
  {
    int[] arrayOfInt2 = (int[])this.folderIds.get(Integer.valueOf(paramInt));
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
    {
      arrayOfInt1 = new int[folderTypes.length];
      Arrays.fill(arrayOfInt1, 0);
      this.folderIds.put(Integer.valueOf(paramInt), arrayOfInt1);
    }
    return Arrays.copyOf(arrayOfInt1, arrayOfInt1.length);
  }
  
  public int getVersion(Integer paramInteger)
  {
    return this.versionManager.getVersion(paramInteger);
  }
  
  public boolean hasTag(int paramInt)
  {
    return this.hasTag.get(paramInt) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMFolderIndex
 * JD-Core Version:    0.7.0.1
 */