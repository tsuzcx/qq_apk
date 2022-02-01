package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;

class TreeRangeMap$SubRangeMap$1
  extends TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap
{
  TreeRangeMap$SubRangeMap$1(TreeRangeMap.SubRangeMap paramSubRangeMap)
  {
    super(paramSubRangeMap);
  }
  
  Iterator<Map.Entry<Range<K>, V>> entryIterator()
  {
    if (TreeRangeMap.SubRangeMap.access$200(this.this$1).isEmpty()) {
      return Iterators.emptyIterator();
    }
    return new TreeRangeMap.SubRangeMap.1.1(this, TreeRangeMap.access$000(this.this$1.this$0).headMap(TreeRangeMap.SubRangeMap.access$200(this.this$1).upperBound, false).descendingMap().values().iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.SubRangeMap.1
 * JD-Core Version:    0.7.0.1
 */