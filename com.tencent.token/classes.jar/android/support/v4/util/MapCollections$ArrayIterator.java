package android.support.v4.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class MapCollections$ArrayIterator
  implements Iterator
{
  boolean mCanRemove = false;
  int mIndex;
  final int mOffset;
  int mSize;
  
  MapCollections$ArrayIterator(MapCollections paramMapCollections, int paramInt)
  {
    this.mOffset = paramInt;
    this.mSize = paramMapCollections.colGetSize();
  }
  
  public boolean hasNext()
  {
    return this.mIndex < this.mSize;
  }
  
  public Object next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object localObject = this.this$0.colGetEntry(this.mIndex, this.mOffset);
    this.mIndex += 1;
    this.mCanRemove = true;
    return localObject;
  }
  
  public void remove()
  {
    if (!this.mCanRemove) {
      throw new IllegalStateException();
    }
    this.mIndex -= 1;
    this.mSize -= 1;
    this.mCanRemove = false;
    this.this$0.colRemoveAt(this.mIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.MapCollections.ArrayIterator
 * JD-Core Version:    0.7.0.1
 */