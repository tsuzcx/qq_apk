package com.google.common.reflect;

import com.google.common.base.Function;
import java.util.Map.Entry;

final class MutableTypeToInstanceMap$UnmodifiableEntry$2
  implements Function<Map.Entry<K, V>, Map.Entry<K, V>>
{
  public Map.Entry<K, V> apply(Map.Entry<K, V> paramEntry)
  {
    return new MutableTypeToInstanceMap.UnmodifiableEntry(paramEntry, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.2
 * JD-Core Version:    0.7.0.1
 */