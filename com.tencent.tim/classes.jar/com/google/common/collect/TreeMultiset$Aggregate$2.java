package com.google.common.collect;

import javax.annotation.Nullable;

 enum TreeMultiset$Aggregate$2
{
  TreeMultiset$Aggregate$2()
  {
    super(str, i, null);
  }
  
  int nodeAggregate(TreeMultiset.AvlNode<?> paramAvlNode)
  {
    return 1;
  }
  
  long treeAggregate(@Nullable TreeMultiset.AvlNode<?> paramAvlNode)
  {
    if (paramAvlNode == null) {
      return 0L;
    }
    return TreeMultiset.AvlNode.access$400(paramAvlNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeMultiset.Aggregate.2
 * JD-Core Version:    0.7.0.1
 */