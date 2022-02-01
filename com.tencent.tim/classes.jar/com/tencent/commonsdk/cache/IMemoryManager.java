package com.tencent.commonsdk.cache;

import android.support.v4.util.LruCache;

public abstract interface IMemoryManager
{
  public abstract void addConCurrentHashMap(QQConcurrentHashMap paramQQConcurrentHashMap);
  
  public abstract void addHashMap(QQHashMap paramQQHashMap);
  
  public abstract void addLruCache(LruCache paramLruCache);
  
  public abstract void addQQLruCache(QQLruCache paramQQLruCache);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.cache.IMemoryManager
 * JD-Core Version:    0.7.0.1
 */