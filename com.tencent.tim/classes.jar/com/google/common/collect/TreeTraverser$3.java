package com.google.common.collect;

class TreeTraverser$3
  extends FluentIterable<T>
{
  TreeTraverser$3(TreeTraverser paramTreeTraverser, Object paramObject) {}
  
  public UnmodifiableIterator<T> iterator()
  {
    return this.this$0.postOrderIterator(this.val$root);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeTraverser.3
 * JD-Core Version:    0.7.0.1
 */