package com.google.common.collect;

class MapConstraints$2$1
  implements Constraint<V>
{
  MapConstraints$2$1(MapConstraints.2 param2) {}
  
  public V checkElement(V paramV)
  {
    this.this$0.val$constraint.checkKeyValue(this.this$0.getKey(), paramV);
    return paramV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.MapConstraints.2.1
 * JD-Core Version:    0.7.0.1
 */