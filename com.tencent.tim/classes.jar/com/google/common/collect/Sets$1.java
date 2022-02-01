package com.google.common.collect;

import com.google.common.math.IntMath;
import java.util.Set;

final class Sets$1
  extends Sets.SetView<E>
{
  Sets$1(Set paramSet1, Set paramSet2, Set paramSet3)
  {
    super(null);
  }
  
  public boolean contains(Object paramObject)
  {
    return (this.val$set1.contains(paramObject)) || (this.val$set2.contains(paramObject));
  }
  
  public <S extends Set<E>> S copyInto(S paramS)
  {
    paramS.addAll(this.val$set1);
    paramS.addAll(this.val$set2);
    return paramS;
  }
  
  public ImmutableSet<E> immutableCopy()
  {
    return new ImmutableSet.Builder().addAll(this.val$set1).addAll(this.val$set2).build();
  }
  
  public boolean isEmpty()
  {
    return (this.val$set1.isEmpty()) && (this.val$set2.isEmpty());
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.unmodifiableIterator(Iterators.concat(this.val$set1.iterator(), this.val$set2minus1.iterator()));
  }
  
  public int size()
  {
    return IntMath.saturatedAdd(this.val$set1.size(), this.val$set2minus1.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.1
 * JD-Core Version:    0.7.0.1
 */