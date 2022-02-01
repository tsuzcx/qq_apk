package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

public class DBInnerIter<O>
  implements Iterator<O>
{
  protected final DataBuffer<O> dataBuffer;
  protected int index = -1;
  
  public DBInnerIter(DataBuffer<O> paramDataBuffer)
  {
    Preconditions.checkNotNull(paramDataBuffer, "dataBuffer cannot be null");
    this.dataBuffer = paramDataBuffer;
  }
  
  public boolean hasNext()
  {
    return this.index + 1 < this.dataBuffer.getCount();
  }
  
  public O next()
  {
    if (hasNext())
    {
      DataBuffer localDataBuffer = this.dataBuffer;
      int i = this.index + 1;
      this.index = i;
      return localDataBuffer.get(i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.data.DBInnerIter
 * JD-Core Version:    0.7.0.1
 */