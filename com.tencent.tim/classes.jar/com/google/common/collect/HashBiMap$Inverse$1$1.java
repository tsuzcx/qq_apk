package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map.Entry;

class HashBiMap$Inverse$1$1
  extends HashBiMap<K, V>.Itr<Map.Entry<V, K>>
{
  HashBiMap$Inverse$1$1(HashBiMap.Inverse.1 param1)
  {
    super(param1.this$1.this$0);
  }
  
  Map.Entry<V, K> output(HashBiMap.BiEntry<K, V> paramBiEntry)
  {
    return new InverseEntry(paramBiEntry);
  }
  
  class InverseEntry
    extends AbstractMapEntry<V, K>
  {
    HashBiMap.BiEntry<K, V> delegate;
    
    InverseEntry()
    {
      Object localObject;
      this.delegate = localObject;
    }
    
    public V getKey()
    {
      return this.delegate.value;
    }
    
    public K getValue()
    {
      return this.delegate.key;
    }
    
    public K setValue(K paramK)
    {
      Object localObject = this.delegate.key;
      int i = Hashing.smearedHash(paramK);
      if ((i == this.delegate.keyHash) && (Objects.equal(paramK, localObject))) {
        return paramK;
      }
      if (HashBiMap.access$300(HashBiMap.Inverse.1.1.this.this$2.this$1.this$0, paramK, i) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "value already present: %s", paramK);
        HashBiMap.access$200(HashBiMap.Inverse.1.1.this.this$2.this$1.this$0, this.delegate);
        paramK = new HashBiMap.BiEntry(paramK, i, this.delegate.value, this.delegate.valueHash);
        this.delegate = paramK;
        HashBiMap.access$500(HashBiMap.Inverse.1.1.this.this$2.this$1.this$0, paramK, null);
        HashBiMap.Inverse.1.1.this.expectedModCount = HashBiMap.access$100(HashBiMap.Inverse.1.1.this.this$2.this$1.this$0);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.HashBiMap.Inverse.1.1
 * JD-Core Version:    0.7.0.1
 */