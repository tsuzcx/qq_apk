package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1
  extends Maps.KeySet<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap, Map paramMap)
  {
    super(paramMap);
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    return this.this$2.remove(paramObject) != null;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.not(Predicates.in(paramCollection)), Maps.keyFunction()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1
 * JD-Core Version:    0.7.0.1
 */