package com.tencent.qqmail.model.cache;

import android.util.SparseBooleanArray;

public class QMAggrConvMailCache
  implements IIndexable<Integer, Boolean, Boolean>
{
  private static QMAggrConvMailCache _instance = null;
  SparseBooleanArray subUnreadCache = new SparseBooleanArray();
  
  public static QMAggrConvMailCache sharedInstance()
  {
    if (_instance == null) {
      _instance = new QMAggrConvMailCache();
    }
    return _instance;
  }
  
  public void clear()
  {
    this.subUnreadCache.clear();
  }
  
  public void dropIndex(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < this.subUnreadCache.size())
      {
        int i = this.subUnreadCache.keyAt(paramInt);
        this.subUnreadCache.put(i, false);
        paramInt += 1;
      }
    }
    this.subUnreadCache.put(paramInt, false);
  }
  
  public void dropIndexes(Boolean paramBoolean) {}
  
  public void ensureIndexes(Boolean paramBoolean)
  {
    throw new UnsupportedOperationException("use QMAggrConvMailCache#ensureUnreadIndexes instead");
  }
  
  public void ensureUnreadIndexes(int paramInt, boolean paramBoolean)
  {
    this.subUnreadCache.put(paramInt, paramBoolean);
  }
  
  public Boolean get(Integer paramInteger)
  {
    return null;
  }
  
  public boolean get(int paramInt)
  {
    return this.subUnreadCache.get(paramInt);
  }
  
  public int getSubscribeConvUnreadCount(int paramInt)
  {
    int i = 1;
    int j;
    if (paramInt == 0)
    {
      i = 0;
      paramInt = 0;
      j = paramInt;
      if (i < this.subUnreadCache.size())
      {
        int k = this.subUnreadCache.keyAt(i);
        j = paramInt;
        if (k != 0) {
          if (!get(k)) {
            break label64;
          }
        }
        label64:
        for (j = 1;; j = 0)
        {
          j = paramInt + j;
          i += 1;
          paramInt = j;
          break;
        }
      }
    }
    else
    {
      if (!get(paramInt)) {
        break label83;
      }
    }
    label83:
    for (paramInt = i;; paramInt = 0)
    {
      j = paramInt;
      return j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.cache.QMAggrConvMailCache
 * JD-Core Version:    0.7.0.1
 */