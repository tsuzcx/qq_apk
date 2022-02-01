package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public abstract interface RemovalListener<K, V>
{
  public abstract void onRemoval(RemovalNotification<K, V> paramRemovalNotification);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.RemovalListener
 * JD-Core Version:    0.7.0.1
 */