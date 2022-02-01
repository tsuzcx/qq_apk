package com.google.common.collect;

import com.google.common.base.Function;

final class TreeTraverser$1
  extends TreeTraverser<T>
{
  TreeTraverser$1(Function paramFunction) {}
  
  public Iterable<T> children(T paramT)
  {
    return (Iterable)this.val$nodeToChildrenFunction.apply(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeTraverser.1
 * JD-Core Version:    0.7.0.1
 */