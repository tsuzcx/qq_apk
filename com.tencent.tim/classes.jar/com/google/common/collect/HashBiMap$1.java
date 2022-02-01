package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;

class HashBiMap$1
  extends HashBiMap<K, V>.Itr<Map.Entry<K, V>>
{
  HashBiMap$1(HashBiMap paramHashBiMap)
  {
    super(paramHashBiMap);
  }
  
  Map.Entry<K, V> output(HashBiMap.BiEntry<K, V> paramBiEntry)
  {
    return new MapEntry(paramBiEntry);
  }
  
  class MapEntry
    extends AbstractMapEntry<K, V>
  {
    HashBiMap.BiEntry<K, V> delegate;
    
    MapEntry()
    {
      Object localObject;
      this.delegate = localObject;
    }
    
    public K getKey()
    {
      return this.delegate.key;
    }
    
    public V getValue()
    {
      return this.delegate.value;
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.delegate.value;
      int i = Hashing.smearedHash(paramV);
      if ((i == this.delegate.valueHash) && (Objects.equal(paramV, localObject))) {
        return paramV;
      }
      if (HashBiMap.access$400(HashBiMap.1.this.this$0, paramV, i) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value already present: %s", paramV);
        HashBiMap.access$200(HashBiMap.1.this.this$0, this.delegate);
        paramV = new HashBiMap.BiEntry(this.delegate.key, this.delegate.keyHash, paramV, i);
        HashBiMap.access$500(HashBiMap.1.this.this$0, paramV, this.delegate);
        this.delegate.prevInKeyInsertionOrder = null;
        this.delegate.nextInKeyInsertionOrder = null;
        HashBiMap.1.this.expectedModCount = HashBiMap.access$100(HashBiMap.1.this.this$0);
        if (HashBiMap.1.this.toRemove == this.delegate) {
          HashBiMap.1.this.toRemove = paramV;
        }
        this.delegate = paramV;
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.HashBiMap.1
 * JD-Core Version:    0.7.0.1
 */