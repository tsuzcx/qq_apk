package com.tencent.beacon.base.net.call;

import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.d;

public abstract interface Callback<T>
{
  public abstract void onFailure(d paramd);
  
  public abstract void onResponse(T paramT)
    throws NetException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.base.net.call.Callback
 * JD-Core Version:    0.7.0.1
 */