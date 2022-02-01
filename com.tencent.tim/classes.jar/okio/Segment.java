package okio;

import javax.annotation.Nullable;

final class Segment
{
  static final int SHARE_MINIMUM = 1024;
  static final int SIZE = 8192;
  final byte[] data;
  int limit;
  Segment next;
  boolean owner;
  int pos;
  Segment prev;
  boolean shared;
  
  Segment()
  {
    this.data = new byte[8192];
    this.owner = true;
    this.shared = false;
  }
  
  Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.shared = paramBoolean1;
    this.owner = paramBoolean2;
  }
  
  public final void compact()
  {
    if (this.prev == this) {
      throw new IllegalStateException();
    }
    if (!this.prev.owner) {}
    for (;;)
    {
      return;
      int j = this.limit - this.pos;
      int k = this.prev.limit;
      if (this.prev.shared) {}
      for (int i = 0; j <= i + (8192 - k); i = this.prev.pos)
      {
        writeTo(this.prev, j);
        pop();
        SegmentPool.recycle(this);
        return;
      }
    }
  }
  
  @Nullable
  public final Segment pop()
  {
    if (this.next != this) {}
    for (Segment localSegment = this.next;; localSegment = null)
    {
      this.prev.next = this.next;
      this.next.prev = this.prev;
      this.next = null;
      this.prev = null;
      return localSegment;
    }
  }
  
  public final Segment push(Segment paramSegment)
  {
    paramSegment.prev = this;
    paramSegment.next = this.next;
    this.next.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  final Segment sharedCopy()
  {
    this.shared = true;
    return new Segment(this.data, this.pos, this.limit, true, false);
  }
  
  public final Segment split(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.limit - this.pos)) {
      throw new IllegalArgumentException();
    }
    Segment localSegment;
    if (paramInt >= 1024) {
      localSegment = sharedCopy();
    }
    for (;;)
    {
      localSegment.limit = (localSegment.pos + paramInt);
      this.pos += paramInt;
      this.prev.push(localSegment);
      return localSegment;
      localSegment = SegmentPool.take();
      System.arraycopy(this.data, this.pos, localSegment.data, 0, paramInt);
    }
  }
  
  final Segment unsharedCopy()
  {
    return new Segment((byte[])this.data.clone(), this.pos, this.limit, false, true);
  }
  
  public final void writeTo(Segment paramSegment, int paramInt)
  {
    if (!paramSegment.owner) {
      throw new IllegalArgumentException();
    }
    if (paramSegment.limit + paramInt > 8192)
    {
      if (paramSegment.shared) {
        throw new IllegalArgumentException();
      }
      if (paramSegment.limit + paramInt - paramSegment.pos > 8192) {
        throw new IllegalArgumentException();
      }
      System.arraycopy(paramSegment.data, paramSegment.pos, paramSegment.data, 0, paramSegment.limit - paramSegment.pos);
      paramSegment.limit -= paramSegment.pos;
      paramSegment.pos = 0;
    }
    System.arraycopy(this.data, this.pos, paramSegment.data, paramSegment.limit, paramInt);
    paramSegment.limit += paramInt;
    this.pos += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.Segment
 * JD-Core Version:    0.7.0.1
 */