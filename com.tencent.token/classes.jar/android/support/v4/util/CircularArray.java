package android.support.v4.util;

public final class CircularArray
{
  private int mCapacityBitmask;
  private Object[] mElements;
  private int mHead;
  private int mTail;
  
  public CircularArray()
  {
    this(8);
  }
  
  public CircularArray(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("capacity must be >= 1");
    }
    if (paramInt > 1073741824) {
      throw new IllegalArgumentException("capacity must be <= 2^30");
    }
    int i = paramInt;
    if (Integer.bitCount(paramInt) != 1) {
      i = Integer.highestOneBit(paramInt - 1) << 1;
    }
    this.mCapacityBitmask = (i - 1);
    this.mElements = ((Object[])new Object[i]);
  }
  
  private void doubleCapacity()
  {
    int i = this.mElements.length;
    int j = i - this.mHead;
    int k = i << 1;
    if (k < 0) {
      throw new RuntimeException("Max array capacity exceeded");
    }
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(this.mElements, this.mHead, arrayOfObject, 0, j);
    System.arraycopy(this.mElements, 0, arrayOfObject, j, this.mHead);
    this.mElements = ((Object[])arrayOfObject);
    this.mHead = 0;
    this.mTail = i;
    this.mCapacityBitmask = (k - 1);
  }
  
  public void addFirst(Object paramObject)
  {
    this.mHead = (this.mHead - 1 & this.mCapacityBitmask);
    this.mElements[this.mHead] = paramObject;
    if (this.mHead == this.mTail) {
      doubleCapacity();
    }
  }
  
  public void addLast(Object paramObject)
  {
    this.mElements[this.mTail] = paramObject;
    this.mTail = (this.mTail + 1 & this.mCapacityBitmask);
    if (this.mTail == this.mHead) {
      doubleCapacity();
    }
  }
  
  public void clear()
  {
    removeFromStart(size());
  }
  
  public Object get(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= size())) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return this.mElements[(this.mHead + paramInt & this.mCapacityBitmask)];
  }
  
  public Object getFirst()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return this.mElements[this.mHead];
  }
  
  public Object getLast()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return this.mElements[(this.mTail - 1 & this.mCapacityBitmask)];
  }
  
  public boolean isEmpty()
  {
    return this.mHead == this.mTail;
  }
  
  public Object popFirst()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    Object localObject = this.mElements[this.mHead];
    this.mElements[this.mHead] = null;
    this.mHead = (this.mHead + 1 & this.mCapacityBitmask);
    return localObject;
  }
  
  public Object popLast()
  {
    if (this.mHead == this.mTail) {
      throw new ArrayIndexOutOfBoundsException();
    }
    int i = this.mTail - 1 & this.mCapacityBitmask;
    Object localObject = this.mElements[i];
    this.mElements[i] = null;
    this.mTail = i;
    return localObject;
  }
  
  public void removeFromEnd(int paramInt)
  {
    if (paramInt <= 0) {}
    do
    {
      return;
      if (paramInt > size()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      i = 0;
      if (paramInt < this.mTail) {
        i = this.mTail - paramInt;
      }
      int j = i;
      while (j < this.mTail)
      {
        this.mElements[j] = null;
        j += 1;
      }
      i = this.mTail - i;
      paramInt -= i;
      this.mTail -= i;
    } while (paramInt <= 0);
    this.mTail = this.mElements.length;
    int i = this.mTail - paramInt;
    paramInt = i;
    while (paramInt < this.mTail)
    {
      this.mElements[paramInt] = null;
      paramInt += 1;
    }
    this.mTail = i;
  }
  
  public void removeFromStart(int paramInt)
  {
    if (paramInt <= 0) {}
    int i;
    do
    {
      return;
      if (paramInt > size()) {
        throw new ArrayIndexOutOfBoundsException();
      }
      int j = this.mElements.length;
      i = j;
      if (paramInt < j - this.mHead) {
        i = this.mHead + paramInt;
      }
      j = this.mHead;
      while (j < i)
      {
        this.mElements[j] = null;
        j += 1;
      }
      j = i - this.mHead;
      i = paramInt - j;
      this.mHead = (j + this.mHead & this.mCapacityBitmask);
    } while (i <= 0);
    paramInt = 0;
    while (paramInt < i)
    {
      this.mElements[paramInt] = null;
      paramInt += 1;
    }
    this.mHead = i;
  }
  
  public int size()
  {
    return this.mTail - this.mHead & this.mCapacityBitmask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.util.CircularArray
 * JD-Core Version:    0.7.0.1
 */