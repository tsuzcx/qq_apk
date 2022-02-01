package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.List;

class CartesianList$1
  extends ImmutableList<E>
{
  CartesianList$1(CartesianList paramCartesianList, int paramInt) {}
  
  public E get(int paramInt)
  {
    Preconditions.checkElementIndex(paramInt, size());
    int i = CartesianList.access$100(this.this$0, this.val$index, paramInt);
    return ((List)CartesianList.access$000(this.this$0).get(paramInt)).get(i);
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public int size()
  {
    return CartesianList.access$000(this.this$0).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.CartesianList.1
 * JD-Core Version:    0.7.0.1
 */