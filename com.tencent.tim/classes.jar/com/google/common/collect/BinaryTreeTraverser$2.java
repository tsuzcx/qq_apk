package com.google.common.collect;

class BinaryTreeTraverser$2
  extends FluentIterable<T>
{
  BinaryTreeTraverser$2(BinaryTreeTraverser paramBinaryTreeTraverser, Object paramObject) {}
  
  public UnmodifiableIterator<T> iterator()
  {
    return new BinaryTreeTraverser.InOrderIterator(this.this$0, this.val$root);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.BinaryTreeTraverser.2
 * JD-Core Version:    0.7.0.1
 */