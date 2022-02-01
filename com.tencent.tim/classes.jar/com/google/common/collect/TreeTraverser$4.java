package com.google.common.collect;

class TreeTraverser$4
  extends FluentIterable<T>
{
  TreeTraverser$4(TreeTraverser paramTreeTraverser, Object paramObject) {}
  
  public UnmodifiableIterator<T> iterator()
  {
    return new TreeTraverser.BreadthFirstIterator(this.this$0, this.val$root);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeTraverser.4
 * JD-Core Version:    0.7.0.1
 */