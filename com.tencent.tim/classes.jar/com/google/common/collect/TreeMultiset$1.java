package com.google.common.collect;

class TreeMultiset$1
  extends Multisets.AbstractEntry<E>
{
  TreeMultiset$1(TreeMultiset paramTreeMultiset, TreeMultiset.AvlNode paramAvlNode) {}
  
  public int getCount()
  {
    int j = this.val$baseEntry.getCount();
    int i = j;
    if (j == 0) {
      i = this.this$0.count(getElement());
    }
    return i;
  }
  
  public E getElement()
  {
    return this.val$baseEntry.getElement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeMultiset.1
 * JD-Core Version:    0.7.0.1
 */