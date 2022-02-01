package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", "", "last", "step", "(JJJ)V", "finalElement", "hasNext", "", "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class LongProgressionIterator
  extends LongIterator
{
  private final long finalElement;
  private boolean hasNext;
  private long next;
  private final long step;
  
  public LongProgressionIterator(long paramLong1, long paramLong2, long paramLong3)
  {
    this.step = paramLong3;
    this.finalElement = paramLong2;
    if (this.step > 0L) {
      if (paramLong1 <= paramLong2)
      {
        this.hasNext = bool;
        if (!this.hasNext) {
          break label70;
        }
      }
    }
    for (;;)
    {
      this.next = paramLong1;
      return;
      bool = false;
      break;
      if (paramLong1 >= paramLong2) {
        break;
      }
      bool = false;
      break;
      label70:
      paramLong1 = this.finalElement;
    }
  }
  
  public final long getStep()
  {
    return this.step;
  }
  
  public boolean hasNext()
  {
    return this.hasNext;
  }
  
  public long nextLong()
  {
    long l = this.next;
    if (l == this.finalElement)
    {
      if (!this.hasNext) {
        throw ((Throwable)new NoSuchElementException());
      }
      this.hasNext = false;
      return l;
    }
    this.next += this.step;
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.LongProgressionIterator
 * JD-Core Version:    0.7.0.1
 */