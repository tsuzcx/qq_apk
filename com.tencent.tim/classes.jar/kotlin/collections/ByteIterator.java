package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/ByteIterator;", "", "", "()V", "next", "()Ljava/lang/Byte;", "nextByte", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class ByteIterator
  implements Iterator<Byte>, KMappedMarker
{
  @NotNull
  public final Byte next()
  {
    return Byte.valueOf(nextByte());
  }
  
  public abstract byte nextByte();
  
  public void remove()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ByteIterator
 * JD-Core Version:    0.7.0.1
 */