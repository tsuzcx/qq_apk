package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public abstract interface Weigher<K, V>
{
  public abstract int weigh(K paramK, V paramV);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.Weigher
 * JD-Core Version:    0.7.0.1
 */