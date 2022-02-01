package com.tencent.qqmail.model.cache;

import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.ArrayList;

public class QMFolderCache
  extends QMReadWriteCache<Integer, QMFolder>
{
  private QMFolderIndex folderIndex = new QMFolderIndex();
  
  public void clear()
  {
    this.folderIndex.clear();
    super.clear();
  }
  
  public boolean dataHasChanged(Integer paramInteger, int paramInt)
  {
    return this.folderIndex.dataHasChanged(paramInteger, paramInt);
  }
  
  public void delete(IMapper<QMFolder> paramIMapper)
  {
    super.delete(new QMFolderCache.6(this, paramIMapper));
  }
  
  public void delete(IMapper<QMFolder> paramIMapper, Runnable paramRunnable)
  {
    super.delete(new QMFolderCache.5(this, paramIMapper), paramRunnable);
  }
  
  public void deleteByKey(Integer paramInteger)
  {
    this.folderIndex.dropIndexes((QMFolder)get(paramInteger));
    super.deleteByKey(paramInteger);
  }
  
  public void deleteByKey(Integer paramInteger, Runnable paramRunnable)
  {
    this.folderIndex.dropIndexes((QMFolder)get(paramInteger));
    super.deleteByKey(paramInteger, paramRunnable);
  }
  
  public int[] getFolderIds(int paramInt)
  {
    return this.folderIndex.getFolderIds(paramInt);
  }
  
  public Integer getKeyByItem(QMFolder paramQMFolder)
  {
    return Integer.valueOf(paramQMFolder.getId());
  }
  
  public int getVersion(Integer paramInteger)
  {
    return this.folderIndex.getVersion(paramInteger);
  }
  
  public boolean hasTag(int paramInt)
  {
    return this.folderIndex.hasTag(paramInt);
  }
  
  public void insert(Integer paramInteger, QMFolder paramQMFolder)
  {
    super.insert(paramInteger, paramQMFolder);
    this.folderIndex.ensureIndexes(paramQMFolder);
  }
  
  public void insert(Integer paramInteger, QMFolder paramQMFolder, Runnable paramRunnable)
  {
    super.insert(paramInteger, paramQMFolder, paramRunnable);
    this.folderIndex.ensureIndexes(paramQMFolder);
  }
  
  public ArrayList<QMFolder> selectByAccountExcludeVipAndUnread(int paramInt)
  {
    return this.folderIndex.getByAccount(Integer.valueOf(paramInt));
  }
  
  public ArrayList<QMFolder> selectByType(int paramInt)
  {
    ArrayList localArrayList = this.folderIndex.getByType(Integer.valueOf(paramInt));
    if (localArrayList == null) {
      return new ArrayList();
    }
    return new ArrayList(localArrayList);
  }
  
  public void update(IQuery<QMFolder> paramIQuery)
  {
    super.update(new QMFolderCache.4(this, paramIQuery));
  }
  
  public void update(IQuery<QMFolder> paramIQuery, Runnable paramRunnable)
  {
    super.update(new QMFolderCache.3(this, paramIQuery), paramRunnable);
  }
  
  public void updateByKey(Integer paramInteger, IReducer<QMFolder> paramIReducer)
  {
    super.updateByKey(paramInteger, new QMFolderCache.2(this, paramIReducer));
  }
  
  public void updateByKey(Integer paramInteger, IReducer<QMFolder> paramIReducer, Runnable paramRunnable)
  {
    super.updateByKey(paramInteger, new QMFolderCache.1(this, paramIReducer), paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMFolderCache
 * JD-Core Version:    0.7.0.1
 */