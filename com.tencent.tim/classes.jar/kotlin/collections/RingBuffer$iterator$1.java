package kotlin.collections;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/RingBuffer$iterator$1", "Lkotlin/collections/AbstractIterator;", "count", "", "index", "computeNext", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class RingBuffer$iterator$1
  extends AbstractIterator<T>
{
  private int count;
  private int index;
  
  RingBuffer$iterator$1()
  {
    this.count = localRingBuffer.size();
    this.index = RingBuffer.access$getStartIndex$p(localRingBuffer);
  }
  
  protected void computeNext()
  {
    if (this.count == 0)
    {
      done();
      return;
    }
    setNext(RingBuffer.access$getBuffer$p(this.this$0)[this.index]);
    RingBuffer localRingBuffer = this.this$0;
    this.index = ((this.index + 1) % RingBuffer.access$getCapacity$p(localRingBuffer));
    this.count -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.RingBuffer.iterator.1
 * JD-Core Version:    0.7.0.1
 */