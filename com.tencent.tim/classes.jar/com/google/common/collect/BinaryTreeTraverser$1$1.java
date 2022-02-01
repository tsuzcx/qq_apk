package com.google.common.collect;

import com.google.common.base.Optional;

class BinaryTreeTraverser$1$1
  extends AbstractIterator<T>
{
  boolean doneLeft;
  boolean doneRight;
  
  BinaryTreeTraverser$1$1(BinaryTreeTraverser.1 param1) {}
  
  protected T computeNext()
  {
    Optional localOptional;
    if (!this.doneLeft)
    {
      this.doneLeft = true;
      localOptional = this.this$1.this$0.leftChild(this.this$1.val$root);
      if (localOptional.isPresent()) {
        return localOptional.get();
      }
    }
    if (!this.doneRight)
    {
      this.doneRight = true;
      localOptional = this.this$1.this$0.rightChild(this.this$1.val$root);
      if (localOptional.isPresent()) {
        return localOptional.get();
      }
    }
    return endOfData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.BinaryTreeTraverser.1.1
 * JD-Core Version:    0.7.0.1
 */