package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4
  extends Maps.Values<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap, Map paramMap)
  {
    super(paramMap);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.in(paramCollection), Maps.valueFunction()));
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.not(Predicates.in(paramCollection)), Maps.valueFunction()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.4
 * JD-Core Version:    0.7.0.1
 */