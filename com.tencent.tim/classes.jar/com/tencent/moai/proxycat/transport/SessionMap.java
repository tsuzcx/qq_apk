package com.tencent.moai.proxycat.transport;

import android.util.SparseArray;

public class SessionMap<S extends Session>
  extends SparseArray<S>
{
  private final int maxCount;
  
  public SessionMap(int paramInt)
  {
    this.maxCount = paramInt;
  }
  
  public void append(int paramInt, S paramS)
  {
    onRemoved((Session)get(paramInt));
    super.append(paramInt, paramS);
    onAdded();
  }
  
  public void clear()
  {
    int i = 0;
    while (i < size())
    {
      onRemoved((Session)valueAt(i));
      i += 1;
    }
    super.clear();
  }
  
  public void delete(int paramInt)
  {
    onRemoved((Session)get(paramInt));
    super.delete(paramInt);
  }
  
  protected void onAdded()
  {
    if (size() <= this.maxCount) {
      return;
    }
    int i = 0;
    label14:
    if (i < size()) {
      if (shouldRecycle((Session)valueAt(i))) {
        break label44;
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      break;
      label44:
      removeAt(i);
    }
  }
  
  protected void onRemoved(S paramS) {}
  
  public void put(int paramInt, S paramS)
  {
    onRemoved((Session)get(paramInt));
    super.put(paramInt, paramS);
    onAdded();
  }
  
  public void remove(int paramInt)
  {
    onRemoved((Session)get(paramInt));
    super.remove(paramInt);
  }
  
  public void removeAt(int paramInt)
  {
    onRemoved((Session)valueAt(paramInt));
    super.removeAt(paramInt);
  }
  
  protected boolean shouldRecycle(S paramS)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.transport.SessionMap
 * JD-Core Version:    0.7.0.1
 */