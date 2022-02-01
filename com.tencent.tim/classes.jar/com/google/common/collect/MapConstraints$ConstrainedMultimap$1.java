package com.google.common.collect;

class MapConstraints$ConstrainedMultimap$1
  implements Constraint<V>
{
  MapConstraints$ConstrainedMultimap$1(MapConstraints.ConstrainedMultimap paramConstrainedMultimap, Object paramObject) {}
  
  public V checkElement(V paramV)
  {
    this.this$0.constraint.checkKeyValue(this.val$key, paramV);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.ConstrainedMultimap.1
 * JD-Core Version:    0.7.0.1
 */