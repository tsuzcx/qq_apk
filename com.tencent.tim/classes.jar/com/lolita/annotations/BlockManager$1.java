package com.lolita.annotations;

import java.util.Comparator;
import java.util.Map.Entry;

final class BlockManager$1
  implements Comparator<Map.Entry<K, V>>
{
  public int compare(Map.Entry<K, V> paramEntry1, Map.Entry<K, V> paramEntry2)
  {
    return ((Comparable)paramEntry2.getValue()).compareTo(paramEntry1.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.lolita.annotations.BlockManager.1
 * JD-Core Version:    0.7.0.1
 */