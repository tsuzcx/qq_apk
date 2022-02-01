package com.google.common.collect;

class WellBehavedMap$EntrySet$1$1
  extends AbstractMapEntry<K, V>
{
  WellBehavedMap$EntrySet$1$1(WellBehavedMap.EntrySet.1 param1, Object paramObject) {}
  
  public K getKey()
  {
    return this.val$key;
  }
  
  public V getValue()
  {
    return this.this$2.this$1.this$0.get(this.val$key);
  }
  
  public V setValue(V paramV)
  {
    return this.this$2.this$1.this$0.put(this.val$key, paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.WellBehavedMap.EntrySet.1.1
 * JD-Core Version:    0.7.0.1
 */