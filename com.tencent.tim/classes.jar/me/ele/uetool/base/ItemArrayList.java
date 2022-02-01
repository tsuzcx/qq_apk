package me.ele.uetool.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import me.ele.uetool.base.item.Item;

public class ItemArrayList<T extends Item>
  extends ArrayList<T>
{
  private void removeInvalidItem(Collection<? extends T> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!((Item)paramCollection.next()).isValid()) {
        paramCollection.remove();
      }
    }
  }
  
  public boolean add(T paramT)
  {
    if (!paramT.isValid()) {
      return false;
    }
    return super.add(paramT);
  }
  
  public boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    removeInvalidItem(paramCollection);
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    removeInvalidItem(paramCollection);
    return super.addAll(paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.base.ItemArrayList
 * JD-Core Version:    0.7.0.1
 */