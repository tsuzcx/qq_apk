package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

class TreeMultiset$3
  implements Iterator<Multiset.Entry<E>>
{
  TreeMultiset.AvlNode<E> current = TreeMultiset.access$1600(this.this$0);
  Multiset.Entry<E> prevEntry = null;
  
  TreeMultiset$3(TreeMultiset paramTreeMultiset) {}
  
  public boolean hasNext()
  {
    if (this.current == null) {
      return false;
    }
    if (TreeMultiset.access$1300(this.this$0).tooLow(this.current.getElement()))
    {
      this.current = null;
      return false;
    }
    return true;
  }
  
  public Multiset.Entry<E> next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Multiset.Entry localEntry = TreeMultiset.access$1400(this.this$0, this.current);
    this.prevEntry = localEntry;
    if (TreeMultiset.AvlNode.access$1100(this.current) == TreeMultiset.access$1500(this.this$0))
    {
      this.current = null;
      return localEntry;
    }
    this.current = TreeMultiset.AvlNode.access$1100(this.current);
    return localEntry;
  }
  
  public void remove()
  {
    if (this.prevEntry != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.this$0.setCount(this.prevEntry.getElement(), 0);
      this.prevEntry = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.TreeMultiset.3
 * JD-Core Version:    0.7.0.1
 */