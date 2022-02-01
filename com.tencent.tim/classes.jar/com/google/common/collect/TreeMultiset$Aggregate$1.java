package com.google.common.collect;

import javax.annotation.Nullable;

 enum TreeMultiset$Aggregate$1
{
  TreeMultiset$Aggregate$1()
  {
    super(str, i, null);
  }
  
  int nodeAggregate(TreeMultiset.AvlNode<?> paramAvlNode)
  {
    return TreeMultiset.AvlNode.access$200(paramAvlNode);
  }
  
  long treeAggregate(@Nullable TreeMultiset.AvlNode<?> paramAvlNode)
  {
    if (paramAvlNode == null) {
      return 0L;
    }
    return TreeMultiset.AvlNode.access$300(paramAvlNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeMultiset.Aggregate.1
 * JD-Core Version:    0.7.0.1
 */